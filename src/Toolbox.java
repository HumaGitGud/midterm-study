import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Toolbox {

 /**
   * Removes an element from an array of strings at the specified index, padding with nulls at the end.
   *
   * @param array the array of strings to modify
   * @param index the index of the element to remove
   * @throws IllegalArgumentException if the array is null or the index is out of bounds
   */
  public static void removeElementInPlace(String[] array, int index) {
    if (array == null || index < 0 || index >= array.length) {
      throw new IllegalArgumentException("Array cannot be null and index must be within bounds.");
    }
    
    // A B C D E
    // 0
    // B C D E null

    // Traverse array starting at target index
    // Shift everything 1 left and stop at the last index
    // Set the last index as null

    for (int i = index; i < array.length-1; i++) {
      array[i] = array[i+1];
    }

    array[array.length-1] = null;
  }

  /**
   * Adds an element to an array of strings at a specified location in-place, evicting the last value.
   *
   * @param array the array of strings to modify
   * @param index the index at which to add the new element
   * @param value the value to add
   * @throws IllegalArgumentException if the array is null or the index is out of bounds
   */
  public static void addElementInPlace(String[] array, int index, String value) {
    if (array == null || index < 0 || index >= array.length) {
      throw new IllegalArgumentException("Array cannot be null and index must be within bounds.");
    }

    // A B C D E
    // X
    // X A B C D

    // Traverse array backwards stopping at target index
    // Shift everything 1 right
    // Overwrite index 0 as value

    for (int i = array.length-1; i > index; i--) {
      array[i] = array[i-1];
    }

    array[index] = value;
  }

  /**
   * Finds the tail of a singly linked list given the head.
   *
   * @param head the head node of the singly linked list
   * @return the tail node of the list, or null if the list is empty
   * @throws IllegalArgumentException if the head is null
   */
  public static SingleNode findTail(SingleNode head) {
    if (head == null) {
      throw new IllegalArgumentException("Head cannot be null.");
    }

    // A - .... ?
    // Traverse a linked list using the head
    // Stop at the last node that isn't null
    // That is the tail, return it

    SingleNode curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }

    return curr;
  }

  /**
   * Finds the head of a doubly linked list given the tail.
   *
   * @param tail the tail node of the doubly linked list
   * @return the head node of the list, or null if the list is empty
   * @throws IllegalArgumentException if the tail is null
   */
  public static DoubleNode findHead(DoubleNode tail) {
    if (tail == null) {
      throw new IllegalArgumentException("Tail cannot be null.");
    }

    // ? - .... tail
    // Traverse the linked list backwards starting at tail
    // Stop until prev is null
    // That is the head, return it

    DoubleNode curr = tail;
    while (curr.prev != null) {
      curr = curr.prev;
    }

    return curr;
  }

  /**
   * Counts the occurrences of values in a linked list.
   *
   * @param head the head node of the linked list
   * @return a map where the keys are the values in the list, and the values are the counts of occurrences
   * @throws IllegalArgumentException if the head is null
   */
  public static Map<Integer, Integer> countOccurrences(SingleNode head) {
    if (head == null) {
      throw new IllegalArgumentException("Head cannot be null.");
    }

    // Traverse linked list in a while loop

    HashMap<Integer, Integer> map = new HashMap<>();
    
    SingleNode curr = head;

    while (curr != null) {
      map.put(curr.data, map.getOrDefault(curr.data, 0)+1);
      curr = curr.next;

      /*
      if (map.containsKey(curr.data)) {
        map.put(curr.data, map.get(curr.data)+1);
      } else {
        map.put(curr.data, 1);
      }
      curr = curr.next;
       */
    }

    return map; 
  }

  /**
   * Removes a node from a doubly linked list.
   *
   * @param node the node to remove
   * @throws IllegalArgumentException if the node is null
   */
  public static void removeNode(DoubleNode node) {
    if (node == null) {
      throw new IllegalArgumentException("Node cannot be null.");
    }
    
    // Check if node isnt head/tail
    // If isnt head = node before curr points to curr.next
    // If isnt tail = next nodes prev points to curr.prev

    // if node isn't head
    if (node.prev != null) {
      node.prev.next = node.next;
    }

    // if node isn't tail
    if (node.next != null) {
      node.next.prev = node.prev;
    }
  }

  /**
   * Finds the nth element in a singly linked list.
   *
   * @param head the head node of the singly linked list
   * @param n the index of the element to find (0-based)
   * @return the nth node, or null if the index is out of bounds
   * @throws IllegalArgumentException if the head is null or n is negative
   */
  public static SingleNode findNthElement(SingleNode head, int n) {
    if (head == null || n < 0) {
      throw new IllegalArgumentException("Head cannot be null and n cannot be negative.");
    }
    // Traverse the linked list
    // Count the nodes
    // Return the node if it matches n

    SingleNode curr = head;
    int i = 0;
    while (curr != null) {
      if (i == n) {
        return curr;
      }
      i++;
      curr = curr.next;
    }
    return null; 
  }

  /**
   * Inserts a new node into a singly linked list given a pointer to a node in the middle of the list.
   *
   * @param node the node before which the new node is to be inserted
   * @param newNode the new node to insert
   * @throws IllegalArgumentException if either node or newNode is null
   */
  public static void insertNode(SingleNode node, SingleNode newNode) {
    if (node == null || newNode == null) {
      throw new IllegalArgumentException("Node and newNode cannot be null.");
    }

    // A B C D E
    //   B
    //   
    // if node isn't a tail
    if (node.next != null) {
      SingleNode n = node.next;
      node.next = newNode;
      newNode.next = n;
    } else {
      node.next = newNode;
    }
  }

  /**
   * Rotates a queue to the left by the specified number of positions in-place.
   * 
   * The first k elements of the queue are moved to the end, preserving the order
   * of all elements.
   *
   * Example:
   * Given a queue [1, 2, 3, 4, 5] and k = 2, the result will be [3, 4, 5, 1, 2].
   *
   * @param queue the queue to rotate
   * @param k the number of positions to rotate to the left
   * @throws IllegalArgumentException if the queue is null or k is negative
   */
  public static void rotateQueueLeft(Queue<Integer> queue, int k) {
    if (queue == null || k < 0) {
      throw new IllegalArgumentException("Queue cannot be null and k cannot be negative.");
    }
    
    int n = queue.size();
    k = k % n;
    for (int i = 0; i < k; i++) {
      queue.offer(queue.poll());
    }
  }

  /**
   * Checks if a string has balanced parentheses using a stack.
   * 
   * A string is considered to have balanced parentheses if each opening parenthesis
   * '(' has a corresponding closing parenthesis ')', and the parentheses are correctly nested.
   *
   * Example:
   * - Input: "(()())" -> Returns true
   * - Input: "(()" -> Returns false
   * - Input: ")" -> Returns false
   *
   * @param input the string to check
   * @return true if the string has balanced parentheses, false otherwise
   * @throws IllegalArgumentException if the input string is null
   */
  public static boolean hasBalancedParentheses(String input) {
    if (input == null) {
      throw new IllegalArgumentException("Input string cannot be null.");
    }

    Stack<Character> stack = new Stack<>();
    
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        if (!stack.isEmpty()) {
          stack.pop();
        } else {
          return false;
        }
      }
    }

    if (!stack.isEmpty()) {
      return false;
    }

    return true;
  }

}