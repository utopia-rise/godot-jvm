// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress

public enum class Key(
  public override val `value`: Long,
) : GodotEnum {
  /**
   * Enum value which doesn't correspond to any key. This is used to initialize [Key] properties
   * with a generic state.
   */
  NONE(0),
  /**
   * Keycodes with this bit applied are non-printable.
   */
  SPECIAL(4194304),
  /**
   * Escape key.
   */
  ESCAPE(4194305),
  /**
   * Tab key.
   */
  TAB(4194306),
  /**
   * Shift + Tab key.
   */
  BACKTAB(4194307),
  /**
   * Backspace key.
   */
  BACKSPACE(4194308),
  /**
   * Return key (on the main keyboard).
   */
  ENTER(4194309),
  /**
   * Enter key on the numeric keypad.
   */
  KP_ENTER(4194310),
  /**
   * Insert key.
   */
  INSERT(4194311),
  /**
   * Delete key.
   */
  DELETE(4194312),
  /**
   * Pause key.
   */
  PAUSE(4194313),
  /**
   * Print Screen key.
   */
  PRINT(4194314),
  /**
   * System Request key.
   */
  SYSREQ(4194315),
  /**
   * Clear key.
   */
  CLEAR(4194316),
  /**
   * Home key.
   */
  HOME(4194317),
  /**
   * End key.
   */
  END(4194318),
  /**
   * Left arrow key.
   */
  LEFT(4194319),
  /**
   * Up arrow key.
   */
  UP(4194320),
  /**
   * Right arrow key.
   */
  RIGHT(4194321),
  /**
   * Down arrow key.
   */
  DOWN(4194322),
  /**
   * Page Up key.
   */
  PAGEUP(4194323),
  /**
   * Page Down key.
   */
  PAGEDOWN(4194324),
  /**
   * Shift key.
   */
  SHIFT(4194325),
  /**
   * Control key.
   */
  CTRL(4194326),
  /**
   * Meta key.
   */
  META(4194327),
  /**
   * Alt key.
   */
  ALT(4194328),
  /**
   * Caps Lock key.
   */
  CAPSLOCK(4194329),
  /**
   * Num Lock key.
   */
  NUMLOCK(4194330),
  /**
   * Scroll Lock key.
   */
  SCROLLLOCK(4194331),
  /**
   * F1 key.
   */
  F1(4194332),
  /**
   * F2 key.
   */
  F2(4194333),
  /**
   * F3 key.
   */
  F3(4194334),
  /**
   * F4 key.
   */
  F4(4194335),
  /**
   * F5 key.
   */
  F5(4194336),
  /**
   * F6 key.
   */
  F6(4194337),
  /**
   * F7 key.
   */
  F7(4194338),
  /**
   * F8 key.
   */
  F8(4194339),
  /**
   * F9 key.
   */
  F9(4194340),
  /**
   * F10 key.
   */
  F10(4194341),
  /**
   * F11 key.
   */
  F11(4194342),
  /**
   * F12 key.
   */
  F12(4194343),
  /**
   * F13 key.
   */
  F13(4194344),
  /**
   * F14 key.
   */
  F14(4194345),
  /**
   * F15 key.
   */
  F15(4194346),
  /**
   * F16 key.
   */
  F16(4194347),
  /**
   * F17 key.
   */
  F17(4194348),
  /**
   * F18 key.
   */
  F18(4194349),
  /**
   * F19 key.
   */
  F19(4194350),
  /**
   * F20 key.
   */
  F20(4194351),
  /**
   * F21 key.
   */
  F21(4194352),
  /**
   * F22 key.
   */
  F22(4194353),
  /**
   * F23 key.
   */
  F23(4194354),
  /**
   * F24 key.
   */
  F24(4194355),
  /**
   * F25 key. Only supported on macOS and Linux due to a Windows limitation.
   */
  F25(4194356),
  /**
   * F26 key. Only supported on macOS and Linux due to a Windows limitation.
   */
  F26(4194357),
  /**
   * F27 key. Only supported on macOS and Linux due to a Windows limitation.
   */
  F27(4194358),
  /**
   * F28 key. Only supported on macOS and Linux due to a Windows limitation.
   */
  F28(4194359),
  /**
   * F29 key. Only supported on macOS and Linux due to a Windows limitation.
   */
  F29(4194360),
  /**
   * F30 key. Only supported on macOS and Linux due to a Windows limitation.
   */
  F30(4194361),
  /**
   * F31 key. Only supported on macOS and Linux due to a Windows limitation.
   */
  F31(4194362),
  /**
   * F32 key. Only supported on macOS and Linux due to a Windows limitation.
   */
  F32(4194363),
  /**
   * F33 key. Only supported on macOS and Linux due to a Windows limitation.
   */
  F33(4194364),
  /**
   * F34 key. Only supported on macOS and Linux due to a Windows limitation.
   */
  F34(4194365),
  /**
   * F35 key. Only supported on macOS and Linux due to a Windows limitation.
   */
  F35(4194366),
  /**
   * Multiply (*) key on the numeric keypad.
   */
  KP_MULTIPLY(4194433),
  /**
   * Divide (/) key on the numeric keypad.
   */
  KP_DIVIDE(4194434),
  /**
   * Subtract (-) key on the numeric keypad.
   */
  KP_SUBTRACT(4194435),
  /**
   * Period (.) key on the numeric keypad.
   */
  KP_PERIOD(4194436),
  /**
   * Add (+) key on the numeric keypad.
   */
  KP_ADD(4194437),
  /**
   * Number 0 on the numeric keypad.
   */
  KP_0(4194438),
  /**
   * Number 1 on the numeric keypad.
   */
  KP_1(4194439),
  /**
   * Number 2 on the numeric keypad.
   */
  KP_2(4194440),
  /**
   * Number 3 on the numeric keypad.
   */
  KP_3(4194441),
  /**
   * Number 4 on the numeric keypad.
   */
  KP_4(4194442),
  /**
   * Number 5 on the numeric keypad.
   */
  KP_5(4194443),
  /**
   * Number 6 on the numeric keypad.
   */
  KP_6(4194444),
  /**
   * Number 7 on the numeric keypad.
   */
  KP_7(4194445),
  /**
   * Number 8 on the numeric keypad.
   */
  KP_8(4194446),
  /**
   * Number 9 on the numeric keypad.
   */
  KP_9(4194447),
  /**
   * Context menu key.
   */
  MENU(4194370),
  /**
   * Hyper key. (On Linux/X11 only).
   */
  HYPER(4194371),
  /**
   * Help key.
   */
  HELP(4194373),
  /**
   * Back key.
   */
  BACK(4194376),
  /**
   * Forward key.
   */
  FORWARD(4194377),
  /**
   * Media stop key.
   */
  STOP(4194378),
  /**
   * Refresh key.
   */
  REFRESH(4194379),
  /**
   * Volume down key.
   */
  VOLUMEDOWN(4194380),
  /**
   * Mute volume key.
   */
  VOLUMEMUTE(4194381),
  /**
   * Volume up key.
   */
  VOLUMEUP(4194382),
  /**
   * Media play key.
   */
  MEDIAPLAY(4194388),
  /**
   * Media stop key.
   */
  MEDIASTOP(4194389),
  /**
   * Previous song key.
   */
  MEDIAPREVIOUS(4194390),
  /**
   * Next song key.
   */
  MEDIANEXT(4194391),
  /**
   * Media record key.
   */
  MEDIARECORD(4194392),
  /**
   * Home page key.
   */
  HOMEPAGE(4194393),
  /**
   * Favorites key.
   */
  FAVORITES(4194394),
  /**
   * Search key.
   */
  SEARCH(4194395),
  /**
   * Standby key.
   */
  STANDBY(4194396),
  /**
   * Open URL / Launch Browser key.
   */
  OPENURL(4194397),
  /**
   * Launch Mail key.
   */
  LAUNCHMAIL(4194398),
  /**
   * Launch Media key.
   */
  LAUNCHMEDIA(4194399),
  /**
   * Launch Shortcut 0 key.
   */
  LAUNCH0(4194400),
  /**
   * Launch Shortcut 1 key.
   */
  LAUNCH1(4194401),
  /**
   * Launch Shortcut 2 key.
   */
  LAUNCH2(4194402),
  /**
   * Launch Shortcut 3 key.
   */
  LAUNCH3(4194403),
  /**
   * Launch Shortcut 4 key.
   */
  LAUNCH4(4194404),
  /**
   * Launch Shortcut 5 key.
   */
  LAUNCH5(4194405),
  /**
   * Launch Shortcut 6 key.
   */
  LAUNCH6(4194406),
  /**
   * Launch Shortcut 7 key.
   */
  LAUNCH7(4194407),
  /**
   * Launch Shortcut 8 key.
   */
  LAUNCH8(4194408),
  /**
   * Launch Shortcut 9 key.
   */
  LAUNCH9(4194409),
  /**
   * Launch Shortcut A key.
   */
  LAUNCHA(4194410),
  /**
   * Launch Shortcut B key.
   */
  LAUNCHB(4194411),
  /**
   * Launch Shortcut C key.
   */
  LAUNCHC(4194412),
  /**
   * Launch Shortcut D key.
   */
  LAUNCHD(4194413),
  /**
   * Launch Shortcut E key.
   */
  LAUNCHE(4194414),
  /**
   * Launch Shortcut F key.
   */
  LAUNCHF(4194415),
  /**
   * "Globe" key on Mac / iPad keyboard.
   */
  GLOBE(4194416),
  /**
   * "On-screen keyboard" key on iPad keyboard.
   */
  KEYBOARD(4194417),
  /**
   * 英数 key on Mac keyboard.
   */
  JIS_EISU(4194418),
  /**
   * かな key on Mac keyboard.
   */
  JIS_KANA(4194419),
  /**
   * Unknown key.
   */
  UNKNOWN(8388607),
  /**
   * Space key.
   */
  SPACE(32),
  /**
   * Exclamation mark (`!`) key.
   */
  EXCLAM(33),
  /**
   * Double quotation mark (`"`) key.
   */
  QUOTEDBL(34),
  /**
   * Number sign or *hash* (`#`) key.
   */
  NUMBERSIGN(35),
  /**
   * Dollar sign (`$`) key.
   */
  DOLLAR(36),
  /**
   * Percent sign (`&#37;`) key.
   */
  PERCENT(37),
  /**
   * Ampersand (`&`) key.
   */
  AMPERSAND(38),
  /**
   * Apostrophe (`'`) key.
   */
  APOSTROPHE(39),
  /**
   * Left parenthesis (`(`) key.
   */
  PARENLEFT(40),
  /**
   * Right parenthesis (`)`) key.
   */
  PARENRIGHT(41),
  /**
   * Asterisk (`*`) key.
   */
  ASTERISK(42),
  /**
   * Plus (`+`) key.
   */
  PLUS(43),
  /**
   * Comma (`,`) key.
   */
  COMMA(44),
  /**
   * Minus (`-`) key.
   */
  MINUS(45),
  /**
   * Period (`.`) key.
   */
  PERIOD(46),
  /**
   * Slash (`/`) key.
   */
  SLASH(47),
  /**
   * Number 0 key.
   */
  KEY_0(48),
  /**
   * Number 1 key.
   */
  KEY_1(49),
  /**
   * Number 2 key.
   */
  KEY_2(50),
  /**
   * Number 3 key.
   */
  KEY_3(51),
  /**
   * Number 4 key.
   */
  KEY_4(52),
  /**
   * Number 5 key.
   */
  KEY_5(53),
  /**
   * Number 6 key.
   */
  KEY_6(54),
  /**
   * Number 7 key.
   */
  KEY_7(55),
  /**
   * Number 8 key.
   */
  KEY_8(56),
  /**
   * Number 9 key.
   */
  KEY_9(57),
  /**
   * Colon (`:`) key.
   */
  COLON(58),
  /**
   * Semicolon (`;`) key.
   */
  SEMICOLON(59),
  /**
   * Less-than sign (`<`) key.
   */
  LESS(60),
  /**
   * Equal sign (`=`) key.
   */
  EQUAL(61),
  /**
   * Greater-than sign (`>`) key.
   */
  GREATER(62),
  /**
   * Question mark (`?`) key.
   */
  QUESTION(63),
  /**
   * At sign (`@`) key.
   */
  AT(64),
  /**
   * A key.
   */
  A(65),
  /**
   * B key.
   */
  B(66),
  /**
   * C key.
   */
  C(67),
  /**
   * D key.
   */
  D(68),
  /**
   * E key.
   */
  E(69),
  /**
   * F key.
   */
  F(70),
  /**
   * G key.
   */
  G(71),
  /**
   * H key.
   */
  H(72),
  /**
   * I key.
   */
  I(73),
  /**
   * J key.
   */
  J(74),
  /**
   * K key.
   */
  K(75),
  /**
   * L key.
   */
  L(76),
  /**
   * M key.
   */
  M(77),
  /**
   * N key.
   */
  N(78),
  /**
   * O key.
   */
  O(79),
  /**
   * P key.
   */
  P(80),
  /**
   * Q key.
   */
  Q(81),
  /**
   * R key.
   */
  R(82),
  /**
   * S key.
   */
  S(83),
  /**
   * T key.
   */
  T(84),
  /**
   * U key.
   */
  U(85),
  /**
   * V key.
   */
  V(86),
  /**
   * W key.
   */
  W(87),
  /**
   * X key.
   */
  X(88),
  /**
   * Y key.
   */
  Y(89),
  /**
   * Z key.
   */
  Z(90),
  /**
   * Left bracket (`[lb]`) key.
   */
  BRACKETLEFT(91),
  /**
   * Backslash (`\`) key.
   */
  BACKSLASH(92),
  /**
   * Right bracket (`[rb]`) key.
   */
  BRACKETRIGHT(93),
  /**
   * Caret (`^`) key.
   */
  ASCIICIRCUM(94),
  /**
   * Underscore (`_`) key.
   */
  UNDERSCORE(95),
  /**
   * Backtick (```) key.
   */
  QUOTELEFT(96),
  /**
   * Left brace (`{`) key.
   */
  BRACELEFT(123),
  /**
   * Vertical bar or *pipe* (`|`) key.
   */
  BAR(124),
  /**
   * Right brace (`}`) key.
   */
  BRACERIGHT(125),
  /**
   * Tilde (`~`) key.
   */
  ASCIITILDE(126),
  /**
   * Yen symbol (`¥`) key.
   */
  YEN(165),
  /**
   * Section sign (`§`) key.
   */
  SECTION(167),
  ;

  public companion object {
    public fun from(`value`: Long): Key = entries.first { it.`value` == `value` }
  }
}
