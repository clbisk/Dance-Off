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
			arrows =	new Arrow[]	{new LeftArrow(2475), new RightArrow(3460), new LeftArrow(4280), new RightArrow(5205), new LeftArrow(5695), new RightArrow(6165), new LeftArrow(7135), new RightArrow(7610), new LeftArrow(8095), new RightArrow(9060), new LeftArrow(9070), new DownArrow(10040), new UpArrow(10055), new RightArrow(10980), new LeftArrow(10990), new UpArrow(11460), new DownArrow(11470), new LeftArrow(11930), new RightArrow(12840), new LeftArrow(13310), new RightArrow(13820), new LeftArrow(14775), new RightArrow(15255), new LeftArrow(15755), new RightArrow(16685), new LeftArrow(16695), new RightArrow(17615), new LeftArrow(17625), new RightArrow(18115), new LeftArrow(18125), new DownArrow(18600), new UpArrow(18610), new RightArrow(19070), new LeftArrow(19080), new RightArrow(19555), new LeftArrow(19565), new RightArrow(20530), new UpArrow(20540), new UpArrow(21000), new LeftArrow(21010), new RightArrow(21480), new UpArrow(21490), new UpArrow(22455), new LeftArrow(22470), new RightArrow(22900), new UpArrow(22920), new UpArrow(23405), new LeftArrow(23415), new RightArrow(24355), new UpArrow(24370), new LeftArrow(24825), new UpArrow(24835), new RightArrow(25310), new LeftArrow(25325), new DownArrow(25765), new DownArrow(26045), new DownArrow(26315), new DownArrow(26760), new UpArrow(27230), new LeftArrow(27945), new RightArrow(28230), new UpArrow(29145), new RightArrow(29870), new LeftArrow(30135), new DownArrow(31045), new LeftArrow(31770), new RightArrow(32025), new DownArrow(32945), new RightArrow(33400), new LeftArrow(33925), new LeftArrow(34840), new RightArrow(34860), new LeftArrow(34985), new RightArrow(35780), new LeftArrow(35790), new DownArrow(36775), new UpArrow(36785), new RightArrow(37230), new LeftArrow(37240), new UpArrow(37475), new DownArrow(37485)};
		}
		else if (Danceoff.getSong()== -1 && Danceoff.getDifficulty() == 1) {
			arrows = new Arrow[] {new LeftArrow(4451), new RightArrow(5400), new LeftArrow(5874), new RightArrow(6108), new LeftArrow(6357), new RightArrow(7321), new LeftArrow(7809), new RightArrow(8063), new LeftArrow(8278), new UpArrow(9251), new DownArrow(9774), new UpArrow(9973), new DownArrow(10207), new RightArrow(10678), new LeftArrow(10689), new RightArrow(11165), new LeftArrow(11175), new RightArrow(11906), new LeftArrow(11916), new UpArrow(12183), new DownArrow(12195), new UpArrow(13347), new DownArrow(13358), new LeftArrow(13701), new RightArrow(13711), new UpArrow(13978), new DownArrow(13990), new LeftArrow(14661), new RightArrow(14912), new LeftArrow(15405), new RightArrow(15622), new LeftArrow(15881), new UpArrow(16594), new DownArrow(16860), new RightArrow(17527), new LeftArrow(17822), new LeftArrow(18537), new UpArrow(18626), new RightArrow(18738), new LeftArrow(19015), new UpArrow(19086), new RightArrow(19220), new RightArrow(19758), new LeftArrow(20241), new RightArrow(20702), new RightArrow(21416), new DownArrow(21529), new LeftArrow(21666), new RightArrow(22023), new DownArrow(22078), new LeftArrow(22171), new LeftArrow(22629), new RightArrow(22997), new LeftArrow(23379), new UpArrow(23469), new RightArrow(23580), new LeftArrow(23846), new UpArrow(23904), new RightArrow(23998), new RightArrow(24543), new LeftArrow(24889), new LeftArrow(25409), new DownArrow(25483), new RightArrow(25549), new LeftArrow(25852), new DownArrow(25920), new RightArrow(25985), new RightArrow(26456), new LeftArrow(26830), new RightArrow(27246), new UpArrow(27337), new LeftArrow(27424), new RightArrow(27748), new UpArrow(27824), new LeftArrow(27895), new RightArrow(28398), new LeftArrow(28760), new RightArrow(29137), new DownArrow(29206), new LeftArrow(29307), new RightArrow(29656), new DownArrow(29724), new LeftArrow(29816), new RightArrow(30312), new LeftArrow(30656), new RightArrow(31049), new DownArrow(31120), new LeftArrow(31237), new RightArrow(31616), new DownArrow(31670), new LeftArrow(31775), new RightArrow(32232), new LeftArrow(32605), new RightArrow(33124), new UpArrow(33191), new LeftArrow(33265), new RightArrow(33566), new UpArrow(33636), new LeftArrow(33707), new RightArrow(34132), new LeftArrow(34500), new RightArrow(35105), new LeftArrow(35114), new DownArrow(35558), new UpArrow(35571), new LeftArrow(35799), new RightArrow(35809), new UpArrow(36508), new LeftArrow(36515), new RightArrow(37027), new UpArrow(37035), new LeftArrow(37495), new UpArrow(37508), new UpArrow(37743), new RightArrow(37753), new DownArrow(38951), new LeftArrow(38959), new RightArrow(39359), new DownArrow(39368), new LeftArrow(39655), new DownArrow(39666), new RightArrow(40863), new LeftArrow(40872), new DownArrow(41575), new UpArrow(41598), new RightArrow(42057), new LeftArrow(42067), new DownArrow(42287), new LeftArrow(42748), new RightArrow(43244), new UpArrow(43726), new LeftArrow(44446), new RightArrow(44717), new LeftArrow(45206), new RightArrow(45426), new LeftArrow(45688), new LeftArrow(46648), new UpArrow(47227), new DownArrow(47644), new RightArrow(48066), new LeftArrow(48551), new UpArrow(48767), new DownArrow(49005), new RightArrow(49247), new LeftArrow(49499), new UpArrow(49718), new DownArrow(49968), new RightArrow(50207), new LeftArrow(50477), new RightArrow(50936), new LeftArrow(51205), new LeftArrow(52367), new RightArrow(52377), new DownArrow(53065), new RightArrow(54272), new LeftArrow(54282), new LeftArrow(54700), new UpArrow(54710), new RightArrow(54966), new UpArrow(54977), new LeftArrow(55755), new RightArrow(56227), new DownArrow(56691), new UpArrow(56921), new LeftArrow(57167), new RightArrow(57433), new UpArrow(57659), new LeftArrow(58156), new RightArrow(58664), new LeftArrow(58922), new LeftArrow(59593), new RightArrow(59604), new DownArrow(60059), new LeftArrow(60069), new RightArrow(60510), new DownArrow(60520), new LeftArrow(60996), new RightArrow(61006), new LeftArrow(61449), new UpArrow(61458), new RightArrow(61928), new UpArrow(61939), new LeftArrow(62903), new RightArrow(62913), new DownArrow(63847), new RightArrow(63856), new LeftArrow(64346), new DownArrow(64356), new UpArrow(64839), new LeftArrow(64850), new UpArrow(65319), new RightArrow(65330), new LeftArrow(65830), new RightArrow(65840)};
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
			ArrayList<Arrow> womp = MakeYerOwn.getArrows();
			//arrows = womp.toArray(Arrow[] a);
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
			if ((Danceoff.getSong() == -1 && songTime < 71000) || (Danceoff.getSong() == 0 && songTime < 85000) || (Danceoff.getSong() == 1 && songTime < 71000) || (Danceoff.getSong() == 2 && songTime < 1000)) {
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
			else if (Danceoff.getSong()!=2) {
				//creates a scanner for reading files
				Scanner infile = null;
				try {
					String filename = "highscores.txt";
					infile = new Scanner(new File(filename));
				} catch (FileNotFoundException d) {
					//creates a scanner for writting to files
					try {
						PrintStream printed = new PrintStream(new FileOutputStream("highscores.txt"));
						System.setOut(printed);
						for (int i = 0; i < 6; i++)
							System.out.println("0");
					} catch (FileNotFoundException f) {
					}
					for (int i = 0; i < 6; i++)
					System.out.println("0");
					String filename = "highscores.txt";
					try {
						infile = new Scanner(new File(filename));
					} catch (FileNotFoundException g) {
					}
				}
				//reads all highscores into array
				int[] numbers = new int[6];
				for (int i = 0; i < 6; i++) {
					numbers[i] = infile.nextInt();
				}
				//creates a scanner for writting to files
				try {
					System.setOut(new PrintStream(new FileOutputStream("highscores.txt")));
				} catch (FileNotFoundException f) {
				}
				//overwrites highscores if score is new highscore
				if (Danceoff.getSong() == -1 && Danceoff.getDifficulty() == 0) {
					if (numbers[0] < scorePanel.getScore()) {
						System.out.println("" + scorePanel.getScore());
						for (int x = 1; x < 6; x++) {
							System.out.println("" + numbers[x]);
						}
					}
				}
				if (Danceoff.getSong() == -1 && Danceoff.getDifficulty() == 1) {
					if (numbers[1] < scorePanel.getScore()) {
						System.out.println("" + numbers[0]);
						System.out.println("" + scorePanel.getScore());
						for (int x = 2; x < 6; x++) {
							System.out.println("" + numbers[x]);
						}
					}
				}
				if (Danceoff.getSong() == 0 && Danceoff.getDifficulty() == 0) {
					if (numbers[2] < scorePanel.getScore()) {
						System.out.println("" + numbers[0]);
						System.out.println("" + numbers[1]);
						System.out.println("" + scorePanel.getScore());
						for (int x = 3; x < 6; x++) {
							System.out.println("" + numbers[x]);
						}
					}
				}
				if (Danceoff.getSong() == 0 && Danceoff.getDifficulty() == 1) {
					if (numbers[3] < scorePanel.getScore()) {
						for (int q = 0; q < 3; q++) {
							System.out.println("" + numbers[q]);
						}
						System.out.println("" + scorePanel.getScore());
						for (int x = 4; x < 6; x++) {
							System.out.println("" + numbers[x]);
						}
					}
				}
				if (Danceoff.getSong() == 1 && Danceoff.getDifficulty() == 0) {
					if (numbers[4] < scorePanel.getScore()) {
						for (int q = 0; q < 4; q++) {
							System.out.println("" + numbers[q]);
						}
						System.out.println("" + scorePanel.getScore());
						for (int x = 5; x < 6; x++) {
							System.out.println("" + numbers[x]);
						}
					}
				}
				if (Danceoff.getSong() == 1 && Danceoff.getDifficulty() == 1) {
					if (numbers[5] < scorePanel.getScore()) {
						for (int q = 0; q < 5; q++) {
							System.out.println("" + numbers[q]);
						}
						System.out.println("" + scorePanel.getScore());
					}
				}
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
