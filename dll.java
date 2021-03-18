
class Node {
public int data;
public Node next;
public Node prev;

public Node(int data) {
  this.data = data;
  next = null;
  prev = null;
}
}

class LinkedList {
public Node head;

public LinkedList(int info) {
  Node a = new Node(info);
  head = a;
}

public void traversal() {
  Node temp = head; 

  while(temp != null) { 
    System.out.print(temp.data);
    temp = temp.next;
  }

  System.out.println("");
}


public void addTOFront(Node n) {
  n.next = head;
  head.prev = n;
  head = n;
}
public void addToTail(Node n) {
  Node temp = head;

  while(temp.next != null) {
    temp = temp.next;
  }

  temp.next = n;
  n.prev = temp;
}


public void addAfter(Node n, Node a) {
  n.next = a.next;
  a.next.prev = n;
  a.next = n;
  n.prev = a;
}


public void remove(Node a) {
  if(a.prev != null) { 
    a.prev.next = a.next;
  }
  else { 
    head = a.next;
  }

  if(a.next != null) {
    a.next.prev = a.prev;
  }
}
}

class ListMain {
public static void main(String[] args) {
  LinkedList d = new LinkedList(20);

  Node f,g,k;
  f = new Node(20);
  g = new Node(50);
  k = new Node(60); d.head.next = f;
  f.next = g;
  g.next = k;

  d.traversal();

  Node z;

  z = new Node(0);
  d.addTOFront(z);
  z = new Node(67);
  d.addTOFront(z);

  z = new Node(43);
  d.addToTail(z);

  z = new Node(43);
  d.addAfter(z, f);
  z = new Node(21);
  d.addAfter(z, f.next);
  z = new Node(95);
  d.addAfter(z, f.next.next);

  d.traversal();

  d.remove(d.head);
  d.remove(z);

  d.traversal();
}
}

