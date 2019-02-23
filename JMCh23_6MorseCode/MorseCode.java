import java.util.TreeMap;

/**
   Creates a Morse Code translator with a BST.

   @author  David Cheng 
   @version 1/30/19

   @author Period - 4
   @author Assignment - Morse Code

   @author Sources - reading
 */
public class MorseCode
{
    private static final char DOT = '.';
    private static final char DASH = '-';

    private static TreeMap<Character, String> codeMap;
    private static TreeNode<Character> decodeTree;

    public static void start()
    {
        codeMap = new TreeMap<Character, String>();

        // put a space in the root of the decoding tree
        decodeTree = new TreeNode<Character>(' ', null, null);  // autoboxing

        addSymbol('A', ".-");
        addSymbol('B', "-...");
        addSymbol('C', "-.-.");
        addSymbol('D', "-..");
        addSymbol('E', ".");
        addSymbol('F', "..-.");
        addSymbol('G', "--.");
        addSymbol('H', "....");
        addSymbol('I', "..");
        addSymbol('J', ".---");
        addSymbol('K', "-.-");
        addSymbol('L', ".-..");
        addSymbol('M', "--");
        addSymbol('N', "-.");
        addSymbol('O', "---");
        addSymbol('P', ".--.");
        addSymbol('Q', "--.-");
        addSymbol('R', ".-.");
        addSymbol('S', "...");
        addSymbol('T', "-");
        addSymbol('U', "..-");
        addSymbol('V', "...-");
        addSymbol('W', ".--");
        addSymbol('X', "-..-");
        addSymbol('Y', "-.--");
        addSymbol('Z', "--..");
        addSymbol('0', "-----");
        addSymbol('1', ".----");
        addSymbol('2', "..---");
        addSymbol('3', "...--");
        addSymbol('4', "....-");
        addSymbol('5', ".....");
        addSymbol('6', "-....");
        addSymbol('7', "--...");
        addSymbol('8', "---..");
        addSymbol('9', "----.");
        addSymbol('.', ".-.-.-");
        addSymbol(',', "--..--");
        addSymbol('?', "..--..");
    }

    /**
     *  Inserts a letter and its Morse code string into the encoding map
     *  and calls treeInsert to insert them into the decoding tree.
     */
    private static void addSymbol(char letter, String code)
    {
        codeMap.put( letter, code );
        treeInsert(letter, code);
    }

    /**
     *  Inserts a letter and its Morse code string into the
     *  decoding tree.  Each dot-dash string corresponds to a path
     *  in the tree from the root to a node: at a "dot" go left, at
     *  a "dash" go right.  The node at the end of the path holds
     *  the symbol for that code string.
     */
    private static void treeInsert(char letter, String code)
    {
        TreeNode<Character> root = decodeTree;
        
        char[] array = code.toCharArray();
        
        for (char character : array)
        {              
            if (character == DOT)
            {
                if (root.getLeft() == null)
                {
                    root.setLeft( new TreeNode<Character>(' ', null, null) );
                }
                root = root.getLeft();
            }
            else //if character == DASH
            {
                if (root.getRight() == null)
                {
                    root.setRight( new TreeNode<Character>(' ', null, null) );
                }
                root = root.getRight();
            }
        }
        
        root.setValue( letter );
        
        root = decodeTree;
    }

    /**
     *   Converts text into a Morse code message.  Adds a space after
     *   a dot-dash sequence for each letter.  Other spaces in the text
     *   are transferred directly into the encoded message.
     *
     *   @return the encoded message.
     */
    public static String encode(String text)
    {
        StringBuffer morse = new StringBuffer(400);
        
        char[] array = text.toCharArray(); //
                
        for (char character : array)
        {
            if (character == ' ')
            {
                morse.append( character );
            }
            else
            {
                character = Character.toUpperCase( character );
                
                if (codeMap.containsKey(character))
                {
                    morse.append( codeMap.get( character ) + " " );
                }
            }
        }

        return morse.toString();
    }

    /**
     *   Converts a Morse code message into a text string.  Assumes
     *   that dot-dash sequences for each letter are separated by one
     *   space.  Additional spaces are transferred directly into text.
     *
     *   @return the plain text message.
     */
    public static String decode(String morse)
    {
        StringBuffer text = new StringBuffer(100);
        TreeNode<Character> og = decodeTree;
        TreeNode<Character> temp = decodeTree;

        char[] array = morse.toCharArray();
        
        int i = 0;
        
        for (char character : array)
        {
            if (character == ' ')
            {
                text.append( temp.getValue() );
                temp = og;
                i++;
            }
            
            else if (character == DOT)
            {
                if (i == array.length - 1)
                {
                    temp = temp.getLeft();
                    text.append( temp.getValue() );
                }
                else
                {
                    temp = temp.getLeft();    
                    i++;
                }              
            }
            
            else if (character == DASH)
            {
                if (i == array.length - 1)
                {
                    temp = temp.getRight();
                    text.append( temp.getValue() );
                }
                else
                {
                    temp = temp.getRight();    
                    i++;
                }  
            }
        }

        return text.toString();
    }

    //--------------------------------------------------------------------
    // For test purposes only. Not to be used in completing the assignment

    public TreeMap<Character, String> getCodeMap()
    {
        return codeMap;
    }

    public TreeNode<Character> getDecodeTree()
    {
        return decodeTree;
    }
}