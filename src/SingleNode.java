import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node in a singly linked list.
 * Each node contains an integer value and a reference to the next node in the list.
 */
public class SingleNode {

  /**
   * The integer value stored in this node.
   */
  public int data;

  /**
   * A reference to the next node in the singly linked list.
   * This is null if there is no next node.
   */
  public SingleNode next;

  /**
   * Constructs a SingleNode with the specified data and a reference to the next node.
   *
   * @param data the integer value to store in this node
   * @param next the next node in the list, or null if there is no next node
   */
  public SingleNode(int data, SingleNode next) {
    this.data = data;
    this.next = next;
  }

  /**
   * Constructs a SingleNode with the specified data.
   * The next reference is initialized to null.
   *
   * @param data the integer value to store in this node
   */
  public SingleNode(int data) {
    this(data, null);
  }

  /**
   * Converts the singly linked list starting at this node into a Java List.
   *
   * @return a list containing the values of the nodes in the linked list
   */
  public List<Integer> toList() {
    ArrayList<Integer> list = new ArrayList<>();

    SingleNode curr = this;

    while (curr != null) {
      list.add(curr.data);
      curr = curr.next;
    }

    return list;
  }

  /**
   * Constructs a singly linked list from a Java List.
   * The head of the list corresponds to the first element in the input list.
   *
   * @param values a list of integers to convert into a singly linked list
   * @return the head node of the constructed singly linked list, or null if the input list is empty
   * @throws IllegalArgumentException if the input list is null or empty
   */
  public static SingleNode fromList(List<Integer> values) {

    /*
     * Set index 0 as head
     * Traverse list of integers using a for loop
     * Inside the loop set the next index as the next node
     */

    if (values == null || values.isEmpty()) {
      throw new IllegalArgumentException("List is empty");
    }

    // A B C D E
    // Create an instance of SingleNode object
    // Set index 0 of values as head
    // Create curr pointer set as head
    // Traverse a values list using for loop
    // Set pointers of each index as a new node

    SingleNode head = new SingleNode(values.get(0));
    SingleNode curr = head;

    for (int i = 1; i < values.size(); i++) {
      curr.next = new SingleNode(values.get(i));
      curr = curr.next;
    }

    return head;
  }
}