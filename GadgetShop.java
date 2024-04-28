import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GadgetShop implements ActionListener 
{
    private JFrame frame;
    private JTextField modelField;
    private JTextField priceField;
    private JTextField weightField;
    private JTextField sizeField;
    private JTextField creditField;
    private JTextField memoryField;
    private JTextField phoneField;
    private JTextField durationField;
    private JTextField downloadField;
    private JTextField disnumberField;
    private JButton downloadinfoButton;
    private JButton clearButton;
    private JButton addmobileButton;
    private JButton addmp3Button;
    private JButton displayallButton;
    private JButton callButton;
    private JButton downloadmusicButton;
    private ArrayList<Gadget>gadgets;
    private HashMap<String, Integer> indexMap;

    public class Mobile extends Gadget 
    {
        private double credit;

        public Mobile(String model, double price, double weight, double size, double credit) 
        {
            super(model, price, weight, size);
            this.credit = credit;
        }
        
        public double getCredit() 
        {
            return credit;
        }

        public void setCredit(double credit) 
        {
            this.credit = credit;
        }
    }

    public class MP3Player extends Gadget 
    {
        private double memory;

        public MP3Player(String model, double price, double weight, double size, double memory) 
        {
            super(model, price, weight, size);
            this.memory = memory;
        }

        public double getMemory() 
        {
            return memory;
        }

        public void setMemory(double memory) 
        {
            this.memory = memory;
        }
    }

    public GadgetShop() 
    {   
        makeFrame();
        gadgets = new ArrayList<>();
        indexMap = new HashMap<>();
    }
    
    private void incorrectInput()
    {
        JOptionPane.showMessageDialog(frame,"Incorrect Input", "GadgetShop",JOptionPane.ERROR_MESSAGE);
    }
    
    private void makeFrame() 
    {
        frame = new JFrame("Gadget Shop");
        Container contentPane = frame.getContentPane();   

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        
        addRow1(contentPane);
        addRow2(contentPane);
        addRow3(contentPane);
        addRow4(contentPane);
        addRow5(contentPane);
        addButtonPanel(contentPane);

      
        clearButton.addActionListener(this);
        addmobileButton.addActionListener(this);
        addmp3Button.addActionListener(this);
        displayallButton.addActionListener(this);
        downloadmusicButton.addActionListener(this);
        callButton.addActionListener(this);
        downloadinfoButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addRow1(Container contentPane) 
    {
        JPanel row1 = new JPanel();
        row1.setLayout(new FlowLayout(FlowLayout.LEFT));
        row1.add(new JLabel("Model:"));
        row1.add(modelField = new JTextField(10));
        row1.add(new JLabel("Price:"));
        row1.add(priceField = new JTextField(10));
        row1.add(new JLabel("Weight:"));
        row1.add(weightField = new JTextField(10));
        contentPane.add(row1);
    }

    private void addRow2(Container contentPane) 
    {
        JPanel row2 = new JPanel();
        row2.setLayout(new FlowLayout(FlowLayout.LEFT));
        row2.add(new JLabel("Size:"));
        row2.add(sizeField = new JTextField(10));
        row2.add(new JLabel("Credit:"));
        row2.add(creditField = new JTextField(10));
        row2.add(new JLabel("Memory:"));
        row2.add(memoryField = new JTextField(10));
        contentPane.add(row2);
    }

    private void addRow3(Container contentPane) 
    {
        JPanel row3 = new JPanel();
        row3.setLayout(new FlowLayout(FlowLayout.LEFT));
        row3.add(new JLabel("Phone:"));
        row3.add(phoneField = new JTextField(10));
        row3.add(callButton = new JButton("Make A Call"));
        contentPane.add(row3);
    }

    private void addRow4(Container contentPane) 
    {
        JPanel row4 = new JPanel();
        row4.setLayout(new FlowLayout(FlowLayout.LEFT));
        row4.add(new JLabel("Duration:"));
        row4.add(durationField = new JTextField(10));
        row4.add(new JLabel("Download:"));
        row4.add(downloadField = new JTextField(10));
        contentPane.add(row4);
    }

    private void addRow5(Container contentPane) 
    {
        JPanel row5 = new JPanel();
        row5.setLayout(new FlowLayout(FlowLayout.LEFT));
        row5.add(new JLabel("Display Number:"));
        row5.add(disnumberField = new JTextField(10));
        contentPane.add(row5);
    }

    private void addButtonPanel(Container contentPane) 
    {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(clearButton = new JButton("Clear"));
        buttonPanel.add(addmobileButton = new JButton("Add Mobile"));
        buttonPanel.add(addmp3Button = new JButton("Add MP3"));
        buttonPanel.add(displayallButton = new JButton("Display All"));
        buttonPanel.add(downloadmusicButton = new JButton("Download Music"));
        buttonPanel.add(downloadinfoButton = new JButton("Download Help"));
        contentPane.add(buttonPanel);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable()
            {
                public void run() 
                {
                    new GadgetShop();
                }
            });
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == clearButton) 
        {
            clearFields();
        }
        else if (e.getSource() == callButton)
        {
            makeCall();
        }
        else if (e.getSource() == addmobileButton)
        {
            addMobile();
        }
        else if (e.getSource() == addmp3Button)
        {
            addMP3();
        }
        else if (e.getSource() == displayallButton)
        {
            displayAllGadgets();
        }
        else if (e.getSource() == downloadmusicButton)
        {
            downloadMusic();
            String userInput = disnumberField.getText().trim();
            try{
                int index = Integer.parseInt(userInput);
                getGadgetByIndex(index);
            }  catch (NumberFormatException ex) 
            {
                JOptionPane.showMessageDialog(frame, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }   
        else if (e.getSource() == downloadinfoButton)
        {
            JOptionPane.showMessageDialog(frame, "Enter the index for the required model in the 'Display Number' field ", "Help", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void addMP3() 
    {
        String model = modelField.getText();
        double size;
        double price;
        double memory;

        try {
            size = Double.parseDouble(sizeField.getText());
            price = Double.parseDouble(priceField.getText());
            memory = Double.parseDouble(memoryField.getText());
        } catch (NumberFormatException e) 
        {
            incorrectInput();
            return;
        }

        double weight;
        try {
            weight = Double.parseDouble(weightField.getText());
        } catch (NumberFormatException e) 
        {
            incorrectInput();
            return; 
        }

        MP3Player mp3Player = new MP3Player(model, price, weight, size, memory);
        gadgets.add(mp3Player);
        JOptionPane.showMessageDialog(frame, "MP3 succesfully added","MP3", JOptionPane.INFORMATION_MESSAGE);
        indexMap.put(model, gadgets.size() - 1);

        clearFields();
    }

    private void addMobile() 
    {
        String model = modelField.getText();
        double price;
        double size;
        double credit;

        try {
            price = Double.parseDouble(priceField.getText());
            size = Double.parseDouble(sizeField.getText());
            credit = Double.parseDouble(creditField.getText());
        } catch (NumberFormatException e) 
        {
            incorrectInput();
            return; 
        }

        double weight;
        try {
            weight = Double.parseDouble(weightField.getText());
        } catch (NumberFormatException e) 
        {
            incorrectInput();
            return; 
        }

        Mobile mobile = new Mobile(model, price, weight, size, credit);
        gadgets.add(mobile);
        JOptionPane.showMessageDialog(frame, "Mobile succesfully added","Mobile", JOptionPane.INFORMATION_MESSAGE);
        indexMap.put(model, gadgets.size() - 1);

        clearFields();
    }

    private void makeCall()
    {
        String phoneNumber = phoneField.getText();

        if (phoneNumber.isEmpty() || phoneNumber.length() != 10)
        {
            JOptionPane.showMessageDialog(frame, "Phone number must be exactly 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int callDuration = Integer.parseInt(durationField.getText());
        System.out.println("Calling: " + phoneNumber);
        System.out.println("Duration is " + callDuration + " minutes");
        clearFields();
    }

    private void displayAllGadgets() 
    {
        if (gadgets.isEmpty()) 
        {
            System.out.println("No gadgets added");
        } else 
        {
            System.out.println("List of gadgets:");
            for (Gadget gadget : gadgets) 
            {
                System.out.println("Model: " + gadget.getModel());
                System.out.println("Price: " + gadget.getPrice());
                System.out.println("Weight: " + gadget.getWeight());
                System.out.println("Size: " + gadget.getSize());
                if (gadget instanceof Mobile) 
                {
                    Mobile mobile = (Mobile) gadget;
                    System.out.println("Credit: " + mobile.getCredit());
                } else if (gadget instanceof MP3Player) 
                {
                    MP3Player mp3Player = (MP3Player) gadget;
                    System.out.println("Memory: " + mp3Player.getMemory());
                }
                System.out.println("-------------------------");
            }
        }
    }

    private void downloadMusic() 
    {
        String userInput = disnumberField.getText().trim();
        try {
            int index = Integer.parseInt(userInput);
            Gadget gadget = findGadgetByIndex(index);
            if (gadget != null) 
            {
                if (gadget instanceof MP3Player) 
                {
                    MP3Player mp3Player = (MP3Player) gadget;
                    String downloadInput = downloadField.getText().trim(); 
                    if (!downloadInput.isEmpty()) 
                    { 
                        try {
                            double downloadSize = Double.parseDouble(downloadInput);
                            System.out.println("Downloading music using " + mp3Player.getModel() + " with " + downloadSize + " memory usage.");
                        } catch (NumberFormatException e) 
                        {
                            JOptionPane.showMessageDialog(frame, "Invalid input for memory usage. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else 
                    {
                        JOptionPane.showMessageDialog(frame, "Please enter the amount of memory to use for downloading music.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else 
                {
                    JOptionPane.showMessageDialog(frame, "Selected gadget is not an MP3 player.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else 
            {
                JOptionPane.showMessageDialog(frame, "Invalid index or gadget not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) 
        {
            JOptionPane.showMessageDialog(frame, "Please enter a valid integer for the gadget index.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Gadget findGadgetByIndex(int index)
    {
        if (index >=0 && index < gadgets.size())
        {
            return gadgets.get(index);
        } else
        {
            return null;
        }
    }

    private void getGadgetByIndex(int index)
    {
        Gadget gadget = findGadgetByIndex(index);
        if(gadget != null)
        {
            System.out.println("Gadget found: " + gadget.getModel());
        } else 
        {
            JOptionPane.showMessageDialog(frame, "Invalid index or gadget not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() 
    {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneField.setText("");
        durationField.setText("");
        downloadField.setText("");
        disnumberField.setText("");
    }
}

