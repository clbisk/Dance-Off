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
	private static long songStart;
	/**scale	factor to determine how	long the	arrow	will take to get up the	screen*/
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
		else if (Danceoff.getSong() == 0 && Danceoff.getDifficulty() == 1) {
			arrows = new Arrow[] {new RightArrow(1820), new LeftArrow(1825), new LeftArrow(3385), new UpArrow(3755), new DownArrow(4165), new RightArrow(4530), new RightArrow(4960), new LeftArrow(4970), new LeftArrow(6540), new UpArrow(6905), new DownArrow(7315), new RightArrow(7670), new RightArrow(8095), new LeftArrow(8100), new LeftArrow(9665), new UpArrow(10070), new DownArrow(10440), new RightArrow(10820), new RightArrow(11255), new LeftArrow(11265), new LeftArrow(12785), new UpArrow(13165), new DownArrow(13580), new RightArrow(14015), new RightArrow(14435), new LeftArrow(14450), new RightArrow(14885), new DownArrow(15170), new DownArrow(15350), new LeftArrow(15685), new UpArrow(15830), new DownArrow(15995), new RightArrow(16245), new DownArrow(16430), new LeftArrow(16625), new LeftArrow(17210), new UpArrow(17390), new DownArrow(17555), new DownArrow(18030), new UpArrow(18445), new UpArrow(18645), new LeftArrow(18825), new LeftArrow(19040), new LeftArrow(19805), new UpArrow(20150), new RightArrow(21185), new UpArrow(21330), new UpArrow(21595), new LeftArrow(21935), new UpArrow(22100), new DownArrow(22250), new RightArrow(22520), new DownArrow(22705), new LeftArrow(22900), new LeftArrow(23535), new DownArrow(23745), new UpArrow(24020), new RightArrow(24375), new RightArrow(24770), new UpArrow(24930), new UpArrow(25160), new RightArrow(25360), new UpArrow(25520), new RightArrow(25605), new UpArrow(25690), new UpArrow(26330), new LeftArrow(26515), new LeftArrow(26725), new LeftArrow(27545), new UpArrow(27710), new UpArrow(27930), new RightArrow(28305), new UpArrow(28715), new LeftArrow(29105), new LeftArrow(29545), new LeftArrow(29965), new UpArrow(30305), new RightArrow(30695), new RightArrow(30990), new UpArrow(31355), new LeftArrow(31525), new UpArrow(31695), new LeftArrow(31880), new LeftArrow(33475), new UpArrow(33830), new UpArrow(34260), new RightArrow(34660), new RightArrow(35065), new UpArrow(35445), new UpArrow(35825), new LeftArrow(36210), new UpArrow(36615), new UpArrow(37025), new LeftArrow(37215), new UpArrow(37405), new RightArrow(37625), new RightArrow(37840), new RightArrow(38190), new LeftArrow(38205), new RightArrow(38590), new LeftArrow(38620), new RightArrow(38970), new LeftArrow(39010), new RightArrow(39390), new LeftArrow(39405), new RightArrow(39770), new LeftArrow(39780), new LeftArrow(40185), new UpArrow(40350), new RightArrow(40605), new LeftArrow(40950), new UpArrow(41120), new DownArrow(41365), new RightArrow(41570), new UpArrow(41800), new UpArrow(42000), new LeftArrow(42530), new UpArrow(42685), new DownArrow(42890), new LeftArrow(43280), new UpArrow(43445), new DownArrow(43635), new LeftArrow(44140), new UpArrow(44315), new DownArrow(44540), new UpArrow(44785), new UpArrow(44960), new UpArrow(45165), new LeftArrow(46170), new RightArrow(46590), new UpArrow(46965), new LeftArrow(47365), new UpArrow(47725), new RightArrow(48410), new RightArrow(48575), new UpArrow(48770), new UpArrow(48960), new UpArrow(49350), new LeftArrow(51320), new UpArrow(51740), new RightArrow(52125), new RightArrow(52565), new LeftArrow(52965), new UpArrow(53135), new RightArrow(53340), new LeftArrow(53745), new UpArrow(53915), new RightArrow(54135), new UpArrow(54370), new UpArrow(54555), new UpArrow(54740), new LeftArrow(55340), new UpArrow(55515), new DownArrow(55695), new LeftArrow(56115), new UpArrow(56275), new DownArrow(56490), new LeftArrow(56905), new DownArrow(57095), new RightArrow(57285), new DownArrow(57580), new LeftArrow(57765), new LeftArrow(57945), new RightArrow(58465), new UpArrow(58625), new LeftArrow(58885), new RightArrow(59295), new UpArrow(59465), new LeftArrow(59890), new RightArrow(60405), new LeftArrow(60425), new RightArrow(61220), new LeftArrow(61265), new LeftArrow(62065), new UpArrow(62075), new LeftArrow(62435), new UpArrow(62440), new UpArrow(62815), new LeftArrow(62820), new LeftArrow(63205), new UpArrow(63210), new RightArrow(63570), new UpArrow(63575), new RightArrow(63920), new UpArrow(63925), new RightArrow(64270), new UpArrow(64275), new RightArrow(64625), new UpArrow(64630), new RightArrow(64980), new LeftArrow(64985)};
		}
		else if (Danceoff.getSong() == 0 && Danceoff.getDifficulty() == 0) {
			arrows = new Arrow[] {new LeftArrow(1970), new RightArrow(2475), new LeftArrow(3452), new RightArrow(3913), new LeftArrow(4379), new RightArrow(5796), new LeftArrow(6339), new RightArrow(7209), new LeftArrow(7711), new RightArrow(8195), new UpArrow(9616), new DownArrow(10114), new UpArrow(11046), new DownArrow(11513), new UpArrow(12023), new DownArrow(13403), new UpArrow(13902), new DownArrow(14812), new UpArrow(15303), new DownArrow(15823), new RightArrow(16818), new LeftArrow(16828), new UpArrow(17791), new DownArrow(17802), new LeftArrow(19712), new RightArrow(19722), new RightArrow(20655), new LeftArrow(21138), new RightArrow(21641), new LeftArrow(23544), new RightArrow(24053), new LeftArrow(24506), new UpArrow(25498), new DownArrow(26430), new UpArrow(27400), new DownArrow(27895), new UpArrow(28329), new DownArrow(28796), new UpArrow(29282), new UpArrow(30242), new DownArrow(31226), new DownArrow(31718), new DownArrow(32196), new DownArrow(32632), new LeftArrow(33138), new RightArrow(35017), new LeftArrow(36535), new RightArrow(37033), new RightArrow(38837), new LeftArrow(40745), new RightArrow(42684), new LeftArrow(44634), new RightArrow(45633), new RightArrow(46566), new LeftArrow(46575), new RightArrow(47516), new LeftArrow(47526), new UpArrow(48500), new DownArrow(48510), new LeftArrow(49420), new RightArrow(49950), new UpArrow(50446), new RightArrow(52324), new DownArrow(53298), new LeftArrow(53791), new UpArrow(54281), new LeftArrow(56168), new RightArrow(57155), new DownArrow(57617), new UpArrow(58098), new UpArrow(59997), new LeftArrow(60949), new RightArrow(60960), new DownArrow(61467), new LeftArrow(61945), new RightArrow(61956), new LeftArrow(63864), new RightArrow(64826)};
		}
		else if (Danceoff.getSong() == 1 && Danceoff.getDifficulty() == 0){
			arrows = new Arrow[] { new RightArrow(661), new LeftArrow(1381), new RightArrow(1685), new UpArrow(3042), new DownArrow(3580), new UpArrow(3834), new LeftArrow(5061), new RightArrow(5661), new LeftArrow(5931), new DownArrow(7203), new UpArrow(7792), new DownArrow(8025), new UpArrow(8519), new DownArrow(8810), new RightArrow(9351), new LeftArrow(9902), new RightArrow(10177), new UpArrow(11546), new DownArrow(12031), new UpArrow(12288), new LeftArrow(13622), new RightArrow(14146), new LeftArrow(14415), new DownArrow(15789), new UpArrow(16293), new DownArrow(16593), new UpArrow(17022), new DownArrow(17327), new RightArrow(17879), new LeftArrow(19186), new LeftArrow(19451), new LeftArrow(20009), new RightArrow(21350), new RightArrow(21601), new UpArrow(22191), new DownArrow(23481), new DownArrow(23710), new DownArrow(24276), new UpArrow(25290), new UpArrow(25854), new LeftArrow(26385), new RightArrow(26927), new LeftArrow(27448), new RightArrow(28544), new LeftArrow(29050), new RightArrow(29566), new LeftArrow(30637), new RightArrow(31167), new LeftArrow(31437), new RightArrow(32707), new LeftArrow(33284), new RightArrow(33558), new DownArrow(34854), new UpArrow(35383), new DownArrow(35651), new UpArrow(36983), new DownArrow(37500), new UpArrow(37785), new RightArrow(39134), new LeftArrow(39148), new RightArrow(39884), new LeftArrow(39896), new RightArrow(41208), new LeftArrow(41218), new UpArrow(41750), new DownArrow(41765), new RightArrow(41993), new LeftArrow(42003), new UpArrow(42502), new DownArrow(42512), new LeftArrow(42772), new RightArrow(42783), new RightArrow(43289), new LeftArrow(43301), new UpArrow(43890), new DownArrow(44133), new RightArrow(45510), new LeftArrow(45521), new RightArrow(45991), new LeftArrow(46256), new LeftArrow(47620), new RightArrow(47631), new LeftArrow(48118), new RightArrow(48376), new DownArrow(49720), new UpArrow(50221), new DownArrow(50513), new UpArrow(51062), new DownArrow(51269), new RightArrow(51809), new LeftArrow(52409), new UpArrow(52661), new LeftArrow(53998), new RightArrow(54509), new UpArrow(54770), new RightArrow(56093), new LeftArrow(56596), new DownArrow(56856), new LeftArrow(58221), new RightArrow(58717), new DownArrow(59011), new LeftArrow(60367), new UpArrow(60864), new RightArrow(61134), new RightArrow(62486), new UpArrow(62945), new LeftArrow(63209), new LeftArrow(64618), new UpArrow(65148), new RightArrow(65783), new DownArrow(66244), new LeftArrow(66738), new RightArrow(67816)};
		}
		else if (Danceoff.getSong() == 1 && Danceoff.getDifficulty() == 1){
			arrows = new Arrow[] { new RightArrow(1067), new LeftArrow(1463), new RightArrow(1729), new LeftArrow(2475), new RightArrow(2700), new LeftArrow(2974), new RightArrow(3505), new LeftArrow(3796), new UpArrow(4535), new DownArrow(4765), new UpArrow(5050), new DownArrow(5652), new UpArrow(5926), new DownArrow(6722), new UpArrow(6949), new DownArrow(7250), new UpArrow(7791), new DownArrow(8060), new UpArrow(8546), new DownArrow(8855), new RightArrow(9086), new LeftArrow(9095), new UpArrow(9346), new DownArrow(9893), new UpArrow(10180), new RightArrow(10725), new LeftArrow(10993), new RightArrow(11542), new LeftArrow(12070), new RightArrow(12325), new LeftArrow(12854), new RightArrow(13128), new UpArrow(13683), new DownArrow(14221), new UpArrow(14469), new UpArrow(14950), new DownArrow(14960), new UpArrow(15494), new RightArrow(15760), new LeftArrow(15766), new DownArrow(16282), new UpArrow(16572), new LeftArrow(17123), new RightArrow(17132), new RightArrow(17423), new LeftArrow(18350), new RightArrow(18645), new RightArrow(20515), new LeftArrow(20812), new UpArrow(21629), new DownArrow(21639), new UpArrow(22179), new DownArrow(22189), new RightArrow(22670), new LeftArrow(22681), new UpArrow(22961), new DownArrow(22972), new LeftArrow(23463), new UpArrow(23748), new RightArrow(24000), new RightArrow(24259), new UpArrow(24269), new UpArrow(24797), new LeftArrow(24806), new LeftArrow(25258), new RightArrow(25268), new DownArrow(25829), new LeftArrow(25840), new RightArrow(26414), new LeftArrow(26935), new RightArrow(27216), new RightArrow(27441), new UpArrow(27452), new UpArrow(27964), new LeftArrow(27974), new RightArrow(28558), new LeftArrow(29055), new RightArrow(29309), new LeftArrow(29582), new UpArrow(29593), new RightArrow(30083), new UpArrow(30094), new RightArrow(30626), new LeftArrow(31201), new RightArrow(31433), new LeftArrow(31716), new RightArrow(31728), new RightArrow(32218), new LeftArrow(32227), new UpArrow(32758), new DownArrow(32768), new RightArrow(33236), new LeftArrow(33244), new DownArrow(33530), new RightArrow(33538), new DownArrow(34020), new LeftArrow(34029), new RightArrow(34307), new DownArrow(34316), new RightArrow(34873), new LeftArrow(35399), new RightArrow(35645), new RightArrow(35913), new DownArrow(35925), new DownArrow(36476), new LeftArrow(36488), new RightArrow(37043), new LeftArrow(37556), new RightArrow(37799), new UpArrow(38068), new RightArrow(38077), new LeftArrow(38587), new UpArrow(38596), new RightArrow(39099), new LeftArrow(39638), new RightArrow(39930), new UpArrow(40191), new LeftArrow(40199), new RightArrow(40716), new UpArrow(40726), new RightArrow(41276), new LeftArrow(41283), new DownArrow(41785), new RightArrow(42327), new LeftArrow(42339), new DownArrow(42573), new LeftArrow(42838), new RightArrow(42848), new UpArrow(43411), new LeftArrow(43908), new UpArrow(44186), new RightArrow(45498), new UpArrow(46024), new RightArrow(46274), new DownArrow(46774), new DownArrow(47336), new LeftArrow(47617), new UpArrow(48165), new LeftArrow(48425), new RightArrow(48988), new RightArrow(49470), new DownArrow(49764), new LeftArrow(50330), new DownArrow(50587), new LeftArrow(51084), new DownArrow(51350), new UpArrow(51857), new RightArrow(52391), new UpArrow(52648), new LeftArrow(53120), new LeftArrow(53717), new DownArrow(53979), new RightArrow(54519), new DownArrow(54794), new LeftArrow(55322), new LeftArrow(55865), new UpArrow(56136), new LeftArrow(56674), new UpArrow(56960), new RightArrow(57471), new RightArrow(57980), new DownArrow(58271), new LeftArrow(58808), new DownArrow(59079), new RightArrow(59540), new RightArrow(59824), new RightArrow(60342), new LeftArrow(60353), new UpArrow(60841), new DownArrow(60851), new LeftArrow(61116), new RightArrow(61127), new RightArrow(62474), new UpArrow(62484), new UpArrow(62989), new LeftArrow(62999), new UpArrow(63246), new RightArrow(63249), new RightArrow(64562), new DownArrow(64572), new DownArrow(65099), new LeftArrow(65109), new RightArrow(65372), new DownArrow(65385), new RightArrow(66753), new LeftArrow(66763), new UpArrow(67243), new DownArrow(67254), new LeftArrow(67524), new RightArrow(67535), new UpArrow(68065), new DownArrow(68076), new RightArrow(68317), new LeftArrow(68327)};
		}
		else {
			//reads songAEasy.ser for highscore
			try {
				Arrow[] dance;
				FileInputStream fileIn = new FileInputStream("customdance.ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				dance = in.readObject();
				in.close();
				fileIn.close();
				arrows = dance;
			}catch(IOException i) {
				System.out.println("error reading highscores");
				return;
			}catch(ClassNotFoundException c) {
				System.out.println("Class not found");
				return;
			} 
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
			warn("YOU FAIL", e);
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
	private static	Arrow[] getArrows() {
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
	private static	Arrow	getArrow(int arrowPos) {
		return arrows[arrowPos];
	}

	/** listener to redraw panel according	to	timer	*/
	private class Listener implements ActionListener {
		/** redraws	panel	*/
		public void	actionPerformed(ActionEvent e) {
			long songTime = getSongTime();
			if ((Danceoff.getSong() == -1 && songTime < 75000) || (Danceoff.getSong() == 0 && songTime < 68000) || (Danceoff.getSong() == 1 && songTime < 85000)) {
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
					System.out.println("This level has not	yet been	created!");
					timer.stop();
				}
				//repaints
				repaint();
				//scheduleNextFrame();
			}
			else {
				//creates a scanner for reading files
				Scanner infile = null;
				try {
					String filename = "high scores.txt";
					infile = new Scanner(new File(filename));
				} catch (FileNotFoundException e) {
					//creates a scanner for writting to files
					System.setOut(new PrintStream(new FileOutputStream("high scores.txt")));
					for (int i = 0; i < 6; i++)
						System.out.println("0");
					String filename = "high scores.txt";
					infile = new Scanner(new File(filename));
				}
				//reads all highscores into array
				int[] numbers = new int[6];
				for (int i = 0; i < 6; i++) {
					numbers[i] = infile.nextInt();
				}
				//creates a scanner for writting to files
				System.setOut(new PrintStream(new FileOutputStream("high scores.txt")));
				//overwrites highscores if score is new highscore
				if (Danceoff.getSong() == -1 && Danceoff.getDifficulty == 0) {
					if numbers[0] < ScorePanel.getScore() {
						System.out.println("" + ScorePanel.getScore());
						if (int x = 1; x < 6; x++) {
							System.out.println("" + numbers[x]);
						}
					}
				}
				if (Danceoff.getSong() == -1 && Danceoff.getDifficulty == 1) {
					if numbers[1] < ScorePanel.getScore() {
						System.out.println("" + numbers[0]);
						System.out.println("" + ScorePanel.getScore());
						if (int x = 2; x < 6; x++) {
							System.out.println("" + numbers[x]);
						}
					}
				}
				if (Danceoff.getSong() == 0 && Danceoff.getDifficulty == 0) {
					if numbers[2] < ScorePanel.getScore() {
						System.out.println("" + numbers[0]);
						System.out.println("" + numbers[1]);
						System.out.println("" + ScorePanel.getScore());
						if (int x = 3; x < 6; x++) {
							System.out.println("" + numbers[x]);
						}
					}
				}
				if (Danceoff.getSong() == 0 && Danceoff.getDifficulty == 1) {
					if numbers[3] < ScorePanel.getScore() {
						for (int q = 0; q < 3; q++) {
							System.out.println("" + numbers[q]);
						}
						System.out.println("" + ScorePanel.getScore());
						if (int x = 4; x < 6; x++) {
							System.out.println("" + numbers[x]);
						}
					}
				}
				if (Danceoff.getSong() == 1 && Danceoff.getDifficulty == 0) {
					if numbers[4] < ScorePanel.getScore() {
						for (int q = 0; q < 4; q++) {
							System.out.println("" + numbers[q]);
						}
						System.out.println("" + ScorePanel.getScore());
						if (int x = 5; x < 6; x++) {
							System.out.println("" + numbers[x]);
						}
					}
				}
				if (Danceoff.getSong() == 1 && Danceoff.getDifficulty == 1) {
					if numbers[5] < ScorePanel.getScore() {
						for (int q = 0; q < 5; q++) {
							System.out.println("" + numbers[q]);
						}
						System.out.println("" + ScorePanel.getScore());
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
