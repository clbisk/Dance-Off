//Pd 5 AccCS RoseS
//Cecilia Bisk, Syona Satwah,	Joanna Gerr

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.imageio.*;
import java.io.*;
import java.util.logging.*;
import java.util.Scanner;

/**
 *	panel	to	display dance queues	for gameplay -- located	to	west of the	gameplay
 *	panel
 */
public class DanceQueuePanel extends JPanel {
	//	private variables
	/**
	 *	an	array	of	Arrow	objects that will	serve	to	store	the coordinates of
	 *	future arrows drawn on screen
	 */
	private static	Arrow[] arrows;
	private BufferedImage myImage;
	private Graphics myBuffer;
	private Timer timer;
	private BufferedImage rightArrowImg;
	private BufferedImage leftArrowImg;
	private BufferedImage upArrowImg;
	private BufferedImage downArrowImg;
	/** an array of Arrow objects that makes up the custom song created with MakeYourOwn*/
	public static Arrow[] yourArrows;
	private static long songStart;
	/** scale	factor to determine how	long the	arrow	will take to get up the	screen*/
	private static	double scaling	= 0.6;
	/**
	 *	variable	to	store	the lowest x-coordinate	of	the box where keys are
	 *	considered "on	time"
	 */
	private static	int boxXMin	= 0;
	/**
	 *	variable	to	store	the highest	x-coordinate of the box	where	keys are
	 *	considered "on	time"
	 */
	private static	int boxXMax	= 600;
	/**
	 *	variable	to	store	the lowest y-coordinate	of	the box where keys are
	 *	considered "on	time"
	 */
	private static	int boxYMin	= 50;
	/**
	 *	variable	to	store	the highest	y-coordinate of the box	where	keys are
	 *	considered "on	time"
	 */
	private static	int boxYMax	= 170;

