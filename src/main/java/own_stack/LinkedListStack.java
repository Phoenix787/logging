package own_stack;


public class LinkedListStack<T> {

   private final LinkedList<T> linkedList = new LinkedList<>();

    public void push(T element) {
        linkedList.addFirst(element);
    }

    public T pop() {
        return linkedList.removeFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }


}
class LinkedList<T> {
    // внутренний класс, который представляет элемент списка
    private static class Node<T>{
        private T data;
        //указатель на следующий элемент
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<T> first = null;

    //используется для push операции
    public void addFirst(T data){
        Node<T> newFirst = new Node<>(data);
        newFirst.next = first;
        first = newFirst;
    }

    //используется для pop-операции
    public T removeFirst() {
        Node<T> oldFirst = first;
        first = first.next;
        return oldFirst.data;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public String toString(){
        StringBuilder listBuilder = new StringBuilder();
        Node currentNode = first;
        while (currentNode != null) {
            listBuilder.append(currentNode).append(",");
            currentNode = currentNode.next;
        }
        return listBuilder.toString();
    }



}
