// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.Callable
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.PackedStringArray
import godot.core.Signal1
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.CALLABLE
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * [FileDialog] is a preset dialog used to choose files and directories in the filesystem. It
 * supports filter masks. [FileDialog] automatically sets its window title according to the [fileMode].
 * If you want to use a custom title, disable this by setting [modeOverridesTitle] to `false`.
 *
 * **Note:** [FileDialog] is invisible by default. To make it visible, call one of the `popup_*`
 * methods from [Window] on the node, such as [Window.popupCenteredClamped].
 */
@GodotBaseType
public open class FileDialog : ConfirmationDialog() {
  /**
   * Emitted when the user selects a file by double-clicking it or pressing the **OK** button.
   */
  public val fileSelected: Signal1<String> by Signal1

  /**
   * Emitted when the user selects multiple files.
   */
  public val filesSelected: Signal1<PackedStringArray> by Signal1

  /**
   * Emitted when the user selects a directory.
   */
  public val dirSelected: Signal1<String> by Signal1

  /**
   * Emitted when the filter for file names changes.
   */
  public val filenameFilterChanged: Signal1<String> by Signal1

  /**
   * If `true`, changing the [fileMode] property will set the window title accordingly (e.g. setting
   * [fileMode] to [FILE_MODE_OPEN_FILE] will change the window title to "Open a File").
   */
  public final inline var modeOverridesTitle: Boolean
    @JvmName("modeOverridesTitleProperty")
    get() = isModeOverridingTitle()
    @JvmName("modeOverridesTitleProperty")
    set(`value`) {
      setModeOverridesTitle(value)
    }

  /**
   * The dialog's open or save mode, which affects the selection behavior.
   */
  public final inline var fileMode: FileMode
    @JvmName("fileModeProperty")
    get() = getFileMode()
    @JvmName("fileModeProperty")
    set(`value`) {
      setFileMode(value)
    }

  /**
   * Display mode of the dialog's file list.
   */
  public final inline var displayMode: DisplayMode
    @JvmName("displayModeProperty")
    get() = getDisplayMode()
    @JvmName("displayModeProperty")
    set(`value`) {
      setDisplayMode(value)
    }

  /**
   * The file system access scope.
   *
   * **Warning:** In Web builds, FileDialog cannot access the host file system. In sandboxed Linux
   * and macOS environments, [useNativeDialog] is automatically used to allow limited access to host
   * file system.
   */
  public final inline var access: Access
    @JvmName("accessProperty")
    get() = getAccess()
    @JvmName("accessProperty")
    set(`value`) {
      setAccess(value)
    }

  /**
   * If non-empty, the given sub-folder will be "root" of this [FileDialog], i.e. user won't be able
   * to go to its parent directory.
   *
   * **Note:** This property is ignored by native file dialogs.
   */
  public final inline var rootSubfolder: String
    @JvmName("rootSubfolderProperty")
    get() = getRootSubfolder()
    @JvmName("rootSubfolderProperty")
    set(`value`) {
      setRootSubfolder(value)
    }

  /**
   * The available file type filters. Each filter string in the array should be formatted like this:
   * `*.png,*.jpg,*.jpeg;Image Files;image/png,image/jpeg`. The description text of the filter is
   * optional and can be omitted. Both file extensions and MIME type should be always set.
   *
   * **Note:** Embedded file dialogs and Windows file dialogs support only file extensions, while
   * Android, Linux, and macOS file dialogs also support MIME types.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var filters: PackedStringArray
    @JvmName("filtersProperty")
    get() = getFilters()
    @JvmName("filtersProperty")
    set(`value`) {
      setFilters(value)
    }

  /**
   * The filter for file names (case-insensitive). When set to a non-empty string, only files that
   * contains the substring will be shown. [filenameFilter] can be edited by the user with the filter
   * button at the top of the file dialog.
   *
   * See also [filters], which should be used to restrict the file types that can be selected
   * instead of [filenameFilter] which is meant to be set by the user.
   */
  public final inline var filenameFilter: String
    @JvmName("filenameFilterProperty")
    get() = getFilenameFilter()
    @JvmName("filenameFilterProperty")
    set(`value`) {
      setFilenameFilter(value)
    }

  /**
   * If `true`, the dialog will show hidden files.
   *
   * **Note:** This property is ignored by native file dialogs on Android and Linux.
   */
  public final inline var showHiddenFiles: Boolean
    @JvmName("showHiddenFilesProperty")
    get() = isShowingHiddenFiles()
    @JvmName("showHiddenFilesProperty")
    set(`value`) {
      setShowHiddenFiles(value)
    }

