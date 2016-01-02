package com.fujitsu.fs.javalab.currency;

import org.junit.Test;

import static org.junit.Assert.*;


public class NameEntityTest {

    @Test
    public void testParseComplete() throws EntityExeption {
        NameEntity entity = NameEntity.parse("1300;#Northcott Tom");
        //assertEquals("str1","str2");
        assertEquals(1300l, entity.getId().longValue()); //entity.getId().longValue() такого нет
        assertEquals("Northcott Tom", entity.getName());
    }

    @Test
    public void testParseIncomplete() throws EntityExeption {
        NameEntity entity = NameEntity.parse("1300;#");
        assertEquals(1300l, entity.getId().longValue());
        assertEquals(entity.getName(),"");
    }

    @Test(expected = EntityExeption.class)
    public void testParseFormatInalid() throws EntityExeption {
//        try {    !!!!! вместо @Test(expected = EntityExeption.class)
//            NameEntity.parse("1300");
//        } catch (EntityExeption e) {
//            //expected
//            return;
//        }
//        fail();

        NameEntity.parse("1300");
    }

    @Test(expected = EntityExeption.class)
    public void testParseInalidId() throws EntityExeption {
        NameEntity.parse("1300");
    }
    @Test(expected = EntityExeption.class)
    public void testParseMissedId() throws EntityExeption {
        NameEntity.parse(";#Tom");
    }
    @Test(expected = EntityExeption.class)
    public void testParseIncorrectId() throws EntityExeption {
        NameEntity.parse("ten;#Tom");
    }
}
