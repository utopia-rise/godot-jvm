// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.PackedByteArray
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_PACKED_BYTE_ARRAY
import godot.writeMethodArguments_STRING
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Provides a low-level interface for creating parsers for
 * [url=https://en.wikipedia.org/wiki/XML]XML[/url] files. This class can serve as base to make custom
 * XML parsers.
 *
 * To parse XML, you must open a file with the [open] method or a buffer with the [openBuffer]
 * method. Then, the [read] method must be called to parse the next nodes. Most of the methods take
 * into consideration the currently parsed node.
 *
 * Here is an example of using [XMLParser] to parse an SVG file (which is based on XML), printing
 * each element and its attributes as a dictionary:
 *
 * ```gdscript
 * //gdscript
 * var parser = XMLParser.new()
 * parser.open("path/to/file.svg")
 * while parser.read() != ERR_FILE_EOF:
 * 	if parser.get_node_type() == XMLParser.NODE_ELEMENT:
 * 		var node_name = parser.get_node_name()
 * 		var attributes_dict = {}
 * 		for idx in range(parser.get_attribute_count()):
 * 			attributes_dict[parser.get_attribute_name(idx)] = parser.get_attribute_value(idx)
 * 		print("The ", node_name, " element has the following attributes: ", attributes_dict)
 * ```
 *
 * ```csharp
 * //csharp
 * var parser = new XmlParser();
 * parser.Open("path/to/file.svg");
 * while (parser.Read() != Error.FileEof)
 * {
 * 	if (parser.GetNodeType() == XmlParser.NodeType.Element)
 * 	{
 * 		var nodeName = parser.GetNodeName();
 * 		var attributesDict = new Godot.Collections.Dictionary();
 * 		for (int idx = 0; idx < parser.GetAttributeCount(); idx++)
 * 		{
 * 			attributesDict[parser.GetAttributeName(idx)] = parser.GetAttributeValue(idx);
 * 		}
 * 		GD.Print($"The {nodeName} element has the following attributes: {attributesDict}");
 * 	}
 * }
 * ```
 */
@GodotBaseType
public open class XMLParser : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(935, scriptPtr)
  }

  /**
   * Parses the next node in the file. This method returns an error code.
   */
  public final fun read(): Error {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.readPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the type of the current node. Compare with [NodeType] constants.
   */
  public final fun getNodeType(): NodeType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNodeTypePtr)
    return NodeType.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the name of a node. This method will raise an error if the currently parsed node is a
   * text node.
   *
   * **Note:** The content of a [NODE_CDATA] node and the comment string of a [NODE_COMMENT] node
   * are also considered names.
   */
  public final fun getNodeName(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNodeNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the contents of a text node. This method will raise an error if the current parsed node
   * is of any other type.
   */
  public final fun getNodeData(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNodeDataPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the byte offset of the currently parsed node since the beginning of the file or buffer.
   * This is usually equivalent to the number of characters before the read position.
   */
  public final fun getNodeOffset(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNodeOffsetPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Returns the number of attributes in the currently parsed element.
   *
   * **Note:** If this method is used while the currently parsed node is not [NODE_ELEMENT] or
   * [NODE_ELEMENT_END], this count will not be updated and will still reflect the last element.
   */
  public final fun getAttributeCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAttributeCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the name of an attribute of the currently parsed element, specified by the [idx] index.
   */
  public final fun getAttributeName(idx: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getAttributeNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the value of an attribute of the currently parsed element, specified by the [idx]
   * index.
   */
  public final fun getAttributeValue(idx: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getAttributeValuePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns `true` if the currently parsed element has an attribute with the [name].
   */
  public final fun hasAttribute(name: String): Boolean {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.hasAttributePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the value of an attribute of the currently parsed element, specified by its [name].
   * This method will raise an error if the element has no such attribute.
   */
  public final fun getNamedAttributeValue(name: String): String {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.getNamedAttributeValuePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the value of an attribute of the currently parsed element, specified by its [name].
   * This method will return an empty string if the element has no such attribute.
   */
  public final fun getNamedAttributeValueSafe(name: String): String {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.getNamedAttributeValueSafePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns `true` if the currently parsed element is empty, e.g. `<element />`.
   */
  public final fun isEmpty(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEmptyPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the current line in the parsed file, counting from 0.
   */
  public final fun getCurrentLine(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentLinePtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Skips the current section. If the currently parsed node contains more inner nodes, they will be
   * ignored and the cursor will go to the closing of the current element.
   */
  public final fun skipSection(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.skipSectionPtr)
  }

  /**
   * Moves the buffer cursor to a certain offset (since the beginning) and reads the next node
   * there. This method returns an error code.
   */
  public final fun seek(position: Long): Error {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, position)
    TransferContext.callMethod(MethodBindings.seekPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Opens an XML [file] for parsing. This method returns an error code.
   */
  public final fun `open`(`file`: String): Error {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, file)
    TransferContext.callMethod(MethodBindings.openPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Opens an XML raw [buffer] for parsing. This method returns an error code.
   */
  public final fun openBuffer(buffer: PackedByteArray): Error {
    TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY(ptr, objectID.id, buffer)
    TransferContext.callMethod(MethodBindings.openBufferPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  public enum class NodeType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * There's no node (no file or buffer opened).
     */
    NONE(0),
    /**
     * An element node type, also known as a tag, e.g. `<title>`.
     */
    ELEMENT(1),
    /**
     * An end of element node type, e.g. `</title>`.
     */
    ELEMENT_END(2),
    /**
     * A text node type, i.e. text that is not inside an element. This includes whitespace.
     */
    TEXT(3),
    /**
     * A comment node type, e.g. `<!--A comment-->`.
     */
    COMMENT(4),
    /**
     * A node type for CDATA (Character Data) sections, e.g. `<![CDATA[CDATA section]]>`.
     */
    CDATA(5),
    /**
     * An unknown node type.
     */
    UNKNOWN(6),
    ;

    public companion object {
      public fun from(`value`: Long): NodeType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val readName: MethodStringName0<XMLParser, Error> =
        MethodStringName0<XMLParser, Error>("read")

    @JvmField
    public val getNodeTypeName: MethodStringName0<XMLParser, NodeType> =
        MethodStringName0<XMLParser, NodeType>("get_node_type")

    @JvmField
    public val getNodeNameName: MethodStringName0<XMLParser, String> =
        MethodStringName0<XMLParser, String>("get_node_name")

    @JvmField
    public val getNodeDataName: MethodStringName0<XMLParser, String> =
        MethodStringName0<XMLParser, String>("get_node_data")

    @JvmField
    public val getNodeOffsetName: MethodStringName0<XMLParser, Long> =
        MethodStringName0<XMLParser, Long>("get_node_offset")

    @JvmField
    public val getAttributeCountName: MethodStringName0<XMLParser, Int> =
        MethodStringName0<XMLParser, Int>("get_attribute_count")

    @JvmField
    public val getAttributeNameName: MethodStringName1<XMLParser, String, Int> =
        MethodStringName1<XMLParser, String, Int>("get_attribute_name")

    @JvmField
    public val getAttributeValueName: MethodStringName1<XMLParser, String, Int> =
        MethodStringName1<XMLParser, String, Int>("get_attribute_value")

    @JvmField
    public val hasAttributeName: MethodStringName1<XMLParser, Boolean, String> =
        MethodStringName1<XMLParser, Boolean, String>("has_attribute")

    @JvmField
    public val getNamedAttributeValueName: MethodStringName1<XMLParser, String, String> =
        MethodStringName1<XMLParser, String, String>("get_named_attribute_value")

    @JvmField
    public val getNamedAttributeValueSafeName: MethodStringName1<XMLParser, String, String> =
        MethodStringName1<XMLParser, String, String>("get_named_attribute_value_safe")

    @JvmField
    public val isEmptyName: MethodStringName0<XMLParser, Boolean> =
        MethodStringName0<XMLParser, Boolean>("is_empty")

    @JvmField
    public val getCurrentLineName: MethodStringName0<XMLParser, Int> =
        MethodStringName0<XMLParser, Int>("get_current_line")

    @JvmField
    public val skipSectionName: MethodStringName0<XMLParser, Unit> =
        MethodStringName0<XMLParser, Unit>("skip_section")

    @JvmField
    public val seekName: MethodStringName1<XMLParser, Error, Long> =
        MethodStringName1<XMLParser, Error, Long>("seek")

    @JvmField
    public val openName: MethodStringName1<XMLParser, Error, String> =
        MethodStringName1<XMLParser, Error, String>("open")

    @JvmField
    public val openBufferName: MethodStringName1<XMLParser, Error, PackedByteArray> =
        MethodStringName1<XMLParser, Error, PackedByteArray>("open_buffer")
  }

  public object MethodBindings {
    internal val readPtr: VoidPtr = TypeManager.getMethodBindPtr("XMLParser", "read", 166280745)

    internal val getNodeTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XMLParser", "get_node_type", 2984359541)

    internal val getNodeNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XMLParser", "get_node_name", 201670096)

    internal val getNodeDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XMLParser", "get_node_data", 201670096)

    internal val getNodeOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XMLParser", "get_node_offset", 3905245786)

    internal val getAttributeCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XMLParser", "get_attribute_count", 3905245786)

    internal val getAttributeNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XMLParser", "get_attribute_name", 844755477)

    internal val getAttributeValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XMLParser", "get_attribute_value", 844755477)

    internal val hasAttributePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XMLParser", "has_attribute", 3927539163)

    internal val getNamedAttributeValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XMLParser", "get_named_attribute_value", 3135753539)

    internal val getNamedAttributeValueSafePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XMLParser", "get_named_attribute_value_safe", 3135753539)

    internal val isEmptyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XMLParser", "is_empty", 36873697)

    internal val getCurrentLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XMLParser", "get_current_line", 3905245786)

    internal val skipSectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XMLParser", "skip_section", 3218959716)

    internal val seekPtr: VoidPtr = TypeManager.getMethodBindPtr("XMLParser", "seek", 844576869)

    internal val openPtr: VoidPtr = TypeManager.getMethodBindPtr("XMLParser", "open", 166001499)

    internal val openBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XMLParser", "open_buffer", 680677267)
  }
}