  /**
   * If `true`, and if supported by the current [DisplayServer], OS native dialog will be used
   * instead of custom one.
   *
   * **Note:** On Android, it is only supported when using [ACCESS_FILESYSTEM]. For access mode
   * [ACCESS_RESOURCES] and [ACCESS_USERDATA], the system will fall back to custom FileDialog.
   *
   * **Note:** On Linux and macOS, sandboxed apps always use native dialogs to access the host file
   * system.
   *
   * **Note:** On macOS, sandboxed apps will save security-scoped bookmarks to retain access to the
   * opened folders across multiple sessions. Use [OS.getGrantedPermissions] to get a list of saved
   * bookmarks.
   *
   * **Note:** Native dialogs are isolated from the base process, file dialog properties can't be
   * modified once the dialog is shown.
   *
   * **Note:** This property is ignored in [EditorFileDialog].
   */
  public final inline var useNativeDialog: Boolean
    @JvmName("useNativeDialogProperty")
    get() = getUseNativeDialog()
    @JvmName("useNativeDialogProperty")
    set(`value`) {
      setUseNativeDialog(value)
    }

  /**
   * The number of additional [OptionButton]s and [CheckBox]es in the dialog.
   */
  public final inline var optionCount: Int
    @JvmName("optionCountProperty")
    get() = getOptionCount()
    @JvmName("optionCountProperty")
    set(`value`) {
      setOptionCount(value)
    }

  /**
   * If `true`, shows the toggle hidden files button.
   */
  public final inline var hiddenFilesToggleEnabled: Boolean
    @JvmName("hiddenFilesToggleEnabledProperty")
    get() = isCustomizationFlagEnabled(FileDialog.Customization.HIDDEN_FILES)
    @JvmName("hiddenFilesToggleEnabledProperty")
    set(`value`) {
      setCustomizationFlagEnabled(FileDialog.Customization.HIDDEN_FILES, value)
    }

  /**
   * If `true`, shows the toggle file filter button.
   */
  public final inline var fileFilterToggleEnabled: Boolean
    @JvmName("fileFilterToggleEnabledProperty")
    get() = isCustomizationFlagEnabled(FileDialog.Customization.FILE_FILTER)
    @JvmName("fileFilterToggleEnabledProperty")
    set(`value`) {
      setCustomizationFlagEnabled(FileDialog.Customization.FILE_FILTER, value)
    }

  /**
   * If `true`, shows the file sorting options button.
   */
  public final inline var fileSortOptionsEnabled: Boolean
    @JvmName("fileSortOptionsEnabledProperty")
    get() = isCustomizationFlagEnabled(FileDialog.Customization.FILE_SORT)
    @JvmName("fileSortOptionsEnabledProperty")
    set(`value`) {
      setCustomizationFlagEnabled(FileDialog.Customization.FILE_SORT, value)
    }

  /**
   * If `true`, shows the button for creating new directories (when using [FILE_MODE_OPEN_DIR],
   * [FILE_MODE_OPEN_ANY], or [FILE_MODE_SAVE_FILE]), and the context menu will have the "New
   * Folder..." option.
   */
  public final inline var folderCreationEnabled: Boolean
    @JvmName("folderCreationEnabledProperty")
    get() = isCustomizationFlagEnabled(FileDialog.Customization.CREATE_FOLDER)
    @JvmName("folderCreationEnabledProperty")
    set(`value`) {
      setCustomizationFlagEnabled(FileDialog.Customization.CREATE_FOLDER, value)
    }

  /**
   * If `true`, shows the toggle favorite button and favorite list on the left side of the dialog.
   */
  public final inline var favoritesEnabled: Boolean
    @JvmName("favoritesEnabledProperty")
    get() = isCustomizationFlagEnabled(FileDialog.Customization.FAVORITES)
    @JvmName("favoritesEnabledProperty")
    set(`value`) {
      setCustomizationFlagEnabled(FileDialog.Customization.FAVORITES, value)
    }

  /**
   * If `true`, shows the recent directories list on the left side of the dialog.
   */
  public final inline var recentListEnabled: Boolean
    @JvmName("recentListEnabledProperty")
    get() = isCustomizationFlagEnabled(FileDialog.Customization.RECENT)
    @JvmName("recentListEnabledProperty")
    set(`value`) {
      setCustomizationFlagEnabled(FileDialog.Customization.RECENT, value)
    }

  /**
   * If `true`, shows the layout switch buttons (list/thumbnails).
   */
  public final inline var layoutToggleEnabled: Boolean
    @JvmName("layoutToggleEnabledProperty")
    get() = isCustomizationFlagEnabled(FileDialog.Customization.LAYOUT)
    @JvmName("layoutToggleEnabledProperty")
    set(`value`) {
      setCustomizationFlagEnabled(FileDialog.Customization.LAYOUT, value)
    }

  /**
   * If `true`, the [FileDialog] will warn the user before overwriting files in save mode.
   */
  public final inline var overwriteWarningEnabled: Boolean
    @JvmName("overwriteWarningEnabledProperty")
    get() = isCustomizationFlagEnabled(FileDialog.Customization.OVERWRITE_WARNING)
    @JvmName("overwriteWarningEnabledProperty")
    set(`value`) {
      setCustomizationFlagEnabled(FileDialog.Customization.OVERWRITE_WARNING, value)
    }

