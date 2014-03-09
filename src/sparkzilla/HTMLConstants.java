/* Generated By:JavaCC: Do not edit this line. HTMLConstants.java */
package sparkzilla;

public interface HTMLConstants {

  int EOF = 0;
  int OPENHTML = 5;
  int CLOSEHTML = 6;
  int OPENBODY = 7;
  int CLOSEBODY = 8;
  int CLOSEFORM = 9;
  int CLOSELINK = 10;
  int OPENPARAGRAPH = 11;
  int CLOSEPARAGRAPH = 12;
  int SUBMIT = 13;
  int OPENFORM = 19;
  int OPENLINK = 22;
  int INPUT = 25;
  int TEXT = 26;

  int DEFAULT = 0;
  int IN_OPENFORM3 = 1;
  int IN_OPENLINK3 = 2;
  int IN_INPUT3 = 3;
  int IN_P = 4;
  int IN_OPENFORM = 5;
  int IN_OPENFORM2 = 6;
  int IN_OPENLINK = 7;
  int IN_OPENLINK2 = 8;
  int IN_INPUT = 9;
  int IN_INPUT2 = 10;

  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\r\"",
    "\"\\n\"",
    "\"<html>\"",
    "\"</html>\"",
    "\"<body>\"",
    "\"</body>\"",
    "\"</form>\"",
    "\"</a>\"",
    "\"<p>\"",
    "\"</p>\"",
    "\"<input type=\\\"submit\\\" value=\\\"submit\\\" />\"",
    "\"<form method=\\\"post\\\" action=\\\"\"",
    "\"<a href=\\\"\"",
    "\"<input type=\\\"text\\\" name=\\\"\"",
    "<token of kind 17>",
    "\"\\\"\"",
    "\">\"",
    "<token of kind 20>",
    "\"\\\"\"",
    "\">\"",
    "<token of kind 23>",
    "\"\\\"\"",
    "\"/>\"",
    "<TEXT>",
  };

}