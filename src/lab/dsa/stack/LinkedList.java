package lab.dsa.stack;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insert(T data) {
        Node<T> node = new Node<>(data);
        if (this.head == null) {
            this.head = this.tail = node;
            size++;
            return;
        }
        this.tail.setNext(node);
        tail = tail.getNext();
        size++;
    }

    public void insertAtHead(T data) {
        if (head == null) {
            insert(data);
            return;
        }
        Node<T> node = new Node<>(data);
        node.setNext(head);
        head = node;
        size++;
    }

    public void insertAt(T data, int index) throws Exception {
        if (head == null) {
            throw new Exception("Linked List is empty");
        }
        if (index == 0) {
            insertAtHead(data);
            return;
        }
        Node<T> nodeAtIndex = head, newNode = new Node<>(data);
        nodeAtIndex = traverseThroughLinkedList(index, nodeAtIndex);
        if (!nodeAtIndex.hasNext()) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        newNode.setNext(nodeAtIndex.getNext());
        nodeAtIndex.setNext(newNode);
        size++;
    }


    public void deleteHead() {
        if (head == null) return;
        head = head.hasNext() ? head.getNext() : null;
        size--;
    }

    public void deleteFromTheTail() {
        if (head == null) return;
        if (!head.hasNext()) {
            head = null;
            size--;
            return;
        }
        Node<T> node = head;
        while (node.getNext().hasNext()) {
            node = node.getNext();
        }
        node.setNext(null);
        tail = node;
        size--;
    }

    public void deleteAt(int index) throws Exception {
        if (head == null) {
            throw new Exception("Linked List is empty");
        }
        if (index == 0) {
            deleteHead();
            return;
        }
        Node<T> nodeAtIndex = head;
        nodeAtIndex = traverseThroughLinkedList(index, nodeAtIndex);
        if (!nodeAtIndex.hasNext()) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        if (nodeAtIndex.getNext().hasNext()) {
            nodeAtIndex.setNext(nodeAtIndex.getNext().getNext());
        } else {
            nodeAtIndex.setNext(null);
        }
        size--;
    }

    public void update(int index, T data) {
        if (head == null) return;
        if (index == 0) {
            head.setData(data);
            return;
        }
        Node<T> nodeAtIndex = head;
        nodeAtIndex = traverseThroughLinkedList(index, nodeAtIndex);
        if (!nodeAtIndex.hasNext()) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        nodeAtIndex.getNext().setData(data);
    }

    public T getFirst() {
        return head.getData();
    }

    public T getLast() {
        return tail.getData();
    }

    public T getFrom(int index) {
        if (head == null) return null;
        if (index == 0) {
            return getFirst();
        }
        Node<T> nodeAtIndex = head;
        nodeAtIndex = traverseThroughLinkedList(index, nodeAtIndex);
        return nodeAtIndex.hasNext() ? nodeAtIndex.getNext().getData() : null;
    }

    public int getSize(){
        return size;
    }
    private Node<T> traverseThroughLinkedList(int index, Node<T> nodeAtIndex) {
        try {
            for (int i = 0; i < (index - 1); i++) {
                nodeAtIndex = nodeAtIndex.getNext();
            }
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        return nodeAtIndex;
    }
}

