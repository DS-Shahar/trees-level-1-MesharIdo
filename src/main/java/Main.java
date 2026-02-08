class Main 
{
  public static void main(String[] args) 
  {
    
  }

    public static boolean ex_22(BinNode<Integer> t)
    {
        if (t==null)
            return true;
            
        if (!t.hasRight() && t.hasLeft() || t.hasRight() && !t.hasLeft())
            return false;
            
        return ex_22(t.getLeft()) && ex_22(t.getRight())
    }
}