	/** constructor */
	public DanceQueuePanel() {
		//	flow layout
		setLayout(new FlowLayout());
		//	uses buffer	to	draw arrows	based	on	queues in an array
		myImage =  new	BufferedImage(600, 600,	BufferedImage.TYPE_INT_RGB);
		myBuffer	= myImage.getGraphics();
		//uses timer to queue buffer changes
		timer	= new	Timer(5,	new Listener());
		timer.start();
		setFocusable(true);
		//picks instructions	based	on	song & level
		if	(Danceoff.getSong() == -1 && Danceoff.getDifficulty()	==	0)	{
			arrows =	new Arrow[]	{new LeftArrow(4471), new RightArrow(5420), new LeftArrow(5893), new RightArrow(6382), new LeftArrow(7312), new RightArrow(7778), new LeftArrow(8244), new RightArrow(9269), new LeftArrow(9705), new RightArrow(10230), new LeftArrow(11215), new RightArrow(11650), new LeftArrow(12128), new RightArrow(13100), new LeftArrow(13517), new RightArrow(14037), new LeftArrow(14960), new RightArrow(15430), new LeftArrow(15947), new UpArrow(16949), new UpArrow(17922), new DownArrow(18850), new DownArrow(19306), new LeftArrow(19790), new RightArrow(19798), new UpArrow(20786), new DownArrow(20796), new LeftArrow(21265), new RightArrow(21752), new DownArrow(22702), new UpArrow(23178), new LeftArrow(23672), new RightArrow(24627), new LeftArrow(25551), new RightArrow(26519), new LeftArrow(27016), new RightArrow(27451), new UpArrow(28461), new DownArrow(28896), new UpArrow(29373), new DownArrow(30368), new UpArrow(30814), new DownArrow(31318), new LeftArrow(32267), new RightArrow(32758), new LeftArrow(33238), new RightArrow(34202), new LeftArrow(34679), new RightArrow(35161), new LeftArrow(37053), new RightArrow(37063), new UpArrow(37795), new DownArrow(37805), new UpArrow(39055), new UpArrow(39724), new DownArrow(40897), new DownArrow(41612), new LeftArrow(42854), new LeftArrow(43503), new RightArrow(44776), new RightArrow(45466), new LeftArrow(46657), new RightArrow(46667), new DownArrow(47667), new UpArrow(47677), new LeftArrow(48572), new UpArrow(49045), new DownArrow(49556), new RightArrow(50027), new LeftArrow(50530), new LeftArrow(51479), new RightArrow(52408), new RightArrow(53383), new DownArrow(54370), new DownArrow(55376), new UpArrow(56285), new UpArrow(57167), new LeftArrow(58139), new DownArrow(59183), new UpArrow(60130), new RightArrow(61097), new RightArrow(62078), new LeftArrow(62089), new DownArrow(63020), new UpArrow(63028), new LeftArrow(63971), new RightArrow(63985), new RightArrow(64914), new LeftArrow(64925)};
		}
		else if (Danceoff.getSong()== -1 && Danceoff.getDifficulty() == 1) {
			arrows = new Arrow[] {new LeftArrow(4658), new RightArrow(5532), new RightArrow(6035), new LeftArrow(6046), new RightArrow(6545), new DownArrow(6560), new DownArrow(7522), new LeftArrow(7532), new UpArrow(7998), new LeftArrow(8003), new UpArrow(8461), new RightArrow(8471), new RightArrow(9428), new LeftArrow(9438), new DownArrow(10414), new LeftArrow(10424), new RightArrow(11340), new DownArrow(11350), new LeftArrow(12319), new LeftArrow(13034), new RightArrow(13275), new LeftArrow(13287), new RightArrow(14267), new RightArrow(14987), new RightArrow(15223), new LeftArrow(15233), new LeftArrow(16150), new RightArrow(16160), new RightArrow(17134), new LeftArrow(17145), new DownArrow(17624), new UpArrow(17632), new RightArrow(18094), new LeftArrow(18104), new UpArrow(19255), new RightArrow(19279), new UpArrow(19484), new LeftArrow(19494), new RightArrow(19961), new LeftArrow(19971), new LeftArrow(20465), new RightArrow(20960), new LeftArrow(21358), new RightArrow(21657), new LeftArrow(21765), new RightArrow(21900), new LeftArrow(22366), new RightArrow(22892), new LeftArrow(23218), new DownArrow(23507), new UpArrow(23683), new DownArrow(23823), new UpArrow(24254), new DownArrow(24769), new UpArrow(25103), new DownArrow(25435), new RightArrow(25910), new DownArrow(25921), new LeftArrow(26454), new DownArrow(26465), new UpArrow(26939), new LeftArrow(26949), new RightArrow(27411), new UpArrow(27420), new LeftArrow(27667), new RightArrow(27677), new RightArrow(28163), new DownArrow(28170), new LeftArrow(28623), new DownArrow(28633), new DownArrow(29361), new LeftArrow(29371), new RightArrow(29602), new DownArrow(29612), new RightArrow(30073), new LeftArrow(30085), new LeftArrow(30546), new UpArrow(30557), new LeftArrow(31238), new UpArrow(31250), new UpArrow(31495), new RightArrow(31502), new RightArrow(32009), new LeftArrow(32018), new RightArrow(32499), new LeftArrow(32507), new LeftArrow(33451), new RightArrow(33457), new DownArrow(33891), new UpArrow(33900), new RightArrow(34390), new LeftArrow(34399), new UpArrow(34832), new DownArrow(34840), new LeftArrow(35750), new LeftArrow(36534), new RightArrow(36799), new LeftArrow(37015), new RightArrow(37110), new LeftArrow(37251), new RightArrow(38030), new RightArrow(39560), new RightArrow(40365), new LeftArrow(41348), new RightArrow(41418), new LeftArrow(41539), new RightArrow(41672), new LeftArrow(41794), new DownArrow(43014), new UpArrow(43476), new DownArrow(43722), new UpArrow(44155), new DownArrow(44392), new DownArrow(44903), new DownArrow(45417), new UpArrow(45651), new UpArrow(46862), new LeftArrow(46870), new RightArrow(47784), new UpArrow(47794), new RightArrow(48749), new LeftArrow(48759), new RightArrow(49233), new LeftArrow(49243), new RightArrow(49720), new DownArrow(49728), new DownArrow(50221), new LeftArrow(50231), new LeftArrow(50690), new UpArrow(50701), new UpArrow(51140), new RightArrow(51150), new LeftArrow(51670), new RightArrow(51681), new RightArrow(52152), new DownArrow(52161), new DownArrow(52609), new LeftArrow(52619), new UpArrow(53075), new LeftArrow(53085), new UpArrow(53556), new RightArrow(53566), new RightArrow(54089), new LeftArrow(54099), new UpArrow(54549), new DownArrow(54559), new UpArrow(55685), new DownArrow(55695), new RightArrow(56454), new LeftArrow(56463), new RightArrow(57200), new LeftArrow(57210), new RightArrow(58386), new DownArrow(58395), new RightArrow(59049), new DownArrow(59059), new DownArrow(60315), new LeftArrow(60325), new LeftArrow(61013), new DownArrow(61023), new LeftArrow(62216), new UpArrow(62226), new RightArrow(63179), new UpArrow(63189), new LeftArrow(64139), new RightArrow(64149), new DownArrow(65042), new UpArrow(65053)};
		}
		else if (Danceoff.getSong() == 0 && Danceoff.getDifficulty() == 0) {
			arrows = new Arrow[] { new RightArrow(1850), new LeftArrow(2423), new RightArrow(3300), new LeftArrow(3782), new RightArrow(4300), new LeftArrow(6198), new RightArrow(7173), new LeftArrow(7644), new RightArrow(8124), new LeftArrow(10081), new RightArrow(11076), new LeftArrow(11520), new RightArrow(12001), new LeftArrow(13861), new RightArrow(14820), new LeftArrow(15307), new RightArrow(15806), new LeftArrow(16778), new RightArrow(16788), new LeftArrow(17764), new UpArrow(18719), new DownArrow(19658), new RightArrow(20595), new LeftArrow(21583), new UpArrow(22548), new DownArrow(23454), new RightArrow(24426), new RightArrow(25443), new DownArrow(26394), new UpArrow(27329), new LeftArrow(28298), new RightArrow(29243), new DownArrow(30162), new UpArrow(31158), new LeftArrow(32146), new UpArrow(32685), new LeftArrow(33116), new LeftArrow(34989), new RightArrow(36831), new RightArrow(38817), new LeftArrow(40714), new RightArrow(40724), new RightArrow(41664), new LeftArrow(41681), new UpArrow(42647), new DownArrow(42657), new UpArrow(44612), new LeftArrow(44622), new RightArrow(46454), new UpArrow(46465), new RightArrow(48395), new LeftArrow(48415), new RightArrow(49875), new LeftArrow(50386), new LeftArrow(52249), new RightArrow(53702), new LeftArrow(53713), new RightArrow(54226), new LeftArrow(54236), new RightArrow(55175), new UpArrow(55680), new LeftArrow(56158), new LeftArrow(57114), new UpArrow(57616), new RightArrow(58072), new LeftArrow(59938), new RightArrow(60900), new LeftArrow(61885), new RightArrow(62885), new LeftArrow(63783), new RightArrow(64757), new LeftArrow(65205), new RightArrow(65706), new LeftArrow(67612), new RightArrow(68554), new LeftArrow(69077), new RightArrow(69575), new LeftArrow(71433), new RightArrow(72446), new LeftArrow(72920), new RightArrow(73416), new UpArrow(75229), new DownArrow(76223), new UpArrow(76739), new DownArrow(77209), new UpArrow(79139), new DownArrow(80105), new UpArrow(81051), new DownArrow(82009), new UpArrow(82985), new DownArrow(83934), new RightArrow(84893), new LeftArrow(84902)}; 
    	}
		else if (Danceoff.getSong() == 0 && Danceoff.getDifficulty() == 1) {
			arrows = new Arrow[] {new LeftArrow(1861), new RightArrow(2371), new LeftArrow(3301), new RightArrow(3728), new RightArrow(4308), new LeftArrow(4319), new UpArrow(5253), new DownArrow(5262), new RightArrow(5748), new LeftArrow(5753), new DownArrow(6230), new UpArrow(6242), new UpArrow(7142), new DownArrow(7582), new UpArrow(8068), new DownArrow(9049), new UpArrow(9575), new RightArrow(10067), new LeftArrow(10076), new RightArrow(11010), new LeftArrow(11449), new RightArrow(11971), new LeftArrow(12959), new RightArrow(13409), new RightArrow(13897), new LeftArrow(13907), new DownArrow(14829), new UpArrow(15301), new DownArrow(15786), new UpArrow(16749), new DownArrow(17249), new LeftArrow(17764), new UpArrow(18709), new DownArrow(19198), new RightArrow(19436), new RightArrow(20607), new UpArrow(20834), new DownArrow(21071), new LeftArrow(21318), new RightArrow(21561), new LeftArrow(22557), new LeftArrow(23516), new UpArrow(24022), new DownArrow(24478), new RightArrow(24935), new LeftArrow(25415), new LeftArrow(26420), new UpArrow(26608), new DownArrow(26855), new RightArrow(27093), new RightArrow(27518), new DownArrow(27787), new UpArrow(28039), new LeftArrow(28302), new RightArrow(29278), new LeftArrow(29288), new UpArrow(30174), new DownArrow(30183), new RightArrow(31150), new LeftArrow(31160), new UpArrow(31628), new RightArrow(31637), new UpArrow(32108), new LeftArrow(32118), new DownArrow(32563), new RightArrow(32573), new LeftArrow(33056), new DownArrow(33070), new DownArrow(33095), new RightArrow(34992), new LeftArrow(35006), new RightArrow(36420), new LeftArrow(36430), new DownArrow(36926), new UpArrow(36940), new LeftArrow(37683), new UpArrow(37728), new RightArrow(38729), new UpArrow(38815), new RightArrow(40757), new LeftArrow(40768), new LeftArrow(41741), new UpArrow(42244), new DownArrow(42700), new RightArrow(43202), new DownArrow(43676), new UpArrow(44121), new LeftArrow(44603), new LeftArrow(45573), new RightArrow(46061), new RightArrow(46538), new LeftArrow(46546), new LeftArrow(47035), new RightArrow(47044), new RightArrow(47541), new LeftArrow(47548), new LeftArrow(48003), new RightArrow(48013), new UpArrow(48450), new DownArrow(48457), new LeftArrow(49444), new UpArrow(49444), new UpArrow(50352), new RightArrow(50361), new DownArrow(51342), new UpArrow(51821), new RightArrow(52312), new LeftArrow(52320), new RightArrow(53230), new DownArrow(53238), new DownArrow(54174), new LeftArrow(54200), new RightArrow(55149), new LeftArrow(55668), new RightArrow(56145), new LeftArrow(56160), new LeftArrow(57120), new DownArrow(57132), new RightArrow(58022), new DownArrow(58031), new LeftArrow(59020), new RightArrow(59518), new LeftArrow(59973), new RightArrow(59985), new LeftArrow(60910), new UpArrow(60925), new UpArrow(61817), new RightArrow(61889), new LeftArrow(62841), new RightArrow(63326), new LeftArrow(63823), new RightArrow(63833), new RightArrow(64757), new LeftArrow(64766), new DownArrow(65736), new UpArrow(66209), new DownArrow(66700), new UpArrow(67154), new RightArrow(67641), new LeftArrow(67649), new RightArrow(68574), new LeftArrow(68584), new RightArrow(69552), new LeftArrow(70027), new RightArrow(70512), new LeftArrow(70983), new UpArrow(71492), new DownArrow(71502), new UpArrow(72446), new DownArrow(73369), new UpArrow(74361), new DownArrow(74859), new UpArrow(75343), new DownArrow(76262), new UpArrow(77216), new UpArrow(77704), new UpArrow(78191), new UpArrow(78687), new RightArrow(79186), new UpArrow(79675), new DownArrow(80157), new LeftArrow(80627), new UpArrow(81126), new DownArrow(81556), new RightArrow(82036), new LeftArrow(82495), new RightArrow(82986), new LeftArrow(82996), new RightArrow(83740), new LeftArrow(83750), new UpArrow(83964), new DownArrow(83975), new UpArrow(84676), new DownArrow(84686), new RightArrow(84936), new LeftArrow(84947), new RightArrow(85604), new LeftArrow(85614)};
		}
		else if (Danceoff.getSong() == 1 && Danceoff.getDifficulty() == 0){
			arrows = new Arrow[] { new RightArrow(661), new LeftArrow(1381), new RightArrow(1685), new UpArrow(3042), new DownArrow(3580), new UpArrow(3834), new LeftArrow(5061), new RightArrow(5661), new LeftArrow(5931), new DownArrow(7203), new UpArrow(7792), new DownArrow(8025), new UpArrow(8519), new DownArrow(8810), new RightArrow(9351), new LeftArrow(9902), new RightArrow(10177), new UpArrow(11546), new DownArrow(12031), new UpArrow(12288), new LeftArrow(13622), new RightArrow(14146), new LeftArrow(14415), new DownArrow(15789), new UpArrow(16293), new DownArrow(16593), new UpArrow(17022), new DownArrow(17327), new RightArrow(17879), new LeftArrow(19186), new LeftArrow(19451), new LeftArrow(20009), new RightArrow(21350), new RightArrow(21601), new UpArrow(22191), new DownArrow(23481), new DownArrow(23710), new DownArrow(24276), new UpArrow(25290), new UpArrow(25854), new LeftArrow(26385), new RightArrow(26927), new LeftArrow(27448), new RightArrow(28544), new LeftArrow(29050), new RightArrow(29566), new LeftArrow(30637), new RightArrow(31167), new LeftArrow(31437), new RightArrow(32707), new LeftArrow(33284), new RightArrow(33558), new DownArrow(34854), new UpArrow(35383), new DownArrow(35651), new UpArrow(36983), new DownArrow(37500), new UpArrow(37785), new RightArrow(39134), new LeftArrow(39148), new RightArrow(39884), new LeftArrow(39896), new RightArrow(41208), new LeftArrow(41218), new UpArrow(41750), new DownArrow(41765), new RightArrow(41993), new LeftArrow(42003), new UpArrow(42502), new DownArrow(42512), new LeftArrow(42772), new RightArrow(42783), new RightArrow(43289), new LeftArrow(43301), new UpArrow(43890), new DownArrow(44133), new RightArrow(45510), new LeftArrow(45521), new RightArrow(45991), new LeftArrow(46256), new LeftArrow(47620), new RightArrow(47631), new LeftArrow(48118), new RightArrow(48376), new DownArrow(49720), new UpArrow(50221), new DownArrow(50513), new UpArrow(51062), new DownArrow(51269), new RightArrow(51809), new LeftArrow(52409), new UpArrow(52661), new LeftArrow(53998), new RightArrow(54509), new UpArrow(54770), new RightArrow(56093), new LeftArrow(56596), new DownArrow(56856), new LeftArrow(58221), new RightArrow(58717), new DownArrow(59011), new LeftArrow(60367), new UpArrow(60864), new RightArrow(61134), new RightArrow(62486), new UpArrow(62945), new LeftArrow(63209), new LeftArrow(64618), new UpArrow(65148), new RightArrow(65783), new DownArrow(66244), new LeftArrow(66738), new RightArrow(67816)};
		}
		else if (Danceoff.getSong() == 1 && Danceoff.getDifficulty() == 1){
			arrows = new Arrow[] { new RightArrow(1067), new LeftArrow(1463), new RightArrow(1729), new LeftArrow(2475), new RightArrow(2700), new LeftArrow(2974), new RightArrow(3505), new LeftArrow(3796), new UpArrow(4535), new DownArrow(4765), new UpArrow(5050), new DownArrow(5652), new UpArrow(5926), new DownArrow(6722), new UpArrow(6949), new DownArrow(7250), new UpArrow(7791), new DownArrow(8060), new UpArrow(8546), new DownArrow(8855), new RightArrow(9086), new LeftArrow(9095), new UpArrow(9346), new DownArrow(9893), new UpArrow(10180), new RightArrow(10725), new LeftArrow(10993), new RightArrow(11542), new LeftArrow(12070), new RightArrow(12325), new LeftArrow(12854), new RightArrow(13128), new UpArrow(13683), new DownArrow(14221), new UpArrow(14469), new UpArrow(14950), new DownArrow(14960), new UpArrow(15494), new RightArrow(15760), new LeftArrow(15766), new DownArrow(16282), new UpArrow(16572), new LeftArrow(17123), new RightArrow(17132), new RightArrow(17423), new LeftArrow(18350), new RightArrow(18645), new RightArrow(20515), new LeftArrow(20812), new UpArrow(21629), new DownArrow(21639), new UpArrow(22179), new DownArrow(22189), new RightArrow(22670), new LeftArrow(22681), new UpArrow(22961), new DownArrow(22972), new LeftArrow(23463), new UpArrow(23748), new RightArrow(24000), new RightArrow(24259), new UpArrow(24269), new UpArrow(24797), new LeftArrow(24806), new LeftArrow(25258), new RightArrow(25268), new DownArrow(25829), new LeftArrow(25840), new RightArrow(26414), new LeftArrow(26935), new RightArrow(27216), new RightArrow(27441), new UpArrow(27452), new UpArrow(27964), new LeftArrow(27974), new RightArrow(28558), new LeftArrow(29055), new RightArrow(29309), new LeftArrow(29582), new UpArrow(29593), new RightArrow(30083), new UpArrow(30094), new RightArrow(30626), new LeftArrow(31201), new RightArrow(31433), new LeftArrow(31716), new RightArrow(31728), new RightArrow(32218), new LeftArrow(32227), new UpArrow(32758), new DownArrow(32768), new RightArrow(33236), new LeftArrow(33244), new DownArrow(33530), new RightArrow(33538), new DownArrow(34020), new LeftArrow(34029), new RightArrow(34307), new DownArrow(34316), new RightArrow(34873), new LeftArrow(35399), new RightArrow(35645), new RightArrow(35913), new DownArrow(35925), new DownArrow(36476), new LeftArrow(36488), new RightArrow(37043), new LeftArrow(37556), new RightArrow(37799), new UpArrow(38068), new RightArrow(38077), new LeftArrow(38587), new UpArrow(38596), new RightArrow(39099), new LeftArrow(39638), new RightArrow(39930), new UpArrow(40191), new LeftArrow(40199), new RightArrow(40716), new UpArrow(40726), new RightArrow(41276), new LeftArrow(41283), new DownArrow(41785), new RightArrow(42327), new LeftArrow(42339), new DownArrow(42573), new LeftArrow(42838), new RightArrow(42848), new UpArrow(43411), new LeftArrow(43908), new UpArrow(44186), new RightArrow(45498), new UpArrow(46024), new RightArrow(46274), new DownArrow(46774), new DownArrow(47336), new LeftArrow(47617), new UpArrow(48165), new LeftArrow(48425), new RightArrow(48988), new RightArrow(49470), new DownArrow(49764), new LeftArrow(50330), new DownArrow(50587), new LeftArrow(51084), new DownArrow(51350), new UpArrow(51857), new RightArrow(52391), new UpArrow(52648), new LeftArrow(53120), new LeftArrow(53717), new DownArrow(53979), new RightArrow(54519), new DownArrow(54794), new LeftArrow(55322), new LeftArrow(55865), new UpArrow(56136), new LeftArrow(56674), new UpArrow(56960), new RightArrow(57471), new RightArrow(57980), new DownArrow(58271), new LeftArrow(58808), new DownArrow(59079), new RightArrow(59540), new RightArrow(59824), new RightArrow(60342), new LeftArrow(60353), new UpArrow(60841), new DownArrow(60851), new LeftArrow(61116), new RightArrow(61127), new RightArrow(62474), new UpArrow(62484), new UpArrow(62989), new LeftArrow(62999), new UpArrow(63246), new RightArrow(63249), new RightArrow(64562), new DownArrow(64572), new DownArrow(65099), new LeftArrow(65109), new RightArrow(65372), new DownArrow(65385), new RightArrow(66753), new LeftArrow(66763), new UpArrow(67243), new DownArrow(67254), new LeftArrow(67524), new RightArrow(67535), new UpArrow(68065), new DownArrow(68076), new RightArrow(68317), new LeftArrow(68327)};
		}
		else if (Danceoff.getSong() == 2) {
			//ArrayList<Arrow> womp = MakeYerOwn.getArrows();
			//arrows = womp.toArray(Arrow[] a);
			System.out.println("" + yourArrows);
			arrows = yourArrows;
		}

		//setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3),	"DanceQueuePanel"));
		//load images for arrows
		rightArrowImg = null;
		leftArrowImg = null;
		upArrowImg = null;
		downArrowImg = null;
		try {
		    rightArrowImg = ImageIO.read(new File("arrowB right.png"));
			 leftArrowImg = ImageIO.read(new File("arrowB left.png"));
			 upArrowImg = ImageIO.read(new File("arrowB up copy.png"));
			 downArrowImg = ImageIO.read(new File("arrowB down.png"));
		} catch (IOException e) {
			warn("oh no!", e);
			System.exit(2);
		}
		songStart = System.currentTimeMillis();
	}
		
