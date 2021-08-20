import java.util.Scanner;

public class BinaryTree     //implements a binary tree
{
    QuestionNode root;

    public BinaryTree() // Class constructor needs to be same name as class
    {

        root = new QuestionNode("","Does it live in the water?");   //set up root node with a question

        // set up root edges ("yes" and "no") with answers
        root.yes = new QuestionNode("frog","");     // root.yes answer FROG does live in the water
        root.no = new QuestionNode("bear","");      // root.no answer BEAR does NOT live in the water

        /*
        question.add("frog","Does it have legs?");
        question.add("shark", "Does it live in the water?");
        question.add("goat", "Does it have fur?");
        question.add("lemur", "Is it smaller than a washing machine?");
        question.add("kangaroo", "Is it a mammal?");
        question.add("whale", "Is it bigger than a car?");
        */

    }

    public void walk()
    {

        Scanner sc2 = new Scanner(System.in);

        QuestionNode current = root;            // starts at root
        QuestionNode parent = null;     // just initialize a temp parent node to hold answer of current node

        while (true) {

          // current = root;
            // current.Question = "Does it live on land?";     // set first default question
            // current.Answer = "";


            ////////////   If we currently have a QUESTION... ///////////
            if (!current.Question.equals(""))   // as long as we still have a question
            {

                System.out.println("Current question: " + current.Question);    // displays current question

                // System.out.println("yes or no?");          // asks user which path they want to walk down

                String ans = sc2.next();   // user input
                sc2.nextLine();

                parent = current;   // copy current to a temp parent node

                if (ans.equals("no"))    // if the user answers "no" for the question, for instance "it does NOT live in water")
                {
                    current = current.no;   // goes on to the next node, (question)

                } else    // if the user answers "yes"
                {
                    current = current.yes;
                }

                // System.out.println(current);
            }


            //Now looking at "next" node, Either following the "no" path or "yes" path
            //////////////    Otherwise we currently have an ANSWER    ////////////
            if (!current.Answer.equals(""))     // if we DO have an answer, we either win or need to gather some info to grow program's "knowledge"
            {
                System.out.println("Is the animal you're thinking of a " + current.Answer + "?");

                String ans = sc2.next();   // user input
                sc2.nextLine();

                if (ans.equals("no"))    // Couldn't find right animal
                {
                    System.out.println("I give up, what animal were you thinking of?");
                    String newAnswer = sc2.next();
                    sc2.nextLine();  // clear index after next()

                    System.out.println("Write a question that would differentiate a " + newAnswer + " from a " + current.Answer);
                    String newQuestion = sc2.nextLine();

                    // create new node with new information   V
                    // QuestionNode question = new QuestionNode()
                    System.out.println("What would be the answer for " + newAnswer + "?");
                    String edge = sc2.next();
                    sc2.nextLine(); //clear index again after next()

                  //  System.out.println("newAnswer: "+newAnswer);
                    // System.out.println("newQuestion: " +newQuestion);

                    QuestionNode answer = new QuestionNode(newAnswer, "");      // new tree node of answer given
                    QuestionNode question = new QuestionNode("", newQuestion);


                    if (edge.equals("no")) {

                       if (current==parent.no) // if you said no to current question
                       {
                           parent.no = question;
                           parent.no.yes = current;
                           parent.no.no = answer;
                       }
                        else if (current==parent.yes)
                        {
                            parent.yes = question;
                            parent.yes.no = answer;
                            parent.yes.yes = current;
                        }
   /*

                       current.yes = new QuestionNode(current.Answer,"");
                        current.no = new QuestionNode(newAnswer,"");

                        current.yes.Answer = current.Answer;
                        current.yes.Question = "";

                        current.no.Answer = newAnswer;
                        current.no.Question = "";

                        current.Question = parent.Question;     // set current node to be a question now
                        current.Answer = parent.Answer;
*/
                    }
                    if (edge.equals("yes")) {       // if yes, the animal should go to the yes side


                        if (current==parent.no)
                        {
                            parent.no = question;     //
                            parent.no.yes = answer;
                            parent.no.no = current;
                        }
                        else if (current==parent.yes)
                        {
                            parent.yes = question;
                            parent.yes.no = current;
                            parent.yes.yes = answer;

                        }
                        //current = question;


                        /*
                        current.yes = new QuestionNode(newAnswer,"");
                        current.no = new QuestionNode(current.Question, "");

                        current.yes.Answer = newAnswer;
                        current.yes.Question = "";

                        current.no.Answer = current.Answer;
                        current.no.Question = "";

                        current.Question = parent.Question;     // set current node to be a question now
                        current.Answer = parent.Answer;

                   */

                    }


                    Problem1_BrennerCampos.totalAnimals++;  // at this point  we now have added a new animal (as well as enw question)

                    System.out.println("THANKS! I NOW KNOW " + Problem1_BrennerCampos.totalAnimals + " ANIMALS!");
                    System.out.println("PLAY AGAIN?");

                    String playAgain = sc2.next();
                    sc2.nextLine();

                    if (!playAgain.equals("yes"))    // if anything other than yes, break out of loop and exit program
                    {
                           break;
                    }

                    current=root;
                    //parent=null;
                    // if (parent.yes = current)
                    // we know frog is on the yes branch

                    // we want newQuestion to point to newAnswer
                    // if correct answer = yes, then question.yes = animal

                    // question.no = current (frog)

                }

                else    // if it WAS the right animal
                {
                    System.out.println("AWWW, YEAH!! I WIN!");
                    System.out.println("PLAY AGAIN?");

                    String playAgain = sc2.next();
                    sc2.nextLine();

                    if (!playAgain.equals("yes"))    // if anything other than yes, break out of loop and exit program
                    {
                        break;
                    }

                    current=root;
                    //current=root;
                }



            }
            //else
            //{
                //System.out.println("Current question: "+ current.Question);

          //  }

            // }


        }


    }

    public void print()
    {

        print_rec(root);

    }

    public void print_rec(QuestionNode current)
    {
        //base case
        if (current == null)
            return;     // don't print, just stop going down that path

        // call this on current's left,
        print_rec(current.no);
        System.out.println(current.Answer);
        // call this on current's right
        print_rec(current.yes);

    }

    public void add(String answer, String question)  //takes value, puts it in a valid place in the tree (somewhere where it's left of everybody bigger and right of everybody smaller
    {
        QuestionNode current = root;    // starts looking at the root
/*
        if (current == null)     //empty tree is a special case. Make it the root and return;
        {
            root = new QuestionNode(answer,question);
            return;
        }

        while (true)
        {

            if (!answer.equals(current.Answer)) // if it is not the answer...
            {

                if (current.left == null) //if it's null, don't go left (will lose track of the tree)
                {
                    current.left = new QuestionNode(answer,question);
                    break; //done with loop
                }
                current = current.left;
            }
            else    //otherwise it's bigger or equal, so go right
            {
                if (current.yes == null) //if it's null, don't go left (will lose track of the tree)
                {
                    current.yes = new QuestionNode(answer,question);
                    break; // done with loop
                }
                current = current.yes;
            }
*/
    }




    private class QuestionNode     ///// encapsulate single node on tree, and provides links to other nodes
    {
        //a TreeNode object consists of...

        String Question;   //actual data
        String Answer;

        QuestionNode no;  //points to left child
        QuestionNode yes; //points to right child

        public QuestionNode(String answer, String question)      ///// constructor, make a Question node for every element that I add to tree
        {

            Answer = answer;
            Question = question;
            no = null;
            yes = null;


        }

    }


}