  /**
   * If `true`, the context menu will show the "Delete" option, which allows moving files and
   * folders to trash.
   */
  public final inline var deletingEnabled: Boolean
    @JvmName("deletingEnabledProperty")
    get() = isCustomizationFlagEnabled(FileDialog.Customization.DELETE)
    @JvmName("deletingEnabledProperty")
    set(`value`) {
      setCustomizationFlagEnabled(FileDialog.Customization.DELETE, value)
    }

  /**
   * The current working directory of the file dialog.
   *
   * **Note:** For native file dialogs, this property is only treated as a hint and may not be
   * respected by specific OS implementations.
   */
  public final inline var currentDir: String
    @JvmName("currentDirProperty")
    get() = getCurrentDir()
    @JvmName("currentDirProperty")
    set(`value`) {
      setCurrentDir(value)
    }

  /**
   * The currently selected file of the file dialog.
   */
  public final inline var currentFile: String
    @JvmName("currentFileProperty")
    get() = getCurrentFile()
    @JvmName("currentFileProperty")
    set(`value`) {
      setCurrentFile(value)
    }

  /**
   * The currently selected file path of the file dialog.
   */
  public final inline var currentPath: String
    @JvmName("currentPathProperty")
    get() = getCurrentPath()
    @JvmName("currentPathProperty")
    set(`value`) {
      setCurrentPath(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(227, scriptPtr)
  }

  /**
   * This is a helper function for [filters] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = filedialog.filters
   * //Your changes
   * filedialog.filters = myCoreType
   * ``````
   *
   * The available file type filters. Each filter string in the array should be formatted like this:
   * `*.png,*.jpg,*.jpeg;Image Files;image/png,image/jpeg`. The description text of the filter is
   * optional and can be omitted. Both file extensions and MIME type should be always set.
   *
   * **Note:** Embedded file dialogs and Windows file dialogs support only file extensions, while
   * Android, Linux, and macOS file dialogs also support MIME types.
   */
  @CoreTypeHelper
  public final fun filtersMutate(block: PackedStringArray.() -> Unit): PackedStringArray =
      filters.apply {
     block(this)
     filters = this
  }

  /**
   * This is a helper function for [filters] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The available file type filters. Each filter string in the array should be formatted like this:
   * `*.png,*.jpg,*.jpeg;Image Files;image/png,image/jpeg`. The description text of the filter is
   * optional and can be omitted. Both file extensions and MIME type should be always set.
   *
   * **Note:** Embedded file dialogs and Windows file dialogs support only file extensions, while
   * Android, Linux, and macOS file dialogs also support MIME types.
   */
  @CoreTypeHelper
  public final fun filtersMutateEach(block: (index: Int, `value`: String) -> Unit):
      PackedStringArray = filters.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     filters = this
  }

