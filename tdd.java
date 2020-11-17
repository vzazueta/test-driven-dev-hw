import sun.jvm.hotspot.utilities.Assert;

/*
    We need to get the size of the list
    We need to clear the list
    We need to add Items
    We need to be able to check if an item exists
    We need to get elements by index
    We need to search the index of an object
    We need to remove an item by index
*/

public class Tdd {
    MyLinkedList lista;

    // We need to be able to check if an item exists
    // We need to get elements by index
    @Test 
    public void doesItemExistTest(){
        lista = new MyLinkedList();

        lista.add(783);

        System.out.println(assertEquals(783, lista.objectExists(783)));
        System.out.println(assertEquals(783, lista.get(0)));
    }

    // We need to search the index of an object
    @Test
    public void getElementIndexTest() {

        lista = new MyLinkedList();
        
        for(int i=0; i<1000; i++){
            lista.add(i);
        }

        System.out.println(lista.indexOf(743));
    }

    // We need to get the size of the list
    // We need to add Items
    @Test
    public void fullListSizeTest() {

        lista = new MyLinkedList();
        
        for(int i=0; i<10000; i++){
            lista.add(i);
        }

        // despues de multiples adiciones, los 
        // cambios en el size deben ser constantes
        System.out.println(assertEquals(1000, list.size()));
    }

    @Test(expected = NullPointerException.class)
    public void nullListSizeTest() {

        // Utilizar una lista sin inicializar
        // debería provocar un NullPointerException
        try {
            lista.size();
        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    // We need to remove an item by index
    @Test
    public void removeElementsTest() {
        lista = new MyLinkedList();

        for(int i=0; i<100; i++){
            lista.add(i);
        }

        // Insertamos elementos cualquiera con
        assertEquals(100, list.size());

        lista.removeByIndex(42);
        lista.removeByIndex(78);
        
        // Removemos dos elementos aleatorios para 
        // verificar que todo alrededor se quede
        // igual
        System.out.println(assertEquals(98, list.size()));
    }

    // We need to clear the list
    @Test
    public void clearList() {

        lista = new MyLinkedList();
        
        for(int i=0; i<1000; i++){
            lista.add(i);
        }

        // Probar que los elementos se hayan
        // insertado correctamente
        assertEquals(1000, list.size());

        lista.clear();

        // Probar que los elementos se hayan
        // eliminado correctamente
        assertEquals(0, list.size());
    }
}








class MyLinkedList {
    private Node root;
    private int size;

    public MyLinkedList(){
        root = null;
        size = 0;
    }

    private Node getNode(int index) {
		return getNodePriv(index);
    }
    
    private Node getNodePriv(int index){
        try {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            
            Node node = root;
            
            for (int i=0; i<index; i++) {
                node = node.next;
            }
        } catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
        
        return node;
    }

    public boolean add(E x){
        return addPriv(x);
    }

    private boolean addPriv(E x){
        try{
            if(root == null){
                root = new Node(x);
            } else {
                Node node = root;

                while(node.next != null){
                    node.next = new Node(x);
                    node = node.next;
                }
            }
        } catch(Exception e) {
            return false;
        }
        
        size++;

        return true;
    }

    public int indexOf(E target){
        return indexOfPriv(target);
    }

    private int indexOfPriv(E target) {
		Node node = root;
		for (int i=0; i<size; i++) {
			if (equals(target, node.cargo)) {
				return i;
			}
			node = node.next;
		}
		return -1;
	}

    public boolean removeByObject(E x){
        return removePriv(x);
    }

    private boolean removeByObjectPriv(E x) {
		int index = indexOf(x);
        
        if (index == -1) {
			return false;
        }
        
		removeByIndex(index);
		return true;
    }
    
    public E removeByIndex(int index) {
		E x = get(index);
        
        if (index == 0) {
			root = root.next;
		} else {
			Node node = getNode(index-1);
			node.next = node.next.next;
        }
        
		size--;
		return element;
	}

    public boolean isEmpty() {
		return size == 0;
	}

    public void clear() {
		root = null;
		size = 0;
    }

    public E getByIndex(int index) {
		return getPriv(index);
    }
    
    private E getByIndexPriv(int index) {
		Node node = getNode(index);
		return node.cargo;
    }
    
    public boolean objectExists(E object){
        int result = indexOf(object);

        if(result >= 0) return true;

        return false;
    }

}







class Node {
    E object;
    //Node prev;
    Node next;

    public Node(E o){
        object = o;
    }

    public Node(E o, Node n){
        object = o;
        next = n;
    }
}