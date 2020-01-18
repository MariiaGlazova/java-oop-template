package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;
import org.apache.commons.lang3.ArrayUtils;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    private SchoolBook[] schoolBooks = new SchoolBook[0];

    @Override
    public boolean save(SchoolBook book) {
        schoolBooks = ArrayUtils.add(schoolBooks, book);
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        SchoolBook[] properBooks = new SchoolBook[0];
        for (SchoolBook book : schoolBooks) {
            if (book.getName().equalsIgnoreCase(name)) {
                properBooks = ArrayUtils.add(properBooks, book);
            }
        }
        return properBooks;
    }

    @Override
    public boolean removeByName(String name) {
        SchoolBook[] properBooks = findByName(name);
        if (properBooks.length != 0) {
            for (SchoolBook book : properBooks) {
                schoolBooks = ArrayUtils.remove(schoolBooks, ArrayUtils.indexOf(schoolBooks, book));
            }
            return true;
        }
        return false;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
