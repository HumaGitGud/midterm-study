import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node in a doubly linked list.
 * Each node stores an integer value and has references to the next and previous nodes in the list.
 */
public class DoubleNode {

  /**
   * The data stored in this node.
   */
  public int data;

  /**
   * The reference to the next node in the doubly linked list.
   * If this is the last node in the list, next is null.
   */
  public DoubleNode next;

  /**
   * The reference to the previous node in the doubly linked list.
   * If this is the first node in the list, prev is null.
   */
  public DoubleNode prev;

  /**
   * Constructs a DoubleNode with the specified data and a reference to the next node.
   * The prev reference is initialized to null.
   *
   * @param data the integer value to store in this node
   * @param next the next node in the list, or null if this is the last node
   */
  public DoubleNode(int data, DoubleNode next) {
    this.data = data;
    this.next = next;
    // prev is null by default
  }

  /**
   * Constructs a DoubleNode with the specified data.
   * The next and prev references are initialized to null.
   *
   * @param data the integer value to store in this node
   */
  public DoubleNode(int data) {
    this(data, null);
  }

  /**
   * Converts the doubly linked list starting at this node into a Java List.
   *
   * @return a list containing the values of the nodes in the linked list
   */
  public List<Integer> toList() {

    /*
     * Create an ArrayList
     * Create a curr node pointer
     * Create a while loop and traverse a doubly linked list
     * Each time a node is found, add it to the list
     */
    
    ArrayList<Integer> list = new ArrayList<>();
    
    DoubleNode curr = this;

    while (curr != null) {
      list.add(curr.data);
      curr = curr.next;
    }

    return list;
  }

  /**
   * Constructs a doubly linked list from a Java List.
   * The head of the list corresponds to the first element in the input list.
   *
   * @param values a list of integers to convert into a doubly linked list
   * @return the head node of the constructed doubly linked list
   * @throws IllegalArgumentException if the input list is null or empty
   */
  public static DoubleNode fromList(List<Integer> values) {
    
     if (values == null || values.isEmpty()) {
      throw new IllegalArgumentException("List is empty");
     }
     
     // A B C D E
    // Create an instance of DoubleNode object
    // set the head as index 0 of values
    // Create a curr pointer and set it to head
    // Create a for loop and traverse the values list
    // Create a next pointer at each index

    DoubleNode head = new DoubleNode(values.get(0));
    DoubleNode curr = head;

    for (int i = 1; i < values.size(); i++) {
      curr.next = new DoubleNode(values.get(i));
      curr.next.prev = curr;
      curr = curr.next;
    }

    return head;
  }
}