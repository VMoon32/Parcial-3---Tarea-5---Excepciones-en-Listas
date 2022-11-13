package uaslp.objetos.list.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

public class LinkedListTest {

    @Test
    public void givenAnEmptyList_thenSizeisZero()
    {
        LinkedList<String> lista = new LinkedList<>();

        int size = lista.getSize();

        Assertions.assertEquals(0,size);
    }

    @Test
    public void givenANewList_whenAddAtTail_thenSizeisOne() throws NullNotAllowedException, WrongIndexException
    {
        LinkedList<String> lista = new LinkedList<>();

        lista.addAtTail("Uno");
        int size = lista.getSize();

        Assertions.assertEquals(1,size);
        Assertions.assertEquals("Uno",lista.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtTail_thenSizeisIncreased() throws NullNotAllowedException, WrongIndexException
    {
        LinkedList<String> lista = new LinkedList<>();

        lista.addAtTail("Uno");
        lista.addAtTail("Dos");
        int size = lista.getSize();

        Assertions.assertEquals(2,size);
        Assertions.assertEquals("Uno",lista.getAt(0));
        Assertions.assertEquals("Dos",lista.getAt(1));
    }

    @Test
    public void givenANonEmptyList_whenAddAtFront_thenSizeisIncreased() throws NullNotAllowedException, WrongIndexException
    {
        LinkedList<String> lista = new LinkedList<>();

        lista.addAtFront("Uno");
        lista.addAtFront("Dos");
        int size = lista.getSize();

        Assertions.assertEquals(2,size);
        Assertions.assertEquals("Dos",lista.getAt(0));
        Assertions.assertEquals("Uno",lista.getAt(1));
    }

    @Test
    public void givenAList_whenRemoveLessThanZero_thenSizeIsThrown() throws NullNotAllowedException, WrongIndexException
    {
        LinkedList<String> lista = new LinkedList<>();

        lista.addAtFront("Uno");

        //boolean result = lista.remove(-1);

        //Assertions.assertFalse(result);
        Assertions.assertThrows(WrongIndexException.class,()->lista.remove(-1));
    }

    @Test
    public void givenAListWithOneElement_whenRemove0_thenReturnTrue() throws NullNotAllowedException, WrongIndexException
    {
        LinkedList<String> lista = new LinkedList<>();

        lista.addAtFront("Uno");

        boolean result = lista.remove(0);

        Assertions.assertTrue(result);
        Assertions.assertEquals(0,lista.getSize());
    }

    @Test
    public void givenAListWithTwoElements_whenRemove0_thenReturnTrue() throws NullNotAllowedException, WrongIndexException
    {
        LinkedList<String> lista = new LinkedList<>();

        lista.addAtFront("Uno");
        lista.addAtFront("Dos");

        boolean result = lista.remove(0);

        Assertions.assertTrue(result);
        Assertions.assertEquals(1,lista.getSize());
        Assertions.assertEquals(lista.getAt(0),"Uno");
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveTail_thenReturnTrue() throws NullNotAllowedException, WrongIndexException
    {
        LinkedList<String> lista = new LinkedList<>();

        lista.addAtTail("Uno");
        lista.addAtTail("Dos");

        boolean result = lista.remove(1);

        Assertions.assertTrue(result);
        Assertions.assertEquals(1,lista.getSize());
        Assertions.assertEquals(lista.getAt(0),"Uno");
    }

    @Test
    public void givenAListWith3Elements_whenRemoveMid_thenReturnTrue() throws NullNotAllowedException, WrongIndexException
    {
        LinkedList<String> lista = new LinkedList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        boolean result = lista.remove(1);

        Assertions.assertTrue(result);
        Assertions.assertEquals(2,lista.getSize());
        Assertions.assertEquals(lista.getAt(0),"Dos");
        Assertions.assertEquals(lista.getAt(1),"Tres");
    }

    @Test
    public void givenAListWith3Elements_whenRemoveAll_thenSizeIsZero() throws NullNotAllowedException, WrongIndexException
    {
        LinkedList<String> lista = new LinkedList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        lista.removeAll();

        Assertions.assertEquals(0,lista.getSize());
    }

    @Test
    public void givenAListWith3Elements_whenSetAt1_thenElementIsModified() throws NullNotAllowedException, WrongIndexException
    {
        LinkedList<String> lista = new LinkedList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        lista.setAt(1,"Cuatro");

        Assertions.assertEquals(3,lista.getSize());
        Assertions.assertEquals("Dos",lista.getAt(0));
        Assertions.assertEquals("Cuatro",lista.getAt(1));
        Assertions.assertEquals("Tres",lista.getAt(2));

    }

    @Test
    public void givenAListWith3Elements_whenSetLessThanZero_thenElementIsModified() throws NullNotAllowedException, WrongIndexException
    {
        LinkedList<String> lista = new LinkedList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        Assertions.assertEquals(3,lista.getSize());
        Assertions.assertEquals("Dos",lista.getAt(0));
        Assertions.assertEquals("Uno",lista.getAt(1));
        Assertions.assertEquals("Tres",lista.getAt(2));
        Assertions.assertThrows(WrongIndexException.class,()->lista.setAt(-1,"Cuatro"));
    }

    @Test
    public void givenAListWithThreeElements_whenGetIterator_thenIteratorWorksOverThreeElements() throws NullNotAllowedException, WrongIndexException
    {
        LinkedList<String> list=new LinkedList<>();

        list.addAtFront("Uno");
        list.addAtTail("Dos");
        list.addAtTail("Tres");

        Iterator<String> iterator = list.getIterator();

        int sizeOfList = list.getSize();

        Assertions.assertEquals(3,sizeOfList);
        Assertions.assertNotNull(iterator);
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Uno",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Dos",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Tres",iterator.next());
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    public void givenAListWithTwoElements_whenAddAtFrontNullValue_thenNullNotAllowedExceptionIsThrown() throws NullNotAllowedException, WrongIndexException
    {

        LinkedList<String> lista=new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtTail("Dos");

        Assertions.assertThrows(NullNotAllowedException.class,()->lista.addAtFront(null));
    }

    @Test
    public void givenAListWithTwoElements_whenAddAtTailNullValue_thenNullNotAllowedExceptionIsThrown() throws NullNotAllowedException, WrongIndexException {

        LinkedList<String> lista=new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtTail("Dos");

        Assertions.assertThrows(NullNotAllowedException.class,()->lista.addAtTail(null));
    }

    @Test
    public void givenAListWithTwoElements_whenSetAtTailNullValue_thenNullNotAllowedExceptionIsThrown() throws NullNotAllowedException, WrongIndexException {

        LinkedList<String> lista=new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtTail("Dos");

        Assertions.assertThrows(NullNotAllowedException.class,()->lista.setAt(0,null));
    }

    @Test
    public void givenAListWithTwoElements_whenSetAtIndex3_thenSizeIsThrown() throws NullNotAllowedException, WrongIndexException
    {
        LinkedList<String> lista=new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtTail("Dos");

        Assertions.assertThrows(WrongIndexException.class,()->lista.setAt(3,"Valor"));
    }
}
