package LinkedList;
public class LinkedList {
    
    ListNode head;

    class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data){
        ListNode curr = new ListNode(data);

        if(head == null){
            head = curr;
        }
        else{
            curr.next = head;
            head = curr;
        }
    }

    public void addEnd(int data){
        ListNode newNode = new ListNode(data);
        ListNode curr = head;

        if(head == null){
            head = newNode;
            return;
        }

        while(curr.next != null)
        curr = curr.next;

        curr.next = newNode;
    }

    public void removeFirst(){
        if(head == null){
            System.out.println("Empty List");
            return;
        }
        head = head.next;
    }

    public void removeLast(){
        if(head == null){
            System.out.println("Empty List");
            return;
        }

        ListNode curr = head;
        ListNode prev = null;

        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
    }

    public void printList(){
        ListNode curr = head;
        while(curr !=null){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.print("null");
    }
    public int getSize(){
        int size = 0;
        ListNode curr = head;

        while(curr != null){
            curr = curr.next;
            size++;
        }

        return size;
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(3);
        list.addFirst(6);
        list.addEnd(7);
        list.removeFirst();
        list.addEnd(8);
        list.removeLast();
        list.printList();
        System.out.println(" ");
        System.out.println("Size of Linked List is " + list.getSize());
    }
}
