import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ATM class to create a user interface to deposit, withdraw money and check account balance
public class ATM extends JFrame implements ActionListener{
    JButton exit, withdraw, checkBalance, deposit;
    JTextField amount;
    UserDetails obj = new UserDetails();

    //ATM class constructor
    ATM(){
        setLayout(null);
        ImageIcon i1 = new ImageIcon(".//Atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(800,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,600);
        add(image);
        setSize(800,600);
        setUndecorated(true);
        setVisible(true);
        setLocation(300,60);

        JLabel text = new JLabel("Welcome to the ATM");
        text.setBounds(190,100,350,30);
        text.setFont(new Font("System",Font.BOLD,28));
        text.setForeground(Color.BLACK);
        image.add(text);

        JLabel label = new JLabel("Please select your Transaction");
        label.setBounds(190,215,350,22);
        label.setFont(new Font("System",Font.BOLD,20));
        image.add(label);

        //Button to deposit money in account 
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(190,265,130,25);
        deposit.setFont(new Font("System",Font.PLAIN,16));
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        image.add(deposit);
        deposit.addActionListener(this);

        //Button to withdraw money from account
        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(345,265,130,25);
        withdraw.setFont(new Font("System",Font.PLAIN,16));
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.WHITE);
        image.add(withdraw);
        withdraw.addActionListener(this);

        //Button to check account balance
        checkBalance = new JButton("BALANCE");
        checkBalance.setBounds(190,300,130,25);
        checkBalance.setFont(new Font("System",Font.PLAIN,16));
        checkBalance.setBackground(Color.BLACK);
        checkBalance.setForeground(Color.WHITE);
        image.add(checkBalance);
        checkBalance.addActionListener(this);

        //Button to exit from ATM interface
        exit = new JButton("EXIT");
        exit.setBounds(345,300,130,25);
        exit.setFont(new Font("System",Font.PLAIN,16));
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        image.add(exit);
        exit.addActionListener(this);

        JLabel label2 = new JLabel("Enter the amount (Deposit/Withdraw):");
        label2.setBounds(135,430,300,24);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setForeground(Color.BLACK);
        image.add(label2);

        //textfield to enter the amount to deposit or withdraw
        amount = new JTextField();
        amount.setBounds(420,430,100,24);
        amount.setFont(new Font("Railway",Font.BOLD,16));
        image.add(amount);

        


    }
    //main method to invoke ATM constructor to create GUI
    public static void main(String[] args){
        new ATM();
    }
    
    //ActionListener for buttons in ATM constructor
    public void actionPerformed(ActionEvent ae){
        
        //action to be performed after EXIT button is clicked
        if(ae.getSource() == exit){
            JOptionPane.showMessageDialog(null,"If you exit you won't be able to access the ATM");
            System.exit(0);

        }

        //action to be performed after DEPOSIT button is clicked with exception handling
        else if(ae.getSource() == deposit){
            try{
            int transactionAmount = Integer.parseInt(amount.getText());
            obj.deposit(transactionAmount);
            JOptionPane.showMessageDialog(null,"Rs "+transactionAmount+" successfully deposited");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Invalid Input.Please enter a valid numeric value");
            }
        }

        //action to be performed after WITHDRAW button is clicked with exception handling
        else if(ae.getSource() == withdraw){
            try{
                int transactionAmount = Integer.parseInt(amount.getText());
                String status = obj.withdraw(transactionAmount);
                if(status.equals("successful")){
                   JOptionPane.showMessageDialog(null,"Rs "+transactionAmount+" successfully withdrawl");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Transaction Failed. Insufficient Balance");
                }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Invalid Input.Please enter a valid numeric value");
                }

        }

        //action to be performed after BALANCE button is clicked
        else if(ae.getSource() == checkBalance){
            int balance = obj.balanceInquiry();
            JOptionPane.showMessageDialog(null,"Balance Amount: Rs "+balance);
        }

    }

}

class UserDetails{
    int balanceAmount;

    //UserDetails Constructor with initial balance as Rs 0
    UserDetails(){
        this.balanceAmount=0;
    }

    //method to deposit money
    public void deposit(int depositAmount){
        this.balanceAmount+=depositAmount;
    }

    //method to withdraw money with withdrawl status
    public String withdraw(int withdrawAmount){
        String status;

        if(withdrawAmount<= balanceAmount){
            this.balanceAmount-=withdrawAmount;
            status="successful";
        }
        else{
            status="fail";
        }
        return status;
    }

    //method to check balance 
    public int balanceInquiry(){
        return this.balanceAmount;
    }

}
