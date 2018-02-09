import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public class TestSorts {

    @Test
    public void testSortIntegerA(){
        Sorts sorts = new Sorts();
        int[] entry1 = {4,2,1,3,5};
        int[] exit1 = {1,2,3,4,5};
        assertArrayEquals(exit1,sorts.sortIA(entry1));
        int[] entry2 = {4,2,1,3,5,10,8,7,6,9};
        int[] exit2 = {1,2,3,4,5,6,7,8,9,10};
        assertArrayEquals(exit2,sorts.sortIA(entry2));
        int[] entry3 = {4,-2,1,-3,-5,-10,8,-7,6,9};
        int[] exit3 =  {-10,-7,-5,-3,-2,1,4,6,8,9};
        assertArrayEquals(exit3,sorts.sortIA(entry3));
    }

    @Test
    public void testSortStringB(){
        Sorts sorts = new Sorts();
        int[] entry1 = {4,2,1,3,5};
        int[] exit1 = {5,4,3,2,1};
        assertArrayEquals(exit1,sorts.sortIB(entry1));
        int[] entry2 = {4,2,1,3,5,10,8,7,6,9};
        int[] exit2 = {10,9,8,7,6,5,4,3,2,1};
        assertArrayEquals(exit2,sorts.sortIB(entry2));
        int[] entry3 = {4,-2,1,-3,-5,-10,8,-7,6,9};
        int[] exit3 =  {9,8,6,4,1,-2,-3,-5,-7,-10};
        assertArrayEquals(exit3,sorts.sortIB(entry3));
    }

    @Test
    public void testSortStringA(){
        Sorts sorts = new Sorts();
        String[] entry1 = {"б","в","г","д","а"};
        String[] exit1 =  {"а","б","в","г","д"};
        assertArrayEquals(exit1,sorts.sortSA(entry1));
        String[] entry2 = {"ж","а","з","и","в","д","г","е","б"};
        String[] exit2 =  {"а","б","в","г","д","е","ж","з","и"};
        assertArrayEquals(exit2,sorts.sortSA(entry2));
        String[] entry3 = {"ж","а","г","е","б","з","и","в","д"};
        String[] exit3 =  {"а","б","в","г","д","е","ж","з","и"};
        assertArrayEquals(exit3,sorts.sortSA(entry3));
        String[] entry4 = {"про","пр","при","труу"};
        String[] exit4 =  {"пр","при","про","труу"};
        assertArrayEquals(exit4,sorts.sortSA(entry4));
    }

    @Test
    public void testSortIntegerB(){
        Sorts sorts = new Sorts();
        String[] entry1 = {"б","в","г","д","а"};
        String[] exit1 =  {"д","г","в","б","а"};
        assertArrayEquals(exit1,sorts.sortSB(entry1));
        String[] entry2 = {"ж","а","з","и","в","д","г","е","б"};
        String[] exit2 =  {"и","з","ж","е","д","г","в","б","а"};
        assertArrayEquals(exit2,sorts.sortSB(entry2));
        String[] entry3 = {"ж","а","г","е","б","з","и","в","д"};
        String[] exit3 =  {"и","з","ж","е","д","г","в","б","а"};
        assertArrayEquals(exit3,sorts.sortSB(entry3));
        String[] entry4 = {"про","пр","при","труу"};
        String[] exit4 =  {"труу","про","при","пр"};
        assertArrayEquals(exit4,sorts.sortSB(entry4));
    }
}
