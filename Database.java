package hangman;

import java.util.Random;

public class Database {
	
	private static Random random = new Random();
	private static String[] fourLetter = {
			"abet",
			"abut",
			"ache",
			"alit",
			"ante",
			"arch",
			"aver",
			"avow",
			"bach",
			"back",
			"bade",
			"bail",
			"bait",
			"bake",
			"bale",
			"balk",
			"ball",
			"band",
			"bang",
			"bank",
			"barb",
			"bard",
			"bare",
			"barf",
			"bark",
			"base",
			"bash",
			"bask",
			"bate",
			"bawl",
			"bead",
			"beam",
			"bean",
			"bear",
			"beat",
			"beef",
			"been",
			"beep",
			"bell",
			"belt",
			"bend",
			"bent",
			"bias",
			"bide",
			"biff",
			"bike",
			"bilk",
			"bill",
			"bind",
			"bird",
			"birl",
			"birr",
			"bite",
			"bitt",
			"blab",
			"blat",
			"bled",
			"blew",
			"blob",
			"blot",
			"blow",
			"blub",
			"blue",
			"blur",
			"boat",
			"bode",
			"body",
			"boil",
			"bolt",
			"bomb",
			"bond",
			"bone",
			"bong",
			"bonk",
			"book",
			"boom",
			"boot",
			"bore",
			"born",
			"boss",
			"bowl",
			"brag",
			"bray",
			"bred",
			"brew",
			"brim",
			"buck",
			"buff",
			"bulk",
			"bull",
			"bump",
			"bung",
			"bunk",
			"bunt",
			"buoy",
			"burl",
			"burn",
			"burp",
			"burr",
			"bury",
			"bush",
			"busk",
			"buss",
			"bust",
			"busy",
			"butt",
			"buzz",
			"caca",
			"cage",
			"cake",
			"calk",
			"call",
			"calm",
			"came",
			"camp",
			"cane",
			"cant",
			"card",
			"care",
			"cart",
			"case",
			"cash",
			"cast",
			"cave",
			"cede",
			"cere",
			"chap",
			"char",
			"chat",
			"chaw",
			"chid",
			"chin",
			"chip",
			"chop",
			"chug",
			"chum",
			"cite",
			"clad",
	};
	
	private static String[] fiveLetter = {
			"urmom"
	};
	
	public static String getWord(int letters) {
		String word;
		if (letters == 4) {
			word = fourLetter[random.nextInt(fourLetter.length)];
		} else if (letters == 5) {
			word = fiveLetter[random.nextInt(fiveLetter.length)];
		} else {
			word = "word";
		}
		return word;
		
	}
}