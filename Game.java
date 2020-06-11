// Yoho Chen
// Game.java
// 4/23/2012
// This program will allow user to play a game called LIGHTNING.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Game extends JApplet
{

	private int value,bosshit,sub,waitwin,loading,nx,ny,herocounter,sub2;
	private int bossnukey[]= new int[99];
	private int bossfirex[]= new int[9];
	private int bossfirey[]= new int[9];
	private int useless[] = new int[113];
	private int enfireleftx[] = new int[113];
	private int enfirelefty[] = new int[113];
	private int enfirerightx[] = new int[113];
	private int enfirerighty[] = new int[113];
	private int enfirex[] = new int[113];
	private int enfirey[] = new int[113];
	private int herofirex[] = new int[99];
	private int herofirey[] = new int[99];
	private int planex[] = new int[113];
	private int planey[] = new int[113];
	private int xpos, ypos;
	private int bossnukex;
	private JPanel p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11;
	private Image i1, i2, i3, i4, i5, i6, i7, i8, i9,i10, i11, i12, i13, i14, i15, i16 ,i17, i18, i19, i20, i21, i22, i23;
	private Image i24, i25, bo1,bo2,bo3,bo4,bo5,bo6,bo7,l1,l2,l3,l4,l5,n1,n2,n3,n4,n5,w,db1,db2,logo;
	private int val, heart, missile, score, level,bulletcounter,savecounter,bosscounter,bossnukecounter;
	private CardLayout card;
	private Container con;
	private boolean flame, herofire, bossdie, loadbossfire,bossnuke,recount,startloading,drawtip,heronuke,blood;
	public Game()
	{
		blood =false;
		waitwin =0;
		loading = 0;
		sub =sub2=0;
		bosshit = 0;
		recount = startloading = drawtip= heronuke = false;
	    bossnuke =true;
		loadbossfire = false;
		bulletcounter = -1;
		flame = herofire = bossdie = false;
		xpos = 280;
		ypos = 500;
		val = 1700;
		level = 0;
		score = 0;
		heart = missile = 3;
		savecounter = bosscounter= herocounter = 0;
	}
	public void init()
	{
		con = this.getContentPane();
		card = new CardLayout();
		con.setLayout(card);


		p1 = new menuPanel();
		p1.setBackground(Color.black);
        con.add(p1, "menu");

        p0 = new startPanel();
		p0.setBackground(Color.black);
		con.add(p0,"start");

        p2 = new levelPanel();
		p2.setBackground(Color.black);
        con.add(p2, "level");

        p3 = new helpPanel();
		p3.setBackground(Color.black);
        con.add(p3, "help");

        p7 = new savePanel();
        p7.setBackground(Color.black);
        con.add(p7, "save");

        p4 = new gamePanel();
		p4.setBackground(Color.black);
        con.add(p4, "game");

        p5 = new barPanel();
		p5.setBackground(Color.white);
        con.add(p5, "bar");

        p6 = new endPanel();
		p6.setBackground(Color.black);
        con.add(p6, "end");

        p8 = new pausePanel();
        p8.setBackground(Color.white);
        con.add(p8, "pause");

        p9 = new occupyPanel();
        p9.setBackground(Color.black);
        con.add(p9, "occupy");

        p10 = new winPanel();
        p10.setBackground(Color.black);
        con.add(p10, "win");

        p11 = new introPanel();
        p10.setBackground(Color.white);
        con.add(p11, "intro");



		i1 = getImage ( getDocumentBase ( ), "background.jpg" );
		WaitForImage ( this, i1 );
		i2 = getImage ( getDocumentBase ( ), "earth.png" );
		WaitForImage ( this, i2 );
		i3 = getImage ( getDocumentBase ( ), "yellowhero.gif" );
		WaitForImage ( this, i3 );
		i4 = getImage ( getDocumentBase ( ), "space1.jpg" );
		WaitForImage ( this, i4 );
		i5 = getImage ( getDocumentBase ( ), "diji.gif" );
		WaitForImage ( this, i5 );
		i6 = getImage ( getDocumentBase ( ), "atomic.gif" );
		WaitForImage ( this, i6 );
		i7 = getImage ( getDocumentBase ( ), "heart.gif" );
		WaitForImage ( this, i7 );
		i8 = getImage ( getDocumentBase ( ), "flame2.gif" );
		WaitForImage ( this, i8 );
		i9 = getImage ( getDocumentBase ( ), "herozidan3.gif" );
		WaitForImage ( this, i9 );
		i10 = getImage ( getDocumentBase ( ), "space2.jpg" );
		WaitForImage ( this, i10 );
		i11 = getImage ( getDocumentBase ( ), "gameover.jpg" );
		WaitForImage ( this, i11 );
		i12 = getImage ( getDocumentBase ( ), "emptybar.gif" );
		WaitForImage ( this, i12 );
		i13 = getImage ( getDocumentBase ( ), "bar1.gif" );
		WaitForImage ( this, i13 );
		i14 = getImage ( getDocumentBase ( ), "space2.jpg" );
		WaitForImage ( this, i14 );
		i15 = getImage ( getDocumentBase ( ), "spacebar.gif" );
		WaitForImage ( this, i15 );
		i16 = getImage ( getDocumentBase ( ), "bullet.gif" );
		WaitForImage ( this, i16 );
		i17 = getImage ( getDocumentBase ( ), "restart.png" );
		WaitForImage ( this, i17 );
		i18 = getImage ( getDocumentBase ( ), "occ.gif" );
		WaitForImage ( this, i18 );
		i19 = getImage ( getDocumentBase ( ), "boss.gif" );
		WaitForImage ( this, i19 );
		i20 = getImage ( getDocumentBase ( ), "yellowhero.gif" );
		WaitForImage ( this, i20 );
		i21 = getImage ( getDocumentBase ( ), "bullet2.gif" );
		WaitForImage ( this, i21 );
		i22 = getImage ( getDocumentBase ( ), "bossnuke.gif" );
		WaitForImage ( this, i22 );
		i23 = getImage ( getDocumentBase ( ), "yellow.jpg" );
		WaitForImage ( this, i23 );
		i24 = getImage ( getDocumentBase ( ), "bar3.gif" );
		WaitForImage ( this, i24 );
		i25 = getImage ( getDocumentBase ( ), "intro.gif" );
		WaitForImage ( this, i24 );
		bo1 = getImage ( getDocumentBase ( ), "b1.gif" );
		WaitForImage ( this, bo1 );
		bo2 = getImage ( getDocumentBase ( ), "b2.gif" );
		WaitForImage ( this, bo2 );
		bo3 = getImage ( getDocumentBase ( ), "b3.gif" );
		WaitForImage ( this, bo3 );
		bo4 = getImage ( getDocumentBase ( ), "b4.gif" );
		WaitForImage ( this, bo4 );
		bo5 = getImage ( getDocumentBase ( ), "b5.gif" );
		WaitForImage ( this, bo5 );
		bo6 = getImage ( getDocumentBase ( ), "b6.gif" );
		WaitForImage ( this, bo6 );
		bo7 = getImage ( getDocumentBase ( ), "b7.gif" );
		WaitForImage ( this, bo7 );
		l1 = getImage ( getDocumentBase ( ), "l1.gif" );
		WaitForImage ( this, l1 );
		l2 = getImage ( getDocumentBase ( ), "l2.gif" );
		WaitForImage ( this, l2 );
		l3 = getImage ( getDocumentBase ( ), "l3.gif" );
		WaitForImage ( this, l3 );
		l4 = getImage ( getDocumentBase ( ), "l4.gif" );
		WaitForImage ( this, l4 );
		l5 = getImage ( getDocumentBase ( ), "l5.gif" );
		WaitForImage ( this, l5 );
		n1 = getImage ( getDocumentBase ( ), "nuke1.gif" );
		WaitForImage ( this, n1 );
		n2 = getImage ( getDocumentBase ( ), "nuke2.gif" );
		WaitForImage ( this, n2 );
		n3 = getImage ( getDocumentBase ( ), "nuke3.gif" );
		WaitForImage ( this, n3 );
		n4 = getImage ( getDocumentBase ( ), "nuke4.gif" );
		WaitForImage ( this, n4 );
		n5 = getImage ( getDocumentBase ( ), "nuke5.gif" );
		WaitForImage ( this, n5 );
		w = getImage ( getDocumentBase ( ), "white.png" );
		WaitForImage ( this, w );
		db1 = getImage ( getDocumentBase ( ), "db1.gif" );
		WaitForImage ( this, db1 );
		db2 = getImage ( getDocumentBase ( ), "db2.gif" );
		WaitForImage ( this, db2 );
		logo = getImage ( getDocumentBase ( ), "logo.jpg" );
		WaitForImage ( this, logo );


	}
	public void WaitForImage ( JApplet component, Image image )   //loading the photos
		{
			MediaTracker tracker = new MediaTracker ( component );
			try
			{
				tracker.addImage ( image, 0 );
				tracker.waitForID ( 0 );
			}
			catch ( InterruptedException e )
			{
				e.printStackTrace ( );
			}
		}
	public class startPanel extends JPanel implements ChangeListener, ActionListener //////////////////////////////// start question
	{
		private JButton enter;
		private JLabel showVal;
		private JSlider slide;
		public startPanel()
		{
			this.setLayout(null);
			showVal = new JLabel(""+val, JLabel.CENTER);
            showVal.setForeground((Color.white));
            showVal.setFont(new Font("Sans",Font.BOLD,40));
            showVal.setBounds(195, 350, 200, 40);
            this.add(showVal);

			slide = new JSlider(1700, 1900,1700);
            slide.addChangeListener(this);
            slide.setBackground(Color.black);
			slide.setBounds(50,300,500,50);
			slide.setMajorTickSpacing(50);
			slide.setPaintTicks(true);
			slide.setPaintLabels(true);
			slide.setValue(val);
		    this.add(slide);

		    enter = new JButton("Enter");
		    enter.addActionListener(this);
		    enter.setForeground(Color.black);
		    enter.setFont(new Font("Sans",Font.BOLD,40));
		    enter.setBounds(220,450,160,80);
		    this.add(enter);
		}
		public void actionPerformed(ActionEvent e)        //to show the Enter button
        {
            String command = e.getActionCommand();
             if( command.equals("Enter")&&val == 1776)//
   			{
   				card.show(con,"bar"); ///////////////////correct
			}
   		}
   		public void stateChanged(ChangeEvent evt) // Adjust color base on slider
		{
			val = slide.getValue();
			showVal.setText(""+val);
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent ( g );
			g.setColor(Color.white);
			g.setFont ( new Font ( "Helvetica", Font.BOLD, 28 ) );
			g.drawString ("Please Answer the Entrance Question:",30,50);
			g.setFont ( new Font ( "Helvetica", Font.BOLD, 25 ) );
			g.drawString ("In which year did United States",120,150);
			g.drawString ("declare independence?",120,200);
		}
	}
	public class menuPanel extends JPanel implements ActionListener ///////////////////////////////////////////////// Menu
	{
		private JLabel title;
		private JButton goToGame, help, levelButt;
		public menuPanel()
       {
              this.setLayout(null);

              title = new JLabel("LIGHTNING", JLabel.CENTER); // title of the game
              title.setForeground(new Color(254,249,33));
              title.setFont(new Font("Sans",Font.BOLD,100));
              title.setBounds(10, 0, 580, 200);
              this.add(title);

              help = new JButton("Help");
              help.setBounds(10, 450, 150, 80);
              help.setForeground(new Color(0,5,255));
              help.addActionListener(this);
              help.setFont(new Font("Sans",Font.BOLD,30));
              this.add(help);

              goToGame = new JButton("Go To Game");
              goToGame.setBounds(180, 420, 240, 110);
              goToGame.setForeground(new Color(0,5,255));
              goToGame.addActionListener(this);
              goToGame.setFont(new Font("Sans",Font.BOLD,32));
              this.add(goToGame);

              levelButt = new JButton("Level");
              levelButt.setBounds(440, 450, 150, 80);
              levelButt.addActionListener(this);
              levelButt.setForeground(new Color(0,5,255));
              levelButt.setFont(new Font("Sans",Font.BOLD,30));
              this.add(levelButt);
       }
        public void paintComponent(Graphics g)      //paint compoent
		{
			super.paintComponent(g);
			g.drawImage ( i1, 0,50 ,615,450,this );
		}
       public void actionPerformed(ActionEvent e)
       {
       		String command = e.getActionCommand();
       		if(command.equals("Help"))
            {
                card.show(con, "help");
            }
            if(command.equals("Level"))
            {
				card.show(con, "level");
			}
			if(command.equals("Go To Game"))
			{
				card.show(con, "bar");
			}

	   }

	}

	public class levelPanel extends JPanel implements ActionListener /////////////////////////////////////////////////  Level
	{
		private JButton back;
		private JLabel levelTitle;
		private ButtonGroup levelOption;
		private JRadioButton easy, normal, hard;
		public levelPanel()
	   {
			this.setLayout(new FlowLayout(FlowLayout.CENTER,400, 50));
			levelOption = new ButtonGroup();

			levelTitle = new JLabel("Level Setting",JLabel.CENTER);
            levelTitle.setForeground(new Color(254,249,33));
            levelTitle.setFont(new Font("Sans",Font.BOLD,70));
            this.add(levelTitle);

			easy = new JRadioButton("Easy");
			levelOption.add(easy);
			easy.addActionListener(this);
            this.add(easy);

            normal = new JRadioButton("Normal");
			levelOption.add(normal);
			normal.addActionListener(this);
            this.add(normal);

            hard = new JRadioButton("Hard");
			levelOption.add(hard);
			hard.addActionListener(this);
            this.add(hard);

			back = new JButton("BACK");
			back.addActionListener(this);
			back.setBounds(10, 0, 580, 200);
            this.add(back);


       }
       public void actionPerformed(ActionEvent e)
       {
       		String command = e.getActionCommand();
       		if(command.equals("BACK"))
            {
                card.show(con, "menu");
            }
            if(easy.isSelected())
            {
				level = 0;
            }
            if(normal.isSelected())
            {
				level = 1;
            }
            if(hard.isSelected())
            {
				level = 2;
            }

	   }
	   public void paintComponent(Graphics g)      //paint compoent
	  {
			super.paintComponent(g);
			g.drawImage ( i2, 0, 0 ,600,600,this );
	  }
	}

	public class helpPanel extends JPanel implements ActionListener/////////////////////////////////////////////////  Help
	{
		private JTextArea helpText;
		private JScrollPane scroll;
		private JButton next;
		private String text;
		public helpPanel()
       {
            this.setLayout(new BorderLayout());//

            text = "Aliens have been trying to attack the Earth since 17th Century\n"
				+ "However, there is no provable evidence to show their existence\n"
				+ "Until the upcoming day: December, 25th, 2012\n"
				+ "Aliens are going to launch a all-out attack on earth and\n"
				+ "You will be the only one who can control the lightning battleplane\n"
				+ "against them in space and prevent them break through the gate of the Earth\n\n\n"
				+ "Objective:\n"
           		+ "Destroy your enermies and save the Earth\n\n\n"
				+ "Control:\n"
				+ "use ARROW in keyboard to control the plane\n"
				+ "use SPACE to fire\n"
				+ "use ALT to use a Nuke\n"
				+ "\n\n"
				+ "Tip:\n"
				+ "You can get some extra help\n"
				+ "if you answer the questions\n"
				+ "correctly during the game\n\n\n\n\n\n\n\n\n\n\n\n\n" ;

            helpText = new JTextArea(0,0);
            helpText.setForeground(Color.white);
            helpText.setText(text);
            helpText.setMargin(new Insets(50,50,50,50) );
            helpText.setFont(new Font("Serif", Font.PLAIN, 20 ));
            helpText.setBackground(Color.black);

            scroll = new JScrollPane(helpText);
            this.add(scroll);



            next = new JButton("Continue"); //goint back
            this.add(next,BorderLayout.SOUTH);
			next.addActionListener(this);
       }
       public void actionPerformed(ActionEvent e)
       {
       		String command = e.getActionCommand();
       		if(command.equals("Continue"))
            {
               card.show(con, "intro");
            }
	   }
	}

	public class gamePanel extends JPanel implements KeyListener,ActionListener////////////////////////////////////// game
	{
		String ques1 = "What is the SPEED of light?";
		String a1 = "  A. 30000m/s";
     	String b1 = "  B. 300000000m/s";
       	String c1 = "  C. 3000000000000m/s";
        String ques2 =	"What is the SPEED of sound?";
        String a2 = "  A. 25m/s";
       	String b2 = "  B. 120m/s";
       	String c2 = "  C. 340m/s";
       	String ques3 = "Who abolish the slavery in 1863";
       	String a3 = "  A. George Washington";
       	String b3 = "  B. Abraham Lincoln";
       	String c3 = "  C. Barack Obama";
       	String ques4 = "<HTML>Which object ensures that only<BR> one button in a group can<br> be selected?<HTML>";
       	String a4 = "  A. JMenuItem";
       	String b4 = "  B. ActionListener";
       	String c4 = "  C. ButtonGroup";
       	String ques5 = "<html>What is the 1st <br>element in periodic table?";
       	String a5 = "  A. Helium";
       	String b5 = "  B. Hydrogen";
       	String c5 = "  C. Hassium";
       	String ques6 = "<html>What shape will this conic going<br> to be if its eccentricity is 1";
       	String a6 = "  A. Hyperbola";
       	String b6 = "  B. Parabola";
       	String c6 = "  C. Both";
       	String ques7 = "<html>There are 2 green balls and<br> 2 yellow balls in the bag,<br>What is the probability of <br>graping a WHITE ball?";
       	String a7 = "  A. 1";
       	String b7 = "  B. 0.5";
       	String c7 = "  C. 0";
       	String ques8 = "<html>What is the sum of <br>angles inside a pentagon?";
       	String a8 = "  A. 180";
       	String b8 = "  B. 360";
       	String c8 = "  C. 540";
       	String ques9 = "<html>Which object transfers<br> mechanical energy into<br>electronic energy?";
       	String a9 = "  A. Generator";
       	String b9 = "  B. Motor";
       	String c9 = "  C. Computer";
       	String ques10 = "Who invented light bulb?";
       	String a10 = "  A. Thomas Edison";
       	String b10 = "  B. Michael Jordan";
       	String c10 = "  C. Albert Einstein";
       	String ques11 = "<html>If a ball has volumn of 5mL <br>and mass of 10g,<br>What is the density of the ball?";
       	String a11 = "  A. 2";
       	String b11 = "  B. 5";
       	String c11 = "  C. 50";
       	String ques12 = "Who teaches Yoho JAVA?";
       	String a12 = "  A. Mr.Dong";
       	String b12 = "  B. Mr.Greenstein";
       	String c12 = "  C. Mr.DeRuiter";

		private JLabel pro;
		private ButtonGroup choose;
		public JRadioButton a,b,c;
		private boolean upPressed, leftPressed;
		private int backgroundY;
		private int backadd;
		private int planeadd;
		private JLabel scoreprint;
		private boolean up;
		private boolean down;
		private boolean left;
		private boolean right;

		public gamePanel()
       {
		    this.setLayout(null);
		    addKeyListener(this);

			backgroundY =  0;
		    backadd = 2;
		    planeadd = 0;
			RepaintAction action = new RepaintAction();
			RepaintAction2 action2 = new RepaintAction2();
			RepaintAction3 action3 = new RepaintAction3();
			RepaintAction4 action4 = new RepaintAction4();

			loadPlane();
			loadFire();
			loadFireleft();
			loadFireright();
			Timer starTimer = new Timer(45, action); // timer 15 45
			Timer bossTimer = new Timer(600, action2);
			Timer bossNukeTimer = new Timer(50,action3);
			Timer effect = new Timer(600,action4);
			bossTimer.start();
     		starTimer.start();
     		bossNukeTimer.start();
     		effect.start();


            pro = new JLabel();
         	pro.setFont(new Font("Sans",Font.BOLD,28));
         	pro.setForeground((Color.white));
  			pro.setBounds(50, 70, 550, 200);
            p7.add(pro);

            choose = new ButtonGroup();
            a = new JRadioButton();				//a
            a.setBackground((Color.black));
            a.setForeground((Color.white));
            a.setFont(new Font("Sans",Font.BOLD,30));
            a.setBounds(50, 300, 400, 70);
            a.addActionListener(this);
            choose.add(a);
            p7.add(a);
            b = new JRadioButton();				//b
            b.setBackground((Color.black));
            b.setForeground((Color.white));
            b.setFont(new Font("Sans",Font.BOLD,30));
            b.setBounds(50, 400, 400, 70);
            b.addActionListener(this);
            choose.add(b);
            p7.add(b);
            c = new JRadioButton();				//c
            c.setBackground((Color.black));
            c.setForeground((Color.white));
            c.setFont(new Font("Sans",Font.BOLD,30));
            c.setBounds(50, 500, 400, 70);
            c.addActionListener(this);
            choose.add(c);
            p7.add(c);
       }
      public void loadPlane()
       {
		    File intfile = null;
			intfile = new File("plane.txt");
			Scanner fromfile = null;
			try
			{
				fromfile = new Scanner(intfile);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not Found!");
				System.exit(1);
			}
				for(int i =0; i<113; i++)
				{
					planex[i]= fromfile.nextInt();
					planey[i]= fromfile.nextInt();
				}
       }
       public void loadFire()
       {
		    File intfile = null;
			intfile = new File("plane.txt");
			Scanner fromfile = null;
			try
			{
				fromfile = new Scanner(intfile);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not Found!");
				System.exit(1);
			}
			for(int i =0; i<112; i++)
			{
				enfirex[i] = fromfile.nextInt()+18;
				useless[i] = fromfile.nextInt();
			}
       }
        public void loadFireleft()
       {

		    File intfile = null;
			intfile = new File("plane.txt");
			Scanner fromfile = null;
			try
			{
				fromfile = new Scanner(intfile);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not Found!");
				System.exit(1);
			}
				for(int i =0; i<112; i++)
				{
					enfireleftx[i] = fromfile.nextInt()+18;
					useless[i] = fromfile.nextInt();
				}
       }
       public void loadFireright()
       {

		    File intfile = null;
			intfile = new File("plane.txt");
			Scanner fromfile = null;
			try
			{
				fromfile = new Scanner(intfile);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not Found!");
				System.exit(1);
			}
				for(int i =0; i<112; i++)
				{
					enfirerightx[i] = fromfile.nextInt()+18;
					useless[i] = fromfile.nextInt();
				}
       }
       public void paintComponent(Graphics g)
       {
			super.paintComponent(g);
			backgroundY = backgroundY+backadd;
			if(level == 0)
			backadd = backadd+6;
			if(level == 1)
			backadd = backadd+8;
			if(level == 2)
			backadd = backadd+10;
			g.drawImage ( i4, 0 ,0+backadd,600,600,this ); //background
			for(int i=0; i<999; i++) //background movement
			{
				g.drawImage(i4,0,backadd-600*i,600,600,this);
			}
			if(up && ypos-5>10)
				ypos -= 9;
			if(down && ypos+55<590)
				ypos += 9;
			if(left && xpos>0)
				xpos -= 8;
			if(right && xpos+44<600 )
				xpos += 8;

			if (flame == true)
			{

				g.drawImage(i8,xpos+9,ypos+55,6,25,this);
				g.drawImage(i8,xpos+30,ypos+55,6,25,this);
			}

			if (herofire == true)         // hero Bullet
			{
				for(int i=0; i<99; i++)
				{
					herofirey[i] = herofirey[i]- 25;
					g.drawImage(i9,herofirex[i],herofirey[i],36,31,this);
				}											//<36,31><5,20>
			}
		if(planey[112]<10)
		{
			for(int j=0; j<113; j++)     // position of enermy
			{
				if(level == 0)
					planey[j]= planey[j]+8;
				else if(level == 1)
					planey[j]= planey[j]+11;
				else if(level == 2)
					planey[j]= planey[j]+13;
				if(j==112)
		        g.drawImage(i19, planex[j] , planey[j], 460,280,this);
		        else
				g.drawImage( i5, planex[j] , planey[j], 46,46,this);		 //draw enermy
			}
		}

			else{
				int plus = (int)(Math.random()*6);
				if((plus ==0 || plus==4) && planex[112]+460<600)   //x-move of boss
				planex[112] = planex[112]+7;
				if((plus ==1 || plus==5) && planex[112]>0)
				planex[112] = planex[112]-7;
				if(plus ==2 && planey[112]+300<300 )               //y-move of boss
				planey[112] = planey[112]+7;
				if(plus ==3 && planey[112]>0)
				planey[112] = planey[112]-7;
				g.drawImage(i19, planex[112] , planey[112], 460,280,this);//position of boss
				for(int j=0; j<111; j++)     // position of enermy
				{
					if(level == 0)
						planey[j]= planey[j]+5;
					else if(level == 1)
						planey[j]= planey[j]+10;
					else if(level == 2)
						planey[j]= planey[j]+15;
				    g.drawImage( i5, planex[j] , planey[j], 46,46,this);
				}
			}
			for(int i=0; i<99; i++)// if fire hit enermy
			{
				for(int q=0; q<112; q++)
				{
					if(herofirey[i]<600 && herofirey[i]>3)
					{
						if(((herofirex[i]>=planex[q]-40) && (herofirex[i]<=planex[q]+46)) &&
						((herofirey[i]>=planey[q])&&(herofirey[i]<=planey[q]+40)))
						{
							herofirex[i]=herofirex[i]-1000;
							planex[q] = planex[q]+2000;
							score = score+100;     //blow effect
							g.drawImage(bo1,planex[q]-20-2000,planey[q]+10,60,60,this);
							g.drawImage(bo2,planex[q]-2000,planey[q]+10,50,50,this);
							g.drawImage(bo3,planex[q]-2000,planey[q]+10,50,50,this);
							g.drawImage(bo4,planex[q]-10-2000,planey[q]+10,50,50,this);
							g.drawImage(bo5,planex[q]-10-2000,planey[q]+10,50,50,this);
							g.drawImage(bo6,planex[q]-10-2000,planey[q]+10,60,60,this);
							g.drawImage(bo7,planex[q]-10-2000,planey[q]+10,60,60,this);
						}
					}
				}
			}
			//fire of boss
			if(waitwin>0)
			{
				ypos-=2;
				g.drawImage(i8,xpos+9,ypos+55,6,25,this);
				g.drawImage(i8,xpos+30,ypos+55,6,25,this);
				g.drawImage( i3, xpos, ypos ,44,55,this);
			}
			else
			g.drawImage( i3, xpos, ypos ,44,55,this);//postition of hero
			if(waitwin==1 ||waitwin ==2 ){
			g.drawImage( db2, 50, 0 ,500,500,this);g.drawImage( db2, 10, 70 ,500,500,this);g.drawImage( db2, 100, 300 ,500,500,this);}
			if(waitwin >25)
			card.show(con,"win");

			if(planey[112]>0)
			{
				if(bossdie ==false)
				{
					sub = bosshit/30;
					g.setColor(Color.white);
					g.drawRect(0,5,599,5);
					g.setColor(Color.red);
					g.fillRect(1,6,598-sub-sub2,4);
					if(sub+sub2>=598)
					{
						planex[112] = 6000;
						bossdie = true;
						bosshit =0;
						}
					}

				if(recount == false)
				{
					bosscounter   =   bossnukecounter = 0;
					recount = true;
				}
				if(loadbossfire == false)       // fire of boss
				{
					bossfirex[0] = planex[112]+220;
					bossfirey[0] = planey[112]+295;

					bossfirex[1] = planex[112]+210;
					bossfirey[1] = planey[112]+290;
					bossfirex[2] = planex[112]+200;
					bossfirey[2] = planey[112]+285;
					bossfirex[3] = planex[112]+190;
					bossfirey[3] = planey[112]+280;
					bossfirex[4] = planex[112]+180;
					bossfirey[4] = planey[112]+275;

					bossfirex[5] = planex[112]+230;
					bossfirey[5] = planey[112]+290;
					bossfirex[6] = planex[112]+240;
					bossfirey[6] = planey[112]+285;
					bossfirex[7] = planex[112]+250;
					bossfirey[7] = planey[112]+280;
					bossfirex[8] = planex[112]+260;
					bossfirey[8] = planey[112]+275;
					loadbossfire = true;
				}
				if(drawtip == true)
				{
					g.drawImage(l4,planex[112]+187,planey[112]+270,80,80,this);
			 	}
				if(bossnuke == false)
				{
					for(int i=0; i<99; i++)
					{
						bossnukex = planex[112]+200;
						if (i==0)
						bossnukey[i] = planey[112]+270;
						else
						bossnukey[i] = bossnukey[i-1]+20;
						g.drawImage(i22,bossnukex,bossnukey[i]+5,60,20,this); //boss nuke
					}
				}
				if(bossnuke == false)        //bossnuke hit hero
				{
					for(int i=0; i<99; i++)
					{
						if((bossnukex < xpos+34)&&(bossnukex+50>xpos)&&(bossnukey[i]>xpos+5)&&(bossnukey[i]<ypos+55))
						{
							score = score -100;
							if(score<0)
							score = 0;
							heart = heart - 1;
							xpos = 10;
							ypos = 500;
							if(heart == -1)      			// if heart = -1
						{
							//card.show(con, "save");
							savecounter = savecounter +1;
							if(savecounter==13)
							savecounter=1 ;
							switch (savecounter)   // set up problem
							{
								case 1:
								a.setText(a1);b.setText(b1);c.setText(c1);pro.setText(ques1);break;
								case 2:
								a.setText(a2);b.setText(b2);c.setText(c2);pro.setText(ques2);break;
								case 3:
								a.setText(a3);b.setText(b3);c.setText(c3);pro.setText(ques3);break;
								case 4:
								a.setText(a4);b.setText(b4);c.setText(c4);pro.setText(ques4);break;
								case 5:
								a.setText(a5);b.setText(b5);c.setText(c5);pro.setText(ques5);break;
								case 6:
								a.setText(a6);b.setText(b6);c.setText(c6);pro.setText(ques6);break;
								case 7:
								a.setText(a7);b.setText(b7);c.setText(c7);pro.setText(ques7);break;
								case 8:
								a.setText(a8);b.setText(b8);c.setText(c8);pro.setText(ques8);break;
								case 9:
								a.setText(a9);b.setText(b9);c.setText(c9);pro.setText(ques9);break;
								case 10:
								a.setText(a10);b.setText(b10);c.setText(c10);pro.setText(ques10);break;
								case 11:
								a.setText(a11);b.setText(b11);c.setText(c11);pro.setText(ques11);break;
								case 12:
								a.setText(a12);b.setText(b12);c.setText(c12);pro.setText(ques12);break;
							}
						}
						}
					}
				}
				for(int i=0; i<99; i++)    //hero fire
				{
					herofirey[i] = herofirey[i]- 25;
					g.drawImage(i9,herofirex[i],herofirey[i],36,31,this);
				}
				for(int i=0; i<9; i++)
				{
					if(i==0)
					{
						bossfirey[i] = bossfirey[i]+8;
					}
					if(i==1)
					{
						bossfirex[i] = bossfirex[i]-3;	bossfirey[i] = bossfirey[i]+8;
					}
					if(i==2)
					{
						bossfirex[i] = bossfirex[i]-6;	bossfirey[i] = bossfirey[i]+8;
					}
					if(i==3)
					{
						bossfirex[i] = bossfirex[i]-9;	bossfirey[i] = bossfirey[i]+8;
					}
					if(i==4)
					{
						bossfirex[i] = bossfirex[i]-12;	 bossfirey[i] = bossfirey[i]+8;
					}
					if(i==5)
					{
						bossfirex[i] = bossfirex[i]+3;	 bossfirey[i] = bossfirey[i]+8;
					}
					if(i==6)
					{
						bossfirex[i] = bossfirex[i]+6;	 bossfirey[i] = bossfirey[i]+8;
					}
					if(i==7)
					{
						bossfirex[i] = bossfirex[i]+9;	 bossfirey[i] = bossfirey[i]+8;
					}
					if(i==8)
					{
						bossfirex[i] = bossfirex[i]+12;	  bossfirey[i] = bossfirey[i]+8;
					}
					g.drawImage( i21, bossfirex[i] , bossfirey[i], 18,18,this); //boss fire
				}
			}

			for(int i=0; i<9; i++)			// bossFire hit hero
				{
					if(bossfirex[i]<600 && bossfirex[i]>0 && bossfirey[i]>3 && bossfirey[i] <600 )
					{
						if( bossfirex[i]+18>xpos+10  && bossfirex[i]+10<xpos+40 && bossfirey[i]+18>ypos+5 && bossfirey[i]+18<ypos +55)
						{
							bossfirex[i] = 5000;
							score = score -100;
							if(score<0)
							score = 0;
							heart = heart - 1;
							g.drawImage(bo1,xpos-5,ypos+10,40,40,this);
							g.drawImage(bo2,xpos-5,ypos+10,40,40,this);
							g.drawImage(bo3,xpos+5,ypos+10,50,50,this);
							g.drawImage(bo4,xpos,ypos+10,40,40,this);
							g.drawImage(bo5,xpos+5,ypos+10,40,40,this);
							g.drawImage(bo6,xpos+5,ypos+10,30,30,this);
							g.drawImage(bo7,xpos+5,ypos+10,60,60,this);
							xpos = 50;
							ypos = 500;
							if(heart == -1)      			// if heart = -1
						{
							//card.show(con, "save");
							savecounter = savecounter +1;
							if(savecounter==13)
							savecounter=1 ;
							switch (savecounter) //set problem
							{
								case 1:
								a.setText(a1);b.setText(b1);c.setText(c1);pro.setText(ques1);break;
								case 2:
								a.setText(a2);b.setText(b2);c.setText(c2);pro.setText(ques2);break;
								case 3:
								a.setText(a3);b.setText(b3);c.setText(c3);pro.setText(ques3);break;
								case 4:
								a.setText(a4);b.setText(b4);c.setText(c4);pro.setText(ques4);break;
								case 5:
								a.setText(a5);b.setText(b5);c.setText(c5);pro.setText(ques5);break;
								case 6:
								a.setText(a6);b.setText(b6);c.setText(c6);pro.setText(ques6);break;
								case 7:
								a.setText(a7);b.setText(b7);c.setText(c7);pro.setText(ques7);break;
								case 8:
								a.setText(a8);b.setText(b8);c.setText(c8);pro.setText(ques8);break;
								case 9:
								a.setText(a9);b.setText(b9);c.setText(c9);pro.setText(ques9);break;
								case 10:
								a.setText(a10);b.setText(b10);c.setText(c10);pro.setText(ques10);break;
								case 11:
								a.setText(a11);b.setText(b11);c.setText(c11);pro.setText(ques11);break;
								case 12:
								a.setText(a12);b.setText(b12);c.setText(c12);pro.setText(ques12);break;
							}
						}
						}
					}
				}
											if(heronuke == true)        //hero nuke
										{

											if(herocounter == 1 ){
											g.drawImage(n1,0,0,600,600,this);}         //blowing effect
											if(herocounter ==2){
											g.drawImage(n2,0,0,600,600,this);}
											if(herocounter >= 3 && herocounter<5){
											g.drawImage(n2,0,0,600,600,this);
											g.drawImage(n3,0,0,600,600,this);}
											if(herocounter >= 5 && herocounter<7){
											g.drawImage(n1,0,0,600,600,this);
											g.drawImage(n3,0,0,600,600,this);}
											if(herocounter >= 7 && herocounter<9){
											g.drawImage(n2,0,0,600,600,this);
											g.drawImage(n3,0,0,600,600,this);
											g.drawImage(n4,0,0,600,600,this);}
											if(herocounter >= 9 && herocounter<11){
											g.drawImage(n1,0,0,600,600,this);
											g.drawImage(n2,0,0,600,600,this);
											g.drawImage(n4,0,0,600,600,this);}
											if(herocounter >= 11&& herocounter<13){
											g.drawImage(n1,0,0,600,600,this);
											g.drawImage(n2,0,0,600,600,this);
											g.drawImage(n3,0,0,600,600,this);}
											if(herocounter >= 13&& herocounter<15){
											g.drawImage(n1,0,0,600,600,this);
											g.drawImage(n3,0,0,600,600,this);}
											if(herocounter >= 15&& herocounter<17){
											g.drawImage(n1,0,0,600,600,this);
											g.drawImage(n3,0,0,600,600,this);}
											if(herocounter >= 17){
											g.drawImage(n2,0,0,600,600,this);
											g.drawImage(n5,250,250,100,100,this);
											}
											if(planey[112]>-1 && blood ==true){
											sub2 = sub2+ 50;
											blood =false;}


											for(int i=0; i<112; i++)
											{
												if((planex[i]<600 && planex[i]>0 && planey[i]>0 &&planey[i]<600)
												||(enfireleftx[i]<600 && enfireleftx[i]>0 && planey[i]>0)
												||(enfirerightx[i]<600 && enfirerightx[i]>0 && planey[i]>0)
												||(enfirex[i]<600 && enfirex[i]>0 && planey[i]>0))
												{
														enfireleftx[i]=20000;
														enfirerightx[i]=20000;
														enfirex[i] =20000;
														planex[i] = planex[i]+2000;
														score = score+70;     //blow effect
														System.out.println(i+"		" +planey[i]);

												}

											}
										}


			for(int i=0; i<99; i++)// if fire hit boss
			{
				if(ypos>250)
				{
					if(planey[112]>0)
					{
						if(herofirey[i]<600 && herofirey[i]>3)
						{
							if(((herofirex[i]+18>planex[112]+197) && (herofirex[i]+18<planex[112]+197+70))&&
							((herofirey[i]>=planey[112]+140)&&(herofirey[i]+30<=planey[112]+120+100)))
							{
								int where = (int)(Math.random()*7);  //blow effect
								if(where == 0)
								g.drawImage(bo1,herofirex[i],herofirey[i]-40,70,70,this);
								if(where == 1)
								g.drawImage(bo2,herofirex[i],herofirey[i]-40,40,40,this);
								if(where == 2)
								g.drawImage(bo3,herofirex[i],herofirey[i]-40,50,50,this);
								if(where == 3)
								g.drawImage(bo4,herofirex[i],herofirey[i]-40,40,40,this);
								if(where == 4)
								g.drawImage(bo5,herofirex[i],herofirey[i]-40,40,40,this);
								if(where == 5)
								g.drawImage(bo6,herofirex[i],herofirey[i]-40,30,30,this);
								if(where == 6)
								g.drawImage(bo7,herofirex[i],herofirey[i]-40,50,50,this);
								herofirex[i]=herofirex[i]-1000;
								bosshit = bosshit+20;
								score = score+50;
							}
							else if(((herofirex[i]>planex[112]+30) && (herofirex[i]<planex[i]+430))&&
							((herofirey[i]>=planey[112])&&(herofirey[i]+30<=planey[112]+180)))
							{
								int where = (int)(Math.random()*7); // //blow effect
								if(where == 0)
								g.drawImage(bo1,herofirex[i],herofirey[i]-40,70,70,this);
								if(where == 1)
								g.drawImage(bo2,herofirex[i],herofirey[i]-40,40,40,this);
								if(where == 2)
								g.drawImage(bo3,herofirex[i],herofirey[i]-40,50,50,this);
								if(where == 3)
								g.drawImage(bo4,herofirex[i],herofirey[i]-40,40,40,this);
								if(where == 4)
								g.drawImage(bo5,herofirex[i],herofirey[i]-40,40,40,this);
								if(where == 5)
								g.drawImage(bo6,herofirex[i],herofirey[i]-40,30,30,this);
								if(where == 6)
								g.drawImage(bo7,herofirex[i],herofirey[i]-40,50,50,this);
								herofirex[i]=herofirex[i]-1000;
								bosshit = bosshit +5;
								score = score+10;
							}
						}

					}
				}
			}
			for(int q =0; q<112; q++)              //draw enermy fire
			{
				if(planex[q]>0 && planey[q]>10)
				{
					if(level == 0)         // easy level
					{
					enfirey[q] = enfirey[q]+13;
					enfireleftx[q] = enfireleftx[q]-3;
					enfirelefty[q] = enfirelefty[q]+12;
					enfirerightx[q] = enfirerightx[q]+3;
					enfirerighty[q] = enfirerighty[q]+12;
					}
					else if(level == 1)      //normal level
					{
					enfirey[q] = enfirey[q]+15;
					enfireleftx[q] = enfireleftx[q]-5;
					enfirelefty[q] = enfirelefty[q]+15;
					enfirerightx[q] = enfirerightx[q]+5;
					enfirerighty[q] = enfirerighty[q]+15;
					}
					else if(level == 2)   //hard level
					{
					enfirey[q] = enfirey[q]+18;
					enfireleftx[q] = enfireleftx[q]-5;
					enfirelefty[q] = enfirelefty[q]+18;
					enfirerightx[q] = enfirerightx[q]+5;
					enfirerighty[q] = enfirerighty[q]+18;
					}

					g.drawImage(i16,enfirex[q],enfirey[q]+50,12,13,this);//middle
					g.drawImage(i16,enfireleftx[q]-20,enfirelefty[q]+40,12,13,this);//left fire
					g.drawImage(i16,enfirerightx[q]+20,enfirerighty[q]+40,12,13,this);//right fire

				}
			}

				for(int i=0; i<112; i++)					// left fire hit hero
				{
					if(enfireleftx[i]<600 && enfireleftx[i]>0 && enfirelefty[i]>3 && enfirelefty[i] <600 )
					{
						if(enfireleftx[i]-14>xpos && enfireleftx[i]-14<xpos+43 && enfirelefty[i]+40>ypos && enfirelefty[i]+40<ypos +50)
						{
							enfireleftx[i] = 50000;
							score = score -100;
							if(score<0)
							score = 0;
							heart = heart - 1;
							g.drawImage(bo1,xpos-5,ypos+10,40,40,this);
							g.drawImage(bo2,xpos-5,ypos+10,40,40,this);
							g.drawImage(bo3,xpos+5,ypos+10,50,50,this);
							g.drawImage(bo4,xpos,ypos+10,40,40,this);
							g.drawImage(bo5,xpos+5,ypos+10,40,40,this);
							g.drawImage(bo6,xpos+5,ypos+10,30,30,this);
							g.drawImage(bo7,xpos+5,ypos+10,60,60,this);
							xpos = 50;
							ypos = 500;
							if(heart == -1)      			// if heart = -1
						{
							//card.show(con, "save");
							savecounter = savecounter +1;
							if(savecounter==13)
							savecounter=1 ;
							switch (savecounter)     //set Problem
							{
								case 1:
								a.setText(a1);b.setText(b1);c.setText(c1);pro.setText(ques1);break;
								case 2:
								a.setText(a2);b.setText(b2);c.setText(c2);pro.setText(ques2);break;
								case 3:
								a.setText(a3);b.setText(b3);c.setText(c3);pro.setText(ques3);break;
								case 4:
								a.setText(a4);b.setText(b4);c.setText(c4);pro.setText(ques4);break;
								case 5:
								a.setText(a5);b.setText(b5);c.setText(c5);pro.setText(ques5);break;
								case 6:
								a.setText(a6);b.setText(b6);c.setText(c6);pro.setText(ques6);break;
								case 7:
								a.setText(a7);b.setText(b7);c.setText(c7);pro.setText(ques7);break;
								case 8:
								a.setText(a8);b.setText(b8);c.setText(c8);pro.setText(ques8);break;
								case 9:
								a.setText(a9);b.setText(b9);c.setText(c9);pro.setText(ques9);break;
								case 10:
								a.setText(a10);b.setText(b10);c.setText(c10);pro.setText(ques10);break;
								case 11:
								a.setText(a11);b.setText(b11);c.setText(c11);pro.setText(ques11);break;
								case 12:
								a.setText(a12);b.setText(b12);c.setText(c12);pro.setText(ques12);break;
							}
						}
						}
					}
				}
				for(int i=0; i<112; i++)					// right fire hit hero
				{
					if(enfirerightx[i]<600 && enfirerightx[i]>0 && enfirerighty[i]>3 && enfirerighty[i] <600 )
					{
						if(enfirerightx[i]+26>xpos && enfirerightx[i]+26<xpos+43 && enfirerighty[i]+40>ypos && enfirerighty[i]+40<ypos +50)
						{
							enfirerightx[i] = 50000;
							score = score -100;
							if(score<0)
							score = 0;
							heart = heart - 1;
							g.drawImage(bo1,xpos-5,ypos+10,40,40,this);
							g.drawImage(bo2,xpos-5,ypos+10,40,40,this);
							g.drawImage(bo3,xpos+5,ypos+10,50,50,this);
							g.drawImage(bo4,xpos,ypos+10,40,40,this);
							g.drawImage(bo5,xpos+5,ypos+10,40,40,this);
							g.drawImage(bo6,xpos+5,ypos+10,30,30,this);
							g.drawImage(bo7,xpos+5,ypos+10,60,60,this);
							xpos = 50;
							ypos = 500;
							if(heart == -1)      			// if heart = -1
						{
							//card.show(con, "save");
							savecounter = savecounter +1;
							if(savecounter==13)
							savecounter=1 ;
							switch (savecounter)     //set problem
							{
								case 1:
								a.setText(a1);b.setText(b1);c.setText(c1);pro.setText(ques1);break;
								case 2:
								a.setText(a2);b.setText(b2);c.setText(c2);pro.setText(ques2);break;
								case 3:
								a.setText(a3);b.setText(b3);c.setText(c3);pro.setText(ques3);break;
								case 4:
								a.setText(a4);b.setText(b4);c.setText(c4);pro.setText(ques4);break;
								case 5:
								a.setText(a5);b.setText(b5);c.setText(c5);pro.setText(ques5);break;
								case 6:
								a.setText(a6);b.setText(b6);c.setText(c6);pro.setText(ques6);break;
								case 7:
								a.setText(a7);b.setText(b7);c.setText(c7);pro.setText(ques7);break;
								case 8:
								a.setText(a8);b.setText(b8);c.setText(c8);pro.setText(ques8);break;
								case 9:
								a.setText(a9);b.setText(b9);c.setText(c9);pro.setText(ques9);break;
								case 10:
								a.setText(a10);b.setText(b10);c.setText(c10);pro.setText(ques10);break;
								case 11:
								a.setText(a11);b.setText(b11);c.setText(c11);pro.setText(ques11);break;
								case 12:
								a.setText(a12);b.setText(b12);c.setText(c12);pro.setText(ques12);break;
							}
						}
						}
					}
				}

			for(int i=0; i<112; i++)					//enermy's fire hit hero
				{
					if(enfirex[i]<600 && enfirex[i]>0 && enfirey[i]>3 && enfirey[i] <600 )
					{
						if(enfirex[i]+6>xpos && enfirex[i]+6<xpos+43 && enfirey[i]+50>ypos && enfirey[i]+50<ypos +50)
						{
							enfirex[i] = 50000;
							score = score -100;
							if(score<0)
							score = 0;
							heart = heart - 1;
							g.drawImage(bo1,xpos-5,ypos+10,40,40,this);
							g.drawImage(bo2,xpos-5,ypos+10,40,40,this);
							g.drawImage(bo3,xpos+5,ypos+10,50,50,this);
							g.drawImage(bo4,xpos,ypos+10,40,40,this);
							g.drawImage(bo5,xpos+5,ypos+10,40,40,this);
							g.drawImage(bo6,xpos+5,ypos+10,30,30,this);
							g.drawImage(bo7,xpos+5,ypos+10,60,60,this);
							xpos = 50;
							ypos = 500;
							if(heart == -1)      			// if heart = -1
						{
							//card.show(con, "save");
							savecounter = savecounter +1;
							if(savecounter==13)
							savecounter=1 ;
							switch (savecounter) //set problem
							{
								case 1:
								a.setText(a1);b.setText(b1);c.setText(c1);pro.setText(ques1);break;
								case 2:
								a.setText(a2);b.setText(b2);c.setText(c2);pro.setText(ques2);break;
								case 3:
								a.setText(a3);b.setText(b3);c.setText(c3);pro.setText(ques3);break;
								case 4:
								a.setText(a4);b.setText(b4);c.setText(c4);pro.setText(ques4);break;
								case 5:
								a.setText(a5);b.setText(b5);c.setText(c5);pro.setText(ques5);break;
								case 6:
								a.setText(a6);b.setText(b6);c.setText(c6);pro.setText(ques6);break;
								case 7:
								a.setText(a7);b.setText(b7);c.setText(c7);pro.setText(ques7);break;
								case 8:
								a.setText(a8);b.setText(b8);c.setText(c8);pro.setText(ques8);break;
								case 9:
								a.setText(a9);b.setText(b9);c.setText(c9);pro.setText(ques9);break;
								case 10:
								a.setText(a10);b.setText(b10);c.setText(c10);pro.setText(ques10);break;
								case 11:
								a.setText(a11);b.setText(b11);c.setText(c11);pro.setText(ques11);break;
								case 12:
								a.setText(a12);b.setText(b12);c.setText(c12);pro.setText(ques12);break;
							}
						}
						}
					}
				}
			for(int h=0; h< heart; h++) // heart logo
			{
				g.drawImage(i7,570-30*h,10,20,20,this);                        // hero:   width 44  length 55
			}													             // enermy: width 46  length 46
			for(int m=0; m< missile; m++) // heart logo
			{
				g.drawImage(i6,570-30*m,40,20,20,this);
			}
			g.setColor(new Color(150,150,150));
			g.setFont(new Font("Sans",Font.PLAIN,20));
			if(bossdie ==false)
			score = score+1;
			String scoreChange = "SCORE: " + score;
			g.drawString(scoreChange,450,90);// score
			this.requestFocus();

			for(int q=0; q<112; q++) // if Crashes && xpos+45<planex[q]+46
			{
				if(((xpos+22>planex[q]+23) && (xpos+22<planex[q]+80))&&((ypos<planey[q]+46)&&(ypos>planey[q]+5))){}
				if(((xpos+22<planex[q]+23) && (xpos+22>planex[q]-20))&&((ypos<planey[q]+46)&&(ypos>planey[q]+5))){}
			 	else if(xpos>planex[q]-40 && xpos<planex[q]+46 && ypos>planey[q]-50 && ypos<planey[q]+35)
				{
					planex[q] = planex[q]+2000;
					g.drawImage(bo1,planex[q]-20-2000,planey[q]+10,60,60,this);  //draw blow effect
					g.drawImage(bo2,planex[q]-2000,planey[q]+10,50,50,this);
					g.drawImage(bo3,planex[q]-2000,planey[q]+10,50,50,this);
					g.drawImage(bo4,planex[q]-10-2000,planey[q]+10,50,50,this);
					g.drawImage(bo5,planex[q]-10-2000,planey[q]+10,50,50,this);
					g.drawImage(bo6,planex[q]-10-2000,planey[q]+10,60,60,this);
					g.drawImage(bo7,planex[q]-10-2000,planey[q]+10,60,60,this);
					score = score -100;
					if(score<0)
					score = 0;
					heart = heart - 1;
					g.drawImage(bo1,xpos-5,ypos+10,40,40,this);      //draw blow effect
					g.drawImage(bo2,xpos-5,ypos+10,40,40,this);
					g.drawImage(bo3,xpos+5,ypos+10,50,50,this);
					g.drawImage(bo4,xpos,ypos+10,40,40,this);
					g.drawImage(bo5,xpos+5,ypos+10,40,40,this);
					g.drawImage(bo6,xpos+5,ypos+10,30,30,this);
					g.drawImage(bo7,xpos+5,ypos+10,60,60,this);
					xpos = 50;
					ypos = 500;
					if(heart == -1)      			// if heart = -1
						{
							//card.show(con, "save");
							savecounter = savecounter +1;
							if(savecounter==13)
							savecounter=1 ;
							switch (savecounter)   //set problem
							{
								case 1:
								a.setText(a1);b.setText(b1);c.setText(c1);pro.setText(ques1);break;
								case 2:
								a.setText(a2);b.setText(b2);c.setText(c2);pro.setText(ques2);break;
								case 3:
								a.setText(a3);b.setText(b3);c.setText(c3);pro.setText(ques3);break;
								case 4:
								a.setText(a4);b.setText(b4);c.setText(c4);pro.setText(ques4);break;
								case 5:
								a.setText(a5);b.setText(b5);c.setText(c5);pro.setText(ques5);break;
								case 6:
								a.setText(a6);b.setText(b6);c.setText(c6);pro.setText(ques6);break;
								case 7:
								a.setText(a7);b.setText(b7);c.setText(c7);pro.setText(ques7);break;
								case 8:
								a.setText(a8);b.setText(b8);c.setText(c8);pro.setText(ques8);break;
								case 9:
								a.setText(a9);b.setText(b9);c.setText(c9);pro.setText(ques9);break;
								case 10:
								a.setText(a10);b.setText(b10);c.setText(c10);pro.setText(ques10);break;
								case 11:
								a.setText(a11);b.setText(b11);c.setText(c11);pro.setText(ques11);break;
								case 12:
								a.setText(a12);b.setText(b12);c.setText(c12);pro.setText(ques12);break;
							}
						}
				}
			}
			flame = false;

		}
		    class RepaintAction implements ActionListener
			{
      			public void actionPerformed(ActionEvent evt)
      			{
         			repaint();
      			}
   			}
   			class RepaintAction2 implements ActionListener
			{

      			public void actionPerformed(ActionEvent evt)
      			{
					bosscounter++;
					if(bosscounter%10==0)
					loadbossfire = false;
      			}
   			}
   			class RepaintAction3 implements ActionListener
			{

      			public void actionPerformed(ActionEvent evt)
      			{
					if(heronuke ==true)
					herocounter++;
					if(herocounter==19)
					{
						herocounter=0;
						heronuke =false;
					}

      			}
   			}
   			class RepaintAction4 implements ActionListener
			{

      			public void actionPerformed(ActionEvent evt)
      			{
					bossnukecounter++;
					if(bossnukecounter==100)//add
					bossnukecounter =0;
					if(bossnukecounter==33)
					drawtip =true;
					if(bossnukecounter==35)  // boss nuke shoot out
					{
						drawtip = false;
						bossnuke = false;
					}
					if(bossnukecounter==45)
					{
						bossnuke = true;
						bossnukecounter =0;
					}
					if(bossdie== true)
						waitwin++;

      			}
   			}

   			public void keyReleased(KeyEvent e){
				int value = e.getKeyCode();
				if (value == KeyEvent.VK_DOWN)
				{
					down = false;
					flame = false;
				}
				if  (value == KeyEvent.VK_UP)
				{
					up = false;
					flame = false;
				}
				if  (value == KeyEvent.VK_RIGHT)
				{
					right = false;
					flame = false;
				}
				if  (value == KeyEvent.VK_LEFT) //keyboard left
				{
					left = false;
					flame = false;
				}
			}
			public void keyTyped(KeyEvent e){}
			public void keyPressed(KeyEvent e)
			{
				if(waitwin<10)
				{
					int value = e.getKeyCode();
					if (value == KeyEvent.VK_DOWN  && ypos+55<590)      // keyboard down
					{
						down = true;
						flame = true;
						//ypos += 30;
					}
					if  (value == KeyEvent.VK_UP && ypos-5>10)      //keyboard up
					{
						up = true;
						flame = true;
						//ypos -= 30;
					}
					if  (value == KeyEvent.VK_RIGHT && xpos+44<600 )	 //keyboard right
					{
						right = true;
						flame = true;
						//xpos += 25;
					}
					if  (value == KeyEvent.VK_LEFT && xpos>0) //keyboard left
					{
						left = true;
						//xpos -= 25;
						flame = true;
					}
					if (value == KeyEvent.VK_SPACE)  //fire button
					{
						bulletcounter = bulletcounter + 1;
							if(bulletcounter == 99)
							bulletcounter = 0;
						herofire = true;
						herofirex[bulletcounter] = xpos+5;
						herofirey[bulletcounter] = ypos-10;
					}
					if (value == KeyEvent.VK_ALT)  //fire button
					{
						nx = xpos-30;
						ny = ypos-100;
						if(missile>0)
						{
							heronuke =true;
							blood=true;
							missile--;
						}
					}
					if (value == KeyEvent.VK_9)  // obviously a bug...
					{
						missile = missile +1;
					}
					if (value == KeyEvent.VK_0)  // obviously a bug...
					{
						heart = heart +1;
					}
				}
			}

			public void actionPerformed(ActionEvent e)
			{
			    String command = e.getActionCommand();
			    if(savecounter == 9 ||savecounter == 10 || savecounter == 11 ||savecounter == 12){
					if(a.isSelected())
					{
						heart = 0;
						card.show(con, "game");
					}
					else
					card.show(con, "end");
				}
			  if(savecounter == 1 || savecounter == 3 ||savecounter ==5 || savecounter == 6)
			  {
					if(b.isSelected())
					{
						heart = 0;
						card.show(con, "game");
					}
					else
					card.show(con, "end");
				}
				if(savecounter == 2 || savecounter == 4 ||savecounter == 7 ||savecounter ==8){
					if(c.isSelected())
					{
						heart = 0;
						card.show(con, "game");
					}
					else
					card.show(con, "end");
				}
			}

	}
	public class barPanel extends JPanel ///////////////////////////////////////////////// question
	{

		public barPanel()
       {
		  RepaintActionbar actionbar = new RepaintActionbar();
          Timer progress = new Timer(15, actionbar);
          progress.start();
       }
        public void paintComponent(Graphics g) //draw progress bar
        {
			startloading = true;
			super.paintComponent ( g );
			g.setColor(Color.black);
			g.drawImage(i13,0,0,600,600,this); //background
			g.drawImage(i12,100,400,400,50,this);//emptybar
			if(loading<=379)
			g.drawImage(i24,112,411,loading,26,this);//fill in the bar      379
			else
			g.drawImage(i24,112,411,379,26,this);



		}
		class RepaintActionbar implements ActionListener      //repaintaction for timer
		{
      		public void actionPerformed(ActionEvent evt)
      		{
         		if(startloading == true)
         		{
					int ran = (int)(Math.random()*3);
					if (ran==0)
					loading =  loading  +1;
					if (ran==1)
					loading =  loading  +2;
					if (ran==2)
					loading =  loading  +5;
				}
         		if(loading>390 )
         		{
					card.show(con,"game");
					loading = 0;
					startloading =false;
				}
				repaint();
      		}
   		}
	}
	public class savePanel extends JPanel implements ActionListener/////////////////////////////// save question
	{
		private JLabel title;
		public savePanel()
       {
		    this.setLayout(null);
			title = new JLabel("Want To CONTINUE?", JLabel.CENTER);       // title
            title.setForeground(Color.yellow);
            title.setFont(new Font("Sans",Font.BOLD,40));
            title.setBounds(3, 20, 595, 40);
            this.add(title);
       }

       public void paintComponent(Graphics g)
       {
       		//super.paintComponent ( g );
	   }
	   public void actionPerformed(ActionEvent e)
		{
			    String command = e.getActionCommand();
		}
	}//end of savepanel
	public class pausePanel extends JPanel implements ActionListener//////////////////////////////    Pause
	{
		private JButton contin;
		public pausePanel()
		{
			this.setLayout(null);
			contin = new JButton("BACK");
			contin.setBounds(200,450,200,100);
			contin.addActionListener(this);
			this.add(contin);
		}
		public void actionPerformed(ActionEvent e)//actionperformed
		{
			String command = e.getActionCommand();
			if(command.equals("BACK"))
			{
				card.show(con,"menu");
			}
		}
		public void paintComponent(Graphics g) //paintcomponent
       {
       		super.paintComponent ( g );
       		g.drawImage(i14,0,0,600,600,this);
		    g.drawImage(i15,0,0,590,432,this);
	   }

	} //end fo pausePanel
	public class introPanel extends JPanel implements ActionListener//////////////////////////////   introduction
	{
		private JButton contin; //declare Jbutton
		public introPanel()
		{
			this.setLayout(null);
			contin = new JButton("Continue");
			contin.setBounds(420,470,130,70);
			contin.addActionListener(this);
			contin.setForeground(Color.white);
			contin.setBackground(Color.black);
			contin.setFont(new Font("Sans",Font.BOLD,20));
			this.add(contin);
		}
		public void actionPerformed(ActionEvent e)    //actionperformed
		{
			String command = e.getActionCommand();
			if(command.equals("Continue"))
			{
				card.show(con,"pause");
			}
		}
		public void paintComponent(Graphics g)    //paintcomponent
       {
       		super.paintComponent ( g );
       		g.drawImage(i25,0,0,600,600,this);
	   }

	}
	public class endPanel extends JPanel implements ActionListener//////////////////////////////////////////////// endddddddddddddddddd
	{
		private JButton again;
		private JButton exit;
		public endPanel()
       {
               this.setLayout(null);
               again = new JButton("Try it again");
               again.setBounds(80,450,200,100);
               again.addActionListener(this);
               this.add(again);
               exit = new JButton("Give Up");
               exit.setBounds(320,450,200,100);
               exit.addActionListener(this);
               this.add(exit);
       }
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if(command.equals("Try it again"))      //if game restart, reload all the data of plane and fire
			{
				bossnuke =true;
				recount =  flame = herofire = bossdie = startloading = drawtip= blood= false;
				bulletcounter = -1;
				xpos = 280;
				ypos = 500;
				val = 1700;
				level = 0;
				score = 0;
				loading =0;
				sub = sub2= waitwin = bosshit =0;
				heart = missile = 3;
				savecounter = 0;
				card.show(con,"menu");
				loadbossfire= false;
				loadPlane();
			    loadFire();
			    loadFireleft();
			    loadFireright();
			    loadFirey();
			    savecounter = bosscounter= herocounter =0;


			}
			if(command.equals("Give Up"))             //if  give up, go to occupy panel
			{
				card.show(con,"occupy");
			}

		}
		 public void paintComponent(Graphics g)
       {
       		super.paintComponent ( g );
       		g.drawImage(i11,35,35,620,412,this);
	   }
	     public void loadPlane()              //location of planes
       {
		    File intfile = null;
			intfile = new File("plane.txt");
			Scanner fromfile = null;
			try
			{
				fromfile = new Scanner(intfile);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not Found!");
				System.exit(1);
			}
				for(int i =0; i<113; i++)
				{
						planex[i]= fromfile.nextInt();
						planey[i]= fromfile.nextInt();
				}
       }
       public void loadFire()           //location of fire-x
       {
		    File intfile = null;
			intfile = new File("plane.txt");
			Scanner fromfile = null;
			try
			{
				fromfile = new Scanner(intfile);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not Found!");
				System.exit(1);
			}
			for(int i =0; i<112; i++)
			{
				enfirex[i] = fromfile.nextInt()+18;
				useless[i] = fromfile.nextInt();
			}
       }
        public void loadFireleft()    //location of left fire
       {

		    File intfile = null;
			intfile = new File("plane.txt");
			Scanner fromfile = null;
			try
			{
				fromfile = new Scanner(intfile);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not Found!");
				System.exit(1);
			}
				for(int i =0; i<112; i++)
				{
					enfireleftx[i] = fromfile.nextInt()+18;
					useless[i] = fromfile.nextInt();
				}
       }
       public void loadFireright() //location of right fire
       {

		    File intfile = null;
			intfile = new File("plane.txt");
			Scanner fromfile = null;
			try
			{
				fromfile = new Scanner(intfile);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not Found!");
				System.exit(1);
			}
			for(int i =0; i<112; i++)
			{
				enfirerightx[i] = fromfile.nextInt()+18;
				useless[i] = fromfile.nextInt();
			}
       }
       public void loadFirey()
       {
		   for(int q =0; q<112; q++)              //draw enermy fire
			{
					enfirey[q]=0;
					enfirey[q] = enfirey[q]+10; //middle fire
					enfirelefty[q] =0;
					enfireleftx[q] = enfireleftx[q]-3; //left fire
					enfirelefty[q] = enfirelefty[q]+10;
					enfirerighty[q] =0;
					enfirerightx[q] = enfirerightx[q]+3; //right fire
					enfirerighty[q] = enfirerighty[q]+10;
			}
		}
	}
	public class occupyPanel extends JPanel       //occupy panel: game over
	{
		private JLabel over;
		private RepaintAction rep;
		private int x, y, sx, sy,bx,by;
		public occupyPanel()
       {
		    this.setLayout(null);
            over = new JLabel("<html>On January 1st, 2013<br>The Earth Is Occupied and Vanished<br>Humans Are Extinct, No One Survives<br><br><br><br>   End")  ;
            over.setForeground((Color.white));
            over.setFont(new Font("Sans",Font.BOLD,27));
            over.setBounds(20, 300, 580, 300);
            this.add(over);
     		RepaintAction action = new RepaintAction();
     		Timer starTimer = new Timer(30, action); // timer 15
     		starTimer.start();
     		x=-10;
     		y=-10;
     		sx=700;
     		sy=700;
     		bx=4000;
     		by=4000;
       }
		 public void paintComponent(Graphics g)
       {
       		super.paintComponent ( g );
       		bx= bx-1;
       		by=by-1;
       		g.drawImage(i10,0,0,bx,by,this);       //zoom out picture
       		x= x+1;
         	y= y+1;
         	sx= sx-2;
         	sy= sy-2;
       		g.drawImage(i18,x,y,sx,sy,this);
       		if(sx==0 || sy == 0)
       		{x=-999000;
       		y=-999000;}

	   }
	    class RepaintAction implements ActionListener
		{
      		public void actionPerformed(ActionEvent evt)
      		{
         		repaint();
      		}
   		}

	}//end of ocupyPanel
	public class winPanel extends JPanel ///////////////////////////////////////////////// Winpanel
	{
		private boolean lo;
		private JLabel winning;
		public winPanel()
       {
            this.setLayout(null);
            winning = new JLabel("<html>After ten years of resistance,"+
            "<br>You eventually return in triumph <br>with a title [LIGHTNING HERO] <br>"+
            "Soon, The world is back in peace<br>People no longer talk about that nightmare<br>"+
            "However, the mystery of 2012 is still unsolved.....<br><br><br><br>END");
			winning.setFont(new Font("Sans",Font.BOLD,28));
			winning.setForeground(Color.white);
            winning.setBounds(20,20,600,600);
            this.add(winning);
       }
        public void paintComponent(Graphics g)
        {
			super.paintComponent ( g ) ;
			p10.setBackground(Color.black);
			g.drawImage(logo,0,230,560,370,this);
		}
	}//end of winpanel

}//end of file