  /**
   * Clear all the added filters in the dialog.
   */
  public final fun clearFilters(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearFiltersPtr)
  }

  /**
   * Adds a comma-separated file extension [filter] and comma-separated MIME type [mimeType] option
   * to the [FileDialog] with an optional [description], which restricts what files can be picked.
   *
   * A [filter] should be of the form `"filename.extension"`, where filename and extension can be
   * `*` to match any string. Filters starting with `.` (i.e. empty filenames) are not allowed.
   *
   * For example, a [filter] of `"*.png, *.jpg"`, a [mimeType] of `image/png, image/jpeg`, and a
   * [description] of `"Images"` results in filter text "Images (*.png, *.jpg)".
   *
   * **Note:** Embedded file dialogs and Windows file dialogs support only file extensions, while
   * Android, Linux, and macOS file dialogs also support MIME types.
   */
  @JvmOverloads
  public final fun addFilter(
    filter: String,
    description: String = "",
    mimeType: String = "",
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to filter, STRING to description, STRING to mimeType)
    TransferContext.callMethod(MethodBindings.addFilterPtr)
  }

  public final fun setFilters(filters: PackedStringArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_STRING_ARRAY to filters)
    TransferContext.callMethod(MethodBindings.setFiltersPtr)
  }

  public final fun getFilters(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFiltersPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Clear the filter for file names.
   */
  public final fun clearFilenameFilter(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearFilenameFilterPtr)
  }

  public final fun setFilenameFilter(filter: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to filter)
    TransferContext.callMethod(MethodBindings.setFilenameFilterPtr)
  }

  public final fun getFilenameFilter(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFilenameFilterPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the name of the [OptionButton] or [CheckBox] with index [option].
   */
  public final fun getOptionName(option: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to option.toLong())
    TransferContext.callMethod(MethodBindings.getOptionNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns an array of values of the [OptionButton] with index [option].
   */
  public final fun getOptionValues(option: Int): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to option.toLong())
    TransferContext.callMethod(MethodBindings.getOptionValuesPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Returns the default value index of the [OptionButton] or [CheckBox] with index [option].
   */
  public final fun getOptionDefault(option: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to option.toLong())
    TransferContext.callMethod(MethodBindings.getOptionDefaultPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the name of the [OptionButton] or [CheckBox] with index [option].
   */
  public final fun setOptionName(option: Int, name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to option.toLong(), STRING to name)
    TransferContext.callMethod(MethodBindings.setOptionNamePtr)
  }

  /**
   * Sets the option values of the [OptionButton] with index [option].
   */
  public final fun setOptionValues(option: Int, values: PackedStringArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to option.toLong(), PACKED_STRING_ARRAY to values)
    TransferContext.callMethod(MethodBindings.setOptionValuesPtr)
  }

  /**
   * Sets the default value index of the [OptionButton] or [CheckBox] with index [option].
   */
  public final fun setOptionDefault(option: Int, defaultValueIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to option.toLong(), LONG to defaultValueIndex.toLong())
    TransferContext.callMethod(MethodBindings.setOptionDefaultPtr)
  }

  public final fun setOptionCount(count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.setOptionCountPtr)
  }

  public final fun getOptionCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOptionCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds an additional [OptionButton] to the file dialog. If [values] is empty, a [CheckBox] is
   * added instead.
   *
   * [defaultValueIndex] should be an index of the value in the [values]. If [values] is empty it
   * should be either `1` (checked), or `0` (unchecked).
   */
  public final fun addOption(
    name: String,
    values: PackedStringArray,
    defaultValueIndex: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name, PACKED_STRING_ARRAY to values, LONG to defaultValueIndex.toLong())
    TransferContext.callMethod(MethodBindings.addOptionPtr)
  }

  /**
   * Returns a [Dictionary] with the selected values of the additional [OptionButton]s and/or
   * [CheckBox]es. [Dictionary] keys are names and values are selected value indices.
   */
  public final fun getSelectedOptions(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSelectedOptionsPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  public final fun getCurrentDir(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentDirPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun getCurrentFile(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentFilePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun getCurrentPath(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentPathPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setCurrentDir(dir: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to dir)
    TransferContext.callMethod(MethodBindings.setCurrentDirPtr)
  }

  public final fun setCurrentFile(`file`: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to file)
    TransferContext.callMethod(MethodBindings.setCurrentFilePtr)
  }

  public final fun setCurrentPath(path: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.setCurrentPathPtr)
  }

  public final fun setModeOverridesTitle(`override`: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to override)
    TransferContext.callMethod(MethodBindings.setModeOverridesTitlePtr)
  }

  public final fun isModeOverridingTitle(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isModeOverridingTitlePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFileMode(mode: FileMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setFileModePtr)
  }

  public final fun getFileMode(): FileMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFileModePtr)
    return FileMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setDisplayMode(mode: DisplayMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setDisplayModePtr)
  }

  public final fun getDisplayMode(): DisplayMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDisplayModePtr)
    return DisplayMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the vertical box container of the dialog, custom controls can be added to it.
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to hide it or any of its children, use their [CanvasItem.visible] property.
   *
   * **Note:** Changes to this node are ignored by native file dialogs, use [addOption] to add
   * custom elements to the dialog instead.
   */
  public final fun getVbox(): VBoxContainer? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVboxPtr)
    return (TransferContext.readReturnValue(OBJECT) as VBoxContainer?)
  }

  /**
   * Returns the LineEdit for the selected file.
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to hide it or any of its children, use their [CanvasItem.visible] property.
   */
  public final fun getLineEdit(): LineEdit? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineEditPtr)
    return (TransferContext.readReturnValue(OBJECT) as LineEdit?)
  }

  public final fun setAccess(access: Access): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to access.value)
    TransferContext.callMethod(MethodBindings.setAccessPtr)
  }

  public final fun getAccess(): Access {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAccessPtr)
    return Access.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setRootSubfolder(dir: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to dir)
    TransferContext.callMethod(MethodBindings.setRootSubfolderPtr)
  }

  public final fun getRootSubfolder(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRootSubfolderPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setShowHiddenFiles(show: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to show)
    TransferContext.callMethod(MethodBindings.setShowHiddenFilesPtr)
  }

  public final fun isShowingHiddenFiles(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShowingHiddenFilesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setUseNativeDialog(native: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to native)
    TransferContext.callMethod(MethodBindings.setUseNativeDialogPtr)
  }

  public final fun getUseNativeDialog(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseNativeDialogPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the specified customization [flag], allowing to customize the features available in this
   * [FileDialog].
   */
  public final fun setCustomizationFlagEnabled(flag: Customization, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flag.value, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setCustomizationFlagEnabledPtr)
  }

  /**
   * Returns `true` if the provided [flag] is enabled.
   */
  public final fun isCustomizationFlagEnabled(flag: Customization): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flag.value)
    TransferContext.callMethod(MethodBindings.isCustomizationFlagEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Clear all currently selected items in the dialog.
   */
  public final fun deselectAll(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.deselectAllPtr)
  }

  /**
   * Shows the [FileDialog] using the default size and position for file dialogs, and selects the
   * file name if there is a current file.
   */
  public final fun popupFileDialog(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.popupFileDialogPtr)
  }

  /**
   * Invalidates and updates this dialog's content list.
   *
   * **Note:** This method does nothing on native file dialogs.
   */
  public final fun invalidate(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.invalidatePtr)
  }

  public enum class FileMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The dialog allows selecting one, and only one file.
     */
    OPEN_FILE(0),
    /**
     * The dialog allows selecting multiple files.
     */
    OPEN_FILES(1),
    /**
     * The dialog only allows selecting a directory, disallowing the selection of any file.
     */
    OPEN_DIR(2),
    /**
     * The dialog allows selecting one file or directory.
     */
    OPEN_ANY(3),
    /**
     * The dialog will warn when a file exists.
     */
    SAVE_FILE(4),
    ;

    public companion object {
      public fun from(`value`: Long): FileMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class Access(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The dialog only allows accessing files under the [Resource] path (`res://`).
     */
    RESOURCES(0),
    /**
     * The dialog only allows accessing files under user data path (`user://`).
     */
    USERDATA(1),
    /**
     * The dialog allows accessing files on the whole file system.
     */
    FILESYSTEM(2),
    ;

    public companion object {
      public fun from(`value`: Long): Access = entries.single { it.`value` == `value` }
    }
  }

  public enum class DisplayMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The dialog displays files as a grid of thumbnails. Use [theme_item thumbnail_size] to adjust
     * their size.
     */
    THUMBNAILS(0),
    /**
     * The dialog displays files as a list of filenames.
     */
    LIST(1),
    ;

    public companion object {
      public fun from(`value`: Long): DisplayMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class Customization(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Toggles visibility of the favorite button, and the favorite list on the left side of the
     * dialog.
     *
     * Equivalent to [hiddenFilesToggleEnabled].
     */
    HIDDEN_FILES(0),
    /**
     * If enabled, shows the button for creating new directories (when using [FILE_MODE_OPEN_DIR],
     * [FILE_MODE_OPEN_ANY], or [FILE_MODE_SAVE_FILE]).
     *
     * Equivalent to [folderCreationEnabled].
     */
    CREATE_FOLDER(1),
    /**
     * If enabled, shows the toggle file filter button.
     *
     * Equivalent to [fileFilterToggleEnabled].
     */
    FILE_FILTER(2),
    /**
     * If enabled, shows the file sorting options button.
     *
     * Equivalent to [fileSortOptionsEnabled].
     */
    FILE_SORT(3),
    /**
     * If enabled, shows the toggle favorite button and favorite list on the left side of the
     * dialog.
     *
     * Equivalent to [favoritesEnabled].
     */
    FAVORITES(4),
    /**
     * If enabled, shows the recent directories list on the left side of the dialog.
     *
     * Equivalent to [recentListEnabled].
     */
    RECENT(5),
    /**
     * If enabled, shows the layout switch buttons (list/thumbnails).
     *
     * Equivalent to [layoutToggleEnabled].
     */
    LAYOUT(6),
    /**
     * If enabled, the [FileDialog] will warn the user before overwriting files in save mode.
     *
     * Equivalent to [overwriteWarningEnabled].
     */
    OVERWRITE_WARNING(7),
    /**
     * If enabled, the context menu will show the "Delete" option, which allows moving files and
     * folders to trash.
     *
     * Equivalent to [deletingEnabled].
     */
    DELETE(8),
    ;

    public companion object {
      public fun from(`value`: Long): Customization = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val clearFiltersName: MethodStringName0<FileDialog, Unit> =
        MethodStringName0<FileDialog, Unit>("clear_filters")

    @JvmField
    public val addFilterName: MethodStringName3<FileDialog, Unit, String, String, String> =
        MethodStringName3<FileDialog, Unit, String, String, String>("add_filter")

    @JvmField
    public val setFiltersName: MethodStringName1<FileDialog, Unit, PackedStringArray> =
        MethodStringName1<FileDialog, Unit, PackedStringArray>("set_filters")

    @JvmField
    public val getFiltersName: MethodStringName0<FileDialog, PackedStringArray> =
        MethodStringName0<FileDialog, PackedStringArray>("get_filters")

    @JvmField
    public val clearFilenameFilterName: MethodStringName0<FileDialog, Unit> =
        MethodStringName0<FileDialog, Unit>("clear_filename_filter")

    @JvmField
    public val setFilenameFilterName: MethodStringName1<FileDialog, Unit, String> =
        MethodStringName1<FileDialog, Unit, String>("set_filename_filter")

    @JvmField
    public val getFilenameFilterName: MethodStringName0<FileDialog, String> =
        MethodStringName0<FileDialog, String>("get_filename_filter")

    @JvmField
    public val getOptionNameName: MethodStringName1<FileDialog, String, Int> =
        MethodStringName1<FileDialog, String, Int>("get_option_name")

    @JvmField
    public val getOptionValuesName: MethodStringName1<FileDialog, PackedStringArray, Int> =
        MethodStringName1<FileDialog, PackedStringArray, Int>("get_option_values")

    @JvmField
    public val getOptionDefaultName: MethodStringName1<FileDialog, Int, Int> =
        MethodStringName1<FileDialog, Int, Int>("get_option_default")

    @JvmField
    public val setOptionNameName: MethodStringName2<FileDialog, Unit, Int, String> =
        MethodStringName2<FileDialog, Unit, Int, String>("set_option_name")

    @JvmField
    public val setOptionValuesName: MethodStringName2<FileDialog, Unit, Int, PackedStringArray> =
        MethodStringName2<FileDialog, Unit, Int, PackedStringArray>("set_option_values")

    @JvmField
    public val setOptionDefaultName: MethodStringName2<FileDialog, Unit, Int, Int> =
        MethodStringName2<FileDialog, Unit, Int, Int>("set_option_default")

    @JvmField
    public val setOptionCountName: MethodStringName1<FileDialog, Unit, Int> =
        MethodStringName1<FileDialog, Unit, Int>("set_option_count")

    @JvmField
    public val getOptionCountName: MethodStringName0<FileDialog, Int> =
        MethodStringName0<FileDialog, Int>("get_option_count")

    @JvmField
    public val addOptionName: MethodStringName3<FileDialog, Unit, String, PackedStringArray, Int> =
        MethodStringName3<FileDialog, Unit, String, PackedStringArray, Int>("add_option")

    @JvmField
    public val getSelectedOptionsName: MethodStringName0<FileDialog, Dictionary<Any?, Any?>> =
        MethodStringName0<FileDialog, Dictionary<Any?, Any?>>("get_selected_options")

    @JvmField
    public val getCurrentDirName: MethodStringName0<FileDialog, String> =
        MethodStringName0<FileDialog, String>("get_current_dir")

    @JvmField
    public val getCurrentFileName: MethodStringName0<FileDialog, String> =
        MethodStringName0<FileDialog, String>("get_current_file")

    @JvmField
    public val getCurrentPathName: MethodStringName0<FileDialog, String> =
        MethodStringName0<FileDialog, String>("get_current_path")

    @JvmField
    public val setCurrentDirName: MethodStringName1<FileDialog, Unit, String> =
        MethodStringName1<FileDialog, Unit, String>("set_current_dir")

    @JvmField
    public val setCurrentFileName: MethodStringName1<FileDialog, Unit, String> =
        MethodStringName1<FileDialog, Unit, String>("set_current_file")

    @JvmField
    public val setCurrentPathName: MethodStringName1<FileDialog, Unit, String> =
        MethodStringName1<FileDialog, Unit, String>("set_current_path")

    @JvmField
    public val setModeOverridesTitleName: MethodStringName1<FileDialog, Unit, Boolean> =
        MethodStringName1<FileDialog, Unit, Boolean>("set_mode_overrides_title")

    @JvmField
    public val isModeOverridingTitleName: MethodStringName0<FileDialog, Boolean> =
        MethodStringName0<FileDialog, Boolean>("is_mode_overriding_title")

    @JvmField
    public val setFileModeName: MethodStringName1<FileDialog, Unit, FileMode> =
        MethodStringName1<FileDialog, Unit, FileMode>("set_file_mode")

    @JvmField
    public val getFileModeName: MethodStringName0<FileDialog, FileMode> =
        MethodStringName0<FileDialog, FileMode>("get_file_mode")

    @JvmField
    public val setDisplayModeName: MethodStringName1<FileDialog, Unit, DisplayMode> =
        MethodStringName1<FileDialog, Unit, DisplayMode>("set_display_mode")

    @JvmField
    public val getDisplayModeName: MethodStringName0<FileDialog, DisplayMode> =
        MethodStringName0<FileDialog, DisplayMode>("get_display_mode")

    @JvmField
    public val getVboxName: MethodStringName0<FileDialog, VBoxContainer?> =
        MethodStringName0<FileDialog, VBoxContainer?>("get_vbox")

    @JvmField
    public val getLineEditName: MethodStringName0<FileDialog, LineEdit?> =
        MethodStringName0<FileDialog, LineEdit?>("get_line_edit")

    @JvmField
    public val setAccessName: MethodStringName1<FileDialog, Unit, Access> =
        MethodStringName1<FileDialog, Unit, Access>("set_access")

    @JvmField
    public val getAccessName: MethodStringName0<FileDialog, Access> =
        MethodStringName0<FileDialog, Access>("get_access")

    @JvmField
    public val setRootSubfolderName: MethodStringName1<FileDialog, Unit, String> =
        MethodStringName1<FileDialog, Unit, String>("set_root_subfolder")

    @JvmField
    public val getRootSubfolderName: MethodStringName0<FileDialog, String> =
        MethodStringName0<FileDialog, String>("get_root_subfolder")

    @JvmField
    public val setShowHiddenFilesName: MethodStringName1<FileDialog, Unit, Boolean> =
        MethodStringName1<FileDialog, Unit, Boolean>("set_show_hidden_files")

    @JvmField
    public val isShowingHiddenFilesName: MethodStringName0<FileDialog, Boolean> =
        MethodStringName0<FileDialog, Boolean>("is_showing_hidden_files")

    @JvmField
    public val setUseNativeDialogName: MethodStringName1<FileDialog, Unit, Boolean> =
        MethodStringName1<FileDialog, Unit, Boolean>("set_use_native_dialog")

    @JvmField
    public val getUseNativeDialogName: MethodStringName0<FileDialog, Boolean> =
        MethodStringName0<FileDialog, Boolean>("get_use_native_dialog")

    @JvmField
    public val setCustomizationFlagEnabledName:
        MethodStringName2<FileDialog, Unit, Customization, Boolean> =
        MethodStringName2<FileDialog, Unit, Customization, Boolean>("set_customization_flag_enabled")

    @JvmField
    public val isCustomizationFlagEnabledName: MethodStringName1<FileDialog, Boolean, Customization>
        = MethodStringName1<FileDialog, Boolean, Customization>("is_customization_flag_enabled")

    @JvmField
    public val deselectAllName: MethodStringName0<FileDialog, Unit> =
        MethodStringName0<FileDialog, Unit>("deselect_all")

    @JvmField
    public val setFavoriteListName: MethodStringName1<FileDialog, Unit, PackedStringArray> =
        MethodStringName1<FileDialog, Unit, PackedStringArray>("set_favorite_list")

    @JvmField
    public val getFavoriteListName: MethodStringName0<FileDialog, PackedStringArray> =
        MethodStringName0<FileDialog, PackedStringArray>("get_favorite_list")

    @JvmField
    public val setRecentListName: MethodStringName1<FileDialog, Unit, PackedStringArray> =
        MethodStringName1<FileDialog, Unit, PackedStringArray>("set_recent_list")

    @JvmField
    public val getRecentListName: MethodStringName0<FileDialog, PackedStringArray> =
        MethodStringName0<FileDialog, PackedStringArray>("get_recent_list")

    @JvmField
    public val setGetIconCallbackName: MethodStringName1<FileDialog, Unit, Callable> =
        MethodStringName1<FileDialog, Unit, Callable>("set_get_icon_callback")

    @JvmField
    public val setGetThumbnailCallbackName: MethodStringName1<FileDialog, Unit, Callable> =
        MethodStringName1<FileDialog, Unit, Callable>("set_get_thumbnail_callback")

    @JvmField
    public val popupFileDialogName: MethodStringName0<FileDialog, Unit> =
        MethodStringName0<FileDialog, Unit>("popup_file_dialog")

    @JvmField
    public val invalidateName: MethodStringName0<FileDialog, Unit> =
        MethodStringName0<FileDialog, Unit>("invalidate")

    /**
     * Sets the list of favorite directories, which is shared by all [FileDialog] nodes. Useful to
     * restore the list of favorites saved with [getFavoriteList]. This method can be called only from
     * the main thread.
     *
     * **Note:** [FileDialog] will update its internal [ItemList] of favorites when its visibility
     * changes. Be sure to call this method earlier if you want your changes to have effect.
     */
    @JvmStatic
    public final fun setFavoriteList(favorites: PackedStringArray): Unit {
      TransferContext.writeMethodArguments(0L, 0L, PACKED_STRING_ARRAY to favorites)
      TransferContext.callMethod(MethodBindings.setFavoriteListPtr)
    }

    /**
     * Returns the list of favorite directories, which is shared by all [FileDialog] nodes. Useful
     * to store the list of favorites between project sessions. This method can be called only from the
     * main thread.
     */
    @JvmStatic
    public final fun getFavoriteList(): PackedStringArray {
      TransferContext.writeMethodArguments(0L, 0L)
      TransferContext.callMethod(MethodBindings.getFavoriteListPtr)
      return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
    }

    /**
     * Sets the list of recent directories, which is shared by all [FileDialog] nodes. Useful to
     * restore the list of recents saved with [setRecentList]. This method can be called only from the
     * main thread.
     *
     * **Note:** [FileDialog] will update its internal [ItemList] of recent directories when its
     * visibility changes. Be sure to call this method earlier if you want your changes to have effect.
     */
    @JvmStatic
    public final fun setRecentList(recents: PackedStringArray): Unit {
      TransferContext.writeMethodArguments(0L, 0L, PACKED_STRING_ARRAY to recents)
      TransferContext.callMethod(MethodBindings.setRecentListPtr)
    }

    /**
     * Returns the list of recent directories, which is shared by all [FileDialog] nodes. Useful to
     * store the list of recents between project sessions. This method can be called only from the main
     * thread.
     */
    @JvmStatic
    public final fun getRecentList(): PackedStringArray {
      TransferContext.writeMethodArguments(0L, 0L)
      TransferContext.callMethod(MethodBindings.getRecentListPtr)
      return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
    }

    /**
     * Sets the callback used by the [FileDialog] nodes to get a file icon, when [DISPLAY_LIST] mode
     * is used. The callback should take a single [String] argument (file path), and return a
     * [Texture2D]. If an invalid texture is returned, the [theme_item file] icon will be used instead.
     */
    @JvmStatic
    public final fun setGetIconCallback(callback: Callable): Unit {
      TransferContext.writeMethodArguments(0L, 0L, CALLABLE to callback)
      TransferContext.callMethod(MethodBindings.setGetIconCallbackPtr)
    }

    /**
     * Sets the callback used by the [FileDialog] nodes to get a file icon, when
     * [DISPLAY_THUMBNAILS] mode is used. The callback should take a single [String] argument (file
     * path), and return a [Texture2D]. If an invalid texture is returned, the [theme_item
     * file_thumbnail] icon will be used instead.
     *
     * Thumbnails are usually more complex and may take a while to load. To avoid stalling the
     * application, you can use [ImageTexture] to asynchronously create the thumbnail.
     *
     * ```
     * func _ready():
     * 	FileDialog.set_get_thumbnail_callback(thumbnail_method)
     *
     * func thumbnail_method(path):
     * 	var image_texture = ImageTexture.new()
     * 	make_thumbnail_async(path, image_texture)
     * 	return image_texture
     *
     * func make_thumbnail_async(path, image_texture):
     * 	var thumbnail_texture = await generate_thumbnail(path) # Some method that generates a
     * thumbnail.
     * 	image_texture.set_image(thumbnail_texture.get_image())
     * ```
     */
    @JvmStatic
    public final fun setGetThumbnailCallback(callback: Callable): Unit {
      TransferContext.writeMethodArguments(0L, 0L, CALLABLE to callback)
      TransferContext.callMethod(MethodBindings.setGetThumbnailCallbackPtr)
    }
  }

  public object MethodBindings {
    internal val clearFiltersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "clear_filters", 3218959716)

    internal val addFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "add_filter", 914921954)

    internal val setFiltersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_filters", 4015028928)

    internal val getFiltersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_filters", 1139954409)

    internal val clearFilenameFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "clear_filename_filter", 3218959716)

    internal val setFilenameFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_filename_filter", 83702148)

    internal val getFilenameFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_filename_filter", 201670096)

    internal val getOptionNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_option_name", 844755477)

    internal val getOptionValuesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_option_values", 647634434)

    internal val getOptionDefaultPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_option_default", 923996154)

    internal val setOptionNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_option_name", 501894301)

    internal val setOptionValuesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_option_values", 3353661094)

    internal val setOptionDefaultPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_option_default", 3937882851)

    internal val setOptionCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_option_count", 1286410249)

    internal val getOptionCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_option_count", 3905245786)

    internal val addOptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "add_option", 149592325)

    internal val getSelectedOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_selected_options", 3102165223)

    internal val getCurrentDirPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_current_dir", 201670096)

    internal val getCurrentFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_current_file", 201670096)

    internal val getCurrentPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_current_path", 201670096)

    internal val setCurrentDirPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_current_dir", 83702148)

    internal val setCurrentFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_current_file", 83702148)

    internal val setCurrentPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_current_path", 83702148)

    internal val setModeOverridesTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_mode_overrides_title", 2586408642)

    internal val isModeOverridingTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "is_mode_overriding_title", 36873697)

    internal val setFileModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_file_mode", 3654936397)

    internal val getFileModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_file_mode", 4074825319)

    internal val setDisplayModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_display_mode", 2692197101)

    internal val getDisplayModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_display_mode", 1092104624)

    internal val getVboxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_vbox", 915758477)

    internal val getLineEditPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_line_edit", 4071694264)

    internal val setAccessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_access", 4104413466)

    internal val getAccessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_access", 3344081076)

    internal val setRootSubfolderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_root_subfolder", 83702148)

    internal val getRootSubfolderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_root_subfolder", 201670096)

    internal val setShowHiddenFilesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_show_hidden_files", 2586408642)

    internal val isShowingHiddenFilesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "is_showing_hidden_files", 36873697)

    internal val setUseNativeDialogPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_use_native_dialog", 2586408642)

    internal val getUseNativeDialogPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_use_native_dialog", 36873697)

    internal val setCustomizationFlagEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_customization_flag_enabled", 3849177100)

    internal val isCustomizationFlagEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "is_customization_flag_enabled", 3722277863)

    internal val deselectAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "deselect_all", 3218959716)

    internal val setFavoriteListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_favorite_list", 4015028928)

    internal val getFavoriteListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_favorite_list", 2981934095)

    internal val setRecentListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_recent_list", 4015028928)

    internal val getRecentListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "get_recent_list", 2981934095)

    internal val setGetIconCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_get_icon_callback", 1611583062)

    internal val setGetThumbnailCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "set_get_thumbnail_callback", 1611583062)

    internal val popupFileDialogPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "popup_file_dialog", 3218959716)

    internal val invalidatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileDialog", "invalidate", 3218959716)
  }
}
