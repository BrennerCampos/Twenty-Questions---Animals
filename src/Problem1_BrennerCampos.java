import java.util.Scanner;

public class Problem1_BrennerCampos
{

    public static Scanner sc = new Scanner(System.in);      //public static scanner so you can use the input between classes/methods
    public static int totalAnimals = 2; // we start knowing 2 animals

    public static void main (String[] args)
    {
         Scanner sc = new Scanner(System.in);

         System.out.println("***ANIMAL LEARNING GAME***");
         System.out.println("HAVE YOU EVER PLAYED BEFORE?");
         String userInput = sc.next();

         if (userInput.equals("no"))
            {

                  System.out.println(   "INSTRUCTIONS\n");
                  System.out.println(
                                        "YOU WILL THINK OF AN ANIMAL AND I WILL TRY TO GUESS WHAT ANIMAL YOU ARE\n" +
                                        "THINKING OF.  I WILL DO THIS BY ASKING YOU A SERIES OF QUESTIONS ABOUT\n" +
                                        "YOUR ANIMAL, TO WHICH YOU RESPOND EITHER YES OR NO. IF I DO NOT GUESS\n" +
                                        "WHAT YOUR ANIMAL IS, I WILL ASK YOU A FEW QUESTIONS SO THAT NEXT TIME I\n" +
                                        "WILL KNOW WHAT YOUR ANIMAL IS.\n");

                  //  System.out.println("DOES IT LIVE IN THE WATER?");
            }

        new Problem1_BrennerCampos();


         //if (userInput.equals("yes"))
        // {
        // ask first question
         //    new Problem1_BrennerCampos();
            // System.out.println("DOES IT LIVE IN THE WATER?");
       //  }

       // userInput = sc.next();




    }


    public Problem1_BrennerCampos()
    {
        BinaryTree question = new BinaryTree();

        question.walk();
        /*
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(100);
        tree.root.right = new TreeNode(17);
        tree.root.left.left = new TreeNode(8);
        tree.root.left.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(41);
         */
        //tree.walk();

        //question.print();
    }


}
