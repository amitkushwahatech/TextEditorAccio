import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Text2 implements ActionListener {
    // frame for text editor
    JFrame frame;
    //menubar for containing menues
    JMenuBar menuBar;
    // for menu
    JMenu file,edit,themes,fontColor;

    //menu items for file menu
    JMenuItem newFile, openFile, saveFile;

    //menu items for edit menu
    JMenuItem cut, copy, paste, selectAll,fontSize, close;
    //menu items for theme
    JMenuItem darkTheme, lightTheme;

    //menu items for color
    JMenuItem red, blue, green,white, yellow,orange;


    //menu items for font


    //Area for writing text
    JTextArea textArea;

    Text2(){
        // Initialize JFrame object -- jFrame --.> simple frame minimize,full display , close X
        frame =new JFrame();
        //Initialize menubar
        menuBar = new JMenuBar();

        //Initialize textares
        textArea = new JTextArea();

        // before setting to the frame add this menu to menubar
        //initialize menu
        file = new JMenu("File");
        edit = new JMenu("Edit");
        themes = new JMenu("Themes");
        fontColor = new JMenu("Color");

        //initialize menu item for file menu
        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");

        //Add Action Listener to File menu items
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);

        //Adding menu items to file menu
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);

        //initialize menu item for edit menu
        cut =new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        fontSize = new JMenuItem("Font Size");
        close = new JMenuItem("Close");


        //Add Action Listener to Edit menu items
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        fontSize.addActionListener(this);
        close.addActionListener(this);

        //Adding menu items to edit menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(fontSize);
        edit.add(close);

        //initialize menu items for themes  menu
        darkTheme = new JMenuItem("Dark Theme");
        lightTheme = new JMenuItem("Light Theme");
        //Add action Listener to themes menu
        darkTheme.addActionListener(this);
        lightTheme.addActionListener(this);

        //Adding menu items to themes menu
        themes.add(darkTheme);
        themes.add(lightTheme);

        //initialize menu items for fontColor  menu
        red = new JMenuItem("Red");
        green = new JMenuItem("Green");
        yellow = new JMenuItem("Yellow");
        blue = new JMenuItem("Blue");
        white = new JMenuItem("White");
        orange = new JMenuItem("Orange");
        //Add action Listener to themes menu
        red.addActionListener(this);
        green.addActionListener(this);
        yellow.addActionListener(this);
        blue.addActionListener(this);
        white.addActionListener(this);
        orange.addActionListener(this);

        //Adding menu items to fontColor menu
        fontColor.add(red);
        fontColor.add(green);
        fontColor.add(blue);
        fontColor.add(yellow);
        fontColor.add(white);
        fontColor.add(orange);

        // Add menus to menubar
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(themes);
        menuBar.add(fontColor);
        // Add menubar to the frame
        frame.setJMenuBar(menuBar);

        //Adding text area to frame
        frame.add(textArea);

        // decide starting and width and height
        //set dimention for frame
        frame.setBounds(100,100,500,500);
        //make the visible frame
        // mark frame as unHidden
        frame.setVisible(true);
        textArea.setLineWrap(true);

    }

    @Override
    public void  actionPerformed(ActionEvent actionEvent){
        // getSource --> where action will perform
        //If source is cut
        if(actionEvent.getSource()==cut){
            //Perform Action according to cut event
            textArea.cut();
        }
        // if source is copy
        if(actionEvent.getSource()==copy){
            //Perform Action according to copy event
            textArea.copy();
        }
        //If source is paste
        if(actionEvent.getSource()==paste){
            //Perform paste
            textArea.paste();
        }
        //If source is selectAll
        if(actionEvent.getSource()==selectAll){
            //Perform paste
            textArea.selectAll();
        }
        //If source is fontSize
        if(actionEvent.getSource()==fontSize){
            String sizeOfFont = JOptionPane.showInputDialog("Enter font Size",JOptionPane.OK_CANCEL_OPTION);

            if(sizeOfFont!=null){
                int  convertSizeOfFont = Integer.parseInt(sizeOfFont);
                Font font = new Font(Font.SANS_SERIF,Font.PLAIN,convertSizeOfFont);
                textArea.setFont(font);
            }
        }
        //If source is close
        if(actionEvent.getSource()==close){
            //Perform close
            System.exit(0);
        }

        //If source is darkTheme
        if(actionEvent.getSource()==darkTheme){
            textArea.setBackground(Color.DARK_GRAY);
            textArea.setForeground(Color.white);

        }
        //If source is lightTheme
        if(actionEvent.getSource()==lightTheme){
            textArea.setBackground(new Color(107,169,255));
            textArea.setForeground(Color.black);
        }
        //If source is red color
        if(actionEvent.getSource()==red){
            textArea.setForeground(Color.red);
        }
        //If source is green color
        if(actionEvent.getSource()==green){
            textArea.setForeground(Color.green);
        }
        //If source is blue color
        if(actionEvent.getSource()==blue){
            textArea.setForeground(Color.blue);
        }
        //If source is white color
        if(actionEvent.getSource()==white){
            textArea.setForeground(Color.white);
        }
        //If source is yellow color
        if(actionEvent.getSource()==yellow){
            textArea.setForeground(Color.yellow);
        }
        //If source is orange color
        if(actionEvent.getSource()==orange){
            textArea.setForeground(Color.orange);
        }

        //If source is new
        if(actionEvent.getSource()==newFile){
            //Create new window
            Text2 newWindow = new Text2();
        }
        // If source is open
        if(actionEvent.getSource()==openFile){
            //Open a text file
            //Intialize file chooser
            JFileChooser fileChooser = new JFileChooser("C:");
            //Get choose option rom file chooser
            int chooseOption = fileChooser.showOpenDialog(null);
            //If choose option approve
            if(chooseOption==JFileChooser.APPROVE_OPTION){
                //get selected file
                File file = fileChooser.getSelectedFile();
                //Get selected file path
                String filePath = file.getPath();
                try{
                    //to read a file -->BufferdReader
                    //Created Bufferrad reader
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                    //Create strings to store content from fie
                    String intermediate = "", output="";
                    //Read content line by line
                    while((intermediate = bufferedReader.readLine())!=null){
                        output = output + intermediate+"\n";
                    }
                    //Set output to text Area
                    textArea.setText(output);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        }

        // If source is save
        if(actionEvent.getSource()==saveFile){
            //save a file
            //Create a file chooser
            JFileChooser fileChooser = new JFileChooser("C:");
            //Get choosen option from file chooser
            int chooseOption = fileChooser.showSaveDialog(null);
            if(chooseOption==JFileChooser.APPROVE_OPTION){
                //Create a file object with selected path
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath()+".text");
                try{
                    //Create buffered writer to write content to file
                    BufferedWriter outfile = new BufferedWriter(new FileWriter(file));
                    //get content from text area to outfile
                    textArea.write(outfile);
                    outfile.close();
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {

        System.out.println("Hello world!");
        //Initialize Text2
        Text2 text2 = new Text2();
    }
}