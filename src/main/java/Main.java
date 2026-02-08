public class Main 
{

    public static void main(String[] args) 
    {
        BinNode<Integer> t15 = new BinNode<Integer>(15);
		BinNode<Integer> t14 = new BinNode<Integer>(14);
		BinNode<Integer> tree = new BinNode<Integer>(t15, 3, t14);
		BinNode<Integer> t9 = new BinNode<Integer>(66);
		tree.getLeft().setLeft(new BinNode<Integer>(t9, 22, new BinNode<Integer>(7)));
		tree.getLeft().setRight(new BinNode<Integer>(new BinNode<Integer>(34), 56, new BinNode<Integer>(12)));
		System.out.println(tree);
		setValueEzZ(tree);
		System.out.println(tree);
		int hwmn = howMany(tree);
		System.out.println(hwmn);
    }
    
    
    public static void setValueEzZ(BinNode<Integer> t)
    {
        int x=0;
        if (t==null)
        {
            return;
        }
        if (t.getValue()%2==0)
        {
            t.setValue(t.getValue()%10);
        }
        else
        {
            x = t.getValue();
            while (x>10)
            {
                x= x/10;
            }
                t.setValue(x);
        }
        setValueEzZ(t.getLeft());
        setValueEzZ(t.getRight());
    }
    
    
    public static int howMany(BinNode<Integer> t)
    {
        int times =0;
        if (t==null)
        {
            return 0;
        }
        if (t.getValue()%2==0 && t.getValue()%3==0)
        {
            times++;
        }
        howMany(t.getRight());
        howMany(t.getLeft());
        return times;
    }
    
    public static void ex1(BinNode<Integer> t) 
    {
        if (t == null) 
          return;
    
        if (t.getValue() % 2 == 0 &&
            (!t.hasLeft() || t.getLeft().getValue() % 2 == 0) &&
            (!t.hasRight() || t.getRight().getValue() % 2 == 0)) 
        {
            System.out.println(t.getValue());
        }
    
        ex1(t.getLeft());
        ex1(t.getRight());
    }
    
    public static int ex2(BinNode<Integer> t) 
    {
        if (t == null) 
          return 0;
    
        int count = 0;
        if (t.getValue() % 2 == 0 &&
            (!t.hasLeft() || t.getLeft().getValue() % 2 == 0) &&
            (!t.hasRight() || t.getRight().getValue() % 2 == 0)) 
        {
            count = 1;
        }
        return count + ex2(t.getLeft()) + ex2(t.getRight());
    }
    
    public static boolean ex3(BinNode<Integer> t) 
    {
        if (t == null) 
          return false;
    
        if (t.getValue() % 2 == 0 &&
            (!t.hasLeft() || t.getLeft().getValue() % 2 == 0) &&
            (!t.hasRight() || t.getRight().getValue() % 2 == 0)) 
        {
            return true;
        }
        return ex3(t.getLeft()) || ex3(t.getRight());
    }
    
    public static boolean ex4(BinNode<Integer> t) 
    {
        if (t == null) 
          return true;
    
        if (t.getValue() % 2 == 0 &&
           ((t.hasLeft() && t.getLeft().getValue() % 2 != 0) ||
            (t.hasRight() && t.getRight().getValue() % 2 != 0))) 
        {
            return false;
        }
        return ex4(t.getLeft()) && ex4(t.getRight());
    }
    
    
    public static int heightex_27(BinNode<Integer> t) 
    {
    if (t == null) 
    {
        return 0;
    }

    int left = heightex_27(t.getLeft());
    int right = heightex_27(t.getRight());

    if (left > right) 
    {
        return left + 1;
    }
    return right + 1;
    }


    
    public static boolean isBalanced ex_21(BinNode<Integer> t) 
    {
        if (t == null) 
        {
            return true;
        }
    
        int leftHeight = heightex_27(t.getLeft());
        int rightHeight = heightex_27(t.getRight());
        
        if (leftHeight - rightHeight > 1) 
        {
            return false;
        }
        if (rightHeight - leftHeight > 1) 
        {
            return false;
        }
        return isBalancedex_21(t.getLeft()) && isBalancedex_21(t.getRight());
    }
    
    public static boolean numOfLeafs(BinNode<Integer> t)
    {
        if (t == null) 
        {
            return 0;
        } 
        
        if (!t.hasleft() && !t.hasRight())
        {
            return 0;
        }
        int a = numOfLeafs(t.getLeft()); +1;
        int b = numOfLeafs(t.getRight()); +1;
        return a+b;
    }
    
    
    public static boolean ex_22(BinNode<Integer> t)
    {
        if (t==null)
            return true;
            
        if (!t.hasRight() && t.hasLeft() || t.hasRight() && !t.hasLeft())
            return false;
            
        return ex_22(t.getLeft()) && ex_22(t.getRight())
    }
    
    public static int ex_23Max(BinNode<Integer> t, int max)
    {
        if (t==null)
            return 0;
        
        if (t.getValue()>max)
        {
            max=t.getValue();
        }
        
        int a = ex_23Max(t.getLeft(),max);
        int b = ex_23Max(t.getRight(),max);
        if (a>b)
            return a;
        return b;
    }
    
    
    public static int ex_23Min(BinNode<Integer> t, int min)
    {
        if (t==null)
            return 0;
        
        if (t.getValue()<min)
        {
            min=t.getValue();
        }
        
        int a = ex_23Min(t.getLeft(),min);
        int b = ex_23Min(t.getRight(),min);
        if (a<b)
            return a;
        return b;
    }
    
    public static boolean ex_26Per(BinNode<Integer> t)
    {
        int a = heightex_27(t);
        int b = numOfLeafs(t);
        if (a*2==b)
        {
            return true;
        }
        return false;
    }
    
    

}

