import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class PolicyTimer
{
     private static int check = 0;//Check will contain 0 for general, 1 for ourprep, and  2 for their prep.
     
     public static int getCheck()
     {
         return check;    
     }
     
     public static void setCheck(int value)
     {
         check = value;
     }
     
	public static void main(String[] args)
	{
		JFrame frame = new PolicyFrame();
		
		final Time time = new Time(48000);
    final Time ourTime = new Time(30000);
    final Time theirTime = new Time(30000);

   /*final JLabel label = new JLabel(time.toString());
    label.setOpaque(true);
    label.setBackground(Color.RED);
    label.setForeground(Color.WHITE);
    label.setFont(label.getFont().deriveFont(size));
    label.setHorizontalAlignment( SwingConstants.CENTER );*/
    float size = 30;

    final JTextField textField = new JTextField(time.toString());
    textField.setOpaque(true);
    textField.setBackground(Color.red);
    textField.setForeground(Color.white);
    textField.setFont(textField.getFont().deriveFont(size));
    textField.setHorizontalAlignment(SwingConstants.CENTER);
    
		JButton startButton = new JButton("Start!");
		JButton stopButton = new JButton("Stop!");
		JButton constructive = new JButton("Constructive");
		JButton crossEx = new JButton("Cross Ex");
                JButton rebuttal = new JButton("Rebuttal");
                JButton ourPrep = new JButton("Our Prep");
                JButton theirPrep = new JButton("Their Prep");
                
		JPanel panel1 = new JPanel(new GridLayout(4,2));
                
                panel1.add(textField);
		panel1.add(startButton);
                panel1.add(stopButton);
		panel1.add(constructive);
                panel1.add(crossEx);
                panel1.add(rebuttal);
		panel1.add(ourPrep);
                panel1.add(theirPrep);
                panel1.setBackground(Color.GREEN);
		frame.add(panel1);
                
		class TimerListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
                                boolean changeColor = false;
				if(PolicyTimer.getCheck() == 2)
                                {                          
                                    changeColor = theirTime.subtractASecond();
                                    textField.setText(theirTime.toString());
                                }
                                else if(PolicyTimer.getCheck()== 1)
                                {
                                    changeColor = ourTime.subtractASecond();
                                    textField.setText(ourTime.toString());
                                }   
                                else
                                {
                                    changeColor = time.subtractASecond();
                                    textField.setText(time.toString());
                                }
                                if(changeColor)
                                {
                                   textField.setBackground(Color.RED);
                                   textField.setForeground(Color.WHITE);
                                }
                                else
                                {
                                   textField.setBackground(Color.GREEN);
                                   textField.setForeground(Color.BLACK);

                                }
			}
		}

		ActionListener listener = new TimerListener();
                
		final Timer t = new Timer(1000, listener);
                
                class TextBox implements ActionListener,  MouseListener
                {
                    public void actionPerformed(ActionEvent event)
                    {
                           String text = textField.getText();
                           int index = text.indexOf(":");
                           if(index == -1)
                           {
                               
                           }
                           else
                           {
                               int minutes;
                               int seconds;
                                try
                                {
                                    minutes = Integer.parseInt(text.substring(0, index).replaceAll(" ", ""));                               
                                    seconds = Integer.parseInt(text.substring(index+1).replaceAll(" ",""));
                                }
                                catch(Exception e)
                                {
                                    if(check == 0)
                                    {
                                        minutes = time.minutes;
                                        seconds = time.seconds;
                                    }
                                    else if(check == 1)
                                    {
                                        minutes = ourTime.minutes;
                                        seconds = ourTime.seconds;
                                    }
                                    else
                                    {
                                        minutes = theirTime.minutes;
                                        seconds = theirTime.seconds;
                                    }
                                }        
                                if(check == 0)
                                {
                                    time.reset(seconds, minutes); 
                                    textField.setText(time.toString());
                                }
                                else if(check == 1)
                                {
                                    ourTime.reset(seconds,minutes);
                                    textField.setText(ourTime.toString());
                                }
                                else if(check == 2)
                                {
                                    theirTime.reset(seconds,minutes);
                                    textField.setText(theirTime.toString());
                                }
                           }
                           t.start();
                                 
                    }

                    public void mouseClicked(MouseEvent e) {
                        t.stop();
                    }

                    public void mousePressed(MouseEvent e) {
                        
                    }

                    public void mouseReleased(MouseEvent e) {
                        
                    }

                    public void mouseEntered(MouseEvent e) {
                        
                    }

                    public void mouseExited(MouseEvent e) {
                        
                    }
               }
                ActionListener textBoxActionListener = new TextBox();
                textField.addActionListener(textBoxActionListener);
                MouseListener textBoxMouseListener = new TextBox();
                textField.addMouseListener(textBoxMouseListener);
		class Start implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
                                String text = textField.getText();
                                int index = text.indexOf(":");
                                if(index == -1)
                                {

                                }
                                else
                                {
                                    int minutes;
                                    int seconds;
                                        try
                                        {
                                            minutes = Integer.parseInt(text.substring(0, index).replaceAll(" ", ""));                               
                                            seconds = Integer.parseInt(text.substring(index+1).replaceAll(" ",""));
                                        }
                                        catch(Exception e)
                                        {
                                            if(check == 0)
                                            {
                                                minutes = time.minutes;
                                                seconds = time.seconds;
                                            }
                                            else if(check == 1)
                                            {
                                                minutes = ourTime.minutes;
                                                seconds = ourTime.seconds;
                                            }
                                            else
                                            {
                                                minutes = theirTime.minutes;
                                                seconds = theirTime.seconds;
                                            }
                                        }        
                                        if(check == 0)
                                        {
                                            time.reset(seconds, minutes); 
                                            textField.setText(time.toString());
                                        }
                                        else if(check == 1)
                                        {
                                            ourTime.reset(seconds,minutes);
                                            textField.setText(ourTime.toString());
                                        }
                                        else if(check == 2)
                                        {
                                            theirTime.reset(seconds,minutes);
                                            textField.setText(theirTime.toString());
                                        }
                                }
				t.start();
				if(PolicyTimer.getCheck() == 2)  
                                    textField.setText(theirTime.toString());
                                else if(PolicyTimer.getCheck() == 1)
                                    textField.setText(ourTime.toString());
                                else
                                    textField.setText(time.toString());
			}
		}
		class OurPrep implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
                                textField.setBackground(Color.RED);
                                textField.setForeground(Color.WHITE);
				t.stop();
				textField.setText(ourTime.toString());
                                PolicyTimer.setCheck(1);

			}
		}
 		class ThierPrep implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
                                textField.setBackground(Color.RED);
                                textField.setForeground(Color.WHITE);
				t.stop();
				textField.setText(theirTime.toString());
                                PolicyTimer.setCheck(2);
			}
		}
              
		class Eight implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
                                textField.setBackground(Color.RED);
                                textField.setForeground(Color.WHITE);
                                t.stop();
                                time.reset(48000);
                                PolicyTimer.setCheck(0);
				textField.setText(time.toString());
			}
		}
		
		class Stop implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				textField.setBackground(Color.GREEN);
                                textField.setForeground(Color.BLACK);
                                t.stop();
				if(PolicyTimer.getCheck() == 2)  
                                    textField.setText(theirTime.toString());
                                else if(PolicyTimer.getCheck() == 1)
                                    textField.setText(ourTime.toString());
                                else
                                    textField.setText(time.toString());
			}
		}
		class Five implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
                                textField.setBackground(Color.RED);
                                textField.setForeground(Color.WHITE);
				time.reset(30000);
				t.stop();
                                PolicyTimer.setCheck(0);
				textField.setText(time.toString());
			}
		}
		class Three implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				textField.setBackground(Color.RED);
                                textField.setForeground(Color.WHITE);
                                time.reset(18000);
				t.stop();
                                PolicyTimer.setCheck(0);
				textField.setText(time.toString());
			}
		}

		startButton.addActionListener(new Start());		
		stopButton.addActionListener(new Stop());
		constructive.addActionListener(new Eight());
                rebuttal.addActionListener(new Five());
                crossEx.addActionListener(new Three());
                ourPrep.addActionListener(new OurPrep());
                theirPrep.addActionListener(new ThierPrep());
		frame.setVisible(true);
	}
}

		