	public void	paintComponent(Graphics	g)	{
		g.drawImage(myImage,	0,	0,	getWidth(),	getHeight(), null);
	}

	//	methods
	/**warns events*/
	private void warn(String msg, Throwable t) {
		Logger.getLogger(getClass().getName()).log(Level.WARNING, msg, t);
	}
	
	/** getter for	private array arrows	*/
	public static	Arrow[] getArrows() {
		if	(arrows != null) {
			return arrows;
		}
		else {
			return null;
		}
	}
	
	private static long getSongTime() {
		return System.currentTimeMillis()-songStart;
	}

	/** getter for	element of private array arrows */
	public static	Arrow	getArrow(int arrowPos) {
		return arrows[arrowPos];
	}

	/** listener to redraw panel according	to	timer	*/
	private class Listener implements ActionListener {
		/** redraws	panel	*/
		public void	actionPerformed(ActionEvent e) {
			long songTime = getSongTime();
			if ((Danceoff.getSong() == -1 && songTime < 71000) || (Danceoff.getSong() == 0 && songTime < 85000) || (Danceoff.getSong() == 1 && songTime < 71000) || (Danceoff.getSong() == 2 && songTime < 70000)) {
				//63000, 90000, 70000 
				//clears	buffer
				myBuffer.setColor(new Color(237,	237, 237));
				myBuffer.fillRect(0,0,600,600);
				//draws box
				myBuffer.setColor(Color.LIGHT_GRAY);
				myBuffer.fillRect(boxXMin,	boxYMin,	(boxXMax-boxXMin), (boxYMax-boxYMin));
				//draw arrows
				if	(arrows != null) {
					for (int	i = 0; i	< arrows.length; i++) {
						drawArrow(myBuffer, DanceQueuePanel.arrows[i]);
					}
				}
				else {
					//warn user that level hasn't been created then exit level
					Danceoff.youFail();
					timer.stop();
				}
				//repaints
				repaint();
				//scheduleNextFrame();
			}
			// else if (Danceoff.getSong()!=2) {
// 				//creates a scanner for reading files
// 				Scanner infile = null;
// 				try {
// 					String filename = "highscores.txt";
// 					infile = new Scanner(new File(filename));
// 				} catch (FileNotFoundException d) {
// 					//creates a scanner for writting to files
// 					try {
// 						PrintStream printed = new PrintStream(new FileOutputStream("highscores.txt"));
// 						System.setOut(printed);
// 						for (int i = 0; i < 6; i++)
// 							System.out.println("0");
// 					} catch (FileNotFoundException f) {
// 					}
// 					for (int i = 0; i < 6; i++)
// 					System.out.println("0");
// 					String filename = "highscores.txt";
// 					try {
// 						infile = new Scanner(new File(filename));
// 					} catch (FileNotFoundException g) {
// 					}
// 				}
// 				//reads all highscores into array
// 				int[] numbers = new int[6];
// 				for (int i = 0; i < 6; i++) {
// 					numbers[i] = infile.nextInt();
// 				}
// 				//creates a scanner for writting to files
// 				try {
// 					System.setOut(new PrintStream(new FileOutputStream("highscores.txt")));
// 				} catch (FileNotFoundException f) {
// 				}
// 				//overwrites highscores if score is new highscore
// 				if (Danceoff.getSong() == -1 && Danceoff.getDifficulty() == 0) {
// 					if (numbers[0] < scorePanel.getScore()) {
// 						System.out.println("" + scorePanel.getScore());
// 						for (int x = 1; x < 6; x++) {
// 							System.out.println("" + numbers[x]);
// 						}
// 					}
// 				}
// 				if (Danceoff.getSong() == -1 && Danceoff.getDifficulty() == 1) {
// 					if (numbers[1] < scorePanel.getScore()) {
// 						System.out.println("" + numbers[0]);
// 						System.out.println("" + scorePanel.getScore());
// 						for (int x = 2; x < 6; x++) {
// 							System.out.println("" + numbers[x]);
// 						}
// 					}
// 				}
// 				if (Danceoff.getSong() == 0 && Danceoff.getDifficulty() == 0) {
// 					if (numbers[2] < scorePanel.getScore()) {
// 						System.out.println("" + numbers[0]);
// 						System.out.println("" + numbers[1]);
// 						System.out.println("" + scorePanel.getScore());
// 						for (int x = 3; x < 6; x++) {
// 							System.out.println("" + numbers[x]);
// 						}
// 					}
// 				}
// 				if (Danceoff.getSong() == 0 && Danceoff.getDifficulty() == 1) {
// 					if (numbers[3] < scorePanel.getScore()) {
// 						for (int q = 0; q < 3; q++) {
// 							System.out.println("" + numbers[q]);
// 						}
// 						System.out.println("" + scorePanel.getScore());
// 						for (int x = 4; x < 6; x++) {
// 							System.out.println("" + numbers[x]);
// 						}
// 					}
// 				}
// 				if (Danceoff.getSong() == 1 && Danceoff.getDifficulty() == 0) {
// 					if (numbers[4] < scorePanel.getScore()) {
// 						for (int q = 0; q < 4; q++) {
// 							System.out.println("" + numbers[q]);
// 						}
// 						System.out.println("" + scorePanel.getScore());
// 						for (int x = 5; x < 6; x++) {
// 							System.out.println("" + numbers[x]);
// 						}
// 					}
// 				}
// 				if (Danceoff.getSong() == 1 && Danceoff.getDifficulty() == 1) {
// 					if (numbers[5] < scorePanel.getScore()) {
// 						for (int q = 0; q < 5; q++) {
// 							System.out.println("" + numbers[q]);
// 						}
// 						System.out.println("" + scorePanel.getScore());
// 					}
			else {
				timer.stop();
				Danceoff.songEnd();
			}
		}
		public void	drawArrow(Graphics myBuffer, Arrow	arrow) {
			int x;
			long time = System.currentTimeMillis()-songStart;
			int y = (int)((arrow.startTime	- time)*scaling);
			if	(arrow instanceof	LeftArrow) {
				x = 0;
				myBuffer.drawImage(leftArrowImg, x, y, null);
			}
			else if (arrow	instanceof UpArrow) {
				x = 150;
				myBuffer.drawImage(upArrowImg, x, y, null);
			}
			else if (arrow	instanceof DownArrow) {
				x = 300;
				myBuffer.drawImage(downArrowImg, x, y, null);
			}
			else {
				x = 450;
				myBuffer.drawImage(rightArrowImg, x, y, null);
			}
			
			//myBuffer.setColor(Color.black);
			//myBuffer.drawLine(0,0,x,y);
			
			//Image	img = Toolkit.getDefaultToolkit().getImage("arrowB down.png");
			myBuffer.finalize();
		}
	}
	
