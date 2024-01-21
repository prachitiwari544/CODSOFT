import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

// StudentGradeCalculator class 
public class StudentGradeCalculator extends JFrame implements ActionListener {

    int totalSubjects;
    JTextField[] marks;
    JButton exit, calculate;

    //StudentGradeCalculator class constructor to create a GUI where user can enter marks in each subject
    StudentGradeCalculator(int totalSubjects) {
        this.totalSubjects = totalSubjects;
        setLayout(null);
        getContentPane().setBackground(Color.CYAN);
        setSize(800, 600);
        setVisible(true);
        setBounds(300, 100, 800, 600);
        setTitle("Student Grade Calculator");

        JLabel text = new JLabel("STUDENT  GRADE  CALCULATOR");
        text.setFont(new Font("Railway", Font.BOLD, 30));
        text.setBounds(140, 30, 500, 35);
        add(text);

        JLabel statement = new JLabel("* Enter your marks obtained out of 100 in each subject.");
        statement.setFont(new Font("Railway", Font.BOLD, 25));
        statement.setBounds(70, 80, 650, 30);
        add(statement);

        int space = 0;
        //an array of textfields to store marks of different subject
        marks = new JTextField[totalSubjects];
        // a loop to create different textfields and label for different subjects
        for (int i = 0; i < totalSubjects; i++) {
            JLabel subject = new JLabel("Subject" + (i + 1) + " :");
            subject.setFont(new Font("Railway", Font.BOLD, 25));
            subject.setBounds(250, (130 + space), 150, 30);
            add(subject);

            marks[i] = new JTextField();
            marks[i].setBackground(Color.white);
            marks[i].setFont(new Font("Railway", Font.BOLD, 25));
            marks[i].setBounds(400, (120 + space), 150, 30);
            add(marks[i]);
            space += 40;
        }
        
        // exit button to exit from the calculator
        exit = new JButton("EXIT");
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Railway", Font.BOLD, 20));
        exit.setBounds(210, 470, 140, 35);
        add(exit);
        exit.addActionListener(this);

        // calculate button which will open a new frame with result
        calculate = new JButton("CALCULATE");
        calculate.setBackground(Color.BLACK);
        calculate.setForeground(Color.WHITE);
        calculate.setFont(new Font("Railway", Font.BOLD, 20));
        calculate.setBounds(420, 470, 160, 35);
        add(calculate);
        calculate.addActionListener(this);

    }

    //ActionListener for StudentGradeCalculator
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == exit) {
            JOptionPane.showMessageDialog(null, "If you exit you won't be able to calculate your grade.");
            System.exit(0);
        } else if (ae.getSource() == calculate) {
            // initially total marks will be 0;
            int totalMarks = 0;
            // a for loop to calculate totalMarks stored in marks array
            for (int j = 0; j < totalSubjects; j++) {
                totalMarks += Integer.parseInt(marks[j].getText());
            }
            // average calculated
            float average = Math.round((totalMarks / (float) totalSubjects) * 100) / 100.0f;
            setVisible(false);
            // new class is called
            new ShowGrade(totalMarks, average).setVisible(true);

        }

    }

    // main method to invoke StudentGradeCalculator constructor and take input of totalSubjects
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of subjects more than 0 and less than 9 : ");
        int totalSubjects = sc.nextInt();
        new StudentGradeCalculator(totalSubjects);
        sc.close();
    }
}

// ShowGrade class 
class ShowGrade extends JFrame implements ActionListener {
    int totalMarks;
    float average;
    JButton exit;

    //ShowGrade class constructor to create a frame which display result
    ShowGrade(int totalMarks, float average) {
        this.totalMarks = totalMarks;
        this.average = average;
        setLayout(null);
        getContentPane().setBackground(Color.CYAN);
        setSize(600, 400);
        setVisible(true);
        setBounds(400, 200, 600, 400);

        JLabel text = new JLabel("CALCULATED  RESULT");
        text.setFont(new Font("Railway", Font.BOLD, 30));
        text.setBounds(150, 25, 350, 35);
        add(text);

        JLabel calculatedMarks = new JLabel("Total Marks Obtained :  " + totalMarks);
        calculatedMarks.setFont(new Font("Railway", Font.BOLD, 25));
        calculatedMarks.setBounds(150, 90, 350, 30);
        add(calculatedMarks);

        JLabel calculatedAverage = new JLabel("Average Percentage:  " + average + "%");
        calculatedAverage.setFont(new Font("Railway", Font.BOLD, 25));
        calculatedAverage.setBounds(150, 130, 350, 30);
        add(calculatedAverage);

        // calculating grade according to the average percentage
        String grade = "";
        if (average >= 97.0f) {
            grade += "A+";
        } else if (average >= 90.0f) {
            grade = "A";
        } else if (average >= 87.0f) {
            grade += "B+";
        } else if (average >= 80.0f) {
            grade += "B";
        } else if (average >= 77.0f) {
            grade += "C+";
        } else if (average >= 70.0f) {
            grade += "C";
        } else if (average >= 67.0f) {
            grade += "D+";
        } else if (average >= 60.0f) {
            grade += "D";
        } else {
            grade += "F";
        }

        JLabel calculatedGrade = new JLabel("Grade: " + grade);
        calculatedGrade.setFont(new Font("Railway", Font.BOLD, 25));
        calculatedGrade.setBounds(150, 170, 300, 30);
        add(calculatedGrade);

        // exit button to exit ShowGrade frame
        exit = new JButton("EXIT");
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Railway", Font.BOLD, 22));
        exit.setBounds(240, 300, 120, 30);
        add(exit);
        exit.addActionListener(this);

    }

    // ActionListener for ShowGrade class
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        }
    }

}