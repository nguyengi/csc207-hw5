package skip;

// Citation: some ideas about implementation taken from 
// http://stackoverflow.com/questions/2942235/deleting-a-node-from-a-skip-list?rq=1

/**
 * Skip lists of strings, stored alphabetically.
 */
public class SkipListOfStrings
    implements
      SetOfStrings
{
  public double p = 0.5;
  public int MAX_NODES = 16;
  public int highest = 1;
  StringNode start;

  public SkipListOfStrings()
  {
    start = new StringNode(null, new StringNode[MAX_NODES]);
  } // SkipListOfStrings()

  @Override
  public boolean contains(String str)
  {
    StringNode check = start;
    // iterates through levels
    for (int i = highest - 1; i >= 0; i--)
      {
        // loop through nodes until encounters end node, in which case go
        // down a level
        while (check.nodes[i] != null)
          {
            if (check.nodes[i].contents.equals(str))
              return true;
            if (check.nodes[i].contents.compareTo(str) > 0)
              // if the next node exceeds str, go down a level
              break;
            // if the next node does not exceed str, go to next node
            check = check.nodes[i];
          } // while
      } // for
    return false;
  } // contains (String)

  @Override
  public void add(String str)
  {
    StringNode node = new StringNode(str, new StringNode[randomLevel()]);
    if (highest < node.nodes.length)
      highest = node.nodes.length;
    StringNode check = start;
    // iterates through levels
    for (int i = highest - 1; i >= 0; i--)
      {
        // loop through nodes until encounters end node, in which case go
        // down a level
        while (check.nodes[i] != null)
          {
            if (check.nodes[i].contents.compareTo(str) > 0)
              // if the next node exceeds str, break to check if it is the
              // correct place, or go down a level
              break;
            // if the next node does not exceed str, go to next node
            check = check.nodes[i];
          } // while
        if (i < node.nodes.length)
          {
            // if level should be pointing to new node, insert
            node.nodes[i] = check.nodes[i];
            check.nodes[i] = node;
          } // if
      } // for
  } // add (String)

  @Override
  public void remove(String str)
  {
    StringNode check = start;
    // iterates through levels
    for (int i = highest - 1; i >= 0; i--)
      {
        // loop through nodes until encounters end node, in which case go
        // down a level
        while (check.nodes[i] != null)
          {
            // if next node is the one, change the reference
            if (check.nodes[i].contents.equals(str))
              {
                check.nodes[i] = check.nodes[i].nodes[i];
                break;
              } // if
            if (check.nodes[i].contents.compareTo(str) > 0)
              // if the next node exceeds str, or go down a level
              break;
            // if the next node does not exceed str, go to next node
            check = check.nodes[i];
          } // while
      } // for

  } // remove (String)

  private int randomLevel()
  {
    int lvl = 1;
    while (lvl < MAX_NODES && (Math.random() <= p))
      {
        lvl++;
      } // while
    return lvl;
  } // randomLevel()

  @Override
  public String toString()
  {
    String str = "[";
    StringNode check = start;
    while (check.nodes[0] != null)
      {
        str += (check.nodes[0].contents + ", ");
        check = check.nodes[0];
      } // while
    str += "]";
    return str;
  } // toString()

} // class SkipListOfStrings