	/**method to handle right arrow key	presses*/
	public static void right()	{
		for (int	i = 0; i	< arrows.length; i++) {
			if	(arrows[i] instanceof RightArrow) {
				double currentPos	= (int)((arrows[i].startTime - getSongTime()) *	scaling);
				if	(currentPos+100 >	boxYMin && currentPos <	boxYMax)	{
					scorePanel.setScore(scorePanel.getScore()+5);
					arrows[i].startTime = 0;
				}
			}
		}
	}
	/**method to handle left arrow key presses*/
	public static void left() {
		for (int	i = 0; i	< arrows.length; i++) {
			if	(arrows[i] instanceof LeftArrow)	{
				double currentPos	= (int)((arrows[i].startTime - getSongTime()) *	scaling);
				if	(currentPos+100 >	boxYMin && currentPos <	boxYMax)	{
					scorePanel.setScore(scorePanel.getScore()+5);
					arrows[i].startTime = 0;
				}
			}
		}
	}
	/**method to handle down arrow key presses*/
	public static void up()	{
		for (int	i = 0; i	< arrows.length; i++) {
			if	(arrows[i] instanceof UpArrow) {
				double currentPos	= (int)((arrows[i].startTime - getSongTime()) *	scaling);
				if	(currentPos+100 >	boxYMin && currentPos <	boxYMax)	{
					scorePanel.setScore(scorePanel.getScore()+5);
					arrows[i].startTime = 0;
				}
			}
		}
	}
	/**method to handle up arrow key	presses*/
	public static void down() {
		for (int	i = 0; i	< arrows.length; i++) {
			if	(arrows[i] instanceof DownArrow)	{
				double currentPos	= (int)((arrows[i].startTime - getSongTime()) *	scaling);
				if	(currentPos+100 >	boxYMin && currentPos <	boxYMax)	{
					scorePanel.setScore(scorePanel.getScore()+5);
					arrows[i].startTime = 0;
				}
			}
		}
	}
}
