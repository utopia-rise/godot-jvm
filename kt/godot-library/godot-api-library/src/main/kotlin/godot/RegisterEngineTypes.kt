package godot

import godot.`internal`.reflection.TypeManager
import godot.api.AESContext
import godot.api.AStar2D
import godot.api.AStar3D
import godot.api.AStarGrid2D
import godot.api.AcceptDialog
import godot.api.AccessibilityServer
import godot.api.AimModifier3D
import godot.api.AnimatableBody2D
import godot.api.AnimatableBody3D
import godot.api.AnimatedSprite2D
import godot.api.AnimatedSprite3D
import godot.api.AnimatedTexture
import godot.api.Animation
import godot.api.AnimationLibrary
import godot.api.AnimationMixer
import godot.api.AnimationNode
import godot.api.AnimationNodeAdd2
import godot.api.AnimationNodeAdd3
import godot.api.AnimationNodeAnimation
import godot.api.AnimationNodeBlend2
import godot.api.AnimationNodeBlend3
import godot.api.AnimationNodeBlendSpace1D
import godot.api.AnimationNodeBlendSpace2D
import godot.api.AnimationNodeBlendTree
import godot.api.AnimationNodeExtension
import godot.api.AnimationNodeExtensionDummy
import godot.api.AnimationNodeOneShot
import godot.api.AnimationNodeOutput
import godot.api.AnimationNodeStateMachine
import godot.api.AnimationNodeStateMachinePlayback
import godot.api.AnimationNodeStateMachineTransition
import godot.api.AnimationNodeSub2
import godot.api.AnimationNodeSync
import godot.api.AnimationNodeTimeScale
import godot.api.AnimationNodeTimeSeek
import godot.api.AnimationNodeTransition
import godot.api.AnimationPlayer
import godot.api.AnimationRootNode
import godot.api.AnimationTree
import godot.api.Area2D
import godot.api.Area3D
import godot.api.AreaLight3D
import godot.api.ArrayMesh
import godot.api.ArrayOccluder3D
import godot.api.AspectRatioContainer
import godot.api.AtlasTexture
import godot.api.AudioBusLayout
import godot.api.AudioEffect
import godot.api.AudioEffectAmplify
import godot.api.AudioEffectBandLimitFilter
import godot.api.AudioEffectBandPassFilter
import godot.api.AudioEffectCapture
import godot.api.AudioEffectChorus
import godot.api.AudioEffectCompressor
import godot.api.AudioEffectDelay
import godot.api.AudioEffectDistortion
import godot.api.AudioEffectDummy
import godot.api.AudioEffectEQ
import godot.api.AudioEffectEQ10
import godot.api.AudioEffectEQ21
import godot.api.AudioEffectEQ6
import godot.api.AudioEffectFilter
import godot.api.AudioEffectHardLimiter
import godot.api.AudioEffectHighPassFilter
import godot.api.AudioEffectHighShelfFilter
import godot.api.AudioEffectInstance
import godot.api.AudioEffectInstanceDummy
import godot.api.AudioEffectLimiter
import godot.api.AudioEffectLowPassFilter
import godot.api.AudioEffectLowShelfFilter
import godot.api.AudioEffectNotchFilter
import godot.api.AudioEffectPanner
import godot.api.AudioEffectPhaser
import godot.api.AudioEffectPitchShift
import godot.api.AudioEffectRecord
import godot.api.AudioEffectReverb
import godot.api.AudioEffectSpectrumAnalyzer
import godot.api.AudioEffectSpectrumAnalyzerInstance
import godot.api.AudioEffectStereoEnhance
import godot.api.AudioListener2D
import godot.api.AudioListener3D
import godot.api.AudioSample
import godot.api.AudioSamplePlayback
import godot.api.AudioServer
import godot.api.AudioStream
import godot.api.AudioStreamDummy
import godot.api.AudioStreamGenerator
import godot.api.AudioStreamGeneratorPlayback
import godot.api.AudioStreamInteractive
import godot.api.AudioStreamMP3
import godot.api.AudioStreamMicrophone
import godot.api.AudioStreamOggVorbis
import godot.api.AudioStreamPlayback
import godot.api.AudioStreamPlaybackDummy
import godot.api.AudioStreamPlaybackInteractive
import godot.api.AudioStreamPlaybackOggVorbis
import godot.api.AudioStreamPlaybackPlaylist
import godot.api.AudioStreamPlaybackPolyphonic
import godot.api.AudioStreamPlaybackResampled
import godot.api.AudioStreamPlaybackResampledDummy
import godot.api.AudioStreamPlaybackSynchronized
import godot.api.AudioStreamPlayer
import godot.api.AudioStreamPlayer2D
import godot.api.AudioStreamPlayer3D
import godot.api.AudioStreamPlaylist
import godot.api.AudioStreamPolyphonic
import godot.api.AudioStreamRandomizer
import godot.api.AudioStreamSynchronized
import godot.api.AudioStreamWAV
import godot.api.AwaitTweener
import godot.api.BackBufferCopy
import godot.api.BaseButton
import godot.api.BaseMaterial3D
import godot.api.BitMap
import godot.api.BlitMaterial
import godot.api.Bone2D
import godot.api.BoneAttachment3D
import godot.api.BoneConstraint3D
import godot.api.BoneMap
import godot.api.BoneTwistDisperser3D
import godot.api.BoxContainer
import godot.api.BoxMesh
import godot.api.BoxOccluder3D
import godot.api.BoxShape3D
import godot.api.Button
import godot.api.ButtonGroup
import godot.api.CCDIK3D
import godot.api.CPUParticles2D
import godot.api.CPUParticles3D
import godot.api.CSGBox3D
import godot.api.CSGCombiner3D
import godot.api.CSGCylinder3D
import godot.api.CSGMesh3D
import godot.api.CSGPolygon3D
import godot.api.CSGPrimitive3D
import godot.api.CSGShape3D
import godot.api.CSGSphere3D
import godot.api.CSGTorus3D
import godot.api.CallbackTweener
import godot.api.Camera2D
import godot.api.Camera3D
import godot.api.CameraAttributes
import godot.api.CameraAttributesPhysical
import godot.api.CameraAttributesPractical
import godot.api.CameraFeed
import godot.api.CameraServer
import godot.api.CameraTexture
import godot.api.CanvasGroup
import godot.api.CanvasItem
import godot.api.CanvasItemMaterial
import godot.api.CanvasLayer
import godot.api.CanvasModulate
import godot.api.CanvasTexture
import godot.api.CapsuleMesh
import godot.api.CapsuleShape2D
import godot.api.CapsuleShape3D
import godot.api.CenterContainer
import godot.api.ChainIK3D
import godot.api.CharFXTransform
import godot.api.CharacterBody2D
import godot.api.CharacterBody3D
import godot.api.CheckBox
import godot.api.CheckButton
import godot.api.CircleShape2D
import godot.api.ClassDB
import godot.api.CodeEdit
import godot.api.CodeHighlighter
import godot.api.CollisionObject2D
import godot.api.CollisionObject3D
import godot.api.CollisionPolygon2D
import godot.api.CollisionPolygon3D
import godot.api.CollisionShape2D
import godot.api.CollisionShape3D
import godot.api.ColorPalette
import godot.api.ColorPicker
import godot.api.ColorPickerButton
import godot.api.ColorRect
import godot.api.Compositor
import godot.api.CompositorEffect
import godot.api.CompressedCubemap
import godot.api.CompressedCubemapArray
import godot.api.CompressedTexture2D
import godot.api.CompressedTexture2DArray
import godot.api.CompressedTexture3D
import godot.api.CompressedTextureLayered
import godot.api.ConcavePolygonShape2D
import godot.api.ConcavePolygonShape3D
import godot.api.ConeTwistJoint3D
import godot.api.ConfigFile
import godot.api.ConfirmationDialog
import godot.api.Container
import godot.api.Control
import godot.api.ConvertTransformModifier3D
import godot.api.ConvexPolygonShape2D
import godot.api.ConvexPolygonShape3D
import godot.api.CopyTransformModifier3D
import godot.api.Crypto
import godot.api.CryptoKey
import godot.api.Cubemap
import godot.api.CubemapArray
import godot.api.Curve
import godot.api.Curve2D
import godot.api.Curve3D
import godot.api.CurveTexture
import godot.api.CurveXYZTexture
import godot.api.CylinderMesh
import godot.api.CylinderShape3D
import godot.api.DPITexture
import godot.api.DTLSServer
import godot.api.DampedSpringJoint2D
import godot.api.Decal
import godot.api.DirAccess
import godot.api.DirectionalLight2D
import godot.api.DirectionalLight3D
import godot.api.DisplayServer
import godot.api.DrawableTexture2D
import godot.api.ENetConnection
import godot.api.ENetMultiplayerPeer
import godot.api.ENetPacketPeer
import godot.api.EncodedObjectAsID
import godot.api.Engine
import godot.api.EngineDebugger
import godot.api.EngineProfiler
import godot.api.Environment
import godot.api.Expression
import godot.api.ExternalTexture
import godot.api.FABRIK3D
import godot.api.FBXDocument
import godot.api.FBXState
import godot.api.FastNoiseLite
import godot.api.FileAccess
import godot.api.FileDialog
import godot.api.FlowContainer
import godot.api.FogMaterial
import godot.api.FogVolume
import godot.api.FoldableContainer
import godot.api.FoldableGroup
import godot.api.Font
import godot.api.FontFile
import godot.api.FontVariation
import godot.api.FramebufferCacheRD
import godot.api.GDExtension
import godot.api.GDExtensionManager
import godot.api.GDScript
import godot.api.GLTFAccessor
import godot.api.GLTFAnimation
import godot.api.GLTFBufferView
import godot.api.GLTFCamera
import godot.api.GLTFDocument
import godot.api.GLTFDocumentExtension
import godot.api.GLTFDocumentExtensionConvertImporterMesh
import godot.api.GLTFLight
import godot.api.GLTFMesh
import godot.api.GLTFNode
import godot.api.GLTFObjectModelProperty
import godot.api.GLTFPhysicsBody
import godot.api.GLTFPhysicsShape
import godot.api.GLTFSkeleton
import godot.api.GLTFSkin
import godot.api.GLTFSpecGloss
import godot.api.GLTFState
import godot.api.GLTFTexture
import godot.api.GLTFTextureSampler
import godot.api.GPUParticles2D
import godot.api.GPUParticles3D
import godot.api.GPUParticlesAttractor3D
import godot.api.GPUParticlesAttractorBox3D
import godot.api.GPUParticlesAttractorSphere3D
import godot.api.GPUParticlesAttractorVectorField3D
import godot.api.GPUParticlesCollision3D
import godot.api.GPUParticlesCollisionBox3D
import godot.api.GPUParticlesCollisionHeightField3D
import godot.api.GPUParticlesCollisionSDF3D
import godot.api.GPUParticlesCollisionSphere3D
import godot.api.GdjScript
import godot.api.Generic6DOFJoint3D
import godot.api.Geometry2D
import godot.api.Geometry3D
import godot.api.GeometryInstance3D
import godot.api.GodotInstance
import godot.api.Gradient
import godot.api.GradientTexture1D
import godot.api.GradientTexture2D
import godot.api.GraphEdit
import godot.api.GraphElement
import godot.api.GraphFrame
import godot.api.GraphNode
import godot.api.GridContainer
import godot.api.GridMap
import godot.api.GrooveJoint2D
import godot.api.HBoxContainer
import godot.api.HFlowContainer
import godot.api.HMACContext
import godot.api.HScrollBar
import godot.api.HSeparator
import godot.api.HSlider
import godot.api.HSplitContainer
import godot.api.HTTPClient
import godot.api.HTTPRequest
import godot.api.HashingContext
import godot.api.HeightMapShape3D
import godot.api.HingeJoint3D
import godot.api.IKModifier3D
import godot.api.IP
import godot.api.Image
import godot.api.ImageFormatLoader
import godot.api.ImageFormatLoaderExtension
import godot.api.ImageTexture
import godot.api.ImageTexture3D
import godot.api.ImageTextureLayered
import godot.api.ImmediateMesh
import godot.api.ImporterMesh
import godot.api.ImporterMeshInstance3D
import godot.api.Input
import godot.api.InputEvent
import godot.api.InputEventAction
import godot.api.InputEventFromWindow
import godot.api.InputEventGesture
import godot.api.InputEventJoypadButton
import godot.api.InputEventJoypadMotion
import godot.api.InputEventKey
import godot.api.InputEventMIDI
import godot.api.InputEventMagnifyGesture
import godot.api.InputEventMouse
import godot.api.InputEventMouseButton
import godot.api.InputEventMouseMotion
import godot.api.InputEventPanGesture
import godot.api.InputEventScreenDrag
import godot.api.InputEventScreenTouch
import godot.api.InputEventShortcut
import godot.api.InputEventWithModifiers
import godot.api.InputMap
import godot.api.InstancePlaceholder
import godot.api.IntervalTweener
import godot.api.ItemList
import godot.api.IterateIK3D
import godot.api.JNISingleton
import godot.api.JSON
import godot.api.JSONRPC
import godot.api.JacobianIK3D
import godot.api.JavaClass
import godot.api.JavaClassWrapper
import godot.api.JavaObject
import godot.api.JavaScript
import godot.api.JavaScriptBridge
import godot.api.JavaScriptObject
import godot.api.Joint2D
import godot.api.Joint3D
import godot.api.JointLimitation3D
import godot.api.JointLimitationCone3D
import godot.api.JvmScript
import godot.api.KinematicCollision2D
import godot.api.KinematicCollision3D
import godot.api.KotlinScript
import godot.api.Label
import godot.api.Label3D
import godot.api.LabelSettings
import godot.api.Light2D
import godot.api.Light3D
import godot.api.LightOccluder2D
import godot.api.LightmapGI
import godot.api.LightmapGIData
import godot.api.LightmapProbe
import godot.api.Lightmapper
import godot.api.LightmapperRD
import godot.api.LimitAngularVelocityModifier3D
import godot.api.Line2D
import godot.api.LineEdit
import godot.api.LinkButton
import godot.api.Logger
import godot.api.LookAtModifier3D
import godot.api.MainLoop
import godot.api.MarginContainer
import godot.api.Marker2D
import godot.api.Marker3D
import godot.api.Marshalls
import godot.api.Material
import godot.api.MaterialDummy
import godot.api.MenuBar
import godot.api.MenuButton
import godot.api.Mesh
import godot.api.MeshConvexDecompositionSettings
import godot.api.MeshDataTool
import godot.api.MeshDummy
import godot.api.MeshInstance2D
import godot.api.MeshInstance3D
import godot.api.MeshLibrary
import godot.api.MeshTexture
import godot.api.MethodTweener
import godot.api.MissingNode
import godot.api.MissingResource
import godot.api.MobileVRInterface
import godot.api.ModifierBoneTarget3D
import godot.api.MovieWriter
import godot.api.MovieWriterDummy
import godot.api.MultiMesh
import godot.api.MultiMeshInstance2D
import godot.api.MultiMeshInstance3D
import godot.api.MultiplayerAPI
import godot.api.MultiplayerAPIExtension
import godot.api.MultiplayerPeer
import godot.api.MultiplayerPeerExtension
import godot.api.MultiplayerPeerExtensionDummy
import godot.api.MultiplayerSpawner
import godot.api.MultiplayerSynchronizer
import godot.api.Mutex
import godot.api.NativeMenu
import godot.api.NavigationAgent2D
import godot.api.NavigationAgent3D
import godot.api.NavigationLink2D
import godot.api.NavigationLink3D
import godot.api.NavigationMesh
import godot.api.NavigationMeshGenerator
import godot.api.NavigationMeshSourceGeometryData2D
import godot.api.NavigationMeshSourceGeometryData3D
import godot.api.NavigationObstacle2D
import godot.api.NavigationObstacle3D
import godot.api.NavigationPathQueryParameters2D
import godot.api.NavigationPathQueryParameters3D
import godot.api.NavigationPathQueryResult2D
import godot.api.NavigationPathQueryResult3D
import godot.api.NavigationPolygon
import godot.api.NavigationRegion2D
import godot.api.NavigationRegion3D
import godot.api.NavigationServer2D
import godot.api.NavigationServer2DManager
import godot.api.NavigationServer3D
import godot.api.NavigationServer3DManager
import godot.api.NinePatchRect
import godot.api.Node
import godot.api.Node2D
import godot.api.Node3D
import godot.api.Node3DGizmo
import godot.api.Noise
import godot.api.NoiseTexture2D
import godot.api.NoiseTexture3D
import godot.api.ORMMaterial3D
import godot.api.OS
import godot.api.Object
import godot.api.Occluder3D
import godot.api.OccluderInstance3D
import godot.api.OccluderPolygon2D
import godot.api.OfflineMultiplayerPeer
import godot.api.OggPacketSequence
import godot.api.OggPacketSequencePlayback
import godot.api.OmniLight3D
import godot.api.OpenXRAPIExtension
import godot.api.OpenXRAction
import godot.api.OpenXRActionBindingModifier
import godot.api.OpenXRActionMap
import godot.api.OpenXRActionSet
import godot.api.OpenXRAnalogThresholdModifier
import godot.api.OpenXRAnchorTracker
import godot.api.OpenXRAndroidThreadSettingsExtension
import godot.api.OpenXRBindingModifier
import godot.api.OpenXRBindingModifierDummy
import godot.api.OpenXRCompositionLayer
import godot.api.OpenXRCompositionLayerCylinder
import godot.api.OpenXRCompositionLayerEquirect
import godot.api.OpenXRCompositionLayerQuad
import godot.api.OpenXRDpadBindingModifier
import godot.api.OpenXRExtensionWrapper
import godot.api.OpenXRExtensionWrapperExtension
import godot.api.OpenXRFrameSynthesisExtension
import godot.api.OpenXRFutureExtension
import godot.api.OpenXRFutureResult
import godot.api.OpenXRHand
import godot.api.OpenXRHapticBase
import godot.api.OpenXRHapticVibration
import godot.api.OpenXRIPBinding
import godot.api.OpenXRIPBindingModifier
import godot.api.OpenXRInteractionProfile
import godot.api.OpenXRInteractionProfileMetadata
import godot.api.OpenXRInterface
import godot.api.OpenXRMarkerTracker
import godot.api.OpenXRPlaneTracker
import godot.api.OpenXRRenderModel
import godot.api.OpenXRRenderModelExtension
import godot.api.OpenXRRenderModelManager
import godot.api.OpenXRSpatialAnchorCapability
import godot.api.OpenXRSpatialCapabilityConfigurationAnchor
import godot.api.OpenXRSpatialCapabilityConfigurationAprilTag
import godot.api.OpenXRSpatialCapabilityConfigurationAruco
import godot.api.OpenXRSpatialCapabilityConfigurationBaseHeader
import godot.api.OpenXRSpatialCapabilityConfigurationMicroQrCode
import godot.api.OpenXRSpatialCapabilityConfigurationPlaneTracking
import godot.api.OpenXRSpatialCapabilityConfigurationQrCode
import godot.api.OpenXRSpatialComponentAnchorList
import godot.api.OpenXRSpatialComponentBounded2DList
import godot.api.OpenXRSpatialComponentBounded3DList
import godot.api.OpenXRSpatialComponentData
import godot.api.OpenXRSpatialComponentMarkerList
import godot.api.OpenXRSpatialComponentMesh2DList
import godot.api.OpenXRSpatialComponentMesh3DList
import godot.api.OpenXRSpatialComponentParentList
import godot.api.OpenXRSpatialComponentPersistenceList
import godot.api.OpenXRSpatialComponentPlaneAlignmentList
import godot.api.OpenXRSpatialComponentPlaneSemanticLabelList
import godot.api.OpenXRSpatialComponentPolygon2DList
import godot.api.OpenXRSpatialContextPersistenceConfig
import godot.api.OpenXRSpatialEntityExtension
import godot.api.OpenXRSpatialEntityTracker
import godot.api.OpenXRSpatialMarkerTrackingCapability
import godot.api.OpenXRSpatialPlaneTrackingCapability
import godot.api.OpenXRSpatialQueryResultData
import godot.api.OpenXRStructureBase
import godot.api.OpenXRVisibilityMask
import godot.api.OptimizedTranslation
import godot.api.OptionButton
import godot.api.PCKPacker
import godot.api.PackedDataContainer
import godot.api.PackedDataContainerRef
import godot.api.PackedScene
import godot.api.PacketPeer
import godot.api.PacketPeerDTLS
import godot.api.PacketPeerExtension
import godot.api.PacketPeerExtensionDummy
import godot.api.PacketPeerStream
import godot.api.PacketPeerUDP
import godot.api.Panel
import godot.api.PanelContainer
import godot.api.PanoramaSkyMaterial
import godot.api.Parallax2D
import godot.api.ParallaxBackground
import godot.api.ParallaxLayer
import godot.api.ParticleProcessMaterial
import godot.api.Path2D
import godot.api.Path3D
import godot.api.PathFollow2D
import godot.api.PathFollow3D
import godot.api.Performance
import godot.api.PhysicalBone2D
import godot.api.PhysicalBone3D
import godot.api.PhysicalBoneSimulator3D
import godot.api.PhysicalSkyMaterial
import godot.api.PhysicsBody2D
import godot.api.PhysicsBody3D
import godot.api.PhysicsDirectBodyState2D
import godot.api.PhysicsDirectBodyState2DExtension
import godot.api.PhysicsDirectBodyState2DExtensionDummy
import godot.api.PhysicsDirectBodyState3D
import godot.api.PhysicsDirectBodyState3DExtension
import godot.api.PhysicsDirectBodyState3DExtensionDummy
import godot.api.PhysicsDirectSpaceState2D
import godot.api.PhysicsDirectSpaceState2DExtension
import godot.api.PhysicsDirectSpaceState2DExtensionDummy
import godot.api.PhysicsDirectSpaceState3D
import godot.api.PhysicsDirectSpaceState3DExtension
import godot.api.PhysicsDirectSpaceState3DExtensionDummy
import godot.api.PhysicsMaterial
import godot.api.PhysicsPointQueryParameters2D
import godot.api.PhysicsPointQueryParameters3D
import godot.api.PhysicsRayQueryParameters2D
import godot.api.PhysicsRayQueryParameters3D
import godot.api.PhysicsServer2D
import godot.api.PhysicsServer2DManager
import godot.api.PhysicsServer3D
import godot.api.PhysicsServer3DManager
import godot.api.PhysicsServer3DRenderingServerHandler
import godot.api.PhysicsServer3DRenderingServerHandlerDummy
import godot.api.PhysicsShapeQueryParameters2D
import godot.api.PhysicsShapeQueryParameters3D
import godot.api.PhysicsTestMotionParameters2D
import godot.api.PhysicsTestMotionParameters3D
import godot.api.PhysicsTestMotionResult2D
import godot.api.PhysicsTestMotionResult3D
import godot.api.PinJoint2D
import godot.api.PinJoint3D
import godot.api.PlaceholderCubemap
import godot.api.PlaceholderCubemapArray
import godot.api.PlaceholderMaterial
import godot.api.PlaceholderMesh
import godot.api.PlaceholderTexture2D
import godot.api.PlaceholderTexture2DArray
import godot.api.PlaceholderTexture3D
import godot.api.PlaceholderTextureLayered
import godot.api.PlaneMesh
import godot.api.PointLight2D
import godot.api.PointMesh
import godot.api.Polygon2D
import godot.api.PolygonOccluder3D
import godot.api.PolygonPathFinder
import godot.api.Popup
import godot.api.PopupMenu
import godot.api.PopupPanel
import godot.api.PortableCompressedTexture2D
import godot.api.PrimitiveMesh
import godot.api.PrismMesh
import godot.api.ProceduralSkyMaterial
import godot.api.ProgressBar
import godot.api.ProjectSettings
import godot.api.PropertyTweener
import godot.api.QuadMesh
import godot.api.QuadOccluder3D
import godot.api.RDAccelerationStructureGeometry
import godot.api.RDAccelerationStructureInstance
import godot.api.RDAttachmentFormat
import godot.api.RDFramebufferPass
import godot.api.RDHitGroup
import godot.api.RDPipelineColorBlendState
import godot.api.RDPipelineColorBlendStateAttachment
import godot.api.RDPipelineDepthStencilState
import godot.api.RDPipelineMultisampleState
import godot.api.RDPipelineRasterizationState
import godot.api.RDPipelineShader
import godot.api.RDPipelineSpecializationConstant
import godot.api.RDSamplerState
import godot.api.RDShaderFile
import godot.api.RDShaderSPIRV
import godot.api.RDShaderSource
import godot.api.RDTextureFormat
import godot.api.RDTextureView
import godot.api.RDUniform
import godot.api.RDVertexAttribute
import godot.api.RandomNumberGenerator
import godot.api.Range
import godot.api.RayCast2D
import godot.api.RayCast3D
import godot.api.RectangleShape2D
import godot.api.RefCounted
import godot.api.ReferenceRect
import godot.api.ReflectionProbe
import godot.api.RegEx
import godot.api.RegExMatch
import godot.api.RemoteTransform2D
import godot.api.RemoteTransform3D
import godot.api.RenderData
import godot.api.RenderDataExtension
import godot.api.RenderDataRD
import godot.api.RenderSceneBuffers
import godot.api.RenderSceneBuffersConfiguration
import godot.api.RenderSceneBuffersExtension
import godot.api.RenderSceneBuffersRD
import godot.api.RenderSceneData
import godot.api.RenderSceneDataExtension
import godot.api.RenderSceneDataRD
import godot.api.RenderingDevice
import godot.api.RenderingServer
import godot.api.Resource
import godot.api.ResourceFormatLoader
import godot.api.ResourceFormatLoaderDummy
import godot.api.ResourceFormatSaver
import godot.api.ResourceImporter
import godot.api.ResourceLoader
import godot.api.ResourcePreloader
import godot.api.ResourceSaver
import godot.api.ResourceUID
import godot.api.RetargetModifier3D
import godot.api.RibbonTrailMesh
import godot.api.RichTextEffect
import godot.api.RichTextLabel
import godot.api.RigidBody2D
import godot.api.RigidBody3D
import godot.api.RootMotionView
import godot.api.ScalaScript
import godot.api.SceneMultiplayer
import godot.api.SceneReplicationConfig
import godot.api.SceneState
import godot.api.SceneTree
import godot.api.SceneTreeTimer
import godot.api.Script
import godot.api.ScriptBacktrace
import godot.api.ScriptExtension
import godot.api.ScriptExtensionDummy
import godot.api.ScriptLanguage
import godot.api.ScriptLanguageExtension
import godot.api.ScriptLanguageExtensionDummy
import godot.api.ScrollBar
import godot.api.ScrollContainer
import godot.api.SegmentShape2D
import godot.api.Semaphore
import godot.api.SeparationRayShape2D
import godot.api.SeparationRayShape3D
import godot.api.Separator
import godot.api.Shader
import godot.api.ShaderGlobalsOverride
import godot.api.ShaderInclude
import godot.api.ShaderIncludeDB
import godot.api.ShaderMaterial
import godot.api.Shape2D
import godot.api.Shape3D
import godot.api.ShapeCast2D
import godot.api.ShapeCast3D
import godot.api.Shortcut
import godot.api.Skeleton2D
import godot.api.Skeleton3D
import godot.api.SkeletonIK3D
import godot.api.SkeletonModification2D
import godot.api.SkeletonModification2DCCDIK
import godot.api.SkeletonModification2DFABRIK
import godot.api.SkeletonModification2DJiggle
import godot.api.SkeletonModification2DLookAt
import godot.api.SkeletonModification2DPhysicalBones
import godot.api.SkeletonModification2DStackHolder
import godot.api.SkeletonModification2DTwoBoneIK
import godot.api.SkeletonModificationStack2D
import godot.api.SkeletonModifier3D
import godot.api.SkeletonProfile
import godot.api.SkeletonProfileHumanoid
import godot.api.Skin
import godot.api.SkinReference
import godot.api.Sky
import godot.api.Slider
import godot.api.SliderJoint3D
import godot.api.SocketServer
import godot.api.SoftBody3D
import godot.api.SphereMesh
import godot.api.SphereOccluder3D
import godot.api.SphereShape3D
import godot.api.SpinBox
import godot.api.SplineIK3D
import godot.api.SplitContainer
import godot.api.SpotLight3D
import godot.api.SpringArm3D
import godot.api.SpringBoneCollision3D
import godot.api.SpringBoneCollisionCapsule3D
import godot.api.SpringBoneCollisionPlane3D
import godot.api.SpringBoneCollisionSphere3D
import godot.api.SpringBoneSimulator3D
import godot.api.Sprite2D
import godot.api.Sprite3D
import godot.api.SpriteBase3D
import godot.api.SpriteFrames
import godot.api.StandardMaterial3D
import godot.api.StaticBody2D
import godot.api.StaticBody3D
import godot.api.StatusIndicator
import godot.api.StreamPeer
import godot.api.StreamPeerBuffer
import godot.api.StreamPeerExtension
import godot.api.StreamPeerExtensionDummy
import godot.api.StreamPeerGZIP
import godot.api.StreamPeerSocket
import godot.api.StreamPeerTCP
import godot.api.StreamPeerTLS
import godot.api.StreamPeerUDS
import godot.api.StyleBox
import godot.api.StyleBoxDummy
import godot.api.StyleBoxEmpty
import godot.api.StyleBoxFlat
import godot.api.StyleBoxLine
import godot.api.StyleBoxTexture
import godot.api.SubViewport
import godot.api.SubViewportContainer
import godot.api.SubtweenTweener
import godot.api.SurfaceTool
import godot.api.SyntaxHighlighter
import godot.api.SystemFont
import godot.api.TCPServer
import godot.api.TLSOptions
import godot.api.TabBar
import godot.api.TabContainer
import godot.api.TextEdit
import godot.api.TextLine
import godot.api.TextMesh
import godot.api.TextParagraph
import godot.api.TextServer
import godot.api.TextServerAdvanced
import godot.api.TextServerDummy
import godot.api.TextServerExtension
import godot.api.TextServerExtensionDummy
import godot.api.TextServerManager
import godot.api.Texture
import godot.api.Texture2D
import godot.api.Texture2DArray
import godot.api.Texture2DArrayRD
import godot.api.Texture2DDummy
import godot.api.Texture2DRD
import godot.api.Texture3D
import godot.api.Texture3DDummy
import godot.api.Texture3DRD
import godot.api.TextureButton
import godot.api.TextureCubemapArrayRD
import godot.api.TextureCubemapRD
import godot.api.TextureLayered
import godot.api.TextureLayeredDummy
import godot.api.TextureLayeredRD
import godot.api.TextureProgressBar
import godot.api.TextureRect
import godot.api.Theme
import godot.api.ThemeDB
import godot.api.Thread
import godot.api.TileData
import godot.api.TileMap
import godot.api.TileMapLayer
import godot.api.TileMapPattern
import godot.api.TileSet
import godot.api.TileSetAtlasSource
import godot.api.TileSetScenesCollectionSource
import godot.api.TileSetSource
import godot.api.Time
import godot.api.Timer
import godot.api.TorusMesh
import godot.api.TouchScreenButton
import godot.api.Translation
import godot.api.TranslationDomain
import godot.api.TranslationServer
import godot.api.Tree
import godot.api.TreeItem
import godot.api.TriangleMesh
import godot.api.TubeTrailMesh
import godot.api.Tween
import godot.api.Tweener
import godot.api.TwoBoneIK3D
import godot.api.UDPServer
import godot.api.UDSServer
import godot.api.UPNP
import godot.api.UPNPDevice
import godot.api.UndoRedo
import godot.api.UniformSetCacheRD
import godot.api.VBoxContainer
import godot.api.VFlowContainer
import godot.api.VScrollBar
import godot.api.VSeparator
import godot.api.VSlider
import godot.api.VSplitContainer
import godot.api.VehicleBody3D
import godot.api.VehicleWheel3D
import godot.api.VideoStream
import godot.api.VideoStreamDummy
import godot.api.VideoStreamPlayback
import godot.api.VideoStreamPlaybackDummy
import godot.api.VideoStreamPlayer
import godot.api.VideoStreamTheora
import godot.api.Viewport
import godot.api.ViewportTexture
import godot.api.VirtualJoystick
import godot.api.VisibleOnScreenEnabler2D
import godot.api.VisibleOnScreenEnabler3D
import godot.api.VisibleOnScreenNotifier2D
import godot.api.VisibleOnScreenNotifier3D
import godot.api.VisualInstance3D
import godot.api.VisualShader
import godot.api.VisualShaderNode
import godot.api.VisualShaderNodeBillboard
import godot.api.VisualShaderNodeBooleanConstant
import godot.api.VisualShaderNodeBooleanParameter
import godot.api.VisualShaderNodeClamp
import godot.api.VisualShaderNodeColorConstant
import godot.api.VisualShaderNodeColorFunc
import godot.api.VisualShaderNodeColorOp
import godot.api.VisualShaderNodeColorParameter
import godot.api.VisualShaderNodeComment
import godot.api.VisualShaderNodeCompare
import godot.api.VisualShaderNodeConstant
import godot.api.VisualShaderNodeCubemap
import godot.api.VisualShaderNodeCubemapParameter
import godot.api.VisualShaderNodeCurveTexture
import godot.api.VisualShaderNodeCurveXYZTexture
import godot.api.VisualShaderNodeCustom
import godot.api.VisualShaderNodeDerivativeFunc
import godot.api.VisualShaderNodeDeterminant
import godot.api.VisualShaderNodeDistanceFade
import godot.api.VisualShaderNodeDotProduct
import godot.api.VisualShaderNodeExpression
import godot.api.VisualShaderNodeFaceForward
import godot.api.VisualShaderNodeFloatConstant
import godot.api.VisualShaderNodeFloatFunc
import godot.api.VisualShaderNodeFloatOp
import godot.api.VisualShaderNodeFloatParameter
import godot.api.VisualShaderNodeFrame
import godot.api.VisualShaderNodeFresnel
import godot.api.VisualShaderNodeGlobalExpression
import godot.api.VisualShaderNodeGroupBase
import godot.api.VisualShaderNodeIf
import godot.api.VisualShaderNodeInput
import godot.api.VisualShaderNodeIntConstant
import godot.api.VisualShaderNodeIntFunc
import godot.api.VisualShaderNodeIntOp
import godot.api.VisualShaderNodeIntParameter
import godot.api.VisualShaderNodeIs
import godot.api.VisualShaderNodeLinearSceneDepth
import godot.api.VisualShaderNodeMix
import godot.api.VisualShaderNodeMultiplyAdd
import godot.api.VisualShaderNodeOuterProduct
import godot.api.VisualShaderNodeOutput
import godot.api.VisualShaderNodeParameter
import godot.api.VisualShaderNodeParameterRef
import godot.api.VisualShaderNodeParticleAccelerator
import godot.api.VisualShaderNodeParticleBoxEmitter
import godot.api.VisualShaderNodeParticleConeVelocity
import godot.api.VisualShaderNodeParticleEmit
import godot.api.VisualShaderNodeParticleEmitter
import godot.api.VisualShaderNodeParticleMeshEmitter
import godot.api.VisualShaderNodeParticleMultiplyByAxisAngle
import godot.api.VisualShaderNodeParticleOutput
import godot.api.VisualShaderNodeParticleRandomness
import godot.api.VisualShaderNodeParticleRingEmitter
import godot.api.VisualShaderNodeParticleSphereEmitter
import godot.api.VisualShaderNodeProximityFade
import godot.api.VisualShaderNodeRandomRange
import godot.api.VisualShaderNodeRemap
import godot.api.VisualShaderNodeReroute
import godot.api.VisualShaderNodeResizableBase
import godot.api.VisualShaderNodeRotationByAxis
import godot.api.VisualShaderNodeSDFRaymarch
import godot.api.VisualShaderNodeSDFToScreenUV
import godot.api.VisualShaderNodeSample3D
import godot.api.VisualShaderNodeScreenNormalWorldSpace
import godot.api.VisualShaderNodeScreenUVToSDF
import godot.api.VisualShaderNodeSmoothStep
import godot.api.VisualShaderNodeStep
import godot.api.VisualShaderNodeSwitch
import godot.api.VisualShaderNodeTexture
import godot.api.VisualShaderNodeTexture2DArray
import godot.api.VisualShaderNodeTexture2DArrayParameter
import godot.api.VisualShaderNodeTexture2DParameter
import godot.api.VisualShaderNodeTexture3D
import godot.api.VisualShaderNodeTexture3DParameter
import godot.api.VisualShaderNodeTextureParameter
import godot.api.VisualShaderNodeTextureParameterTriplanar
import godot.api.VisualShaderNodeTextureSDF
import godot.api.VisualShaderNodeTextureSDFNormal
import godot.api.VisualShaderNodeTransformCompose
import godot.api.VisualShaderNodeTransformConstant
import godot.api.VisualShaderNodeTransformDecompose
import godot.api.VisualShaderNodeTransformFunc
import godot.api.VisualShaderNodeTransformOp
import godot.api.VisualShaderNodeTransformParameter
import godot.api.VisualShaderNodeTransformVecMult
import godot.api.VisualShaderNodeUIntConstant
import godot.api.VisualShaderNodeUIntFunc
import godot.api.VisualShaderNodeUIntOp
import godot.api.VisualShaderNodeUIntParameter
import godot.api.VisualShaderNodeUVFunc
import godot.api.VisualShaderNodeUVPolarCoord
import godot.api.VisualShaderNodeVarying
import godot.api.VisualShaderNodeVaryingGetter
import godot.api.VisualShaderNodeVaryingSetter
import godot.api.VisualShaderNodeVec2Constant
import godot.api.VisualShaderNodeVec2Parameter
import godot.api.VisualShaderNodeVec3Constant
import godot.api.VisualShaderNodeVec3Parameter
import godot.api.VisualShaderNodeVec4Constant
import godot.api.VisualShaderNodeVec4Parameter
import godot.api.VisualShaderNodeVectorBase
import godot.api.VisualShaderNodeVectorCompose
import godot.api.VisualShaderNodeVectorDecompose
import godot.api.VisualShaderNodeVectorDistance
import godot.api.VisualShaderNodeVectorFunc
import godot.api.VisualShaderNodeVectorLen
import godot.api.VisualShaderNodeVectorOp
import godot.api.VisualShaderNodeVectorRefract
import godot.api.VisualShaderNodeWorldPositionFromDepth
import godot.api.VoxelGI
import godot.api.VoxelGIData
import godot.api.WeakRef
import godot.api.WebRTCDataChannel
import godot.api.WebRTCDataChannelExtension
import godot.api.WebRTCDataChannelExtensionDummy
import godot.api.WebRTCMultiplayerPeer
import godot.api.WebRTCPeerConnection
import godot.api.WebRTCPeerConnectionExtension
import godot.api.WebRTCPeerConnectionExtensionDummy
import godot.api.WebSocketMultiplayerPeer
import godot.api.WebSocketPeer
import godot.api.WebXRInterface
import godot.api.Window
import godot.api.WorkerThreadPool
import godot.api.World2D
import godot.api.World3D
import godot.api.WorldBoundaryShape2D
import godot.api.WorldBoundaryShape3D
import godot.api.WorldEnvironment
import godot.api.X509Certificate
import godot.api.XMLParser
import godot.api.XRAnchor3D
import godot.api.XRBodyModifier3D
import godot.api.XRBodyTracker
import godot.api.XRCamera3D
import godot.api.XRController3D
import godot.api.XRControllerTracker
import godot.api.XRFaceModifier3D
import godot.api.XRFaceTracker
import godot.api.XRHandModifier3D
import godot.api.XRHandTracker
import godot.api.XRInterface
import godot.api.XRInterfaceExtension
import godot.api.XRNode3D
import godot.api.XROrigin3D
import godot.api.XRPose
import godot.api.XRPositionalTracker
import godot.api.XRServer
import godot.api.XRTracker
import godot.api.XRVRS
import godot.api.ZIPPacker
import godot.api.ZIPReader
import godot.core.VariantParser.OBJECT
import godot.core.addVariantMapping
import java.lang.Class
import kotlin.Unit

public fun registerVariantMapping(): Unit {
  addVariantMapping(AESContext::class, OBJECT)
  addVariantMapping(AStar2D::class, OBJECT)
  addVariantMapping(AStar3D::class, OBJECT)
  addVariantMapping(AStarGrid2D::class, OBJECT)
  addVariantMapping(AcceptDialog::class, OBJECT)
  addVariantMapping(AccessibilityServer::class, OBJECT)
  addVariantMapping(AimModifier3D::class, OBJECT)
  addVariantMapping(AnimatableBody2D::class, OBJECT)
  addVariantMapping(AnimatableBody3D::class, OBJECT)
  addVariantMapping(AnimatedSprite2D::class, OBJECT)
  addVariantMapping(AnimatedSprite3D::class, OBJECT)
  addVariantMapping(AnimatedTexture::class, OBJECT)
  addVariantMapping(Animation::class, OBJECT)
  addVariantMapping(AnimationLibrary::class, OBJECT)
  addVariantMapping(AnimationMixer::class, OBJECT)
  addVariantMapping(AnimationNode::class, OBJECT)
  addVariantMapping(AnimationNodeAdd2::class, OBJECT)
  addVariantMapping(AnimationNodeAdd3::class, OBJECT)
  addVariantMapping(AnimationNodeAnimation::class, OBJECT)
  addVariantMapping(AnimationNodeBlend2::class, OBJECT)
  addVariantMapping(AnimationNodeBlend3::class, OBJECT)
  addVariantMapping(AnimationNodeBlendSpace1D::class, OBJECT)
  addVariantMapping(AnimationNodeBlendSpace2D::class, OBJECT)
  addVariantMapping(AnimationNodeBlendTree::class, OBJECT)
  addVariantMapping(AnimationNodeExtension::class, OBJECT)
  addVariantMapping(AnimationNodeOneShot::class, OBJECT)
  addVariantMapping(AnimationNodeOutput::class, OBJECT)
  addVariantMapping(AnimationNodeStateMachine::class, OBJECT)
  addVariantMapping(AnimationNodeStateMachinePlayback::class, OBJECT)
  addVariantMapping(AnimationNodeStateMachineTransition::class, OBJECT)
  addVariantMapping(AnimationNodeSub2::class, OBJECT)
  addVariantMapping(AnimationNodeSync::class, OBJECT)
  addVariantMapping(AnimationNodeTimeScale::class, OBJECT)
  addVariantMapping(AnimationNodeTimeSeek::class, OBJECT)
  addVariantMapping(AnimationNodeTransition::class, OBJECT)
  addVariantMapping(AnimationPlayer::class, OBJECT)
  addVariantMapping(AnimationRootNode::class, OBJECT)
  addVariantMapping(AnimationTree::class, OBJECT)
  addVariantMapping(Area2D::class, OBJECT)
  addVariantMapping(Area3D::class, OBJECT)
  addVariantMapping(AreaLight3D::class, OBJECT)
  addVariantMapping(ArrayMesh::class, OBJECT)
  addVariantMapping(ArrayOccluder3D::class, OBJECT)
  addVariantMapping(AspectRatioContainer::class, OBJECT)
  addVariantMapping(AtlasTexture::class, OBJECT)
  addVariantMapping(AudioBusLayout::class, OBJECT)
  addVariantMapping(AudioEffect::class, OBJECT)
  addVariantMapping(AudioEffectAmplify::class, OBJECT)
  addVariantMapping(AudioEffectBandLimitFilter::class, OBJECT)
  addVariantMapping(AudioEffectBandPassFilter::class, OBJECT)
  addVariantMapping(AudioEffectCapture::class, OBJECT)
  addVariantMapping(AudioEffectChorus::class, OBJECT)
  addVariantMapping(AudioEffectCompressor::class, OBJECT)
  addVariantMapping(AudioEffectDelay::class, OBJECT)
  addVariantMapping(AudioEffectDistortion::class, OBJECT)
  addVariantMapping(AudioEffectEQ::class, OBJECT)
  addVariantMapping(AudioEffectEQ10::class, OBJECT)
  addVariantMapping(AudioEffectEQ21::class, OBJECT)
  addVariantMapping(AudioEffectEQ6::class, OBJECT)
  addVariantMapping(AudioEffectFilter::class, OBJECT)
  addVariantMapping(AudioEffectHardLimiter::class, OBJECT)
  addVariantMapping(AudioEffectHighPassFilter::class, OBJECT)
  addVariantMapping(AudioEffectHighShelfFilter::class, OBJECT)
  addVariantMapping(AudioEffectInstance::class, OBJECT)
  addVariantMapping(AudioEffectLimiter::class, OBJECT)
  addVariantMapping(AudioEffectLowPassFilter::class, OBJECT)
  addVariantMapping(AudioEffectLowShelfFilter::class, OBJECT)
  addVariantMapping(AudioEffectNotchFilter::class, OBJECT)
  addVariantMapping(AudioEffectPanner::class, OBJECT)
  addVariantMapping(AudioEffectPhaser::class, OBJECT)
  addVariantMapping(AudioEffectPitchShift::class, OBJECT)
  addVariantMapping(AudioEffectRecord::class, OBJECT)
  addVariantMapping(AudioEffectReverb::class, OBJECT)
  addVariantMapping(AudioEffectSpectrumAnalyzer::class, OBJECT)
  addVariantMapping(AudioEffectSpectrumAnalyzerInstance::class, OBJECT)
  addVariantMapping(AudioEffectStereoEnhance::class, OBJECT)
  addVariantMapping(AudioListener2D::class, OBJECT)
  addVariantMapping(AudioListener3D::class, OBJECT)
  addVariantMapping(AudioSample::class, OBJECT)
  addVariantMapping(AudioSamplePlayback::class, OBJECT)
  addVariantMapping(AudioServer::class, OBJECT)
  addVariantMapping(AudioStream::class, OBJECT)
  addVariantMapping(AudioStreamGenerator::class, OBJECT)
  addVariantMapping(AudioStreamGeneratorPlayback::class, OBJECT)
  addVariantMapping(AudioStreamInteractive::class, OBJECT)
  addVariantMapping(AudioStreamMP3::class, OBJECT)
  addVariantMapping(AudioStreamMicrophone::class, OBJECT)
  addVariantMapping(AudioStreamOggVorbis::class, OBJECT)
  addVariantMapping(AudioStreamPlayback::class, OBJECT)
  addVariantMapping(AudioStreamPlaybackInteractive::class, OBJECT)
  addVariantMapping(AudioStreamPlaybackOggVorbis::class, OBJECT)
  addVariantMapping(AudioStreamPlaybackPlaylist::class, OBJECT)
  addVariantMapping(AudioStreamPlaybackPolyphonic::class, OBJECT)
  addVariantMapping(AudioStreamPlaybackResampled::class, OBJECT)
  addVariantMapping(AudioStreamPlaybackSynchronized::class, OBJECT)
  addVariantMapping(AudioStreamPlayer::class, OBJECT)
  addVariantMapping(AudioStreamPlayer2D::class, OBJECT)
  addVariantMapping(AudioStreamPlayer3D::class, OBJECT)
  addVariantMapping(AudioStreamPlaylist::class, OBJECT)
  addVariantMapping(AudioStreamPolyphonic::class, OBJECT)
  addVariantMapping(AudioStreamRandomizer::class, OBJECT)
  addVariantMapping(AudioStreamSynchronized::class, OBJECT)
  addVariantMapping(AudioStreamWAV::class, OBJECT)
  addVariantMapping(AwaitTweener::class, OBJECT)
  addVariantMapping(BackBufferCopy::class, OBJECT)
  addVariantMapping(BaseButton::class, OBJECT)
  addVariantMapping(BaseMaterial3D::class, OBJECT)
  addVariantMapping(BitMap::class, OBJECT)
  addVariantMapping(BlitMaterial::class, OBJECT)
  addVariantMapping(Bone2D::class, OBJECT)
  addVariantMapping(BoneAttachment3D::class, OBJECT)
  addVariantMapping(BoneConstraint3D::class, OBJECT)
  addVariantMapping(BoneMap::class, OBJECT)
  addVariantMapping(BoneTwistDisperser3D::class, OBJECT)
  addVariantMapping(BoxContainer::class, OBJECT)
  addVariantMapping(BoxMesh::class, OBJECT)
  addVariantMapping(BoxOccluder3D::class, OBJECT)
  addVariantMapping(BoxShape3D::class, OBJECT)
  addVariantMapping(Button::class, OBJECT)
  addVariantMapping(ButtonGroup::class, OBJECT)
  addVariantMapping(CCDIK3D::class, OBJECT)
  addVariantMapping(CPUParticles2D::class, OBJECT)
  addVariantMapping(CPUParticles3D::class, OBJECT)
  addVariantMapping(CSGBox3D::class, OBJECT)
  addVariantMapping(CSGCombiner3D::class, OBJECT)
  addVariantMapping(CSGCylinder3D::class, OBJECT)
  addVariantMapping(CSGMesh3D::class, OBJECT)
  addVariantMapping(CSGPolygon3D::class, OBJECT)
  addVariantMapping(CSGPrimitive3D::class, OBJECT)
  addVariantMapping(CSGShape3D::class, OBJECT)
  addVariantMapping(CSGSphere3D::class, OBJECT)
  addVariantMapping(CSGTorus3D::class, OBJECT)
  addVariantMapping(CallbackTweener::class, OBJECT)
  addVariantMapping(Camera2D::class, OBJECT)
  addVariantMapping(Camera3D::class, OBJECT)
  addVariantMapping(CameraAttributes::class, OBJECT)
  addVariantMapping(CameraAttributesPhysical::class, OBJECT)
  addVariantMapping(CameraAttributesPractical::class, OBJECT)
  addVariantMapping(CameraFeed::class, OBJECT)
  addVariantMapping(CameraServer::class, OBJECT)
  addVariantMapping(CameraTexture::class, OBJECT)
  addVariantMapping(CanvasGroup::class, OBJECT)
  addVariantMapping(CanvasItem::class, OBJECT)
  addVariantMapping(CanvasItemMaterial::class, OBJECT)
  addVariantMapping(CanvasLayer::class, OBJECT)
  addVariantMapping(CanvasModulate::class, OBJECT)
  addVariantMapping(CanvasTexture::class, OBJECT)
  addVariantMapping(CapsuleMesh::class, OBJECT)
  addVariantMapping(CapsuleShape2D::class, OBJECT)
  addVariantMapping(CapsuleShape3D::class, OBJECT)
  addVariantMapping(CenterContainer::class, OBJECT)
  addVariantMapping(ChainIK3D::class, OBJECT)
  addVariantMapping(CharFXTransform::class, OBJECT)
  addVariantMapping(CharacterBody2D::class, OBJECT)
  addVariantMapping(CharacterBody3D::class, OBJECT)
  addVariantMapping(CheckBox::class, OBJECT)
  addVariantMapping(CheckButton::class, OBJECT)
  addVariantMapping(CircleShape2D::class, OBJECT)
  addVariantMapping(ClassDB::class, OBJECT)
  addVariantMapping(CodeEdit::class, OBJECT)
  addVariantMapping(CodeHighlighter::class, OBJECT)
  addVariantMapping(CollisionObject2D::class, OBJECT)
  addVariantMapping(CollisionObject3D::class, OBJECT)
  addVariantMapping(CollisionPolygon2D::class, OBJECT)
  addVariantMapping(CollisionPolygon3D::class, OBJECT)
  addVariantMapping(CollisionShape2D::class, OBJECT)
  addVariantMapping(CollisionShape3D::class, OBJECT)
  addVariantMapping(ColorPalette::class, OBJECT)
  addVariantMapping(ColorPicker::class, OBJECT)
  addVariantMapping(ColorPickerButton::class, OBJECT)
  addVariantMapping(ColorRect::class, OBJECT)
  addVariantMapping(Compositor::class, OBJECT)
  addVariantMapping(CompositorEffect::class, OBJECT)
  addVariantMapping(CompressedCubemap::class, OBJECT)
  addVariantMapping(CompressedCubemapArray::class, OBJECT)
  addVariantMapping(CompressedTexture2D::class, OBJECT)
  addVariantMapping(CompressedTexture2DArray::class, OBJECT)
  addVariantMapping(CompressedTexture3D::class, OBJECT)
  addVariantMapping(CompressedTextureLayered::class, OBJECT)
  addVariantMapping(ConcavePolygonShape2D::class, OBJECT)
  addVariantMapping(ConcavePolygonShape3D::class, OBJECT)
  addVariantMapping(ConeTwistJoint3D::class, OBJECT)
  addVariantMapping(ConfigFile::class, OBJECT)
  addVariantMapping(ConfirmationDialog::class, OBJECT)
  addVariantMapping(Container::class, OBJECT)
  addVariantMapping(Control::class, OBJECT)
  addVariantMapping(ConvertTransformModifier3D::class, OBJECT)
  addVariantMapping(ConvexPolygonShape2D::class, OBJECT)
  addVariantMapping(ConvexPolygonShape3D::class, OBJECT)
  addVariantMapping(CopyTransformModifier3D::class, OBJECT)
  addVariantMapping(Crypto::class, OBJECT)
  addVariantMapping(CryptoKey::class, OBJECT)
  addVariantMapping(Cubemap::class, OBJECT)
  addVariantMapping(CubemapArray::class, OBJECT)
  addVariantMapping(Curve::class, OBJECT)
  addVariantMapping(Curve2D::class, OBJECT)
  addVariantMapping(Curve3D::class, OBJECT)
  addVariantMapping(CurveTexture::class, OBJECT)
  addVariantMapping(CurveXYZTexture::class, OBJECT)
  addVariantMapping(CylinderMesh::class, OBJECT)
  addVariantMapping(CylinderShape3D::class, OBJECT)
  addVariantMapping(DPITexture::class, OBJECT)
  addVariantMapping(DTLSServer::class, OBJECT)
  addVariantMapping(DampedSpringJoint2D::class, OBJECT)
  addVariantMapping(Decal::class, OBJECT)
  addVariantMapping(DirAccess::class, OBJECT)
  addVariantMapping(DirectionalLight2D::class, OBJECT)
  addVariantMapping(DirectionalLight3D::class, OBJECT)
  addVariantMapping(DisplayServer::class, OBJECT)
  addVariantMapping(DrawableTexture2D::class, OBJECT)
  addVariantMapping(ENetConnection::class, OBJECT)
  addVariantMapping(ENetMultiplayerPeer::class, OBJECT)
  addVariantMapping(ENetPacketPeer::class, OBJECT)
  addVariantMapping(EncodedObjectAsID::class, OBJECT)
  addVariantMapping(Engine::class, OBJECT)
  addVariantMapping(EngineDebugger::class, OBJECT)
  addVariantMapping(EngineProfiler::class, OBJECT)
  addVariantMapping(Environment::class, OBJECT)
  addVariantMapping(Expression::class, OBJECT)
  addVariantMapping(ExternalTexture::class, OBJECT)
  addVariantMapping(FABRIK3D::class, OBJECT)
  addVariantMapping(FBXDocument::class, OBJECT)
  addVariantMapping(FBXState::class, OBJECT)
  addVariantMapping(FastNoiseLite::class, OBJECT)
  addVariantMapping(FileAccess::class, OBJECT)
  addVariantMapping(FileDialog::class, OBJECT)
  addVariantMapping(FlowContainer::class, OBJECT)
  addVariantMapping(FogMaterial::class, OBJECT)
  addVariantMapping(FogVolume::class, OBJECT)
  addVariantMapping(FoldableContainer::class, OBJECT)
  addVariantMapping(FoldableGroup::class, OBJECT)
  addVariantMapping(Font::class, OBJECT)
  addVariantMapping(FontFile::class, OBJECT)
  addVariantMapping(FontVariation::class, OBJECT)
  addVariantMapping(FramebufferCacheRD::class, OBJECT)
  addVariantMapping(GDExtension::class, OBJECT)
  addVariantMapping(GDExtensionManager::class, OBJECT)
  addVariantMapping(GDScript::class, OBJECT)
  addVariantMapping(GLTFAccessor::class, OBJECT)
  addVariantMapping(GLTFAnimation::class, OBJECT)
  addVariantMapping(GLTFBufferView::class, OBJECT)
  addVariantMapping(GLTFCamera::class, OBJECT)
  addVariantMapping(GLTFDocument::class, OBJECT)
  addVariantMapping(GLTFDocumentExtension::class, OBJECT)
  addVariantMapping(GLTFDocumentExtensionConvertImporterMesh::class, OBJECT)
  addVariantMapping(GLTFLight::class, OBJECT)
  addVariantMapping(GLTFMesh::class, OBJECT)
  addVariantMapping(GLTFNode::class, OBJECT)
  addVariantMapping(GLTFObjectModelProperty::class, OBJECT)
  addVariantMapping(GLTFPhysicsBody::class, OBJECT)
  addVariantMapping(GLTFPhysicsShape::class, OBJECT)
  addVariantMapping(GLTFSkeleton::class, OBJECT)
  addVariantMapping(GLTFSkin::class, OBJECT)
  addVariantMapping(GLTFSpecGloss::class, OBJECT)
  addVariantMapping(GLTFState::class, OBJECT)
  addVariantMapping(GLTFTexture::class, OBJECT)
  addVariantMapping(GLTFTextureSampler::class, OBJECT)
  addVariantMapping(GPUParticles2D::class, OBJECT)
  addVariantMapping(GPUParticles3D::class, OBJECT)
  addVariantMapping(GPUParticlesAttractor3D::class, OBJECT)
  addVariantMapping(GPUParticlesAttractorBox3D::class, OBJECT)
  addVariantMapping(GPUParticlesAttractorSphere3D::class, OBJECT)
  addVariantMapping(GPUParticlesAttractorVectorField3D::class, OBJECT)
  addVariantMapping(GPUParticlesCollision3D::class, OBJECT)
  addVariantMapping(GPUParticlesCollisionBox3D::class, OBJECT)
  addVariantMapping(GPUParticlesCollisionHeightField3D::class, OBJECT)
  addVariantMapping(GPUParticlesCollisionSDF3D::class, OBJECT)
  addVariantMapping(GPUParticlesCollisionSphere3D::class, OBJECT)
  addVariantMapping(GdjScript::class, OBJECT)
  addVariantMapping(Generic6DOFJoint3D::class, OBJECT)
  addVariantMapping(Geometry2D::class, OBJECT)
  addVariantMapping(Geometry3D::class, OBJECT)
  addVariantMapping(GeometryInstance3D::class, OBJECT)
  addVariantMapping(GodotInstance::class, OBJECT)
  addVariantMapping(Gradient::class, OBJECT)
  addVariantMapping(GradientTexture1D::class, OBJECT)
  addVariantMapping(GradientTexture2D::class, OBJECT)
  addVariantMapping(GraphEdit::class, OBJECT)
  addVariantMapping(GraphElement::class, OBJECT)
  addVariantMapping(GraphFrame::class, OBJECT)
  addVariantMapping(GraphNode::class, OBJECT)
  addVariantMapping(GridContainer::class, OBJECT)
  addVariantMapping(GridMap::class, OBJECT)
  addVariantMapping(GrooveJoint2D::class, OBJECT)
  addVariantMapping(HBoxContainer::class, OBJECT)
  addVariantMapping(HFlowContainer::class, OBJECT)
  addVariantMapping(HMACContext::class, OBJECT)
  addVariantMapping(HScrollBar::class, OBJECT)
  addVariantMapping(HSeparator::class, OBJECT)
  addVariantMapping(HSlider::class, OBJECT)
  addVariantMapping(HSplitContainer::class, OBJECT)
  addVariantMapping(HTTPClient::class, OBJECT)
  addVariantMapping(HTTPRequest::class, OBJECT)
  addVariantMapping(HashingContext::class, OBJECT)
  addVariantMapping(HeightMapShape3D::class, OBJECT)
  addVariantMapping(HingeJoint3D::class, OBJECT)
  addVariantMapping(IKModifier3D::class, OBJECT)
  addVariantMapping(IP::class, OBJECT)
  addVariantMapping(Image::class, OBJECT)
  addVariantMapping(ImageFormatLoader::class, OBJECT)
  addVariantMapping(ImageFormatLoaderExtension::class, OBJECT)
  addVariantMapping(ImageTexture::class, OBJECT)
  addVariantMapping(ImageTexture3D::class, OBJECT)
  addVariantMapping(ImageTextureLayered::class, OBJECT)
  addVariantMapping(ImmediateMesh::class, OBJECT)
  addVariantMapping(ImporterMesh::class, OBJECT)
  addVariantMapping(ImporterMeshInstance3D::class, OBJECT)
  addVariantMapping(Input::class, OBJECT)
  addVariantMapping(InputEvent::class, OBJECT)
  addVariantMapping(InputEventAction::class, OBJECT)
  addVariantMapping(InputEventFromWindow::class, OBJECT)
  addVariantMapping(InputEventGesture::class, OBJECT)
  addVariantMapping(InputEventJoypadButton::class, OBJECT)
  addVariantMapping(InputEventJoypadMotion::class, OBJECT)
  addVariantMapping(InputEventKey::class, OBJECT)
  addVariantMapping(InputEventMIDI::class, OBJECT)
  addVariantMapping(InputEventMagnifyGesture::class, OBJECT)
  addVariantMapping(InputEventMouse::class, OBJECT)
  addVariantMapping(InputEventMouseButton::class, OBJECT)
  addVariantMapping(InputEventMouseMotion::class, OBJECT)
  addVariantMapping(InputEventPanGesture::class, OBJECT)
  addVariantMapping(InputEventScreenDrag::class, OBJECT)
  addVariantMapping(InputEventScreenTouch::class, OBJECT)
  addVariantMapping(InputEventShortcut::class, OBJECT)
  addVariantMapping(InputEventWithModifiers::class, OBJECT)
  addVariantMapping(InputMap::class, OBJECT)
  addVariantMapping(InstancePlaceholder::class, OBJECT)
  addVariantMapping(IntervalTweener::class, OBJECT)
  addVariantMapping(ItemList::class, OBJECT)
  addVariantMapping(IterateIK3D::class, OBJECT)
  addVariantMapping(JNISingleton::class, OBJECT)
  addVariantMapping(JSON::class, OBJECT)
  addVariantMapping(JSONRPC::class, OBJECT)
  addVariantMapping(JacobianIK3D::class, OBJECT)
  addVariantMapping(JavaClass::class, OBJECT)
  addVariantMapping(JavaClassWrapper::class, OBJECT)
  addVariantMapping(JavaObject::class, OBJECT)
  addVariantMapping(JavaScript::class, OBJECT)
  addVariantMapping(JavaScriptBridge::class, OBJECT)
  addVariantMapping(JavaScriptObject::class, OBJECT)
  addVariantMapping(Joint2D::class, OBJECT)
  addVariantMapping(Joint3D::class, OBJECT)
  addVariantMapping(JointLimitation3D::class, OBJECT)
  addVariantMapping(JointLimitationCone3D::class, OBJECT)
  addVariantMapping(JvmScript::class, OBJECT)
  addVariantMapping(KinematicCollision2D::class, OBJECT)
  addVariantMapping(KinematicCollision3D::class, OBJECT)
  addVariantMapping(KotlinScript::class, OBJECT)
  addVariantMapping(Label::class, OBJECT)
  addVariantMapping(Label3D::class, OBJECT)
  addVariantMapping(LabelSettings::class, OBJECT)
  addVariantMapping(Light2D::class, OBJECT)
  addVariantMapping(Light3D::class, OBJECT)
  addVariantMapping(LightOccluder2D::class, OBJECT)
  addVariantMapping(LightmapGI::class, OBJECT)
  addVariantMapping(LightmapGIData::class, OBJECT)
  addVariantMapping(LightmapProbe::class, OBJECT)
  addVariantMapping(Lightmapper::class, OBJECT)
  addVariantMapping(LightmapperRD::class, OBJECT)
  addVariantMapping(LimitAngularVelocityModifier3D::class, OBJECT)
  addVariantMapping(Line2D::class, OBJECT)
  addVariantMapping(LineEdit::class, OBJECT)
  addVariantMapping(LinkButton::class, OBJECT)
  addVariantMapping(Logger::class, OBJECT)
  addVariantMapping(LookAtModifier3D::class, OBJECT)
  addVariantMapping(MainLoop::class, OBJECT)
  addVariantMapping(MarginContainer::class, OBJECT)
  addVariantMapping(Marker2D::class, OBJECT)
  addVariantMapping(Marker3D::class, OBJECT)
  addVariantMapping(Marshalls::class, OBJECT)
  addVariantMapping(Material::class, OBJECT)
  addVariantMapping(MenuBar::class, OBJECT)
  addVariantMapping(MenuButton::class, OBJECT)
  addVariantMapping(Mesh::class, OBJECT)
  addVariantMapping(MeshConvexDecompositionSettings::class, OBJECT)
  addVariantMapping(MeshDataTool::class, OBJECT)
  addVariantMapping(MeshInstance2D::class, OBJECT)
  addVariantMapping(MeshInstance3D::class, OBJECT)
  addVariantMapping(MeshLibrary::class, OBJECT)
  addVariantMapping(MeshTexture::class, OBJECT)
  addVariantMapping(MethodTweener::class, OBJECT)
  addVariantMapping(MissingNode::class, OBJECT)
  addVariantMapping(MissingResource::class, OBJECT)
  addVariantMapping(MobileVRInterface::class, OBJECT)
  addVariantMapping(ModifierBoneTarget3D::class, OBJECT)
  addVariantMapping(MovieWriter::class, OBJECT)
  addVariantMapping(MultiMesh::class, OBJECT)
  addVariantMapping(MultiMeshInstance2D::class, OBJECT)
  addVariantMapping(MultiMeshInstance3D::class, OBJECT)
  addVariantMapping(MultiplayerAPI::class, OBJECT)
  addVariantMapping(MultiplayerAPIExtension::class, OBJECT)
  addVariantMapping(MultiplayerPeer::class, OBJECT)
  addVariantMapping(MultiplayerPeerExtension::class, OBJECT)
  addVariantMapping(MultiplayerSpawner::class, OBJECT)
  addVariantMapping(MultiplayerSynchronizer::class, OBJECT)
  addVariantMapping(Mutex::class, OBJECT)
  addVariantMapping(NativeMenu::class, OBJECT)
  addVariantMapping(NavigationAgent2D::class, OBJECT)
  addVariantMapping(NavigationAgent3D::class, OBJECT)
  addVariantMapping(NavigationLink2D::class, OBJECT)
  addVariantMapping(NavigationLink3D::class, OBJECT)
  addVariantMapping(NavigationMesh::class, OBJECT)
  addVariantMapping(NavigationMeshGenerator::class, OBJECT)
  addVariantMapping(NavigationMeshSourceGeometryData2D::class, OBJECT)
  addVariantMapping(NavigationMeshSourceGeometryData3D::class, OBJECT)
  addVariantMapping(NavigationObstacle2D::class, OBJECT)
  addVariantMapping(NavigationObstacle3D::class, OBJECT)
  addVariantMapping(NavigationPathQueryParameters2D::class, OBJECT)
  addVariantMapping(NavigationPathQueryParameters3D::class, OBJECT)
  addVariantMapping(NavigationPathQueryResult2D::class, OBJECT)
  addVariantMapping(NavigationPathQueryResult3D::class, OBJECT)
  addVariantMapping(NavigationPolygon::class, OBJECT)
  addVariantMapping(NavigationRegion2D::class, OBJECT)
  addVariantMapping(NavigationRegion3D::class, OBJECT)
  addVariantMapping(NavigationServer2D::class, OBJECT)
  addVariantMapping(NavigationServer2DManager::class, OBJECT)
  addVariantMapping(NavigationServer3D::class, OBJECT)
  addVariantMapping(NavigationServer3DManager::class, OBJECT)
  addVariantMapping(NinePatchRect::class, OBJECT)
  addVariantMapping(Node::class, OBJECT)
  addVariantMapping(Node2D::class, OBJECT)
  addVariantMapping(Node3D::class, OBJECT)
  addVariantMapping(Node3DGizmo::class, OBJECT)
  addVariantMapping(Noise::class, OBJECT)
  addVariantMapping(NoiseTexture2D::class, OBJECT)
  addVariantMapping(NoiseTexture3D::class, OBJECT)
  addVariantMapping(ORMMaterial3D::class, OBJECT)
  addVariantMapping(OS::class, OBJECT)
  addVariantMapping(Object::class, OBJECT)
  addVariantMapping(Occluder3D::class, OBJECT)
  addVariantMapping(OccluderInstance3D::class, OBJECT)
  addVariantMapping(OccluderPolygon2D::class, OBJECT)
  addVariantMapping(OfflineMultiplayerPeer::class, OBJECT)
  addVariantMapping(OggPacketSequence::class, OBJECT)
  addVariantMapping(OggPacketSequencePlayback::class, OBJECT)
  addVariantMapping(OmniLight3D::class, OBJECT)
  addVariantMapping(OpenXRAPIExtension::class, OBJECT)
  addVariantMapping(OpenXRAction::class, OBJECT)
  addVariantMapping(OpenXRActionBindingModifier::class, OBJECT)
  addVariantMapping(OpenXRActionMap::class, OBJECT)
  addVariantMapping(OpenXRActionSet::class, OBJECT)
  addVariantMapping(OpenXRAnalogThresholdModifier::class, OBJECT)
  addVariantMapping(OpenXRAnchorTracker::class, OBJECT)
  addVariantMapping(OpenXRAndroidThreadSettingsExtension::class, OBJECT)
  addVariantMapping(OpenXRBindingModifier::class, OBJECT)
  addVariantMapping(OpenXRCompositionLayer::class, OBJECT)
  addVariantMapping(OpenXRCompositionLayerCylinder::class, OBJECT)
  addVariantMapping(OpenXRCompositionLayerEquirect::class, OBJECT)
  addVariantMapping(OpenXRCompositionLayerQuad::class, OBJECT)
  addVariantMapping(OpenXRDpadBindingModifier::class, OBJECT)
  addVariantMapping(OpenXRExtensionWrapper::class, OBJECT)
  addVariantMapping(OpenXRExtensionWrapperExtension::class, OBJECT)
  addVariantMapping(OpenXRFrameSynthesisExtension::class, OBJECT)
  addVariantMapping(OpenXRFutureExtension::class, OBJECT)
  addVariantMapping(OpenXRFutureResult::class, OBJECT)
  addVariantMapping(OpenXRHand::class, OBJECT)
  addVariantMapping(OpenXRHapticBase::class, OBJECT)
  addVariantMapping(OpenXRHapticVibration::class, OBJECT)
  addVariantMapping(OpenXRIPBinding::class, OBJECT)
  addVariantMapping(OpenXRIPBindingModifier::class, OBJECT)
  addVariantMapping(OpenXRInteractionProfile::class, OBJECT)
  addVariantMapping(OpenXRInteractionProfileMetadata::class, OBJECT)
  addVariantMapping(OpenXRInterface::class, OBJECT)
  addVariantMapping(OpenXRMarkerTracker::class, OBJECT)
  addVariantMapping(OpenXRPlaneTracker::class, OBJECT)
  addVariantMapping(OpenXRRenderModel::class, OBJECT)
  addVariantMapping(OpenXRRenderModelExtension::class, OBJECT)
  addVariantMapping(OpenXRRenderModelManager::class, OBJECT)
  addVariantMapping(OpenXRSpatialAnchorCapability::class, OBJECT)
  addVariantMapping(OpenXRSpatialCapabilityConfigurationAnchor::class, OBJECT)
  addVariantMapping(OpenXRSpatialCapabilityConfigurationAprilTag::class, OBJECT)
  addVariantMapping(OpenXRSpatialCapabilityConfigurationAruco::class, OBJECT)
  addVariantMapping(OpenXRSpatialCapabilityConfigurationBaseHeader::class, OBJECT)
  addVariantMapping(OpenXRSpatialCapabilityConfigurationMicroQrCode::class, OBJECT)
  addVariantMapping(OpenXRSpatialCapabilityConfigurationPlaneTracking::class, OBJECT)
  addVariantMapping(OpenXRSpatialCapabilityConfigurationQrCode::class, OBJECT)
  addVariantMapping(OpenXRSpatialComponentAnchorList::class, OBJECT)
  addVariantMapping(OpenXRSpatialComponentBounded2DList::class, OBJECT)
  addVariantMapping(OpenXRSpatialComponentBounded3DList::class, OBJECT)
  addVariantMapping(OpenXRSpatialComponentData::class, OBJECT)
  addVariantMapping(OpenXRSpatialComponentMarkerList::class, OBJECT)
  addVariantMapping(OpenXRSpatialComponentMesh2DList::class, OBJECT)
  addVariantMapping(OpenXRSpatialComponentMesh3DList::class, OBJECT)
  addVariantMapping(OpenXRSpatialComponentParentList::class, OBJECT)
  addVariantMapping(OpenXRSpatialComponentPersistenceList::class, OBJECT)
  addVariantMapping(OpenXRSpatialComponentPlaneAlignmentList::class, OBJECT)
  addVariantMapping(OpenXRSpatialComponentPlaneSemanticLabelList::class, OBJECT)
  addVariantMapping(OpenXRSpatialComponentPolygon2DList::class, OBJECT)
  addVariantMapping(OpenXRSpatialContextPersistenceConfig::class, OBJECT)
  addVariantMapping(OpenXRSpatialEntityExtension::class, OBJECT)
  addVariantMapping(OpenXRSpatialEntityTracker::class, OBJECT)
  addVariantMapping(OpenXRSpatialMarkerTrackingCapability::class, OBJECT)
  addVariantMapping(OpenXRSpatialPlaneTrackingCapability::class, OBJECT)
  addVariantMapping(OpenXRSpatialQueryResultData::class, OBJECT)
  addVariantMapping(OpenXRStructureBase::class, OBJECT)
  addVariantMapping(OpenXRVisibilityMask::class, OBJECT)
  addVariantMapping(OptimizedTranslation::class, OBJECT)
  addVariantMapping(OptionButton::class, OBJECT)
  addVariantMapping(PCKPacker::class, OBJECT)
  addVariantMapping(PackedDataContainer::class, OBJECT)
  addVariantMapping(PackedDataContainerRef::class, OBJECT)
  addVariantMapping(PackedScene::class, OBJECT)
  addVariantMapping(PacketPeer::class, OBJECT)
  addVariantMapping(PacketPeerDTLS::class, OBJECT)
  addVariantMapping(PacketPeerExtension::class, OBJECT)
  addVariantMapping(PacketPeerStream::class, OBJECT)
  addVariantMapping(PacketPeerUDP::class, OBJECT)
  addVariantMapping(Panel::class, OBJECT)
  addVariantMapping(PanelContainer::class, OBJECT)
  addVariantMapping(PanoramaSkyMaterial::class, OBJECT)
  addVariantMapping(Parallax2D::class, OBJECT)
  addVariantMapping(ParallaxBackground::class, OBJECT)
  addVariantMapping(ParallaxLayer::class, OBJECT)
  addVariantMapping(ParticleProcessMaterial::class, OBJECT)
  addVariantMapping(Path2D::class, OBJECT)
  addVariantMapping(Path3D::class, OBJECT)
  addVariantMapping(PathFollow2D::class, OBJECT)
  addVariantMapping(PathFollow3D::class, OBJECT)
  addVariantMapping(Performance::class, OBJECT)
  addVariantMapping(PhysicalBone2D::class, OBJECT)
  addVariantMapping(PhysicalBone3D::class, OBJECT)
  addVariantMapping(PhysicalBoneSimulator3D::class, OBJECT)
  addVariantMapping(PhysicalSkyMaterial::class, OBJECT)
  addVariantMapping(PhysicsBody2D::class, OBJECT)
  addVariantMapping(PhysicsBody3D::class, OBJECT)
  addVariantMapping(PhysicsDirectBodyState2D::class, OBJECT)
  addVariantMapping(PhysicsDirectBodyState2DExtension::class, OBJECT)
  addVariantMapping(PhysicsDirectBodyState3D::class, OBJECT)
  addVariantMapping(PhysicsDirectBodyState3DExtension::class, OBJECT)
  addVariantMapping(PhysicsDirectSpaceState2D::class, OBJECT)
  addVariantMapping(PhysicsDirectSpaceState2DExtension::class, OBJECT)
  addVariantMapping(PhysicsDirectSpaceState3D::class, OBJECT)
  addVariantMapping(PhysicsDirectSpaceState3DExtension::class, OBJECT)
  addVariantMapping(PhysicsMaterial::class, OBJECT)
  addVariantMapping(PhysicsPointQueryParameters2D::class, OBJECT)
  addVariantMapping(PhysicsPointQueryParameters3D::class, OBJECT)
  addVariantMapping(PhysicsRayQueryParameters2D::class, OBJECT)
  addVariantMapping(PhysicsRayQueryParameters3D::class, OBJECT)
  addVariantMapping(PhysicsServer2D::class, OBJECT)
  addVariantMapping(PhysicsServer2DManager::class, OBJECT)
  addVariantMapping(PhysicsServer3D::class, OBJECT)
  addVariantMapping(PhysicsServer3DManager::class, OBJECT)
  addVariantMapping(PhysicsServer3DRenderingServerHandler::class, OBJECT)
  addVariantMapping(PhysicsShapeQueryParameters2D::class, OBJECT)
  addVariantMapping(PhysicsShapeQueryParameters3D::class, OBJECT)
  addVariantMapping(PhysicsTestMotionParameters2D::class, OBJECT)
  addVariantMapping(PhysicsTestMotionParameters3D::class, OBJECT)
  addVariantMapping(PhysicsTestMotionResult2D::class, OBJECT)
  addVariantMapping(PhysicsTestMotionResult3D::class, OBJECT)
  addVariantMapping(PinJoint2D::class, OBJECT)
  addVariantMapping(PinJoint3D::class, OBJECT)
  addVariantMapping(PlaceholderCubemap::class, OBJECT)
  addVariantMapping(PlaceholderCubemapArray::class, OBJECT)
  addVariantMapping(PlaceholderMaterial::class, OBJECT)
  addVariantMapping(PlaceholderMesh::class, OBJECT)
  addVariantMapping(PlaceholderTexture2D::class, OBJECT)
  addVariantMapping(PlaceholderTexture2DArray::class, OBJECT)
  addVariantMapping(PlaceholderTexture3D::class, OBJECT)
  addVariantMapping(PlaceholderTextureLayered::class, OBJECT)
  addVariantMapping(PlaneMesh::class, OBJECT)
  addVariantMapping(PointLight2D::class, OBJECT)
  addVariantMapping(PointMesh::class, OBJECT)
  addVariantMapping(Polygon2D::class, OBJECT)
  addVariantMapping(PolygonOccluder3D::class, OBJECT)
  addVariantMapping(PolygonPathFinder::class, OBJECT)
  addVariantMapping(Popup::class, OBJECT)
  addVariantMapping(PopupMenu::class, OBJECT)
  addVariantMapping(PopupPanel::class, OBJECT)
  addVariantMapping(PortableCompressedTexture2D::class, OBJECT)
  addVariantMapping(PrimitiveMesh::class, OBJECT)
  addVariantMapping(PrismMesh::class, OBJECT)
  addVariantMapping(ProceduralSkyMaterial::class, OBJECT)
  addVariantMapping(ProgressBar::class, OBJECT)
  addVariantMapping(ProjectSettings::class, OBJECT)
  addVariantMapping(PropertyTweener::class, OBJECT)
  addVariantMapping(QuadMesh::class, OBJECT)
  addVariantMapping(QuadOccluder3D::class, OBJECT)
  addVariantMapping(RDAccelerationStructureGeometry::class, OBJECT)
  addVariantMapping(RDAccelerationStructureInstance::class, OBJECT)
  addVariantMapping(RDAttachmentFormat::class, OBJECT)
  addVariantMapping(RDFramebufferPass::class, OBJECT)
  addVariantMapping(RDHitGroup::class, OBJECT)
  addVariantMapping(RDPipelineColorBlendState::class, OBJECT)
  addVariantMapping(RDPipelineColorBlendStateAttachment::class, OBJECT)
  addVariantMapping(RDPipelineDepthStencilState::class, OBJECT)
  addVariantMapping(RDPipelineMultisampleState::class, OBJECT)
  addVariantMapping(RDPipelineRasterizationState::class, OBJECT)
  addVariantMapping(RDPipelineShader::class, OBJECT)
  addVariantMapping(RDPipelineSpecializationConstant::class, OBJECT)
  addVariantMapping(RDSamplerState::class, OBJECT)
  addVariantMapping(RDShaderFile::class, OBJECT)
  addVariantMapping(RDShaderSPIRV::class, OBJECT)
  addVariantMapping(RDShaderSource::class, OBJECT)
  addVariantMapping(RDTextureFormat::class, OBJECT)
  addVariantMapping(RDTextureView::class, OBJECT)
  addVariantMapping(RDUniform::class, OBJECT)
  addVariantMapping(RDVertexAttribute::class, OBJECT)
  addVariantMapping(RandomNumberGenerator::class, OBJECT)
  addVariantMapping(Range::class, OBJECT)
  addVariantMapping(RayCast2D::class, OBJECT)
  addVariantMapping(RayCast3D::class, OBJECT)
  addVariantMapping(RectangleShape2D::class, OBJECT)
  addVariantMapping(RefCounted::class, OBJECT)
  addVariantMapping(ReferenceRect::class, OBJECT)
  addVariantMapping(ReflectionProbe::class, OBJECT)
  addVariantMapping(RegEx::class, OBJECT)
  addVariantMapping(RegExMatch::class, OBJECT)
  addVariantMapping(RemoteTransform2D::class, OBJECT)
  addVariantMapping(RemoteTransform3D::class, OBJECT)
  addVariantMapping(RenderData::class, OBJECT)
  addVariantMapping(RenderDataExtension::class, OBJECT)
  addVariantMapping(RenderDataRD::class, OBJECT)
  addVariantMapping(RenderSceneBuffers::class, OBJECT)
  addVariantMapping(RenderSceneBuffersConfiguration::class, OBJECT)
  addVariantMapping(RenderSceneBuffersExtension::class, OBJECT)
  addVariantMapping(RenderSceneBuffersRD::class, OBJECT)
  addVariantMapping(RenderSceneData::class, OBJECT)
  addVariantMapping(RenderSceneDataExtension::class, OBJECT)
  addVariantMapping(RenderSceneDataRD::class, OBJECT)
  addVariantMapping(RenderingDevice::class, OBJECT)
  addVariantMapping(RenderingServer::class, OBJECT)
  addVariantMapping(Resource::class, OBJECT)
  addVariantMapping(ResourceFormatLoader::class, OBJECT)
  addVariantMapping(ResourceFormatSaver::class, OBJECT)
  addVariantMapping(ResourceImporter::class, OBJECT)
  addVariantMapping(ResourceLoader::class, OBJECT)
  addVariantMapping(ResourcePreloader::class, OBJECT)
  addVariantMapping(ResourceSaver::class, OBJECT)
  addVariantMapping(ResourceUID::class, OBJECT)
  addVariantMapping(RetargetModifier3D::class, OBJECT)
  addVariantMapping(RibbonTrailMesh::class, OBJECT)
  addVariantMapping(RichTextEffect::class, OBJECT)
  addVariantMapping(RichTextLabel::class, OBJECT)
  addVariantMapping(RigidBody2D::class, OBJECT)
  addVariantMapping(RigidBody3D::class, OBJECT)
  addVariantMapping(RootMotionView::class, OBJECT)
  addVariantMapping(ScalaScript::class, OBJECT)
  addVariantMapping(SceneMultiplayer::class, OBJECT)
  addVariantMapping(SceneReplicationConfig::class, OBJECT)
  addVariantMapping(SceneState::class, OBJECT)
  addVariantMapping(SceneTree::class, OBJECT)
  addVariantMapping(SceneTreeTimer::class, OBJECT)
  addVariantMapping(Script::class, OBJECT)
  addVariantMapping(ScriptBacktrace::class, OBJECT)
  addVariantMapping(ScriptExtension::class, OBJECT)
  addVariantMapping(ScriptLanguage::class, OBJECT)
  addVariantMapping(ScriptLanguageExtension::class, OBJECT)
  addVariantMapping(ScrollBar::class, OBJECT)
  addVariantMapping(ScrollContainer::class, OBJECT)
  addVariantMapping(SegmentShape2D::class, OBJECT)
  addVariantMapping(Semaphore::class, OBJECT)
  addVariantMapping(SeparationRayShape2D::class, OBJECT)
  addVariantMapping(SeparationRayShape3D::class, OBJECT)
  addVariantMapping(Separator::class, OBJECT)
  addVariantMapping(Shader::class, OBJECT)
  addVariantMapping(ShaderGlobalsOverride::class, OBJECT)
  addVariantMapping(ShaderInclude::class, OBJECT)
  addVariantMapping(ShaderIncludeDB::class, OBJECT)
  addVariantMapping(ShaderMaterial::class, OBJECT)
  addVariantMapping(Shape2D::class, OBJECT)
  addVariantMapping(Shape3D::class, OBJECT)
  addVariantMapping(ShapeCast2D::class, OBJECT)
  addVariantMapping(ShapeCast3D::class, OBJECT)
  addVariantMapping(Shortcut::class, OBJECT)
  addVariantMapping(Skeleton2D::class, OBJECT)
  addVariantMapping(Skeleton3D::class, OBJECT)
  addVariantMapping(SkeletonIK3D::class, OBJECT)
  addVariantMapping(SkeletonModification2D::class, OBJECT)
  addVariantMapping(SkeletonModification2DCCDIK::class, OBJECT)
  addVariantMapping(SkeletonModification2DFABRIK::class, OBJECT)
  addVariantMapping(SkeletonModification2DJiggle::class, OBJECT)
  addVariantMapping(SkeletonModification2DLookAt::class, OBJECT)
  addVariantMapping(SkeletonModification2DPhysicalBones::class, OBJECT)
  addVariantMapping(SkeletonModification2DStackHolder::class, OBJECT)
  addVariantMapping(SkeletonModification2DTwoBoneIK::class, OBJECT)
  addVariantMapping(SkeletonModificationStack2D::class, OBJECT)
  addVariantMapping(SkeletonModifier3D::class, OBJECT)
  addVariantMapping(SkeletonProfile::class, OBJECT)
  addVariantMapping(SkeletonProfileHumanoid::class, OBJECT)
  addVariantMapping(Skin::class, OBJECT)
  addVariantMapping(SkinReference::class, OBJECT)
  addVariantMapping(Sky::class, OBJECT)
  addVariantMapping(Slider::class, OBJECT)
  addVariantMapping(SliderJoint3D::class, OBJECT)
  addVariantMapping(SocketServer::class, OBJECT)
  addVariantMapping(SoftBody3D::class, OBJECT)
  addVariantMapping(SphereMesh::class, OBJECT)
  addVariantMapping(SphereOccluder3D::class, OBJECT)
  addVariantMapping(SphereShape3D::class, OBJECT)
  addVariantMapping(SpinBox::class, OBJECT)
  addVariantMapping(SplineIK3D::class, OBJECT)
  addVariantMapping(SplitContainer::class, OBJECT)
  addVariantMapping(SpotLight3D::class, OBJECT)
  addVariantMapping(SpringArm3D::class, OBJECT)
  addVariantMapping(SpringBoneCollision3D::class, OBJECT)
  addVariantMapping(SpringBoneCollisionCapsule3D::class, OBJECT)
  addVariantMapping(SpringBoneCollisionPlane3D::class, OBJECT)
  addVariantMapping(SpringBoneCollisionSphere3D::class, OBJECT)
  addVariantMapping(SpringBoneSimulator3D::class, OBJECT)
  addVariantMapping(Sprite2D::class, OBJECT)
  addVariantMapping(Sprite3D::class, OBJECT)
  addVariantMapping(SpriteBase3D::class, OBJECT)
  addVariantMapping(SpriteFrames::class, OBJECT)
  addVariantMapping(StandardMaterial3D::class, OBJECT)
  addVariantMapping(StaticBody2D::class, OBJECT)
  addVariantMapping(StaticBody3D::class, OBJECT)
  addVariantMapping(StatusIndicator::class, OBJECT)
  addVariantMapping(StreamPeer::class, OBJECT)
  addVariantMapping(StreamPeerBuffer::class, OBJECT)
  addVariantMapping(StreamPeerExtension::class, OBJECT)
  addVariantMapping(StreamPeerGZIP::class, OBJECT)
  addVariantMapping(StreamPeerSocket::class, OBJECT)
  addVariantMapping(StreamPeerTCP::class, OBJECT)
  addVariantMapping(StreamPeerTLS::class, OBJECT)
  addVariantMapping(StreamPeerUDS::class, OBJECT)
  addVariantMapping(StyleBox::class, OBJECT)
  addVariantMapping(StyleBoxEmpty::class, OBJECT)
  addVariantMapping(StyleBoxFlat::class, OBJECT)
  addVariantMapping(StyleBoxLine::class, OBJECT)
  addVariantMapping(StyleBoxTexture::class, OBJECT)
  addVariantMapping(SubViewport::class, OBJECT)
  addVariantMapping(SubViewportContainer::class, OBJECT)
  addVariantMapping(SubtweenTweener::class, OBJECT)
  addVariantMapping(SurfaceTool::class, OBJECT)
  addVariantMapping(SyntaxHighlighter::class, OBJECT)
  addVariantMapping(SystemFont::class, OBJECT)
  addVariantMapping(TCPServer::class, OBJECT)
  addVariantMapping(TLSOptions::class, OBJECT)
  addVariantMapping(TabBar::class, OBJECT)
  addVariantMapping(TabContainer::class, OBJECT)
  addVariantMapping(TextEdit::class, OBJECT)
  addVariantMapping(TextLine::class, OBJECT)
  addVariantMapping(TextMesh::class, OBJECT)
  addVariantMapping(TextParagraph::class, OBJECT)
  addVariantMapping(TextServer::class, OBJECT)
  addVariantMapping(TextServerAdvanced::class, OBJECT)
  addVariantMapping(TextServerDummy::class, OBJECT)
  addVariantMapping(TextServerExtension::class, OBJECT)
  addVariantMapping(TextServerManager::class, OBJECT)
  addVariantMapping(Texture::class, OBJECT)
  addVariantMapping(Texture2D::class, OBJECT)
  addVariantMapping(Texture2DArray::class, OBJECT)
  addVariantMapping(Texture2DArrayRD::class, OBJECT)
  addVariantMapping(Texture2DRD::class, OBJECT)
  addVariantMapping(Texture3D::class, OBJECT)
  addVariantMapping(Texture3DRD::class, OBJECT)
  addVariantMapping(TextureButton::class, OBJECT)
  addVariantMapping(TextureCubemapArrayRD::class, OBJECT)
  addVariantMapping(TextureCubemapRD::class, OBJECT)
  addVariantMapping(TextureLayered::class, OBJECT)
  addVariantMapping(TextureLayeredRD::class, OBJECT)
  addVariantMapping(TextureProgressBar::class, OBJECT)
  addVariantMapping(TextureRect::class, OBJECT)
  addVariantMapping(Theme::class, OBJECT)
  addVariantMapping(ThemeDB::class, OBJECT)
  addVariantMapping(Thread::class, OBJECT)
  addVariantMapping(TileData::class, OBJECT)
  addVariantMapping(TileMap::class, OBJECT)
  addVariantMapping(TileMapLayer::class, OBJECT)
  addVariantMapping(TileMapPattern::class, OBJECT)
  addVariantMapping(TileSet::class, OBJECT)
  addVariantMapping(TileSetAtlasSource::class, OBJECT)
  addVariantMapping(TileSetScenesCollectionSource::class, OBJECT)
  addVariantMapping(TileSetSource::class, OBJECT)
  addVariantMapping(Time::class, OBJECT)
  addVariantMapping(Timer::class, OBJECT)
  addVariantMapping(TorusMesh::class, OBJECT)
  addVariantMapping(TouchScreenButton::class, OBJECT)
  addVariantMapping(Translation::class, OBJECT)
  addVariantMapping(TranslationDomain::class, OBJECT)
  addVariantMapping(TranslationServer::class, OBJECT)
  addVariantMapping(Tree::class, OBJECT)
  addVariantMapping(TreeItem::class, OBJECT)
  addVariantMapping(TriangleMesh::class, OBJECT)
  addVariantMapping(TubeTrailMesh::class, OBJECT)
  addVariantMapping(Tween::class, OBJECT)
  addVariantMapping(Tweener::class, OBJECT)
  addVariantMapping(TwoBoneIK3D::class, OBJECT)
  addVariantMapping(UDPServer::class, OBJECT)
  addVariantMapping(UDSServer::class, OBJECT)
  addVariantMapping(UPNP::class, OBJECT)
  addVariantMapping(UPNPDevice::class, OBJECT)
  addVariantMapping(UndoRedo::class, OBJECT)
  addVariantMapping(UniformSetCacheRD::class, OBJECT)
  addVariantMapping(VBoxContainer::class, OBJECT)
  addVariantMapping(VFlowContainer::class, OBJECT)
  addVariantMapping(VScrollBar::class, OBJECT)
  addVariantMapping(VSeparator::class, OBJECT)
  addVariantMapping(VSlider::class, OBJECT)
  addVariantMapping(VSplitContainer::class, OBJECT)
  addVariantMapping(VehicleBody3D::class, OBJECT)
  addVariantMapping(VehicleWheel3D::class, OBJECT)
  addVariantMapping(VideoStream::class, OBJECT)
  addVariantMapping(VideoStreamPlayback::class, OBJECT)
  addVariantMapping(VideoStreamPlayer::class, OBJECT)
  addVariantMapping(VideoStreamTheora::class, OBJECT)
  addVariantMapping(Viewport::class, OBJECT)
  addVariantMapping(ViewportTexture::class, OBJECT)
  addVariantMapping(VirtualJoystick::class, OBJECT)
  addVariantMapping(VisibleOnScreenEnabler2D::class, OBJECT)
  addVariantMapping(VisibleOnScreenEnabler3D::class, OBJECT)
  addVariantMapping(VisibleOnScreenNotifier2D::class, OBJECT)
  addVariantMapping(VisibleOnScreenNotifier3D::class, OBJECT)
  addVariantMapping(VisualInstance3D::class, OBJECT)
  addVariantMapping(VisualShader::class, OBJECT)
  addVariantMapping(VisualShaderNode::class, OBJECT)
  addVariantMapping(VisualShaderNodeBillboard::class, OBJECT)
  addVariantMapping(VisualShaderNodeBooleanConstant::class, OBJECT)
  addVariantMapping(VisualShaderNodeBooleanParameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeClamp::class, OBJECT)
  addVariantMapping(VisualShaderNodeColorConstant::class, OBJECT)
  addVariantMapping(VisualShaderNodeColorFunc::class, OBJECT)
  addVariantMapping(VisualShaderNodeColorOp::class, OBJECT)
  addVariantMapping(VisualShaderNodeColorParameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeComment::class, OBJECT)
  addVariantMapping(VisualShaderNodeCompare::class, OBJECT)
  addVariantMapping(VisualShaderNodeConstant::class, OBJECT)
  addVariantMapping(VisualShaderNodeCubemap::class, OBJECT)
  addVariantMapping(VisualShaderNodeCubemapParameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeCurveTexture::class, OBJECT)
  addVariantMapping(VisualShaderNodeCurveXYZTexture::class, OBJECT)
  addVariantMapping(VisualShaderNodeCustom::class, OBJECT)
  addVariantMapping(VisualShaderNodeDerivativeFunc::class, OBJECT)
  addVariantMapping(VisualShaderNodeDeterminant::class, OBJECT)
  addVariantMapping(VisualShaderNodeDistanceFade::class, OBJECT)
  addVariantMapping(VisualShaderNodeDotProduct::class, OBJECT)
  addVariantMapping(VisualShaderNodeExpression::class, OBJECT)
  addVariantMapping(VisualShaderNodeFaceForward::class, OBJECT)
  addVariantMapping(VisualShaderNodeFloatConstant::class, OBJECT)
  addVariantMapping(VisualShaderNodeFloatFunc::class, OBJECT)
  addVariantMapping(VisualShaderNodeFloatOp::class, OBJECT)
  addVariantMapping(VisualShaderNodeFloatParameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeFrame::class, OBJECT)
  addVariantMapping(VisualShaderNodeFresnel::class, OBJECT)
  addVariantMapping(VisualShaderNodeGlobalExpression::class, OBJECT)
  addVariantMapping(VisualShaderNodeGroupBase::class, OBJECT)
  addVariantMapping(VisualShaderNodeIf::class, OBJECT)
  addVariantMapping(VisualShaderNodeInput::class, OBJECT)
  addVariantMapping(VisualShaderNodeIntConstant::class, OBJECT)
  addVariantMapping(VisualShaderNodeIntFunc::class, OBJECT)
  addVariantMapping(VisualShaderNodeIntOp::class, OBJECT)
  addVariantMapping(VisualShaderNodeIntParameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeIs::class, OBJECT)
  addVariantMapping(VisualShaderNodeLinearSceneDepth::class, OBJECT)
  addVariantMapping(VisualShaderNodeMix::class, OBJECT)
  addVariantMapping(VisualShaderNodeMultiplyAdd::class, OBJECT)
  addVariantMapping(VisualShaderNodeOuterProduct::class, OBJECT)
  addVariantMapping(VisualShaderNodeOutput::class, OBJECT)
  addVariantMapping(VisualShaderNodeParameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeParameterRef::class, OBJECT)
  addVariantMapping(VisualShaderNodeParticleAccelerator::class, OBJECT)
  addVariantMapping(VisualShaderNodeParticleBoxEmitter::class, OBJECT)
  addVariantMapping(VisualShaderNodeParticleConeVelocity::class, OBJECT)
  addVariantMapping(VisualShaderNodeParticleEmit::class, OBJECT)
  addVariantMapping(VisualShaderNodeParticleEmitter::class, OBJECT)
  addVariantMapping(VisualShaderNodeParticleMeshEmitter::class, OBJECT)
  addVariantMapping(VisualShaderNodeParticleMultiplyByAxisAngle::class, OBJECT)
  addVariantMapping(VisualShaderNodeParticleOutput::class, OBJECT)
  addVariantMapping(VisualShaderNodeParticleRandomness::class, OBJECT)
  addVariantMapping(VisualShaderNodeParticleRingEmitter::class, OBJECT)
  addVariantMapping(VisualShaderNodeParticleSphereEmitter::class, OBJECT)
  addVariantMapping(VisualShaderNodeProximityFade::class, OBJECT)
  addVariantMapping(VisualShaderNodeRandomRange::class, OBJECT)
  addVariantMapping(VisualShaderNodeRemap::class, OBJECT)
  addVariantMapping(VisualShaderNodeReroute::class, OBJECT)
  addVariantMapping(VisualShaderNodeResizableBase::class, OBJECT)
  addVariantMapping(VisualShaderNodeRotationByAxis::class, OBJECT)
  addVariantMapping(VisualShaderNodeSDFRaymarch::class, OBJECT)
  addVariantMapping(VisualShaderNodeSDFToScreenUV::class, OBJECT)
  addVariantMapping(VisualShaderNodeSample3D::class, OBJECT)
  addVariantMapping(VisualShaderNodeScreenNormalWorldSpace::class, OBJECT)
  addVariantMapping(VisualShaderNodeScreenUVToSDF::class, OBJECT)
  addVariantMapping(VisualShaderNodeSmoothStep::class, OBJECT)
  addVariantMapping(VisualShaderNodeStep::class, OBJECT)
  addVariantMapping(VisualShaderNodeSwitch::class, OBJECT)
  addVariantMapping(VisualShaderNodeTexture::class, OBJECT)
  addVariantMapping(VisualShaderNodeTexture2DArray::class, OBJECT)
  addVariantMapping(VisualShaderNodeTexture2DArrayParameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeTexture2DParameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeTexture3D::class, OBJECT)
  addVariantMapping(VisualShaderNodeTexture3DParameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeTextureParameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeTextureParameterTriplanar::class, OBJECT)
  addVariantMapping(VisualShaderNodeTextureSDF::class, OBJECT)
  addVariantMapping(VisualShaderNodeTextureSDFNormal::class, OBJECT)
  addVariantMapping(VisualShaderNodeTransformCompose::class, OBJECT)
  addVariantMapping(VisualShaderNodeTransformConstant::class, OBJECT)
  addVariantMapping(VisualShaderNodeTransformDecompose::class, OBJECT)
  addVariantMapping(VisualShaderNodeTransformFunc::class, OBJECT)
  addVariantMapping(VisualShaderNodeTransformOp::class, OBJECT)
  addVariantMapping(VisualShaderNodeTransformParameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeTransformVecMult::class, OBJECT)
  addVariantMapping(VisualShaderNodeUIntConstant::class, OBJECT)
  addVariantMapping(VisualShaderNodeUIntFunc::class, OBJECT)
  addVariantMapping(VisualShaderNodeUIntOp::class, OBJECT)
  addVariantMapping(VisualShaderNodeUIntParameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeUVFunc::class, OBJECT)
  addVariantMapping(VisualShaderNodeUVPolarCoord::class, OBJECT)
  addVariantMapping(VisualShaderNodeVarying::class, OBJECT)
  addVariantMapping(VisualShaderNodeVaryingGetter::class, OBJECT)
  addVariantMapping(VisualShaderNodeVaryingSetter::class, OBJECT)
  addVariantMapping(VisualShaderNodeVec2Constant::class, OBJECT)
  addVariantMapping(VisualShaderNodeVec2Parameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeVec3Constant::class, OBJECT)
  addVariantMapping(VisualShaderNodeVec3Parameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeVec4Constant::class, OBJECT)
  addVariantMapping(VisualShaderNodeVec4Parameter::class, OBJECT)
  addVariantMapping(VisualShaderNodeVectorBase::class, OBJECT)
  addVariantMapping(VisualShaderNodeVectorCompose::class, OBJECT)
  addVariantMapping(VisualShaderNodeVectorDecompose::class, OBJECT)
  addVariantMapping(VisualShaderNodeVectorDistance::class, OBJECT)
  addVariantMapping(VisualShaderNodeVectorFunc::class, OBJECT)
  addVariantMapping(VisualShaderNodeVectorLen::class, OBJECT)
  addVariantMapping(VisualShaderNodeVectorOp::class, OBJECT)
  addVariantMapping(VisualShaderNodeVectorRefract::class, OBJECT)
  addVariantMapping(VisualShaderNodeWorldPositionFromDepth::class, OBJECT)
  addVariantMapping(VoxelGI::class, OBJECT)
  addVariantMapping(VoxelGIData::class, OBJECT)
  addVariantMapping(WeakRef::class, OBJECT)
  addVariantMapping(WebRTCDataChannel::class, OBJECT)
  addVariantMapping(WebRTCDataChannelExtension::class, OBJECT)
  addVariantMapping(WebRTCMultiplayerPeer::class, OBJECT)
  addVariantMapping(WebRTCPeerConnection::class, OBJECT)
  addVariantMapping(WebRTCPeerConnectionExtension::class, OBJECT)
  addVariantMapping(WebSocketMultiplayerPeer::class, OBJECT)
  addVariantMapping(WebSocketPeer::class, OBJECT)
  addVariantMapping(WebXRInterface::class, OBJECT)
  addVariantMapping(Window::class, OBJECT)
  addVariantMapping(WorkerThreadPool::class, OBJECT)
  addVariantMapping(World2D::class, OBJECT)
  addVariantMapping(World3D::class, OBJECT)
  addVariantMapping(WorldBoundaryShape2D::class, OBJECT)
  addVariantMapping(WorldBoundaryShape3D::class, OBJECT)
  addVariantMapping(WorldEnvironment::class, OBJECT)
  addVariantMapping(X509Certificate::class, OBJECT)
  addVariantMapping(XMLParser::class, OBJECT)
  addVariantMapping(XRAnchor3D::class, OBJECT)
  addVariantMapping(XRBodyModifier3D::class, OBJECT)
  addVariantMapping(XRBodyTracker::class, OBJECT)
  addVariantMapping(XRCamera3D::class, OBJECT)
  addVariantMapping(XRController3D::class, OBJECT)
  addVariantMapping(XRControllerTracker::class, OBJECT)
  addVariantMapping(XRFaceModifier3D::class, OBJECT)
  addVariantMapping(XRFaceTracker::class, OBJECT)
  addVariantMapping(XRHandModifier3D::class, OBJECT)
  addVariantMapping(XRHandTracker::class, OBJECT)
  addVariantMapping(XRInterface::class, OBJECT)
  addVariantMapping(XRInterfaceExtension::class, OBJECT)
  addVariantMapping(XRNode3D::class, OBJECT)
  addVariantMapping(XROrigin3D::class, OBJECT)
  addVariantMapping(XRPose::class, OBJECT)
  addVariantMapping(XRPositionalTracker::class, OBJECT)
  addVariantMapping(XRServer::class, OBJECT)
  addVariantMapping(XRTracker::class, OBJECT)
  addVariantMapping(XRVRS::class, OBJECT)
  addVariantMapping(ZIPPacker::class, OBJECT)
  addVariantMapping(ZIPReader::class, OBJECT)
}

public fun warmEngineTypes(): Unit {
  Class.forName(AESContext::class.java.name, true, AESContext::class.java.classLoader)
  AESContext.MethodBindings
  Class.forName(AStar2D::class.java.name, true, AStar2D::class.java.classLoader)
  AStar2D.MethodBindings
  Class.forName(AStar3D::class.java.name, true, AStar3D::class.java.classLoader)
  AStar3D.MethodBindings
  Class.forName(AStarGrid2D::class.java.name, true, AStarGrid2D::class.java.classLoader)
  AStarGrid2D.MethodBindings
  Class.forName(AcceptDialog::class.java.name, true, AcceptDialog::class.java.classLoader)
  AcceptDialog.MethodBindings
  Class.forName(AccessibilityServer::class.java.name, true, AccessibilityServer::class.java.classLoader)
  AccessibilityServer.MethodBindings
  Class.forName(AimModifier3D::class.java.name, true, AimModifier3D::class.java.classLoader)
  AimModifier3D.MethodBindings
  Class.forName(AnimatableBody2D::class.java.name, true, AnimatableBody2D::class.java.classLoader)
  AnimatableBody2D.MethodBindings
  Class.forName(AnimatableBody3D::class.java.name, true, AnimatableBody3D::class.java.classLoader)
  AnimatableBody3D.MethodBindings
  Class.forName(AnimatedSprite2D::class.java.name, true, AnimatedSprite2D::class.java.classLoader)
  AnimatedSprite2D.MethodBindings
  Class.forName(AnimatedSprite3D::class.java.name, true, AnimatedSprite3D::class.java.classLoader)
  AnimatedSprite3D.MethodBindings
  Class.forName(AnimatedTexture::class.java.name, true, AnimatedTexture::class.java.classLoader)
  AnimatedTexture.MethodBindings
  Class.forName(Animation::class.java.name, true, Animation::class.java.classLoader)
  Animation.MethodBindings
  Class.forName(AnimationLibrary::class.java.name, true, AnimationLibrary::class.java.classLoader)
  AnimationLibrary.MethodBindings
  Class.forName(AnimationMixer::class.java.name, true, AnimationMixer::class.java.classLoader)
  AnimationMixer.MethodBindings
  Class.forName(AnimationNode::class.java.name, true, AnimationNode::class.java.classLoader)
  AnimationNode.MethodBindings
  Class.forName(AnimationNodeAdd2::class.java.name, true, AnimationNodeAdd2::class.java.classLoader)
  AnimationNodeAdd2.MethodBindings
  Class.forName(AnimationNodeAdd3::class.java.name, true, AnimationNodeAdd3::class.java.classLoader)
  AnimationNodeAdd3.MethodBindings
  Class.forName(AnimationNodeAnimation::class.java.name, true, AnimationNodeAnimation::class.java.classLoader)
  AnimationNodeAnimation.MethodBindings
  Class.forName(AnimationNodeBlend2::class.java.name, true, AnimationNodeBlend2::class.java.classLoader)
  AnimationNodeBlend2.MethodBindings
  Class.forName(AnimationNodeBlend3::class.java.name, true, AnimationNodeBlend3::class.java.classLoader)
  AnimationNodeBlend3.MethodBindings
  Class.forName(AnimationNodeBlendSpace1D::class.java.name, true, AnimationNodeBlendSpace1D::class.java.classLoader)
  AnimationNodeBlendSpace1D.MethodBindings
  Class.forName(AnimationNodeBlendSpace2D::class.java.name, true, AnimationNodeBlendSpace2D::class.java.classLoader)
  AnimationNodeBlendSpace2D.MethodBindings
  Class.forName(AnimationNodeBlendTree::class.java.name, true, AnimationNodeBlendTree::class.java.classLoader)
  AnimationNodeBlendTree.MethodBindings
  Class.forName(AnimationNodeExtension::class.java.name, true, AnimationNodeExtension::class.java.classLoader)
  AnimationNodeExtension.MethodBindings
  Class.forName(AnimationNodeOneShot::class.java.name, true, AnimationNodeOneShot::class.java.classLoader)
  AnimationNodeOneShot.MethodBindings
  Class.forName(AnimationNodeOutput::class.java.name, true, AnimationNodeOutput::class.java.classLoader)
  AnimationNodeOutput.MethodBindings
  Class.forName(AnimationNodeStateMachine::class.java.name, true, AnimationNodeStateMachine::class.java.classLoader)
  AnimationNodeStateMachine.MethodBindings
  Class.forName(AnimationNodeStateMachinePlayback::class.java.name, true, AnimationNodeStateMachinePlayback::class.java.classLoader)
  AnimationNodeStateMachinePlayback.MethodBindings
  Class.forName(AnimationNodeStateMachineTransition::class.java.name, true, AnimationNodeStateMachineTransition::class.java.classLoader)
  AnimationNodeStateMachineTransition.MethodBindings
  Class.forName(AnimationNodeSub2::class.java.name, true, AnimationNodeSub2::class.java.classLoader)
  AnimationNodeSub2.MethodBindings
  Class.forName(AnimationNodeSync::class.java.name, true, AnimationNodeSync::class.java.classLoader)
  AnimationNodeSync.MethodBindings
  Class.forName(AnimationNodeTimeScale::class.java.name, true, AnimationNodeTimeScale::class.java.classLoader)
  AnimationNodeTimeScale.MethodBindings
  Class.forName(AnimationNodeTimeSeek::class.java.name, true, AnimationNodeTimeSeek::class.java.classLoader)
  AnimationNodeTimeSeek.MethodBindings
  Class.forName(AnimationNodeTransition::class.java.name, true, AnimationNodeTransition::class.java.classLoader)
  AnimationNodeTransition.MethodBindings
  Class.forName(AnimationPlayer::class.java.name, true, AnimationPlayer::class.java.classLoader)
  AnimationPlayer.MethodBindings
  Class.forName(AnimationRootNode::class.java.name, true, AnimationRootNode::class.java.classLoader)
  AnimationRootNode.MethodBindings
  Class.forName(AnimationTree::class.java.name, true, AnimationTree::class.java.classLoader)
  AnimationTree.MethodBindings
  Class.forName(Area2D::class.java.name, true, Area2D::class.java.classLoader)
  Area2D.MethodBindings
  Class.forName(Area3D::class.java.name, true, Area3D::class.java.classLoader)
  Area3D.MethodBindings
  Class.forName(AreaLight3D::class.java.name, true, AreaLight3D::class.java.classLoader)
  AreaLight3D.MethodBindings
  Class.forName(ArrayMesh::class.java.name, true, ArrayMesh::class.java.classLoader)
  ArrayMesh.MethodBindings
  Class.forName(ArrayOccluder3D::class.java.name, true, ArrayOccluder3D::class.java.classLoader)
  ArrayOccluder3D.MethodBindings
  Class.forName(AspectRatioContainer::class.java.name, true, AspectRatioContainer::class.java.classLoader)
  AspectRatioContainer.MethodBindings
  Class.forName(AtlasTexture::class.java.name, true, AtlasTexture::class.java.classLoader)
  AtlasTexture.MethodBindings
  Class.forName(AudioBusLayout::class.java.name, true, AudioBusLayout::class.java.classLoader)
  AudioBusLayout.MethodBindings
  Class.forName(AudioEffect::class.java.name, true, AudioEffect::class.java.classLoader)
  AudioEffect.MethodBindings
  Class.forName(AudioEffectAmplify::class.java.name, true, AudioEffectAmplify::class.java.classLoader)
  AudioEffectAmplify.MethodBindings
  Class.forName(AudioEffectBandLimitFilter::class.java.name, true, AudioEffectBandLimitFilter::class.java.classLoader)
  AudioEffectBandLimitFilter.MethodBindings
  Class.forName(AudioEffectBandPassFilter::class.java.name, true, AudioEffectBandPassFilter::class.java.classLoader)
  AudioEffectBandPassFilter.MethodBindings
  Class.forName(AudioEffectCapture::class.java.name, true, AudioEffectCapture::class.java.classLoader)
  AudioEffectCapture.MethodBindings
  Class.forName(AudioEffectChorus::class.java.name, true, AudioEffectChorus::class.java.classLoader)
  AudioEffectChorus.MethodBindings
  Class.forName(AudioEffectCompressor::class.java.name, true, AudioEffectCompressor::class.java.classLoader)
  AudioEffectCompressor.MethodBindings
  Class.forName(AudioEffectDelay::class.java.name, true, AudioEffectDelay::class.java.classLoader)
  AudioEffectDelay.MethodBindings
  Class.forName(AudioEffectDistortion::class.java.name, true, AudioEffectDistortion::class.java.classLoader)
  AudioEffectDistortion.MethodBindings
  Class.forName(AudioEffectEQ::class.java.name, true, AudioEffectEQ::class.java.classLoader)
  AudioEffectEQ.MethodBindings
  Class.forName(AudioEffectEQ10::class.java.name, true, AudioEffectEQ10::class.java.classLoader)
  AudioEffectEQ10.MethodBindings
  Class.forName(AudioEffectEQ21::class.java.name, true, AudioEffectEQ21::class.java.classLoader)
  AudioEffectEQ21.MethodBindings
  Class.forName(AudioEffectEQ6::class.java.name, true, AudioEffectEQ6::class.java.classLoader)
  AudioEffectEQ6.MethodBindings
  Class.forName(AudioEffectFilter::class.java.name, true, AudioEffectFilter::class.java.classLoader)
  AudioEffectFilter.MethodBindings
  Class.forName(AudioEffectHardLimiter::class.java.name, true, AudioEffectHardLimiter::class.java.classLoader)
  AudioEffectHardLimiter.MethodBindings
  Class.forName(AudioEffectHighPassFilter::class.java.name, true, AudioEffectHighPassFilter::class.java.classLoader)
  AudioEffectHighPassFilter.MethodBindings
  Class.forName(AudioEffectHighShelfFilter::class.java.name, true, AudioEffectHighShelfFilter::class.java.classLoader)
  AudioEffectHighShelfFilter.MethodBindings
  Class.forName(AudioEffectInstance::class.java.name, true, AudioEffectInstance::class.java.classLoader)
  AudioEffectInstance.MethodBindings
  Class.forName(AudioEffectLimiter::class.java.name, true, AudioEffectLimiter::class.java.classLoader)
  AudioEffectLimiter.MethodBindings
  Class.forName(AudioEffectLowPassFilter::class.java.name, true, AudioEffectLowPassFilter::class.java.classLoader)
  AudioEffectLowPassFilter.MethodBindings
  Class.forName(AudioEffectLowShelfFilter::class.java.name, true, AudioEffectLowShelfFilter::class.java.classLoader)
  AudioEffectLowShelfFilter.MethodBindings
  Class.forName(AudioEffectNotchFilter::class.java.name, true, AudioEffectNotchFilter::class.java.classLoader)
  AudioEffectNotchFilter.MethodBindings
  Class.forName(AudioEffectPanner::class.java.name, true, AudioEffectPanner::class.java.classLoader)
  AudioEffectPanner.MethodBindings
  Class.forName(AudioEffectPhaser::class.java.name, true, AudioEffectPhaser::class.java.classLoader)
  AudioEffectPhaser.MethodBindings
  Class.forName(AudioEffectPitchShift::class.java.name, true, AudioEffectPitchShift::class.java.classLoader)
  AudioEffectPitchShift.MethodBindings
  Class.forName(AudioEffectRecord::class.java.name, true, AudioEffectRecord::class.java.classLoader)
  AudioEffectRecord.MethodBindings
  Class.forName(AudioEffectReverb::class.java.name, true, AudioEffectReverb::class.java.classLoader)
  AudioEffectReverb.MethodBindings
  Class.forName(AudioEffectSpectrumAnalyzer::class.java.name, true, AudioEffectSpectrumAnalyzer::class.java.classLoader)
  AudioEffectSpectrumAnalyzer.MethodBindings
  Class.forName(AudioEffectSpectrumAnalyzerInstance::class.java.name, true, AudioEffectSpectrumAnalyzerInstance::class.java.classLoader)
  AudioEffectSpectrumAnalyzerInstance.MethodBindings
  Class.forName(AudioEffectStereoEnhance::class.java.name, true, AudioEffectStereoEnhance::class.java.classLoader)
  AudioEffectStereoEnhance.MethodBindings
  Class.forName(AudioListener2D::class.java.name, true, AudioListener2D::class.java.classLoader)
  AudioListener2D.MethodBindings
  Class.forName(AudioListener3D::class.java.name, true, AudioListener3D::class.java.classLoader)
  AudioListener3D.MethodBindings
  Class.forName(AudioSample::class.java.name, true, AudioSample::class.java.classLoader)
  AudioSample.MethodBindings
  Class.forName(AudioSamplePlayback::class.java.name, true, AudioSamplePlayback::class.java.classLoader)
  AudioSamplePlayback.MethodBindings
  Class.forName(AudioServer::class.java.name, true, AudioServer::class.java.classLoader)
  AudioServer.MethodBindings
  Class.forName(AudioStream::class.java.name, true, AudioStream::class.java.classLoader)
  AudioStream.MethodBindings
  Class.forName(AudioStreamGenerator::class.java.name, true, AudioStreamGenerator::class.java.classLoader)
  AudioStreamGenerator.MethodBindings
  Class.forName(AudioStreamGeneratorPlayback::class.java.name, true, AudioStreamGeneratorPlayback::class.java.classLoader)
  AudioStreamGeneratorPlayback.MethodBindings
  Class.forName(AudioStreamInteractive::class.java.name, true, AudioStreamInteractive::class.java.classLoader)
  AudioStreamInteractive.MethodBindings
  Class.forName(AudioStreamMP3::class.java.name, true, AudioStreamMP3::class.java.classLoader)
  AudioStreamMP3.MethodBindings
  Class.forName(AudioStreamMicrophone::class.java.name, true, AudioStreamMicrophone::class.java.classLoader)
  AudioStreamMicrophone.MethodBindings
  Class.forName(AudioStreamOggVorbis::class.java.name, true, AudioStreamOggVorbis::class.java.classLoader)
  AudioStreamOggVorbis.MethodBindings
  Class.forName(AudioStreamPlayback::class.java.name, true, AudioStreamPlayback::class.java.classLoader)
  AudioStreamPlayback.MethodBindings
  Class.forName(AudioStreamPlaybackInteractive::class.java.name, true, AudioStreamPlaybackInteractive::class.java.classLoader)
  AudioStreamPlaybackInteractive.MethodBindings
  Class.forName(AudioStreamPlaybackOggVorbis::class.java.name, true, AudioStreamPlaybackOggVorbis::class.java.classLoader)
  AudioStreamPlaybackOggVorbis.MethodBindings
  Class.forName(AudioStreamPlaybackPlaylist::class.java.name, true, AudioStreamPlaybackPlaylist::class.java.classLoader)
  AudioStreamPlaybackPlaylist.MethodBindings
  Class.forName(AudioStreamPlaybackPolyphonic::class.java.name, true, AudioStreamPlaybackPolyphonic::class.java.classLoader)
  AudioStreamPlaybackPolyphonic.MethodBindings
  Class.forName(AudioStreamPlaybackResampled::class.java.name, true, AudioStreamPlaybackResampled::class.java.classLoader)
  AudioStreamPlaybackResampled.MethodBindings
  Class.forName(AudioStreamPlaybackSynchronized::class.java.name, true, AudioStreamPlaybackSynchronized::class.java.classLoader)
  AudioStreamPlaybackSynchronized.MethodBindings
  Class.forName(AudioStreamPlayer::class.java.name, true, AudioStreamPlayer::class.java.classLoader)
  AudioStreamPlayer.MethodBindings
  Class.forName(AudioStreamPlayer2D::class.java.name, true, AudioStreamPlayer2D::class.java.classLoader)
  AudioStreamPlayer2D.MethodBindings
  Class.forName(AudioStreamPlayer3D::class.java.name, true, AudioStreamPlayer3D::class.java.classLoader)
  AudioStreamPlayer3D.MethodBindings
  Class.forName(AudioStreamPlaylist::class.java.name, true, AudioStreamPlaylist::class.java.classLoader)
  AudioStreamPlaylist.MethodBindings
  Class.forName(AudioStreamPolyphonic::class.java.name, true, AudioStreamPolyphonic::class.java.classLoader)
  AudioStreamPolyphonic.MethodBindings
  Class.forName(AudioStreamRandomizer::class.java.name, true, AudioStreamRandomizer::class.java.classLoader)
  AudioStreamRandomizer.MethodBindings
  Class.forName(AudioStreamSynchronized::class.java.name, true, AudioStreamSynchronized::class.java.classLoader)
  AudioStreamSynchronized.MethodBindings
  Class.forName(AudioStreamWAV::class.java.name, true, AudioStreamWAV::class.java.classLoader)
  AudioStreamWAV.MethodBindings
  Class.forName(AwaitTweener::class.java.name, true, AwaitTweener::class.java.classLoader)
  AwaitTweener.MethodBindings
  Class.forName(BackBufferCopy::class.java.name, true, BackBufferCopy::class.java.classLoader)
  BackBufferCopy.MethodBindings
  Class.forName(BaseButton::class.java.name, true, BaseButton::class.java.classLoader)
  BaseButton.MethodBindings
  Class.forName(BaseMaterial3D::class.java.name, true, BaseMaterial3D::class.java.classLoader)
  BaseMaterial3D.MethodBindings
  Class.forName(BitMap::class.java.name, true, BitMap::class.java.classLoader)
  BitMap.MethodBindings
  Class.forName(BlitMaterial::class.java.name, true, BlitMaterial::class.java.classLoader)
  BlitMaterial.MethodBindings
  Class.forName(Bone2D::class.java.name, true, Bone2D::class.java.classLoader)
  Bone2D.MethodBindings
  Class.forName(BoneAttachment3D::class.java.name, true, BoneAttachment3D::class.java.classLoader)
  BoneAttachment3D.MethodBindings
  Class.forName(BoneConstraint3D::class.java.name, true, BoneConstraint3D::class.java.classLoader)
  BoneConstraint3D.MethodBindings
  Class.forName(BoneMap::class.java.name, true, BoneMap::class.java.classLoader)
  BoneMap.MethodBindings
  Class.forName(BoneTwistDisperser3D::class.java.name, true, BoneTwistDisperser3D::class.java.classLoader)
  BoneTwistDisperser3D.MethodBindings
  Class.forName(BoxContainer::class.java.name, true, BoxContainer::class.java.classLoader)
  BoxContainer.MethodBindings
  Class.forName(BoxMesh::class.java.name, true, BoxMesh::class.java.classLoader)
  BoxMesh.MethodBindings
  Class.forName(BoxOccluder3D::class.java.name, true, BoxOccluder3D::class.java.classLoader)
  BoxOccluder3D.MethodBindings
  Class.forName(BoxShape3D::class.java.name, true, BoxShape3D::class.java.classLoader)
  BoxShape3D.MethodBindings
  Class.forName(Button::class.java.name, true, Button::class.java.classLoader)
  Button.MethodBindings
  Class.forName(ButtonGroup::class.java.name, true, ButtonGroup::class.java.classLoader)
  ButtonGroup.MethodBindings
  Class.forName(CCDIK3D::class.java.name, true, CCDIK3D::class.java.classLoader)
  CCDIK3D.MethodBindings
  Class.forName(CPUParticles2D::class.java.name, true, CPUParticles2D::class.java.classLoader)
  CPUParticles2D.MethodBindings
  Class.forName(CPUParticles3D::class.java.name, true, CPUParticles3D::class.java.classLoader)
  CPUParticles3D.MethodBindings
  Class.forName(CSGBox3D::class.java.name, true, CSGBox3D::class.java.classLoader)
  CSGBox3D.MethodBindings
  Class.forName(CSGCombiner3D::class.java.name, true, CSGCombiner3D::class.java.classLoader)
  CSGCombiner3D.MethodBindings
  Class.forName(CSGCylinder3D::class.java.name, true, CSGCylinder3D::class.java.classLoader)
  CSGCylinder3D.MethodBindings
  Class.forName(CSGMesh3D::class.java.name, true, CSGMesh3D::class.java.classLoader)
  CSGMesh3D.MethodBindings
  Class.forName(CSGPolygon3D::class.java.name, true, CSGPolygon3D::class.java.classLoader)
  CSGPolygon3D.MethodBindings
  Class.forName(CSGPrimitive3D::class.java.name, true, CSGPrimitive3D::class.java.classLoader)
  CSGPrimitive3D.MethodBindings
  Class.forName(CSGShape3D::class.java.name, true, CSGShape3D::class.java.classLoader)
  CSGShape3D.MethodBindings
  Class.forName(CSGSphere3D::class.java.name, true, CSGSphere3D::class.java.classLoader)
  CSGSphere3D.MethodBindings
  Class.forName(CSGTorus3D::class.java.name, true, CSGTorus3D::class.java.classLoader)
  CSGTorus3D.MethodBindings
  Class.forName(CallbackTweener::class.java.name, true, CallbackTweener::class.java.classLoader)
  CallbackTweener.MethodBindings
  Class.forName(Camera2D::class.java.name, true, Camera2D::class.java.classLoader)
  Camera2D.MethodBindings
  Class.forName(Camera3D::class.java.name, true, Camera3D::class.java.classLoader)
  Camera3D.MethodBindings
  Class.forName(CameraAttributes::class.java.name, true, CameraAttributes::class.java.classLoader)
  CameraAttributes.MethodBindings
  Class.forName(CameraAttributesPhysical::class.java.name, true, CameraAttributesPhysical::class.java.classLoader)
  CameraAttributesPhysical.MethodBindings
  Class.forName(CameraAttributesPractical::class.java.name, true, CameraAttributesPractical::class.java.classLoader)
  CameraAttributesPractical.MethodBindings
  Class.forName(CameraFeed::class.java.name, true, CameraFeed::class.java.classLoader)
  CameraFeed.MethodBindings
  Class.forName(CameraServer::class.java.name, true, CameraServer::class.java.classLoader)
  CameraServer.MethodBindings
  Class.forName(CameraTexture::class.java.name, true, CameraTexture::class.java.classLoader)
  CameraTexture.MethodBindings
  Class.forName(CanvasGroup::class.java.name, true, CanvasGroup::class.java.classLoader)
  CanvasGroup.MethodBindings
  Class.forName(CanvasItem::class.java.name, true, CanvasItem::class.java.classLoader)
  CanvasItem.MethodBindings
  Class.forName(CanvasItemMaterial::class.java.name, true, CanvasItemMaterial::class.java.classLoader)
  CanvasItemMaterial.MethodBindings
  Class.forName(CanvasLayer::class.java.name, true, CanvasLayer::class.java.classLoader)
  CanvasLayer.MethodBindings
  Class.forName(CanvasModulate::class.java.name, true, CanvasModulate::class.java.classLoader)
  CanvasModulate.MethodBindings
  Class.forName(CanvasTexture::class.java.name, true, CanvasTexture::class.java.classLoader)
  CanvasTexture.MethodBindings
  Class.forName(CapsuleMesh::class.java.name, true, CapsuleMesh::class.java.classLoader)
  CapsuleMesh.MethodBindings
  Class.forName(CapsuleShape2D::class.java.name, true, CapsuleShape2D::class.java.classLoader)
  CapsuleShape2D.MethodBindings
  Class.forName(CapsuleShape3D::class.java.name, true, CapsuleShape3D::class.java.classLoader)
  CapsuleShape3D.MethodBindings
  Class.forName(CenterContainer::class.java.name, true, CenterContainer::class.java.classLoader)
  CenterContainer.MethodBindings
  Class.forName(ChainIK3D::class.java.name, true, ChainIK3D::class.java.classLoader)
  ChainIK3D.MethodBindings
  Class.forName(CharFXTransform::class.java.name, true, CharFXTransform::class.java.classLoader)
  CharFXTransform.MethodBindings
  Class.forName(CharacterBody2D::class.java.name, true, CharacterBody2D::class.java.classLoader)
  CharacterBody2D.MethodBindings
  Class.forName(CharacterBody3D::class.java.name, true, CharacterBody3D::class.java.classLoader)
  CharacterBody3D.MethodBindings
  Class.forName(CheckBox::class.java.name, true, CheckBox::class.java.classLoader)
  CheckBox.MethodBindings
  Class.forName(CheckButton::class.java.name, true, CheckButton::class.java.classLoader)
  CheckButton.MethodBindings
  Class.forName(CircleShape2D::class.java.name, true, CircleShape2D::class.java.classLoader)
  CircleShape2D.MethodBindings
  Class.forName(ClassDB::class.java.name, true, ClassDB::class.java.classLoader)
  ClassDB.MethodBindings
  Class.forName(CodeEdit::class.java.name, true, CodeEdit::class.java.classLoader)
  CodeEdit.MethodBindings
  Class.forName(CodeHighlighter::class.java.name, true, CodeHighlighter::class.java.classLoader)
  CodeHighlighter.MethodBindings
  Class.forName(CollisionObject2D::class.java.name, true, CollisionObject2D::class.java.classLoader)
  CollisionObject2D.MethodBindings
  Class.forName(CollisionObject3D::class.java.name, true, CollisionObject3D::class.java.classLoader)
  CollisionObject3D.MethodBindings
  Class.forName(CollisionPolygon2D::class.java.name, true, CollisionPolygon2D::class.java.classLoader)
  CollisionPolygon2D.MethodBindings
  Class.forName(CollisionPolygon3D::class.java.name, true, CollisionPolygon3D::class.java.classLoader)
  CollisionPolygon3D.MethodBindings
  Class.forName(CollisionShape2D::class.java.name, true, CollisionShape2D::class.java.classLoader)
  CollisionShape2D.MethodBindings
  Class.forName(CollisionShape3D::class.java.name, true, CollisionShape3D::class.java.classLoader)
  CollisionShape3D.MethodBindings
  Class.forName(ColorPalette::class.java.name, true, ColorPalette::class.java.classLoader)
  ColorPalette.MethodBindings
  Class.forName(ColorPicker::class.java.name, true, ColorPicker::class.java.classLoader)
  ColorPicker.MethodBindings
  Class.forName(ColorPickerButton::class.java.name, true, ColorPickerButton::class.java.classLoader)
  ColorPickerButton.MethodBindings
  Class.forName(ColorRect::class.java.name, true, ColorRect::class.java.classLoader)
  ColorRect.MethodBindings
  Class.forName(Compositor::class.java.name, true, Compositor::class.java.classLoader)
  Compositor.MethodBindings
  Class.forName(CompositorEffect::class.java.name, true, CompositorEffect::class.java.classLoader)
  CompositorEffect.MethodBindings
  Class.forName(CompressedCubemap::class.java.name, true, CompressedCubemap::class.java.classLoader)
  CompressedCubemap.MethodBindings
  Class.forName(CompressedCubemapArray::class.java.name, true, CompressedCubemapArray::class.java.classLoader)
  CompressedCubemapArray.MethodBindings
  Class.forName(CompressedTexture2D::class.java.name, true, CompressedTexture2D::class.java.classLoader)
  CompressedTexture2D.MethodBindings
  Class.forName(CompressedTexture2DArray::class.java.name, true, CompressedTexture2DArray::class.java.classLoader)
  CompressedTexture2DArray.MethodBindings
  Class.forName(CompressedTexture3D::class.java.name, true, CompressedTexture3D::class.java.classLoader)
  CompressedTexture3D.MethodBindings
  Class.forName(CompressedTextureLayered::class.java.name, true, CompressedTextureLayered::class.java.classLoader)
  CompressedTextureLayered.MethodBindings
  Class.forName(ConcavePolygonShape2D::class.java.name, true, ConcavePolygonShape2D::class.java.classLoader)
  ConcavePolygonShape2D.MethodBindings
  Class.forName(ConcavePolygonShape3D::class.java.name, true, ConcavePolygonShape3D::class.java.classLoader)
  ConcavePolygonShape3D.MethodBindings
  Class.forName(ConeTwistJoint3D::class.java.name, true, ConeTwistJoint3D::class.java.classLoader)
  ConeTwistJoint3D.MethodBindings
  Class.forName(ConfigFile::class.java.name, true, ConfigFile::class.java.classLoader)
  ConfigFile.MethodBindings
  Class.forName(ConfirmationDialog::class.java.name, true, ConfirmationDialog::class.java.classLoader)
  ConfirmationDialog.MethodBindings
  Class.forName(Container::class.java.name, true, Container::class.java.classLoader)
  Container.MethodBindings
  Class.forName(Control::class.java.name, true, Control::class.java.classLoader)
  Control.MethodBindings
  Class.forName(ConvertTransformModifier3D::class.java.name, true, ConvertTransformModifier3D::class.java.classLoader)
  ConvertTransformModifier3D.MethodBindings
  Class.forName(ConvexPolygonShape2D::class.java.name, true, ConvexPolygonShape2D::class.java.classLoader)
  ConvexPolygonShape2D.MethodBindings
  Class.forName(ConvexPolygonShape3D::class.java.name, true, ConvexPolygonShape3D::class.java.classLoader)
  ConvexPolygonShape3D.MethodBindings
  Class.forName(CopyTransformModifier3D::class.java.name, true, CopyTransformModifier3D::class.java.classLoader)
  CopyTransformModifier3D.MethodBindings
  Class.forName(Crypto::class.java.name, true, Crypto::class.java.classLoader)
  Crypto.MethodBindings
  Class.forName(CryptoKey::class.java.name, true, CryptoKey::class.java.classLoader)
  CryptoKey.MethodBindings
  Class.forName(Cubemap::class.java.name, true, Cubemap::class.java.classLoader)
  Cubemap.MethodBindings
  Class.forName(CubemapArray::class.java.name, true, CubemapArray::class.java.classLoader)
  CubemapArray.MethodBindings
  Class.forName(Curve::class.java.name, true, Curve::class.java.classLoader)
  Curve.MethodBindings
  Class.forName(Curve2D::class.java.name, true, Curve2D::class.java.classLoader)
  Curve2D.MethodBindings
  Class.forName(Curve3D::class.java.name, true, Curve3D::class.java.classLoader)
  Curve3D.MethodBindings
  Class.forName(CurveTexture::class.java.name, true, CurveTexture::class.java.classLoader)
  CurveTexture.MethodBindings
  Class.forName(CurveXYZTexture::class.java.name, true, CurveXYZTexture::class.java.classLoader)
  CurveXYZTexture.MethodBindings
  Class.forName(CylinderMesh::class.java.name, true, CylinderMesh::class.java.classLoader)
  CylinderMesh.MethodBindings
  Class.forName(CylinderShape3D::class.java.name, true, CylinderShape3D::class.java.classLoader)
  CylinderShape3D.MethodBindings
  Class.forName(DPITexture::class.java.name, true, DPITexture::class.java.classLoader)
  DPITexture.MethodBindings
  Class.forName(DTLSServer::class.java.name, true, DTLSServer::class.java.classLoader)
  DTLSServer.MethodBindings
  Class.forName(DampedSpringJoint2D::class.java.name, true, DampedSpringJoint2D::class.java.classLoader)
  DampedSpringJoint2D.MethodBindings
  Class.forName(Decal::class.java.name, true, Decal::class.java.classLoader)
  Decal.MethodBindings
  Class.forName(DirAccess::class.java.name, true, DirAccess::class.java.classLoader)
  DirAccess.MethodBindings
  Class.forName(DirectionalLight2D::class.java.name, true, DirectionalLight2D::class.java.classLoader)
  DirectionalLight2D.MethodBindings
  Class.forName(DirectionalLight3D::class.java.name, true, DirectionalLight3D::class.java.classLoader)
  DirectionalLight3D.MethodBindings
  Class.forName(DisplayServer::class.java.name, true, DisplayServer::class.java.classLoader)
  DisplayServer.MethodBindings
  Class.forName(DrawableTexture2D::class.java.name, true, DrawableTexture2D::class.java.classLoader)
  DrawableTexture2D.MethodBindings
  Class.forName(ENetConnection::class.java.name, true, ENetConnection::class.java.classLoader)
  ENetConnection.MethodBindings
  Class.forName(ENetMultiplayerPeer::class.java.name, true, ENetMultiplayerPeer::class.java.classLoader)
  ENetMultiplayerPeer.MethodBindings
  Class.forName(ENetPacketPeer::class.java.name, true, ENetPacketPeer::class.java.classLoader)
  ENetPacketPeer.MethodBindings
  Class.forName(EncodedObjectAsID::class.java.name, true, EncodedObjectAsID::class.java.classLoader)
  EncodedObjectAsID.MethodBindings
  Class.forName(Engine::class.java.name, true, Engine::class.java.classLoader)
  Engine.MethodBindings
  Class.forName(EngineDebugger::class.java.name, true, EngineDebugger::class.java.classLoader)
  EngineDebugger.MethodBindings
  Class.forName(EngineProfiler::class.java.name, true, EngineProfiler::class.java.classLoader)
  EngineProfiler.MethodBindings
  Class.forName(Environment::class.java.name, true, Environment::class.java.classLoader)
  Environment.MethodBindings
  Class.forName(Expression::class.java.name, true, Expression::class.java.classLoader)
  Expression.MethodBindings
  Class.forName(ExternalTexture::class.java.name, true, ExternalTexture::class.java.classLoader)
  ExternalTexture.MethodBindings
  Class.forName(FABRIK3D::class.java.name, true, FABRIK3D::class.java.classLoader)
  FABRIK3D.MethodBindings
  Class.forName(FBXDocument::class.java.name, true, FBXDocument::class.java.classLoader)
  FBXDocument.MethodBindings
  Class.forName(FBXState::class.java.name, true, FBXState::class.java.classLoader)
  FBXState.MethodBindings
  Class.forName(FastNoiseLite::class.java.name, true, FastNoiseLite::class.java.classLoader)
  FastNoiseLite.MethodBindings
  Class.forName(FileAccess::class.java.name, true, FileAccess::class.java.classLoader)
  FileAccess.MethodBindings
  Class.forName(FileDialog::class.java.name, true, FileDialog::class.java.classLoader)
  FileDialog.MethodBindings
  Class.forName(FlowContainer::class.java.name, true, FlowContainer::class.java.classLoader)
  FlowContainer.MethodBindings
  Class.forName(FogMaterial::class.java.name, true, FogMaterial::class.java.classLoader)
  FogMaterial.MethodBindings
  Class.forName(FogVolume::class.java.name, true, FogVolume::class.java.classLoader)
  FogVolume.MethodBindings
  Class.forName(FoldableContainer::class.java.name, true, FoldableContainer::class.java.classLoader)
  FoldableContainer.MethodBindings
  Class.forName(FoldableGroup::class.java.name, true, FoldableGroup::class.java.classLoader)
  FoldableGroup.MethodBindings
  Class.forName(Font::class.java.name, true, Font::class.java.classLoader)
  Font.MethodBindings
  Class.forName(FontFile::class.java.name, true, FontFile::class.java.classLoader)
  FontFile.MethodBindings
  Class.forName(FontVariation::class.java.name, true, FontVariation::class.java.classLoader)
  FontVariation.MethodBindings
  Class.forName(FramebufferCacheRD::class.java.name, true, FramebufferCacheRD::class.java.classLoader)
  FramebufferCacheRD.MethodBindings
  Class.forName(GDExtension::class.java.name, true, GDExtension::class.java.classLoader)
  GDExtension.MethodBindings
  Class.forName(GDExtensionManager::class.java.name, true, GDExtensionManager::class.java.classLoader)
  GDExtensionManager.MethodBindings
  Class.forName(GDScript::class.java.name, true, GDScript::class.java.classLoader)
  GDScript.MethodBindings
  Class.forName(GLTFAccessor::class.java.name, true, GLTFAccessor::class.java.classLoader)
  GLTFAccessor.MethodBindings
  Class.forName(GLTFAnimation::class.java.name, true, GLTFAnimation::class.java.classLoader)
  GLTFAnimation.MethodBindings
  Class.forName(GLTFBufferView::class.java.name, true, GLTFBufferView::class.java.classLoader)
  GLTFBufferView.MethodBindings
  Class.forName(GLTFCamera::class.java.name, true, GLTFCamera::class.java.classLoader)
  GLTFCamera.MethodBindings
  Class.forName(GLTFDocument::class.java.name, true, GLTFDocument::class.java.classLoader)
  GLTFDocument.MethodBindings
  Class.forName(GLTFDocumentExtension::class.java.name, true, GLTFDocumentExtension::class.java.classLoader)
  GLTFDocumentExtension.MethodBindings
  Class.forName(GLTFDocumentExtensionConvertImporterMesh::class.java.name, true, GLTFDocumentExtensionConvertImporterMesh::class.java.classLoader)
  GLTFDocumentExtensionConvertImporterMesh.MethodBindings
  Class.forName(GLTFLight::class.java.name, true, GLTFLight::class.java.classLoader)
  GLTFLight.MethodBindings
  Class.forName(GLTFMesh::class.java.name, true, GLTFMesh::class.java.classLoader)
  GLTFMesh.MethodBindings
  Class.forName(GLTFNode::class.java.name, true, GLTFNode::class.java.classLoader)
  GLTFNode.MethodBindings
  Class.forName(GLTFObjectModelProperty::class.java.name, true, GLTFObjectModelProperty::class.java.classLoader)
  GLTFObjectModelProperty.MethodBindings
  Class.forName(GLTFPhysicsBody::class.java.name, true, GLTFPhysicsBody::class.java.classLoader)
  GLTFPhysicsBody.MethodBindings
  Class.forName(GLTFPhysicsShape::class.java.name, true, GLTFPhysicsShape::class.java.classLoader)
  GLTFPhysicsShape.MethodBindings
  Class.forName(GLTFSkeleton::class.java.name, true, GLTFSkeleton::class.java.classLoader)
  GLTFSkeleton.MethodBindings
  Class.forName(GLTFSkin::class.java.name, true, GLTFSkin::class.java.classLoader)
  GLTFSkin.MethodBindings
  Class.forName(GLTFSpecGloss::class.java.name, true, GLTFSpecGloss::class.java.classLoader)
  GLTFSpecGloss.MethodBindings
  Class.forName(GLTFState::class.java.name, true, GLTFState::class.java.classLoader)
  GLTFState.MethodBindings
  Class.forName(GLTFTexture::class.java.name, true, GLTFTexture::class.java.classLoader)
  GLTFTexture.MethodBindings
  Class.forName(GLTFTextureSampler::class.java.name, true, GLTFTextureSampler::class.java.classLoader)
  GLTFTextureSampler.MethodBindings
  Class.forName(GPUParticles2D::class.java.name, true, GPUParticles2D::class.java.classLoader)
  GPUParticles2D.MethodBindings
  Class.forName(GPUParticles3D::class.java.name, true, GPUParticles3D::class.java.classLoader)
  GPUParticles3D.MethodBindings
  Class.forName(GPUParticlesAttractor3D::class.java.name, true, GPUParticlesAttractor3D::class.java.classLoader)
  GPUParticlesAttractor3D.MethodBindings
  Class.forName(GPUParticlesAttractorBox3D::class.java.name, true, GPUParticlesAttractorBox3D::class.java.classLoader)
  GPUParticlesAttractorBox3D.MethodBindings
  Class.forName(GPUParticlesAttractorSphere3D::class.java.name, true, GPUParticlesAttractorSphere3D::class.java.classLoader)
  GPUParticlesAttractorSphere3D.MethodBindings
  Class.forName(GPUParticlesAttractorVectorField3D::class.java.name, true, GPUParticlesAttractorVectorField3D::class.java.classLoader)
  GPUParticlesAttractorVectorField3D.MethodBindings
  Class.forName(GPUParticlesCollision3D::class.java.name, true, GPUParticlesCollision3D::class.java.classLoader)
  GPUParticlesCollision3D.MethodBindings
  Class.forName(GPUParticlesCollisionBox3D::class.java.name, true, GPUParticlesCollisionBox3D::class.java.classLoader)
  GPUParticlesCollisionBox3D.MethodBindings
  Class.forName(GPUParticlesCollisionHeightField3D::class.java.name, true, GPUParticlesCollisionHeightField3D::class.java.classLoader)
  GPUParticlesCollisionHeightField3D.MethodBindings
  Class.forName(GPUParticlesCollisionSDF3D::class.java.name, true, GPUParticlesCollisionSDF3D::class.java.classLoader)
  GPUParticlesCollisionSDF3D.MethodBindings
  Class.forName(GPUParticlesCollisionSphere3D::class.java.name, true, GPUParticlesCollisionSphere3D::class.java.classLoader)
  GPUParticlesCollisionSphere3D.MethodBindings
  Class.forName(GdjScript::class.java.name, true, GdjScript::class.java.classLoader)
  GdjScript.MethodBindings
  Class.forName(Generic6DOFJoint3D::class.java.name, true, Generic6DOFJoint3D::class.java.classLoader)
  Generic6DOFJoint3D.MethodBindings
  Class.forName(Geometry2D::class.java.name, true, Geometry2D::class.java.classLoader)
  Geometry2D.MethodBindings
  Class.forName(Geometry3D::class.java.name, true, Geometry3D::class.java.classLoader)
  Geometry3D.MethodBindings
  Class.forName(GeometryInstance3D::class.java.name, true, GeometryInstance3D::class.java.classLoader)
  GeometryInstance3D.MethodBindings
  Class.forName(GodotInstance::class.java.name, true, GodotInstance::class.java.classLoader)
  GodotInstance.MethodBindings
  Class.forName(Gradient::class.java.name, true, Gradient::class.java.classLoader)
  Gradient.MethodBindings
  Class.forName(GradientTexture1D::class.java.name, true, GradientTexture1D::class.java.classLoader)
  GradientTexture1D.MethodBindings
  Class.forName(GradientTexture2D::class.java.name, true, GradientTexture2D::class.java.classLoader)
  GradientTexture2D.MethodBindings
  Class.forName(GraphEdit::class.java.name, true, GraphEdit::class.java.classLoader)
  GraphEdit.MethodBindings
  Class.forName(GraphElement::class.java.name, true, GraphElement::class.java.classLoader)
  GraphElement.MethodBindings
  Class.forName(GraphFrame::class.java.name, true, GraphFrame::class.java.classLoader)
  GraphFrame.MethodBindings
  Class.forName(GraphNode::class.java.name, true, GraphNode::class.java.classLoader)
  GraphNode.MethodBindings
  Class.forName(GridContainer::class.java.name, true, GridContainer::class.java.classLoader)
  GridContainer.MethodBindings
  Class.forName(GridMap::class.java.name, true, GridMap::class.java.classLoader)
  GridMap.MethodBindings
  Class.forName(GrooveJoint2D::class.java.name, true, GrooveJoint2D::class.java.classLoader)
  GrooveJoint2D.MethodBindings
  Class.forName(HBoxContainer::class.java.name, true, HBoxContainer::class.java.classLoader)
  HBoxContainer.MethodBindings
  Class.forName(HFlowContainer::class.java.name, true, HFlowContainer::class.java.classLoader)
  HFlowContainer.MethodBindings
  Class.forName(HMACContext::class.java.name, true, HMACContext::class.java.classLoader)
  HMACContext.MethodBindings
  Class.forName(HScrollBar::class.java.name, true, HScrollBar::class.java.classLoader)
  HScrollBar.MethodBindings
  Class.forName(HSeparator::class.java.name, true, HSeparator::class.java.classLoader)
  HSeparator.MethodBindings
  Class.forName(HSlider::class.java.name, true, HSlider::class.java.classLoader)
  HSlider.MethodBindings
  Class.forName(HSplitContainer::class.java.name, true, HSplitContainer::class.java.classLoader)
  HSplitContainer.MethodBindings
  Class.forName(HTTPClient::class.java.name, true, HTTPClient::class.java.classLoader)
  HTTPClient.MethodBindings
  Class.forName(HTTPRequest::class.java.name, true, HTTPRequest::class.java.classLoader)
  HTTPRequest.MethodBindings
  Class.forName(HashingContext::class.java.name, true, HashingContext::class.java.classLoader)
  HashingContext.MethodBindings
  Class.forName(HeightMapShape3D::class.java.name, true, HeightMapShape3D::class.java.classLoader)
  HeightMapShape3D.MethodBindings
  Class.forName(HingeJoint3D::class.java.name, true, HingeJoint3D::class.java.classLoader)
  HingeJoint3D.MethodBindings
  Class.forName(IKModifier3D::class.java.name, true, IKModifier3D::class.java.classLoader)
  IKModifier3D.MethodBindings
  Class.forName(IP::class.java.name, true, IP::class.java.classLoader)
  IP.MethodBindings
  Class.forName(Image::class.java.name, true, Image::class.java.classLoader)
  Image.MethodBindings
  Class.forName(ImageFormatLoader::class.java.name, true, ImageFormatLoader::class.java.classLoader)
  ImageFormatLoader.MethodBindings
  Class.forName(ImageFormatLoaderExtension::class.java.name, true, ImageFormatLoaderExtension::class.java.classLoader)
  ImageFormatLoaderExtension.MethodBindings
  Class.forName(ImageTexture::class.java.name, true, ImageTexture::class.java.classLoader)
  ImageTexture.MethodBindings
  Class.forName(ImageTexture3D::class.java.name, true, ImageTexture3D::class.java.classLoader)
  ImageTexture3D.MethodBindings
  Class.forName(ImageTextureLayered::class.java.name, true, ImageTextureLayered::class.java.classLoader)
  ImageTextureLayered.MethodBindings
  Class.forName(ImmediateMesh::class.java.name, true, ImmediateMesh::class.java.classLoader)
  ImmediateMesh.MethodBindings
  Class.forName(ImporterMesh::class.java.name, true, ImporterMesh::class.java.classLoader)
  ImporterMesh.MethodBindings
  Class.forName(ImporterMeshInstance3D::class.java.name, true, ImporterMeshInstance3D::class.java.classLoader)
  ImporterMeshInstance3D.MethodBindings
  Class.forName(Input::class.java.name, true, Input::class.java.classLoader)
  Input.MethodBindings
  Class.forName(InputEvent::class.java.name, true, InputEvent::class.java.classLoader)
  InputEvent.MethodBindings
  Class.forName(InputEventAction::class.java.name, true, InputEventAction::class.java.classLoader)
  InputEventAction.MethodBindings
  Class.forName(InputEventFromWindow::class.java.name, true, InputEventFromWindow::class.java.classLoader)
  InputEventFromWindow.MethodBindings
  Class.forName(InputEventGesture::class.java.name, true, InputEventGesture::class.java.classLoader)
  InputEventGesture.MethodBindings
  Class.forName(InputEventJoypadButton::class.java.name, true, InputEventJoypadButton::class.java.classLoader)
  InputEventJoypadButton.MethodBindings
  Class.forName(InputEventJoypadMotion::class.java.name, true, InputEventJoypadMotion::class.java.classLoader)
  InputEventJoypadMotion.MethodBindings
  Class.forName(InputEventKey::class.java.name, true, InputEventKey::class.java.classLoader)
  InputEventKey.MethodBindings
  Class.forName(InputEventMIDI::class.java.name, true, InputEventMIDI::class.java.classLoader)
  InputEventMIDI.MethodBindings
  Class.forName(InputEventMagnifyGesture::class.java.name, true, InputEventMagnifyGesture::class.java.classLoader)
  InputEventMagnifyGesture.MethodBindings
  Class.forName(InputEventMouse::class.java.name, true, InputEventMouse::class.java.classLoader)
  InputEventMouse.MethodBindings
  Class.forName(InputEventMouseButton::class.java.name, true, InputEventMouseButton::class.java.classLoader)
  InputEventMouseButton.MethodBindings
  Class.forName(InputEventMouseMotion::class.java.name, true, InputEventMouseMotion::class.java.classLoader)
  InputEventMouseMotion.MethodBindings
  Class.forName(InputEventPanGesture::class.java.name, true, InputEventPanGesture::class.java.classLoader)
  InputEventPanGesture.MethodBindings
  Class.forName(InputEventScreenDrag::class.java.name, true, InputEventScreenDrag::class.java.classLoader)
  InputEventScreenDrag.MethodBindings
  Class.forName(InputEventScreenTouch::class.java.name, true, InputEventScreenTouch::class.java.classLoader)
  InputEventScreenTouch.MethodBindings
  Class.forName(InputEventShortcut::class.java.name, true, InputEventShortcut::class.java.classLoader)
  InputEventShortcut.MethodBindings
  Class.forName(InputEventWithModifiers::class.java.name, true, InputEventWithModifiers::class.java.classLoader)
  InputEventWithModifiers.MethodBindings
  Class.forName(InputMap::class.java.name, true, InputMap::class.java.classLoader)
  InputMap.MethodBindings
  Class.forName(InstancePlaceholder::class.java.name, true, InstancePlaceholder::class.java.classLoader)
  InstancePlaceholder.MethodBindings
  Class.forName(IntervalTweener::class.java.name, true, IntervalTweener::class.java.classLoader)
  IntervalTweener.MethodBindings
  Class.forName(ItemList::class.java.name, true, ItemList::class.java.classLoader)
  ItemList.MethodBindings
  Class.forName(IterateIK3D::class.java.name, true, IterateIK3D::class.java.classLoader)
  IterateIK3D.MethodBindings
  Class.forName(JNISingleton::class.java.name, true, JNISingleton::class.java.classLoader)
  JNISingleton.MethodBindings
  Class.forName(JSON::class.java.name, true, JSON::class.java.classLoader)
  JSON.MethodBindings
  Class.forName(JSONRPC::class.java.name, true, JSONRPC::class.java.classLoader)
  JSONRPC.MethodBindings
  Class.forName(JacobianIK3D::class.java.name, true, JacobianIK3D::class.java.classLoader)
  JacobianIK3D.MethodBindings
  Class.forName(JavaClass::class.java.name, true, JavaClass::class.java.classLoader)
  JavaClass.MethodBindings
  Class.forName(JavaClassWrapper::class.java.name, true, JavaClassWrapper::class.java.classLoader)
  JavaClassWrapper.MethodBindings
  Class.forName(JavaObject::class.java.name, true, JavaObject::class.java.classLoader)
  JavaObject.MethodBindings
  Class.forName(JavaScript::class.java.name, true, JavaScript::class.java.classLoader)
  JavaScript.MethodBindings
  Class.forName(JavaScriptBridge::class.java.name, true, JavaScriptBridge::class.java.classLoader)
  JavaScriptBridge.MethodBindings
  Class.forName(JavaScriptObject::class.java.name, true, JavaScriptObject::class.java.classLoader)
  JavaScriptObject.MethodBindings
  Class.forName(Joint2D::class.java.name, true, Joint2D::class.java.classLoader)
  Joint2D.MethodBindings
  Class.forName(Joint3D::class.java.name, true, Joint3D::class.java.classLoader)
  Joint3D.MethodBindings
  Class.forName(JointLimitation3D::class.java.name, true, JointLimitation3D::class.java.classLoader)
  JointLimitation3D.MethodBindings
  Class.forName(JointLimitationCone3D::class.java.name, true, JointLimitationCone3D::class.java.classLoader)
  JointLimitationCone3D.MethodBindings
  Class.forName(JvmScript::class.java.name, true, JvmScript::class.java.classLoader)
  JvmScript.MethodBindings
  Class.forName(KinematicCollision2D::class.java.name, true, KinematicCollision2D::class.java.classLoader)
  KinematicCollision2D.MethodBindings
  Class.forName(KinematicCollision3D::class.java.name, true, KinematicCollision3D::class.java.classLoader)
  KinematicCollision3D.MethodBindings
  Class.forName(KotlinScript::class.java.name, true, KotlinScript::class.java.classLoader)
  KotlinScript.MethodBindings
  Class.forName(Label::class.java.name, true, Label::class.java.classLoader)
  Label.MethodBindings
  Class.forName(Label3D::class.java.name, true, Label3D::class.java.classLoader)
  Label3D.MethodBindings
  Class.forName(LabelSettings::class.java.name, true, LabelSettings::class.java.classLoader)
  LabelSettings.MethodBindings
  Class.forName(Light2D::class.java.name, true, Light2D::class.java.classLoader)
  Light2D.MethodBindings
  Class.forName(Light3D::class.java.name, true, Light3D::class.java.classLoader)
  Light3D.MethodBindings
  Class.forName(LightOccluder2D::class.java.name, true, LightOccluder2D::class.java.classLoader)
  LightOccluder2D.MethodBindings
  Class.forName(LightmapGI::class.java.name, true, LightmapGI::class.java.classLoader)
  LightmapGI.MethodBindings
  Class.forName(LightmapGIData::class.java.name, true, LightmapGIData::class.java.classLoader)
  LightmapGIData.MethodBindings
  Class.forName(LightmapProbe::class.java.name, true, LightmapProbe::class.java.classLoader)
  LightmapProbe.MethodBindings
  Class.forName(Lightmapper::class.java.name, true, Lightmapper::class.java.classLoader)
  Lightmapper.MethodBindings
  Class.forName(LightmapperRD::class.java.name, true, LightmapperRD::class.java.classLoader)
  LightmapperRD.MethodBindings
  Class.forName(LimitAngularVelocityModifier3D::class.java.name, true, LimitAngularVelocityModifier3D::class.java.classLoader)
  LimitAngularVelocityModifier3D.MethodBindings
  Class.forName(Line2D::class.java.name, true, Line2D::class.java.classLoader)
  Line2D.MethodBindings
  Class.forName(LineEdit::class.java.name, true, LineEdit::class.java.classLoader)
  LineEdit.MethodBindings
  Class.forName(LinkButton::class.java.name, true, LinkButton::class.java.classLoader)
  LinkButton.MethodBindings
  Class.forName(Logger::class.java.name, true, Logger::class.java.classLoader)
  Logger.MethodBindings
  Class.forName(LookAtModifier3D::class.java.name, true, LookAtModifier3D::class.java.classLoader)
  LookAtModifier3D.MethodBindings
  Class.forName(MainLoop::class.java.name, true, MainLoop::class.java.classLoader)
  MainLoop.MethodBindings
  Class.forName(MarginContainer::class.java.name, true, MarginContainer::class.java.classLoader)
  MarginContainer.MethodBindings
  Class.forName(Marker2D::class.java.name, true, Marker2D::class.java.classLoader)
  Marker2D.MethodBindings
  Class.forName(Marker3D::class.java.name, true, Marker3D::class.java.classLoader)
  Marker3D.MethodBindings
  Class.forName(Marshalls::class.java.name, true, Marshalls::class.java.classLoader)
  Marshalls.MethodBindings
  Class.forName(Material::class.java.name, true, Material::class.java.classLoader)
  Material.MethodBindings
  Class.forName(MenuBar::class.java.name, true, MenuBar::class.java.classLoader)
  MenuBar.MethodBindings
  Class.forName(MenuButton::class.java.name, true, MenuButton::class.java.classLoader)
  MenuButton.MethodBindings
  Class.forName(Mesh::class.java.name, true, Mesh::class.java.classLoader)
  Mesh.MethodBindings
  Class.forName(MeshConvexDecompositionSettings::class.java.name, true, MeshConvexDecompositionSettings::class.java.classLoader)
  MeshConvexDecompositionSettings.MethodBindings
  Class.forName(MeshDataTool::class.java.name, true, MeshDataTool::class.java.classLoader)
  MeshDataTool.MethodBindings
  Class.forName(MeshInstance2D::class.java.name, true, MeshInstance2D::class.java.classLoader)
  MeshInstance2D.MethodBindings
  Class.forName(MeshInstance3D::class.java.name, true, MeshInstance3D::class.java.classLoader)
  MeshInstance3D.MethodBindings
  Class.forName(MeshLibrary::class.java.name, true, MeshLibrary::class.java.classLoader)
  MeshLibrary.MethodBindings
  Class.forName(MeshTexture::class.java.name, true, MeshTexture::class.java.classLoader)
  MeshTexture.MethodBindings
  Class.forName(MethodTweener::class.java.name, true, MethodTweener::class.java.classLoader)
  MethodTweener.MethodBindings
  Class.forName(MissingNode::class.java.name, true, MissingNode::class.java.classLoader)
  MissingNode.MethodBindings
  Class.forName(MissingResource::class.java.name, true, MissingResource::class.java.classLoader)
  MissingResource.MethodBindings
  Class.forName(MobileVRInterface::class.java.name, true, MobileVRInterface::class.java.classLoader)
  MobileVRInterface.MethodBindings
  Class.forName(ModifierBoneTarget3D::class.java.name, true, ModifierBoneTarget3D::class.java.classLoader)
  ModifierBoneTarget3D.MethodBindings
  Class.forName(MovieWriter::class.java.name, true, MovieWriter::class.java.classLoader)
  MovieWriter.MethodBindings
  Class.forName(MultiMesh::class.java.name, true, MultiMesh::class.java.classLoader)
  MultiMesh.MethodBindings
  Class.forName(MultiMeshInstance2D::class.java.name, true, MultiMeshInstance2D::class.java.classLoader)
  MultiMeshInstance2D.MethodBindings
  Class.forName(MultiMeshInstance3D::class.java.name, true, MultiMeshInstance3D::class.java.classLoader)
  MultiMeshInstance3D.MethodBindings
  Class.forName(MultiplayerAPI::class.java.name, true, MultiplayerAPI::class.java.classLoader)
  MultiplayerAPI.MethodBindings
  Class.forName(MultiplayerAPIExtension::class.java.name, true, MultiplayerAPIExtension::class.java.classLoader)
  MultiplayerAPIExtension.MethodBindings
  Class.forName(MultiplayerPeer::class.java.name, true, MultiplayerPeer::class.java.classLoader)
  MultiplayerPeer.MethodBindings
  Class.forName(MultiplayerPeerExtension::class.java.name, true, MultiplayerPeerExtension::class.java.classLoader)
  MultiplayerPeerExtension.MethodBindings
  Class.forName(MultiplayerSpawner::class.java.name, true, MultiplayerSpawner::class.java.classLoader)
  MultiplayerSpawner.MethodBindings
  Class.forName(MultiplayerSynchronizer::class.java.name, true, MultiplayerSynchronizer::class.java.classLoader)
  MultiplayerSynchronizer.MethodBindings
  Class.forName(Mutex::class.java.name, true, Mutex::class.java.classLoader)
  Mutex.MethodBindings
  Class.forName(NativeMenu::class.java.name, true, NativeMenu::class.java.classLoader)
  NativeMenu.MethodBindings
  Class.forName(NavigationAgent2D::class.java.name, true, NavigationAgent2D::class.java.classLoader)
  NavigationAgent2D.MethodBindings
  Class.forName(NavigationAgent3D::class.java.name, true, NavigationAgent3D::class.java.classLoader)
  NavigationAgent3D.MethodBindings
  Class.forName(NavigationLink2D::class.java.name, true, NavigationLink2D::class.java.classLoader)
  NavigationLink2D.MethodBindings
  Class.forName(NavigationLink3D::class.java.name, true, NavigationLink3D::class.java.classLoader)
  NavigationLink3D.MethodBindings
  Class.forName(NavigationMesh::class.java.name, true, NavigationMesh::class.java.classLoader)
  NavigationMesh.MethodBindings
  Class.forName(NavigationMeshGenerator::class.java.name, true, NavigationMeshGenerator::class.java.classLoader)
  NavigationMeshGenerator.MethodBindings
  Class.forName(NavigationMeshSourceGeometryData2D::class.java.name, true, NavigationMeshSourceGeometryData2D::class.java.classLoader)
  NavigationMeshSourceGeometryData2D.MethodBindings
  Class.forName(NavigationMeshSourceGeometryData3D::class.java.name, true, NavigationMeshSourceGeometryData3D::class.java.classLoader)
  NavigationMeshSourceGeometryData3D.MethodBindings
  Class.forName(NavigationObstacle2D::class.java.name, true, NavigationObstacle2D::class.java.classLoader)
  NavigationObstacle2D.MethodBindings
  Class.forName(NavigationObstacle3D::class.java.name, true, NavigationObstacle3D::class.java.classLoader)
  NavigationObstacle3D.MethodBindings
  Class.forName(NavigationPathQueryParameters2D::class.java.name, true, NavigationPathQueryParameters2D::class.java.classLoader)
  NavigationPathQueryParameters2D.MethodBindings
  Class.forName(NavigationPathQueryParameters3D::class.java.name, true, NavigationPathQueryParameters3D::class.java.classLoader)
  NavigationPathQueryParameters3D.MethodBindings
  Class.forName(NavigationPathQueryResult2D::class.java.name, true, NavigationPathQueryResult2D::class.java.classLoader)
  NavigationPathQueryResult2D.MethodBindings
  Class.forName(NavigationPathQueryResult3D::class.java.name, true, NavigationPathQueryResult3D::class.java.classLoader)
  NavigationPathQueryResult3D.MethodBindings
  Class.forName(NavigationPolygon::class.java.name, true, NavigationPolygon::class.java.classLoader)
  NavigationPolygon.MethodBindings
  Class.forName(NavigationRegion2D::class.java.name, true, NavigationRegion2D::class.java.classLoader)
  NavigationRegion2D.MethodBindings
  Class.forName(NavigationRegion3D::class.java.name, true, NavigationRegion3D::class.java.classLoader)
  NavigationRegion3D.MethodBindings
  Class.forName(NavigationServer2D::class.java.name, true, NavigationServer2D::class.java.classLoader)
  NavigationServer2D.MethodBindings
  Class.forName(NavigationServer2DManager::class.java.name, true, NavigationServer2DManager::class.java.classLoader)
  NavigationServer2DManager.MethodBindings
  Class.forName(NavigationServer3D::class.java.name, true, NavigationServer3D::class.java.classLoader)
  NavigationServer3D.MethodBindings
  Class.forName(NavigationServer3DManager::class.java.name, true, NavigationServer3DManager::class.java.classLoader)
  NavigationServer3DManager.MethodBindings
  Class.forName(NinePatchRect::class.java.name, true, NinePatchRect::class.java.classLoader)
  NinePatchRect.MethodBindings
  Class.forName(Node::class.java.name, true, Node::class.java.classLoader)
  Node.MethodBindings
  Class.forName(Node2D::class.java.name, true, Node2D::class.java.classLoader)
  Node2D.MethodBindings
  Class.forName(Node3D::class.java.name, true, Node3D::class.java.classLoader)
  Node3D.MethodBindings
  Class.forName(Node3DGizmo::class.java.name, true, Node3DGizmo::class.java.classLoader)
  Node3DGizmo.MethodBindings
  Class.forName(Noise::class.java.name, true, Noise::class.java.classLoader)
  Noise.MethodBindings
  Class.forName(NoiseTexture2D::class.java.name, true, NoiseTexture2D::class.java.classLoader)
  NoiseTexture2D.MethodBindings
  Class.forName(NoiseTexture3D::class.java.name, true, NoiseTexture3D::class.java.classLoader)
  NoiseTexture3D.MethodBindings
  Class.forName(ORMMaterial3D::class.java.name, true, ORMMaterial3D::class.java.classLoader)
  ORMMaterial3D.MethodBindings
  Class.forName(OS::class.java.name, true, OS::class.java.classLoader)
  OS.MethodBindings
  Class.forName(Object::class.java.name, true, Object::class.java.classLoader)
  Object.MethodBindings
  Class.forName(Occluder3D::class.java.name, true, Occluder3D::class.java.classLoader)
  Occluder3D.MethodBindings
  Class.forName(OccluderInstance3D::class.java.name, true, OccluderInstance3D::class.java.classLoader)
  OccluderInstance3D.MethodBindings
  Class.forName(OccluderPolygon2D::class.java.name, true, OccluderPolygon2D::class.java.classLoader)
  OccluderPolygon2D.MethodBindings
  Class.forName(OfflineMultiplayerPeer::class.java.name, true, OfflineMultiplayerPeer::class.java.classLoader)
  OfflineMultiplayerPeer.MethodBindings
  Class.forName(OggPacketSequence::class.java.name, true, OggPacketSequence::class.java.classLoader)
  OggPacketSequence.MethodBindings
  Class.forName(OggPacketSequencePlayback::class.java.name, true, OggPacketSequencePlayback::class.java.classLoader)
  OggPacketSequencePlayback.MethodBindings
  Class.forName(OmniLight3D::class.java.name, true, OmniLight3D::class.java.classLoader)
  OmniLight3D.MethodBindings
  Class.forName(OpenXRAPIExtension::class.java.name, true, OpenXRAPIExtension::class.java.classLoader)
  OpenXRAPIExtension.MethodBindings
  Class.forName(OpenXRAction::class.java.name, true, OpenXRAction::class.java.classLoader)
  OpenXRAction.MethodBindings
  Class.forName(OpenXRActionBindingModifier::class.java.name, true, OpenXRActionBindingModifier::class.java.classLoader)
  OpenXRActionBindingModifier.MethodBindings
  Class.forName(OpenXRActionMap::class.java.name, true, OpenXRActionMap::class.java.classLoader)
  OpenXRActionMap.MethodBindings
  Class.forName(OpenXRActionSet::class.java.name, true, OpenXRActionSet::class.java.classLoader)
  OpenXRActionSet.MethodBindings
  Class.forName(OpenXRAnalogThresholdModifier::class.java.name, true, OpenXRAnalogThresholdModifier::class.java.classLoader)
  OpenXRAnalogThresholdModifier.MethodBindings
  Class.forName(OpenXRAnchorTracker::class.java.name, true, OpenXRAnchorTracker::class.java.classLoader)
  OpenXRAnchorTracker.MethodBindings
  Class.forName(OpenXRAndroidThreadSettingsExtension::class.java.name, true, OpenXRAndroidThreadSettingsExtension::class.java.classLoader)
  OpenXRAndroidThreadSettingsExtension.MethodBindings
  Class.forName(OpenXRBindingModifier::class.java.name, true, OpenXRBindingModifier::class.java.classLoader)
  OpenXRBindingModifier.MethodBindings
  Class.forName(OpenXRCompositionLayer::class.java.name, true, OpenXRCompositionLayer::class.java.classLoader)
  OpenXRCompositionLayer.MethodBindings
  Class.forName(OpenXRCompositionLayerCylinder::class.java.name, true, OpenXRCompositionLayerCylinder::class.java.classLoader)
  OpenXRCompositionLayerCylinder.MethodBindings
  Class.forName(OpenXRCompositionLayerEquirect::class.java.name, true, OpenXRCompositionLayerEquirect::class.java.classLoader)
  OpenXRCompositionLayerEquirect.MethodBindings
  Class.forName(OpenXRCompositionLayerQuad::class.java.name, true, OpenXRCompositionLayerQuad::class.java.classLoader)
  OpenXRCompositionLayerQuad.MethodBindings
  Class.forName(OpenXRDpadBindingModifier::class.java.name, true, OpenXRDpadBindingModifier::class.java.classLoader)
  OpenXRDpadBindingModifier.MethodBindings
  Class.forName(OpenXRExtensionWrapper::class.java.name, true, OpenXRExtensionWrapper::class.java.classLoader)
  OpenXRExtensionWrapper.MethodBindings
  Class.forName(OpenXRExtensionWrapperExtension::class.java.name, true, OpenXRExtensionWrapperExtension::class.java.classLoader)
  OpenXRExtensionWrapperExtension.MethodBindings
  Class.forName(OpenXRFrameSynthesisExtension::class.java.name, true, OpenXRFrameSynthesisExtension::class.java.classLoader)
  OpenXRFrameSynthesisExtension.MethodBindings
  Class.forName(OpenXRFutureExtension::class.java.name, true, OpenXRFutureExtension::class.java.classLoader)
  OpenXRFutureExtension.MethodBindings
  Class.forName(OpenXRFutureResult::class.java.name, true, OpenXRFutureResult::class.java.classLoader)
  OpenXRFutureResult.MethodBindings
  Class.forName(OpenXRHand::class.java.name, true, OpenXRHand::class.java.classLoader)
  OpenXRHand.MethodBindings
  Class.forName(OpenXRHapticBase::class.java.name, true, OpenXRHapticBase::class.java.classLoader)
  OpenXRHapticBase.MethodBindings
  Class.forName(OpenXRHapticVibration::class.java.name, true, OpenXRHapticVibration::class.java.classLoader)
  OpenXRHapticVibration.MethodBindings
  Class.forName(OpenXRIPBinding::class.java.name, true, OpenXRIPBinding::class.java.classLoader)
  OpenXRIPBinding.MethodBindings
  Class.forName(OpenXRIPBindingModifier::class.java.name, true, OpenXRIPBindingModifier::class.java.classLoader)
  OpenXRIPBindingModifier.MethodBindings
  Class.forName(OpenXRInteractionProfile::class.java.name, true, OpenXRInteractionProfile::class.java.classLoader)
  OpenXRInteractionProfile.MethodBindings
  Class.forName(OpenXRInteractionProfileMetadata::class.java.name, true, OpenXRInteractionProfileMetadata::class.java.classLoader)
  OpenXRInteractionProfileMetadata.MethodBindings
  Class.forName(OpenXRInterface::class.java.name, true, OpenXRInterface::class.java.classLoader)
  OpenXRInterface.MethodBindings
  Class.forName(OpenXRMarkerTracker::class.java.name, true, OpenXRMarkerTracker::class.java.classLoader)
  OpenXRMarkerTracker.MethodBindings
  Class.forName(OpenXRPlaneTracker::class.java.name, true, OpenXRPlaneTracker::class.java.classLoader)
  OpenXRPlaneTracker.MethodBindings
  Class.forName(OpenXRRenderModel::class.java.name, true, OpenXRRenderModel::class.java.classLoader)
  OpenXRRenderModel.MethodBindings
  Class.forName(OpenXRRenderModelExtension::class.java.name, true, OpenXRRenderModelExtension::class.java.classLoader)
  OpenXRRenderModelExtension.MethodBindings
  Class.forName(OpenXRRenderModelManager::class.java.name, true, OpenXRRenderModelManager::class.java.classLoader)
  OpenXRRenderModelManager.MethodBindings
  Class.forName(OpenXRSpatialAnchorCapability::class.java.name, true, OpenXRSpatialAnchorCapability::class.java.classLoader)
  OpenXRSpatialAnchorCapability.MethodBindings
  Class.forName(OpenXRSpatialCapabilityConfigurationAnchor::class.java.name, true, OpenXRSpatialCapabilityConfigurationAnchor::class.java.classLoader)
  OpenXRSpatialCapabilityConfigurationAnchor.MethodBindings
  Class.forName(OpenXRSpatialCapabilityConfigurationAprilTag::class.java.name, true, OpenXRSpatialCapabilityConfigurationAprilTag::class.java.classLoader)
  OpenXRSpatialCapabilityConfigurationAprilTag.MethodBindings
  Class.forName(OpenXRSpatialCapabilityConfigurationAruco::class.java.name, true, OpenXRSpatialCapabilityConfigurationAruco::class.java.classLoader)
  OpenXRSpatialCapabilityConfigurationAruco.MethodBindings
  Class.forName(OpenXRSpatialCapabilityConfigurationBaseHeader::class.java.name, true, OpenXRSpatialCapabilityConfigurationBaseHeader::class.java.classLoader)
  OpenXRSpatialCapabilityConfigurationBaseHeader.MethodBindings
  Class.forName(OpenXRSpatialCapabilityConfigurationMicroQrCode::class.java.name, true, OpenXRSpatialCapabilityConfigurationMicroQrCode::class.java.classLoader)
  OpenXRSpatialCapabilityConfigurationMicroQrCode.MethodBindings
  Class.forName(OpenXRSpatialCapabilityConfigurationPlaneTracking::class.java.name, true, OpenXRSpatialCapabilityConfigurationPlaneTracking::class.java.classLoader)
  OpenXRSpatialCapabilityConfigurationPlaneTracking.MethodBindings
  Class.forName(OpenXRSpatialCapabilityConfigurationQrCode::class.java.name, true, OpenXRSpatialCapabilityConfigurationQrCode::class.java.classLoader)
  OpenXRSpatialCapabilityConfigurationQrCode.MethodBindings
  Class.forName(OpenXRSpatialComponentAnchorList::class.java.name, true, OpenXRSpatialComponentAnchorList::class.java.classLoader)
  OpenXRSpatialComponentAnchorList.MethodBindings
  Class.forName(OpenXRSpatialComponentBounded2DList::class.java.name, true, OpenXRSpatialComponentBounded2DList::class.java.classLoader)
  OpenXRSpatialComponentBounded2DList.MethodBindings
  Class.forName(OpenXRSpatialComponentBounded3DList::class.java.name, true, OpenXRSpatialComponentBounded3DList::class.java.classLoader)
  OpenXRSpatialComponentBounded3DList.MethodBindings
  Class.forName(OpenXRSpatialComponentData::class.java.name, true, OpenXRSpatialComponentData::class.java.classLoader)
  OpenXRSpatialComponentData.MethodBindings
  Class.forName(OpenXRSpatialComponentMarkerList::class.java.name, true, OpenXRSpatialComponentMarkerList::class.java.classLoader)
  OpenXRSpatialComponentMarkerList.MethodBindings
  Class.forName(OpenXRSpatialComponentMesh2DList::class.java.name, true, OpenXRSpatialComponentMesh2DList::class.java.classLoader)
  OpenXRSpatialComponentMesh2DList.MethodBindings
  Class.forName(OpenXRSpatialComponentMesh3DList::class.java.name, true, OpenXRSpatialComponentMesh3DList::class.java.classLoader)
  OpenXRSpatialComponentMesh3DList.MethodBindings
  Class.forName(OpenXRSpatialComponentParentList::class.java.name, true, OpenXRSpatialComponentParentList::class.java.classLoader)
  OpenXRSpatialComponentParentList.MethodBindings
  Class.forName(OpenXRSpatialComponentPersistenceList::class.java.name, true, OpenXRSpatialComponentPersistenceList::class.java.classLoader)
  OpenXRSpatialComponentPersistenceList.MethodBindings
  Class.forName(OpenXRSpatialComponentPlaneAlignmentList::class.java.name, true, OpenXRSpatialComponentPlaneAlignmentList::class.java.classLoader)
  OpenXRSpatialComponentPlaneAlignmentList.MethodBindings
  Class.forName(OpenXRSpatialComponentPlaneSemanticLabelList::class.java.name, true, OpenXRSpatialComponentPlaneSemanticLabelList::class.java.classLoader)
  OpenXRSpatialComponentPlaneSemanticLabelList.MethodBindings
  Class.forName(OpenXRSpatialComponentPolygon2DList::class.java.name, true, OpenXRSpatialComponentPolygon2DList::class.java.classLoader)
  OpenXRSpatialComponentPolygon2DList.MethodBindings
  Class.forName(OpenXRSpatialContextPersistenceConfig::class.java.name, true, OpenXRSpatialContextPersistenceConfig::class.java.classLoader)
  OpenXRSpatialContextPersistenceConfig.MethodBindings
  Class.forName(OpenXRSpatialEntityExtension::class.java.name, true, OpenXRSpatialEntityExtension::class.java.classLoader)
  OpenXRSpatialEntityExtension.MethodBindings
  Class.forName(OpenXRSpatialEntityTracker::class.java.name, true, OpenXRSpatialEntityTracker::class.java.classLoader)
  OpenXRSpatialEntityTracker.MethodBindings
  Class.forName(OpenXRSpatialMarkerTrackingCapability::class.java.name, true, OpenXRSpatialMarkerTrackingCapability::class.java.classLoader)
  OpenXRSpatialMarkerTrackingCapability.MethodBindings
  Class.forName(OpenXRSpatialPlaneTrackingCapability::class.java.name, true, OpenXRSpatialPlaneTrackingCapability::class.java.classLoader)
  OpenXRSpatialPlaneTrackingCapability.MethodBindings
  Class.forName(OpenXRSpatialQueryResultData::class.java.name, true, OpenXRSpatialQueryResultData::class.java.classLoader)
  OpenXRSpatialQueryResultData.MethodBindings
  Class.forName(OpenXRStructureBase::class.java.name, true, OpenXRStructureBase::class.java.classLoader)
  OpenXRStructureBase.MethodBindings
  Class.forName(OpenXRVisibilityMask::class.java.name, true, OpenXRVisibilityMask::class.java.classLoader)
  OpenXRVisibilityMask.MethodBindings
  Class.forName(OptimizedTranslation::class.java.name, true, OptimizedTranslation::class.java.classLoader)
  OptimizedTranslation.MethodBindings
  Class.forName(OptionButton::class.java.name, true, OptionButton::class.java.classLoader)
  OptionButton.MethodBindings
  Class.forName(PCKPacker::class.java.name, true, PCKPacker::class.java.classLoader)
  PCKPacker.MethodBindings
  Class.forName(PackedDataContainer::class.java.name, true, PackedDataContainer::class.java.classLoader)
  PackedDataContainer.MethodBindings
  Class.forName(PackedDataContainerRef::class.java.name, true, PackedDataContainerRef::class.java.classLoader)
  PackedDataContainerRef.MethodBindings
  Class.forName(PackedScene::class.java.name, true, PackedScene::class.java.classLoader)
  PackedScene.MethodBindings
  Class.forName(PacketPeer::class.java.name, true, PacketPeer::class.java.classLoader)
  PacketPeer.MethodBindings
  Class.forName(PacketPeerDTLS::class.java.name, true, PacketPeerDTLS::class.java.classLoader)
  PacketPeerDTLS.MethodBindings
  Class.forName(PacketPeerExtension::class.java.name, true, PacketPeerExtension::class.java.classLoader)
  PacketPeerExtension.MethodBindings
  Class.forName(PacketPeerStream::class.java.name, true, PacketPeerStream::class.java.classLoader)
  PacketPeerStream.MethodBindings
  Class.forName(PacketPeerUDP::class.java.name, true, PacketPeerUDP::class.java.classLoader)
  PacketPeerUDP.MethodBindings
  Class.forName(Panel::class.java.name, true, Panel::class.java.classLoader)
  Panel.MethodBindings
  Class.forName(PanelContainer::class.java.name, true, PanelContainer::class.java.classLoader)
  PanelContainer.MethodBindings
  Class.forName(PanoramaSkyMaterial::class.java.name, true, PanoramaSkyMaterial::class.java.classLoader)
  PanoramaSkyMaterial.MethodBindings
  Class.forName(Parallax2D::class.java.name, true, Parallax2D::class.java.classLoader)
  Parallax2D.MethodBindings
  Class.forName(ParallaxBackground::class.java.name, true, ParallaxBackground::class.java.classLoader)
  ParallaxBackground.MethodBindings
  Class.forName(ParallaxLayer::class.java.name, true, ParallaxLayer::class.java.classLoader)
  ParallaxLayer.MethodBindings
  Class.forName(ParticleProcessMaterial::class.java.name, true, ParticleProcessMaterial::class.java.classLoader)
  ParticleProcessMaterial.MethodBindings
  Class.forName(Path2D::class.java.name, true, Path2D::class.java.classLoader)
  Path2D.MethodBindings
  Class.forName(Path3D::class.java.name, true, Path3D::class.java.classLoader)
  Path3D.MethodBindings
  Class.forName(PathFollow2D::class.java.name, true, PathFollow2D::class.java.classLoader)
  PathFollow2D.MethodBindings
  Class.forName(PathFollow3D::class.java.name, true, PathFollow3D::class.java.classLoader)
  PathFollow3D.MethodBindings
  Class.forName(Performance::class.java.name, true, Performance::class.java.classLoader)
  Performance.MethodBindings
  Class.forName(PhysicalBone2D::class.java.name, true, PhysicalBone2D::class.java.classLoader)
  PhysicalBone2D.MethodBindings
  Class.forName(PhysicalBone3D::class.java.name, true, PhysicalBone3D::class.java.classLoader)
  PhysicalBone3D.MethodBindings
  Class.forName(PhysicalBoneSimulator3D::class.java.name, true, PhysicalBoneSimulator3D::class.java.classLoader)
  PhysicalBoneSimulator3D.MethodBindings
  Class.forName(PhysicalSkyMaterial::class.java.name, true, PhysicalSkyMaterial::class.java.classLoader)
  PhysicalSkyMaterial.MethodBindings
  Class.forName(PhysicsBody2D::class.java.name, true, PhysicsBody2D::class.java.classLoader)
  PhysicsBody2D.MethodBindings
  Class.forName(PhysicsBody3D::class.java.name, true, PhysicsBody3D::class.java.classLoader)
  PhysicsBody3D.MethodBindings
  Class.forName(PhysicsDirectBodyState2D::class.java.name, true, PhysicsDirectBodyState2D::class.java.classLoader)
  PhysicsDirectBodyState2D.MethodBindings
  Class.forName(PhysicsDirectBodyState2DExtension::class.java.name, true, PhysicsDirectBodyState2DExtension::class.java.classLoader)
  PhysicsDirectBodyState2DExtension.MethodBindings
  Class.forName(PhysicsDirectBodyState3D::class.java.name, true, PhysicsDirectBodyState3D::class.java.classLoader)
  PhysicsDirectBodyState3D.MethodBindings
  Class.forName(PhysicsDirectBodyState3DExtension::class.java.name, true, PhysicsDirectBodyState3DExtension::class.java.classLoader)
  PhysicsDirectBodyState3DExtension.MethodBindings
  Class.forName(PhysicsDirectSpaceState2D::class.java.name, true, PhysicsDirectSpaceState2D::class.java.classLoader)
  PhysicsDirectSpaceState2D.MethodBindings
  Class.forName(PhysicsDirectSpaceState2DExtension::class.java.name, true, PhysicsDirectSpaceState2DExtension::class.java.classLoader)
  PhysicsDirectSpaceState2DExtension.MethodBindings
  Class.forName(PhysicsDirectSpaceState3D::class.java.name, true, PhysicsDirectSpaceState3D::class.java.classLoader)
  PhysicsDirectSpaceState3D.MethodBindings
  Class.forName(PhysicsDirectSpaceState3DExtension::class.java.name, true, PhysicsDirectSpaceState3DExtension::class.java.classLoader)
  PhysicsDirectSpaceState3DExtension.MethodBindings
  Class.forName(PhysicsMaterial::class.java.name, true, PhysicsMaterial::class.java.classLoader)
  PhysicsMaterial.MethodBindings
  Class.forName(PhysicsPointQueryParameters2D::class.java.name, true, PhysicsPointQueryParameters2D::class.java.classLoader)
  PhysicsPointQueryParameters2D.MethodBindings
  Class.forName(PhysicsPointQueryParameters3D::class.java.name, true, PhysicsPointQueryParameters3D::class.java.classLoader)
  PhysicsPointQueryParameters3D.MethodBindings
  Class.forName(PhysicsRayQueryParameters2D::class.java.name, true, PhysicsRayQueryParameters2D::class.java.classLoader)
  PhysicsRayQueryParameters2D.MethodBindings
  Class.forName(PhysicsRayQueryParameters3D::class.java.name, true, PhysicsRayQueryParameters3D::class.java.classLoader)
  PhysicsRayQueryParameters3D.MethodBindings
  Class.forName(PhysicsServer2D::class.java.name, true, PhysicsServer2D::class.java.classLoader)
  PhysicsServer2D.MethodBindings
  Class.forName(PhysicsServer2DManager::class.java.name, true, PhysicsServer2DManager::class.java.classLoader)
  PhysicsServer2DManager.MethodBindings
  Class.forName(PhysicsServer3D::class.java.name, true, PhysicsServer3D::class.java.classLoader)
  PhysicsServer3D.MethodBindings
  Class.forName(PhysicsServer3DManager::class.java.name, true, PhysicsServer3DManager::class.java.classLoader)
  PhysicsServer3DManager.MethodBindings
  Class.forName(PhysicsServer3DRenderingServerHandler::class.java.name, true, PhysicsServer3DRenderingServerHandler::class.java.classLoader)
  PhysicsServer3DRenderingServerHandler.MethodBindings
  Class.forName(PhysicsShapeQueryParameters2D::class.java.name, true, PhysicsShapeQueryParameters2D::class.java.classLoader)
  PhysicsShapeQueryParameters2D.MethodBindings
  Class.forName(PhysicsShapeQueryParameters3D::class.java.name, true, PhysicsShapeQueryParameters3D::class.java.classLoader)
  PhysicsShapeQueryParameters3D.MethodBindings
  Class.forName(PhysicsTestMotionParameters2D::class.java.name, true, PhysicsTestMotionParameters2D::class.java.classLoader)
  PhysicsTestMotionParameters2D.MethodBindings
  Class.forName(PhysicsTestMotionParameters3D::class.java.name, true, PhysicsTestMotionParameters3D::class.java.classLoader)
  PhysicsTestMotionParameters3D.MethodBindings
  Class.forName(PhysicsTestMotionResult2D::class.java.name, true, PhysicsTestMotionResult2D::class.java.classLoader)
  PhysicsTestMotionResult2D.MethodBindings
  Class.forName(PhysicsTestMotionResult3D::class.java.name, true, PhysicsTestMotionResult3D::class.java.classLoader)
  PhysicsTestMotionResult3D.MethodBindings
  Class.forName(PinJoint2D::class.java.name, true, PinJoint2D::class.java.classLoader)
  PinJoint2D.MethodBindings
  Class.forName(PinJoint3D::class.java.name, true, PinJoint3D::class.java.classLoader)
  PinJoint3D.MethodBindings
  Class.forName(PlaceholderCubemap::class.java.name, true, PlaceholderCubemap::class.java.classLoader)
  PlaceholderCubemap.MethodBindings
  Class.forName(PlaceholderCubemapArray::class.java.name, true, PlaceholderCubemapArray::class.java.classLoader)
  PlaceholderCubemapArray.MethodBindings
  Class.forName(PlaceholderMaterial::class.java.name, true, PlaceholderMaterial::class.java.classLoader)
  PlaceholderMaterial.MethodBindings
  Class.forName(PlaceholderMesh::class.java.name, true, PlaceholderMesh::class.java.classLoader)
  PlaceholderMesh.MethodBindings
  Class.forName(PlaceholderTexture2D::class.java.name, true, PlaceholderTexture2D::class.java.classLoader)
  PlaceholderTexture2D.MethodBindings
  Class.forName(PlaceholderTexture2DArray::class.java.name, true, PlaceholderTexture2DArray::class.java.classLoader)
  PlaceholderTexture2DArray.MethodBindings
  Class.forName(PlaceholderTexture3D::class.java.name, true, PlaceholderTexture3D::class.java.classLoader)
  PlaceholderTexture3D.MethodBindings
  Class.forName(PlaceholderTextureLayered::class.java.name, true, PlaceholderTextureLayered::class.java.classLoader)
  PlaceholderTextureLayered.MethodBindings
  Class.forName(PlaneMesh::class.java.name, true, PlaneMesh::class.java.classLoader)
  PlaneMesh.MethodBindings
  Class.forName(PointLight2D::class.java.name, true, PointLight2D::class.java.classLoader)
  PointLight2D.MethodBindings
  Class.forName(PointMesh::class.java.name, true, PointMesh::class.java.classLoader)
  PointMesh.MethodBindings
  Class.forName(Polygon2D::class.java.name, true, Polygon2D::class.java.classLoader)
  Polygon2D.MethodBindings
  Class.forName(PolygonOccluder3D::class.java.name, true, PolygonOccluder3D::class.java.classLoader)
  PolygonOccluder3D.MethodBindings
  Class.forName(PolygonPathFinder::class.java.name, true, PolygonPathFinder::class.java.classLoader)
  PolygonPathFinder.MethodBindings
  Class.forName(Popup::class.java.name, true, Popup::class.java.classLoader)
  Popup.MethodBindings
  Class.forName(PopupMenu::class.java.name, true, PopupMenu::class.java.classLoader)
  PopupMenu.MethodBindings
  Class.forName(PopupPanel::class.java.name, true, PopupPanel::class.java.classLoader)
  PopupPanel.MethodBindings
  Class.forName(PortableCompressedTexture2D::class.java.name, true, PortableCompressedTexture2D::class.java.classLoader)
  PortableCompressedTexture2D.MethodBindings
  Class.forName(PrimitiveMesh::class.java.name, true, PrimitiveMesh::class.java.classLoader)
  PrimitiveMesh.MethodBindings
  Class.forName(PrismMesh::class.java.name, true, PrismMesh::class.java.classLoader)
  PrismMesh.MethodBindings
  Class.forName(ProceduralSkyMaterial::class.java.name, true, ProceduralSkyMaterial::class.java.classLoader)
  ProceduralSkyMaterial.MethodBindings
  Class.forName(ProgressBar::class.java.name, true, ProgressBar::class.java.classLoader)
  ProgressBar.MethodBindings
  Class.forName(ProjectSettings::class.java.name, true, ProjectSettings::class.java.classLoader)
  ProjectSettings.MethodBindings
  Class.forName(PropertyTweener::class.java.name, true, PropertyTweener::class.java.classLoader)
  PropertyTweener.MethodBindings
  Class.forName(QuadMesh::class.java.name, true, QuadMesh::class.java.classLoader)
  QuadMesh.MethodBindings
  Class.forName(QuadOccluder3D::class.java.name, true, QuadOccluder3D::class.java.classLoader)
  QuadOccluder3D.MethodBindings
  Class.forName(RDAccelerationStructureGeometry::class.java.name, true, RDAccelerationStructureGeometry::class.java.classLoader)
  RDAccelerationStructureGeometry.MethodBindings
  Class.forName(RDAccelerationStructureInstance::class.java.name, true, RDAccelerationStructureInstance::class.java.classLoader)
  RDAccelerationStructureInstance.MethodBindings
  Class.forName(RDAttachmentFormat::class.java.name, true, RDAttachmentFormat::class.java.classLoader)
  RDAttachmentFormat.MethodBindings
  Class.forName(RDFramebufferPass::class.java.name, true, RDFramebufferPass::class.java.classLoader)
  RDFramebufferPass.MethodBindings
  Class.forName(RDHitGroup::class.java.name, true, RDHitGroup::class.java.classLoader)
  RDHitGroup.MethodBindings
  Class.forName(RDPipelineColorBlendState::class.java.name, true, RDPipelineColorBlendState::class.java.classLoader)
  RDPipelineColorBlendState.MethodBindings
  Class.forName(RDPipelineColorBlendStateAttachment::class.java.name, true, RDPipelineColorBlendStateAttachment::class.java.classLoader)
  RDPipelineColorBlendStateAttachment.MethodBindings
  Class.forName(RDPipelineDepthStencilState::class.java.name, true, RDPipelineDepthStencilState::class.java.classLoader)
  RDPipelineDepthStencilState.MethodBindings
  Class.forName(RDPipelineMultisampleState::class.java.name, true, RDPipelineMultisampleState::class.java.classLoader)
  RDPipelineMultisampleState.MethodBindings
  Class.forName(RDPipelineRasterizationState::class.java.name, true, RDPipelineRasterizationState::class.java.classLoader)
  RDPipelineRasterizationState.MethodBindings
  Class.forName(RDPipelineShader::class.java.name, true, RDPipelineShader::class.java.classLoader)
  RDPipelineShader.MethodBindings
  Class.forName(RDPipelineSpecializationConstant::class.java.name, true, RDPipelineSpecializationConstant::class.java.classLoader)
  RDPipelineSpecializationConstant.MethodBindings
  Class.forName(RDSamplerState::class.java.name, true, RDSamplerState::class.java.classLoader)
  RDSamplerState.MethodBindings
  Class.forName(RDShaderFile::class.java.name, true, RDShaderFile::class.java.classLoader)
  RDShaderFile.MethodBindings
  Class.forName(RDShaderSPIRV::class.java.name, true, RDShaderSPIRV::class.java.classLoader)
  RDShaderSPIRV.MethodBindings
  Class.forName(RDShaderSource::class.java.name, true, RDShaderSource::class.java.classLoader)
  RDShaderSource.MethodBindings
  Class.forName(RDTextureFormat::class.java.name, true, RDTextureFormat::class.java.classLoader)
  RDTextureFormat.MethodBindings
  Class.forName(RDTextureView::class.java.name, true, RDTextureView::class.java.classLoader)
  RDTextureView.MethodBindings
  Class.forName(RDUniform::class.java.name, true, RDUniform::class.java.classLoader)
  RDUniform.MethodBindings
  Class.forName(RDVertexAttribute::class.java.name, true, RDVertexAttribute::class.java.classLoader)
  RDVertexAttribute.MethodBindings
  Class.forName(RandomNumberGenerator::class.java.name, true, RandomNumberGenerator::class.java.classLoader)
  RandomNumberGenerator.MethodBindings
  Class.forName(Range::class.java.name, true, Range::class.java.classLoader)
  Range.MethodBindings
  Class.forName(RayCast2D::class.java.name, true, RayCast2D::class.java.classLoader)
  RayCast2D.MethodBindings
  Class.forName(RayCast3D::class.java.name, true, RayCast3D::class.java.classLoader)
  RayCast3D.MethodBindings
  Class.forName(RectangleShape2D::class.java.name, true, RectangleShape2D::class.java.classLoader)
  RectangleShape2D.MethodBindings
  Class.forName(RefCounted::class.java.name, true, RefCounted::class.java.classLoader)
  RefCounted.MethodBindings
  Class.forName(ReferenceRect::class.java.name, true, ReferenceRect::class.java.classLoader)
  ReferenceRect.MethodBindings
  Class.forName(ReflectionProbe::class.java.name, true, ReflectionProbe::class.java.classLoader)
  ReflectionProbe.MethodBindings
  Class.forName(RegEx::class.java.name, true, RegEx::class.java.classLoader)
  RegEx.MethodBindings
  Class.forName(RegExMatch::class.java.name, true, RegExMatch::class.java.classLoader)
  RegExMatch.MethodBindings
  Class.forName(RemoteTransform2D::class.java.name, true, RemoteTransform2D::class.java.classLoader)
  RemoteTransform2D.MethodBindings
  Class.forName(RemoteTransform3D::class.java.name, true, RemoteTransform3D::class.java.classLoader)
  RemoteTransform3D.MethodBindings
  Class.forName(RenderData::class.java.name, true, RenderData::class.java.classLoader)
  RenderData.MethodBindings
  Class.forName(RenderDataExtension::class.java.name, true, RenderDataExtension::class.java.classLoader)
  RenderDataExtension.MethodBindings
  Class.forName(RenderDataRD::class.java.name, true, RenderDataRD::class.java.classLoader)
  RenderDataRD.MethodBindings
  Class.forName(RenderSceneBuffers::class.java.name, true, RenderSceneBuffers::class.java.classLoader)
  RenderSceneBuffers.MethodBindings
  Class.forName(RenderSceneBuffersConfiguration::class.java.name, true, RenderSceneBuffersConfiguration::class.java.classLoader)
  RenderSceneBuffersConfiguration.MethodBindings
  Class.forName(RenderSceneBuffersExtension::class.java.name, true, RenderSceneBuffersExtension::class.java.classLoader)
  RenderSceneBuffersExtension.MethodBindings
  Class.forName(RenderSceneBuffersRD::class.java.name, true, RenderSceneBuffersRD::class.java.classLoader)
  RenderSceneBuffersRD.MethodBindings
  Class.forName(RenderSceneData::class.java.name, true, RenderSceneData::class.java.classLoader)
  RenderSceneData.MethodBindings
  Class.forName(RenderSceneDataExtension::class.java.name, true, RenderSceneDataExtension::class.java.classLoader)
  RenderSceneDataExtension.MethodBindings
  Class.forName(RenderSceneDataRD::class.java.name, true, RenderSceneDataRD::class.java.classLoader)
  RenderSceneDataRD.MethodBindings
  Class.forName(RenderingDevice::class.java.name, true, RenderingDevice::class.java.classLoader)
  RenderingDevice.MethodBindings
  Class.forName(RenderingServer::class.java.name, true, RenderingServer::class.java.classLoader)
  RenderingServer.MethodBindings
  Class.forName(Resource::class.java.name, true, Resource::class.java.classLoader)
  Resource.MethodBindings
  Class.forName(ResourceFormatLoader::class.java.name, true, ResourceFormatLoader::class.java.classLoader)
  ResourceFormatLoader.MethodBindings
  Class.forName(ResourceFormatSaver::class.java.name, true, ResourceFormatSaver::class.java.classLoader)
  ResourceFormatSaver.MethodBindings
  Class.forName(ResourceImporter::class.java.name, true, ResourceImporter::class.java.classLoader)
  ResourceImporter.MethodBindings
  Class.forName(ResourceLoader::class.java.name, true, ResourceLoader::class.java.classLoader)
  ResourceLoader.MethodBindings
  Class.forName(ResourcePreloader::class.java.name, true, ResourcePreloader::class.java.classLoader)
  ResourcePreloader.MethodBindings
  Class.forName(ResourceSaver::class.java.name, true, ResourceSaver::class.java.classLoader)
  ResourceSaver.MethodBindings
  Class.forName(ResourceUID::class.java.name, true, ResourceUID::class.java.classLoader)
  ResourceUID.MethodBindings
  Class.forName(RetargetModifier3D::class.java.name, true, RetargetModifier3D::class.java.classLoader)
  RetargetModifier3D.MethodBindings
  Class.forName(RibbonTrailMesh::class.java.name, true, RibbonTrailMesh::class.java.classLoader)
  RibbonTrailMesh.MethodBindings
  Class.forName(RichTextEffect::class.java.name, true, RichTextEffect::class.java.classLoader)
  RichTextEffect.MethodBindings
  Class.forName(RichTextLabel::class.java.name, true, RichTextLabel::class.java.classLoader)
  RichTextLabel.MethodBindings
  Class.forName(RigidBody2D::class.java.name, true, RigidBody2D::class.java.classLoader)
  RigidBody2D.MethodBindings
  Class.forName(RigidBody3D::class.java.name, true, RigidBody3D::class.java.classLoader)
  RigidBody3D.MethodBindings
  Class.forName(RootMotionView::class.java.name, true, RootMotionView::class.java.classLoader)
  RootMotionView.MethodBindings
  Class.forName(ScalaScript::class.java.name, true, ScalaScript::class.java.classLoader)
  ScalaScript.MethodBindings
  Class.forName(SceneMultiplayer::class.java.name, true, SceneMultiplayer::class.java.classLoader)
  SceneMultiplayer.MethodBindings
  Class.forName(SceneReplicationConfig::class.java.name, true, SceneReplicationConfig::class.java.classLoader)
  SceneReplicationConfig.MethodBindings
  Class.forName(SceneState::class.java.name, true, SceneState::class.java.classLoader)
  SceneState.MethodBindings
  Class.forName(SceneTree::class.java.name, true, SceneTree::class.java.classLoader)
  SceneTree.MethodBindings
  Class.forName(SceneTreeTimer::class.java.name, true, SceneTreeTimer::class.java.classLoader)
  SceneTreeTimer.MethodBindings
  Class.forName(Script::class.java.name, true, Script::class.java.classLoader)
  Script.MethodBindings
  Class.forName(ScriptBacktrace::class.java.name, true, ScriptBacktrace::class.java.classLoader)
  ScriptBacktrace.MethodBindings
  Class.forName(ScriptExtension::class.java.name, true, ScriptExtension::class.java.classLoader)
  ScriptExtension.MethodBindings
  Class.forName(ScriptLanguage::class.java.name, true, ScriptLanguage::class.java.classLoader)
  ScriptLanguage.MethodBindings
  Class.forName(ScriptLanguageExtension::class.java.name, true, ScriptLanguageExtension::class.java.classLoader)
  ScriptLanguageExtension.MethodBindings
  Class.forName(ScrollBar::class.java.name, true, ScrollBar::class.java.classLoader)
  ScrollBar.MethodBindings
  Class.forName(ScrollContainer::class.java.name, true, ScrollContainer::class.java.classLoader)
  ScrollContainer.MethodBindings
  Class.forName(SegmentShape2D::class.java.name, true, SegmentShape2D::class.java.classLoader)
  SegmentShape2D.MethodBindings
  Class.forName(Semaphore::class.java.name, true, Semaphore::class.java.classLoader)
  Semaphore.MethodBindings
  Class.forName(SeparationRayShape2D::class.java.name, true, SeparationRayShape2D::class.java.classLoader)
  SeparationRayShape2D.MethodBindings
  Class.forName(SeparationRayShape3D::class.java.name, true, SeparationRayShape3D::class.java.classLoader)
  SeparationRayShape3D.MethodBindings
  Class.forName(Separator::class.java.name, true, Separator::class.java.classLoader)
  Separator.MethodBindings
  Class.forName(Shader::class.java.name, true, Shader::class.java.classLoader)
  Shader.MethodBindings
  Class.forName(ShaderGlobalsOverride::class.java.name, true, ShaderGlobalsOverride::class.java.classLoader)
  ShaderGlobalsOverride.MethodBindings
  Class.forName(ShaderInclude::class.java.name, true, ShaderInclude::class.java.classLoader)
  ShaderInclude.MethodBindings
  Class.forName(ShaderIncludeDB::class.java.name, true, ShaderIncludeDB::class.java.classLoader)
  ShaderIncludeDB.MethodBindings
  Class.forName(ShaderMaterial::class.java.name, true, ShaderMaterial::class.java.classLoader)
  ShaderMaterial.MethodBindings
  Class.forName(Shape2D::class.java.name, true, Shape2D::class.java.classLoader)
  Shape2D.MethodBindings
  Class.forName(Shape3D::class.java.name, true, Shape3D::class.java.classLoader)
  Shape3D.MethodBindings
  Class.forName(ShapeCast2D::class.java.name, true, ShapeCast2D::class.java.classLoader)
  ShapeCast2D.MethodBindings
  Class.forName(ShapeCast3D::class.java.name, true, ShapeCast3D::class.java.classLoader)
  ShapeCast3D.MethodBindings
  Class.forName(Shortcut::class.java.name, true, Shortcut::class.java.classLoader)
  Shortcut.MethodBindings
  Class.forName(Skeleton2D::class.java.name, true, Skeleton2D::class.java.classLoader)
  Skeleton2D.MethodBindings
  Class.forName(Skeleton3D::class.java.name, true, Skeleton3D::class.java.classLoader)
  Skeleton3D.MethodBindings
  Class.forName(SkeletonIK3D::class.java.name, true, SkeletonIK3D::class.java.classLoader)
  SkeletonIK3D.MethodBindings
  Class.forName(SkeletonModification2D::class.java.name, true, SkeletonModification2D::class.java.classLoader)
  SkeletonModification2D.MethodBindings
  Class.forName(SkeletonModification2DCCDIK::class.java.name, true, SkeletonModification2DCCDIK::class.java.classLoader)
  SkeletonModification2DCCDIK.MethodBindings
  Class.forName(SkeletonModification2DFABRIK::class.java.name, true, SkeletonModification2DFABRIK::class.java.classLoader)
  SkeletonModification2DFABRIK.MethodBindings
  Class.forName(SkeletonModification2DJiggle::class.java.name, true, SkeletonModification2DJiggle::class.java.classLoader)
  SkeletonModification2DJiggle.MethodBindings
  Class.forName(SkeletonModification2DLookAt::class.java.name, true, SkeletonModification2DLookAt::class.java.classLoader)
  SkeletonModification2DLookAt.MethodBindings
  Class.forName(SkeletonModification2DPhysicalBones::class.java.name, true, SkeletonModification2DPhysicalBones::class.java.classLoader)
  SkeletonModification2DPhysicalBones.MethodBindings
  Class.forName(SkeletonModification2DStackHolder::class.java.name, true, SkeletonModification2DStackHolder::class.java.classLoader)
  SkeletonModification2DStackHolder.MethodBindings
  Class.forName(SkeletonModification2DTwoBoneIK::class.java.name, true, SkeletonModification2DTwoBoneIK::class.java.classLoader)
  SkeletonModification2DTwoBoneIK.MethodBindings
  Class.forName(SkeletonModificationStack2D::class.java.name, true, SkeletonModificationStack2D::class.java.classLoader)
  SkeletonModificationStack2D.MethodBindings
  Class.forName(SkeletonModifier3D::class.java.name, true, SkeletonModifier3D::class.java.classLoader)
  SkeletonModifier3D.MethodBindings
  Class.forName(SkeletonProfile::class.java.name, true, SkeletonProfile::class.java.classLoader)
  SkeletonProfile.MethodBindings
  Class.forName(SkeletonProfileHumanoid::class.java.name, true, SkeletonProfileHumanoid::class.java.classLoader)
  SkeletonProfileHumanoid.MethodBindings
  Class.forName(Skin::class.java.name, true, Skin::class.java.classLoader)
  Skin.MethodBindings
  Class.forName(SkinReference::class.java.name, true, SkinReference::class.java.classLoader)
  SkinReference.MethodBindings
  Class.forName(Sky::class.java.name, true, Sky::class.java.classLoader)
  Sky.MethodBindings
  Class.forName(Slider::class.java.name, true, Slider::class.java.classLoader)
  Slider.MethodBindings
  Class.forName(SliderJoint3D::class.java.name, true, SliderJoint3D::class.java.classLoader)
  SliderJoint3D.MethodBindings
  Class.forName(SocketServer::class.java.name, true, SocketServer::class.java.classLoader)
  SocketServer.MethodBindings
  Class.forName(SoftBody3D::class.java.name, true, SoftBody3D::class.java.classLoader)
  SoftBody3D.MethodBindings
  Class.forName(SphereMesh::class.java.name, true, SphereMesh::class.java.classLoader)
  SphereMesh.MethodBindings
  Class.forName(SphereOccluder3D::class.java.name, true, SphereOccluder3D::class.java.classLoader)
  SphereOccluder3D.MethodBindings
  Class.forName(SphereShape3D::class.java.name, true, SphereShape3D::class.java.classLoader)
  SphereShape3D.MethodBindings
  Class.forName(SpinBox::class.java.name, true, SpinBox::class.java.classLoader)
  SpinBox.MethodBindings
  Class.forName(SplineIK3D::class.java.name, true, SplineIK3D::class.java.classLoader)
  SplineIK3D.MethodBindings
  Class.forName(SplitContainer::class.java.name, true, SplitContainer::class.java.classLoader)
  SplitContainer.MethodBindings
  Class.forName(SpotLight3D::class.java.name, true, SpotLight3D::class.java.classLoader)
  SpotLight3D.MethodBindings
  Class.forName(SpringArm3D::class.java.name, true, SpringArm3D::class.java.classLoader)
  SpringArm3D.MethodBindings
  Class.forName(SpringBoneCollision3D::class.java.name, true, SpringBoneCollision3D::class.java.classLoader)
  SpringBoneCollision3D.MethodBindings
  Class.forName(SpringBoneCollisionCapsule3D::class.java.name, true, SpringBoneCollisionCapsule3D::class.java.classLoader)
  SpringBoneCollisionCapsule3D.MethodBindings
  Class.forName(SpringBoneCollisionPlane3D::class.java.name, true, SpringBoneCollisionPlane3D::class.java.classLoader)
  SpringBoneCollisionPlane3D.MethodBindings
  Class.forName(SpringBoneCollisionSphere3D::class.java.name, true, SpringBoneCollisionSphere3D::class.java.classLoader)
  SpringBoneCollisionSphere3D.MethodBindings
  Class.forName(SpringBoneSimulator3D::class.java.name, true, SpringBoneSimulator3D::class.java.classLoader)
  SpringBoneSimulator3D.MethodBindings
  Class.forName(Sprite2D::class.java.name, true, Sprite2D::class.java.classLoader)
  Sprite2D.MethodBindings
  Class.forName(Sprite3D::class.java.name, true, Sprite3D::class.java.classLoader)
  Sprite3D.MethodBindings
  Class.forName(SpriteBase3D::class.java.name, true, SpriteBase3D::class.java.classLoader)
  SpriteBase3D.MethodBindings
  Class.forName(SpriteFrames::class.java.name, true, SpriteFrames::class.java.classLoader)
  SpriteFrames.MethodBindings
  Class.forName(StandardMaterial3D::class.java.name, true, StandardMaterial3D::class.java.classLoader)
  StandardMaterial3D.MethodBindings
  Class.forName(StaticBody2D::class.java.name, true, StaticBody2D::class.java.classLoader)
  StaticBody2D.MethodBindings
  Class.forName(StaticBody3D::class.java.name, true, StaticBody3D::class.java.classLoader)
  StaticBody3D.MethodBindings
  Class.forName(StatusIndicator::class.java.name, true, StatusIndicator::class.java.classLoader)
  StatusIndicator.MethodBindings
  Class.forName(StreamPeer::class.java.name, true, StreamPeer::class.java.classLoader)
  StreamPeer.MethodBindings
  Class.forName(StreamPeerBuffer::class.java.name, true, StreamPeerBuffer::class.java.classLoader)
  StreamPeerBuffer.MethodBindings
  Class.forName(StreamPeerExtension::class.java.name, true, StreamPeerExtension::class.java.classLoader)
  StreamPeerExtension.MethodBindings
  Class.forName(StreamPeerGZIP::class.java.name, true, StreamPeerGZIP::class.java.classLoader)
  StreamPeerGZIP.MethodBindings
  Class.forName(StreamPeerSocket::class.java.name, true, StreamPeerSocket::class.java.classLoader)
  StreamPeerSocket.MethodBindings
  Class.forName(StreamPeerTCP::class.java.name, true, StreamPeerTCP::class.java.classLoader)
  StreamPeerTCP.MethodBindings
  Class.forName(StreamPeerTLS::class.java.name, true, StreamPeerTLS::class.java.classLoader)
  StreamPeerTLS.MethodBindings
  Class.forName(StreamPeerUDS::class.java.name, true, StreamPeerUDS::class.java.classLoader)
  StreamPeerUDS.MethodBindings
  Class.forName(StyleBox::class.java.name, true, StyleBox::class.java.classLoader)
  StyleBox.MethodBindings
  Class.forName(StyleBoxEmpty::class.java.name, true, StyleBoxEmpty::class.java.classLoader)
  StyleBoxEmpty.MethodBindings
  Class.forName(StyleBoxFlat::class.java.name, true, StyleBoxFlat::class.java.classLoader)
  StyleBoxFlat.MethodBindings
  Class.forName(StyleBoxLine::class.java.name, true, StyleBoxLine::class.java.classLoader)
  StyleBoxLine.MethodBindings
  Class.forName(StyleBoxTexture::class.java.name, true, StyleBoxTexture::class.java.classLoader)
  StyleBoxTexture.MethodBindings
  Class.forName(SubViewport::class.java.name, true, SubViewport::class.java.classLoader)
  SubViewport.MethodBindings
  Class.forName(SubViewportContainer::class.java.name, true, SubViewportContainer::class.java.classLoader)
  SubViewportContainer.MethodBindings
  Class.forName(SubtweenTweener::class.java.name, true, SubtweenTweener::class.java.classLoader)
  SubtweenTweener.MethodBindings
  Class.forName(SurfaceTool::class.java.name, true, SurfaceTool::class.java.classLoader)
  SurfaceTool.MethodBindings
  Class.forName(SyntaxHighlighter::class.java.name, true, SyntaxHighlighter::class.java.classLoader)
  SyntaxHighlighter.MethodBindings
  Class.forName(SystemFont::class.java.name, true, SystemFont::class.java.classLoader)
  SystemFont.MethodBindings
  Class.forName(TCPServer::class.java.name, true, TCPServer::class.java.classLoader)
  TCPServer.MethodBindings
  Class.forName(TLSOptions::class.java.name, true, TLSOptions::class.java.classLoader)
  TLSOptions.MethodBindings
  Class.forName(TabBar::class.java.name, true, TabBar::class.java.classLoader)
  TabBar.MethodBindings
  Class.forName(TabContainer::class.java.name, true, TabContainer::class.java.classLoader)
  TabContainer.MethodBindings
  Class.forName(TextEdit::class.java.name, true, TextEdit::class.java.classLoader)
  TextEdit.MethodBindings
  Class.forName(TextLine::class.java.name, true, TextLine::class.java.classLoader)
  TextLine.MethodBindings
  Class.forName(TextMesh::class.java.name, true, TextMesh::class.java.classLoader)
  TextMesh.MethodBindings
  Class.forName(TextParagraph::class.java.name, true, TextParagraph::class.java.classLoader)
  TextParagraph.MethodBindings
  Class.forName(TextServer::class.java.name, true, TextServer::class.java.classLoader)
  TextServer.MethodBindings
  Class.forName(TextServerAdvanced::class.java.name, true, TextServerAdvanced::class.java.classLoader)
  TextServerAdvanced.MethodBindings
  Class.forName(TextServerDummy::class.java.name, true, TextServerDummy::class.java.classLoader)
  TextServerDummy.MethodBindings
  Class.forName(TextServerExtension::class.java.name, true, TextServerExtension::class.java.classLoader)
  TextServerExtension.MethodBindings
  Class.forName(TextServerManager::class.java.name, true, TextServerManager::class.java.classLoader)
  TextServerManager.MethodBindings
  Class.forName(Texture::class.java.name, true, Texture::class.java.classLoader)
  Texture.MethodBindings
  Class.forName(Texture2D::class.java.name, true, Texture2D::class.java.classLoader)
  Texture2D.MethodBindings
  Class.forName(Texture2DArray::class.java.name, true, Texture2DArray::class.java.classLoader)
  Texture2DArray.MethodBindings
  Class.forName(Texture2DArrayRD::class.java.name, true, Texture2DArrayRD::class.java.classLoader)
  Texture2DArrayRD.MethodBindings
  Class.forName(Texture2DRD::class.java.name, true, Texture2DRD::class.java.classLoader)
  Texture2DRD.MethodBindings
  Class.forName(Texture3D::class.java.name, true, Texture3D::class.java.classLoader)
  Texture3D.MethodBindings
  Class.forName(Texture3DRD::class.java.name, true, Texture3DRD::class.java.classLoader)
  Texture3DRD.MethodBindings
  Class.forName(TextureButton::class.java.name, true, TextureButton::class.java.classLoader)
  TextureButton.MethodBindings
  Class.forName(TextureCubemapArrayRD::class.java.name, true, TextureCubemapArrayRD::class.java.classLoader)
  TextureCubemapArrayRD.MethodBindings
  Class.forName(TextureCubemapRD::class.java.name, true, TextureCubemapRD::class.java.classLoader)
  TextureCubemapRD.MethodBindings
  Class.forName(TextureLayered::class.java.name, true, TextureLayered::class.java.classLoader)
  TextureLayered.MethodBindings
  Class.forName(TextureLayeredRD::class.java.name, true, TextureLayeredRD::class.java.classLoader)
  TextureLayeredRD.MethodBindings
  Class.forName(TextureProgressBar::class.java.name, true, TextureProgressBar::class.java.classLoader)
  TextureProgressBar.MethodBindings
  Class.forName(TextureRect::class.java.name, true, TextureRect::class.java.classLoader)
  TextureRect.MethodBindings
  Class.forName(Theme::class.java.name, true, Theme::class.java.classLoader)
  Theme.MethodBindings
  Class.forName(ThemeDB::class.java.name, true, ThemeDB::class.java.classLoader)
  ThemeDB.MethodBindings
  Class.forName(Thread::class.java.name, true, Thread::class.java.classLoader)
  Thread.MethodBindings
  Class.forName(TileData::class.java.name, true, TileData::class.java.classLoader)
  TileData.MethodBindings
  Class.forName(TileMap::class.java.name, true, TileMap::class.java.classLoader)
  TileMap.MethodBindings
  Class.forName(TileMapLayer::class.java.name, true, TileMapLayer::class.java.classLoader)
  TileMapLayer.MethodBindings
  Class.forName(TileMapPattern::class.java.name, true, TileMapPattern::class.java.classLoader)
  TileMapPattern.MethodBindings
  Class.forName(TileSet::class.java.name, true, TileSet::class.java.classLoader)
  TileSet.MethodBindings
  Class.forName(TileSetAtlasSource::class.java.name, true, TileSetAtlasSource::class.java.classLoader)
  TileSetAtlasSource.MethodBindings
  Class.forName(TileSetScenesCollectionSource::class.java.name, true, TileSetScenesCollectionSource::class.java.classLoader)
  TileSetScenesCollectionSource.MethodBindings
  Class.forName(TileSetSource::class.java.name, true, TileSetSource::class.java.classLoader)
  TileSetSource.MethodBindings
  Class.forName(Time::class.java.name, true, Time::class.java.classLoader)
  Time.MethodBindings
  Class.forName(Timer::class.java.name, true, Timer::class.java.classLoader)
  Timer.MethodBindings
  Class.forName(TorusMesh::class.java.name, true, TorusMesh::class.java.classLoader)
  TorusMesh.MethodBindings
  Class.forName(TouchScreenButton::class.java.name, true, TouchScreenButton::class.java.classLoader)
  TouchScreenButton.MethodBindings
  Class.forName(Translation::class.java.name, true, Translation::class.java.classLoader)
  Translation.MethodBindings
  Class.forName(TranslationDomain::class.java.name, true, TranslationDomain::class.java.classLoader)
  TranslationDomain.MethodBindings
  Class.forName(TranslationServer::class.java.name, true, TranslationServer::class.java.classLoader)
  TranslationServer.MethodBindings
  Class.forName(Tree::class.java.name, true, Tree::class.java.classLoader)
  Tree.MethodBindings
  Class.forName(TreeItem::class.java.name, true, TreeItem::class.java.classLoader)
  TreeItem.MethodBindings
  Class.forName(TriangleMesh::class.java.name, true, TriangleMesh::class.java.classLoader)
  TriangleMesh.MethodBindings
  Class.forName(TubeTrailMesh::class.java.name, true, TubeTrailMesh::class.java.classLoader)
  TubeTrailMesh.MethodBindings
  Class.forName(Tween::class.java.name, true, Tween::class.java.classLoader)
  Tween.MethodBindings
  Class.forName(Tweener::class.java.name, true, Tweener::class.java.classLoader)
  Tweener.MethodBindings
  Class.forName(TwoBoneIK3D::class.java.name, true, TwoBoneIK3D::class.java.classLoader)
  TwoBoneIK3D.MethodBindings
  Class.forName(UDPServer::class.java.name, true, UDPServer::class.java.classLoader)
  UDPServer.MethodBindings
  Class.forName(UDSServer::class.java.name, true, UDSServer::class.java.classLoader)
  UDSServer.MethodBindings
  Class.forName(UPNP::class.java.name, true, UPNP::class.java.classLoader)
  UPNP.MethodBindings
  Class.forName(UPNPDevice::class.java.name, true, UPNPDevice::class.java.classLoader)
  UPNPDevice.MethodBindings
  Class.forName(UndoRedo::class.java.name, true, UndoRedo::class.java.classLoader)
  UndoRedo.MethodBindings
  Class.forName(UniformSetCacheRD::class.java.name, true, UniformSetCacheRD::class.java.classLoader)
  UniformSetCacheRD.MethodBindings
  Class.forName(VBoxContainer::class.java.name, true, VBoxContainer::class.java.classLoader)
  VBoxContainer.MethodBindings
  Class.forName(VFlowContainer::class.java.name, true, VFlowContainer::class.java.classLoader)
  VFlowContainer.MethodBindings
  Class.forName(VScrollBar::class.java.name, true, VScrollBar::class.java.classLoader)
  VScrollBar.MethodBindings
  Class.forName(VSeparator::class.java.name, true, VSeparator::class.java.classLoader)
  VSeparator.MethodBindings
  Class.forName(VSlider::class.java.name, true, VSlider::class.java.classLoader)
  VSlider.MethodBindings
  Class.forName(VSplitContainer::class.java.name, true, VSplitContainer::class.java.classLoader)
  VSplitContainer.MethodBindings
  Class.forName(VehicleBody3D::class.java.name, true, VehicleBody3D::class.java.classLoader)
  VehicleBody3D.MethodBindings
  Class.forName(VehicleWheel3D::class.java.name, true, VehicleWheel3D::class.java.classLoader)
  VehicleWheel3D.MethodBindings
  Class.forName(VideoStream::class.java.name, true, VideoStream::class.java.classLoader)
  VideoStream.MethodBindings
  Class.forName(VideoStreamPlayback::class.java.name, true, VideoStreamPlayback::class.java.classLoader)
  VideoStreamPlayback.MethodBindings
  Class.forName(VideoStreamPlayer::class.java.name, true, VideoStreamPlayer::class.java.classLoader)
  VideoStreamPlayer.MethodBindings
  Class.forName(VideoStreamTheora::class.java.name, true, VideoStreamTheora::class.java.classLoader)
  VideoStreamTheora.MethodBindings
  Class.forName(Viewport::class.java.name, true, Viewport::class.java.classLoader)
  Viewport.MethodBindings
  Class.forName(ViewportTexture::class.java.name, true, ViewportTexture::class.java.classLoader)
  ViewportTexture.MethodBindings
  Class.forName(VirtualJoystick::class.java.name, true, VirtualJoystick::class.java.classLoader)
  VirtualJoystick.MethodBindings
  Class.forName(VisibleOnScreenEnabler2D::class.java.name, true, VisibleOnScreenEnabler2D::class.java.classLoader)
  VisibleOnScreenEnabler2D.MethodBindings
  Class.forName(VisibleOnScreenEnabler3D::class.java.name, true, VisibleOnScreenEnabler3D::class.java.classLoader)
  VisibleOnScreenEnabler3D.MethodBindings
  Class.forName(VisibleOnScreenNotifier2D::class.java.name, true, VisibleOnScreenNotifier2D::class.java.classLoader)
  VisibleOnScreenNotifier2D.MethodBindings
  Class.forName(VisibleOnScreenNotifier3D::class.java.name, true, VisibleOnScreenNotifier3D::class.java.classLoader)
  VisibleOnScreenNotifier3D.MethodBindings
  Class.forName(VisualInstance3D::class.java.name, true, VisualInstance3D::class.java.classLoader)
  VisualInstance3D.MethodBindings
  Class.forName(VisualShader::class.java.name, true, VisualShader::class.java.classLoader)
  VisualShader.MethodBindings
  Class.forName(VisualShaderNode::class.java.name, true, VisualShaderNode::class.java.classLoader)
  VisualShaderNode.MethodBindings
  Class.forName(VisualShaderNodeBillboard::class.java.name, true, VisualShaderNodeBillboard::class.java.classLoader)
  VisualShaderNodeBillboard.MethodBindings
  Class.forName(VisualShaderNodeBooleanConstant::class.java.name, true, VisualShaderNodeBooleanConstant::class.java.classLoader)
  VisualShaderNodeBooleanConstant.MethodBindings
  Class.forName(VisualShaderNodeBooleanParameter::class.java.name, true, VisualShaderNodeBooleanParameter::class.java.classLoader)
  VisualShaderNodeBooleanParameter.MethodBindings
  Class.forName(VisualShaderNodeClamp::class.java.name, true, VisualShaderNodeClamp::class.java.classLoader)
  VisualShaderNodeClamp.MethodBindings
  Class.forName(VisualShaderNodeColorConstant::class.java.name, true, VisualShaderNodeColorConstant::class.java.classLoader)
  VisualShaderNodeColorConstant.MethodBindings
  Class.forName(VisualShaderNodeColorFunc::class.java.name, true, VisualShaderNodeColorFunc::class.java.classLoader)
  VisualShaderNodeColorFunc.MethodBindings
  Class.forName(VisualShaderNodeColorOp::class.java.name, true, VisualShaderNodeColorOp::class.java.classLoader)
  VisualShaderNodeColorOp.MethodBindings
  Class.forName(VisualShaderNodeColorParameter::class.java.name, true, VisualShaderNodeColorParameter::class.java.classLoader)
  VisualShaderNodeColorParameter.MethodBindings
  Class.forName(VisualShaderNodeComment::class.java.name, true, VisualShaderNodeComment::class.java.classLoader)
  VisualShaderNodeComment.MethodBindings
  Class.forName(VisualShaderNodeCompare::class.java.name, true, VisualShaderNodeCompare::class.java.classLoader)
  VisualShaderNodeCompare.MethodBindings
  Class.forName(VisualShaderNodeConstant::class.java.name, true, VisualShaderNodeConstant::class.java.classLoader)
  VisualShaderNodeConstant.MethodBindings
  Class.forName(VisualShaderNodeCubemap::class.java.name, true, VisualShaderNodeCubemap::class.java.classLoader)
  VisualShaderNodeCubemap.MethodBindings
  Class.forName(VisualShaderNodeCubemapParameter::class.java.name, true, VisualShaderNodeCubemapParameter::class.java.classLoader)
  VisualShaderNodeCubemapParameter.MethodBindings
  Class.forName(VisualShaderNodeCurveTexture::class.java.name, true, VisualShaderNodeCurveTexture::class.java.classLoader)
  VisualShaderNodeCurveTexture.MethodBindings
  Class.forName(VisualShaderNodeCurveXYZTexture::class.java.name, true, VisualShaderNodeCurveXYZTexture::class.java.classLoader)
  VisualShaderNodeCurveXYZTexture.MethodBindings
  Class.forName(VisualShaderNodeCustom::class.java.name, true, VisualShaderNodeCustom::class.java.classLoader)
  VisualShaderNodeCustom.MethodBindings
  Class.forName(VisualShaderNodeDerivativeFunc::class.java.name, true, VisualShaderNodeDerivativeFunc::class.java.classLoader)
  VisualShaderNodeDerivativeFunc.MethodBindings
  Class.forName(VisualShaderNodeDeterminant::class.java.name, true, VisualShaderNodeDeterminant::class.java.classLoader)
  VisualShaderNodeDeterminant.MethodBindings
  Class.forName(VisualShaderNodeDistanceFade::class.java.name, true, VisualShaderNodeDistanceFade::class.java.classLoader)
  VisualShaderNodeDistanceFade.MethodBindings
  Class.forName(VisualShaderNodeDotProduct::class.java.name, true, VisualShaderNodeDotProduct::class.java.classLoader)
  VisualShaderNodeDotProduct.MethodBindings
  Class.forName(VisualShaderNodeExpression::class.java.name, true, VisualShaderNodeExpression::class.java.classLoader)
  VisualShaderNodeExpression.MethodBindings
  Class.forName(VisualShaderNodeFaceForward::class.java.name, true, VisualShaderNodeFaceForward::class.java.classLoader)
  VisualShaderNodeFaceForward.MethodBindings
  Class.forName(VisualShaderNodeFloatConstant::class.java.name, true, VisualShaderNodeFloatConstant::class.java.classLoader)
  VisualShaderNodeFloatConstant.MethodBindings
  Class.forName(VisualShaderNodeFloatFunc::class.java.name, true, VisualShaderNodeFloatFunc::class.java.classLoader)
  VisualShaderNodeFloatFunc.MethodBindings
  Class.forName(VisualShaderNodeFloatOp::class.java.name, true, VisualShaderNodeFloatOp::class.java.classLoader)
  VisualShaderNodeFloatOp.MethodBindings
  Class.forName(VisualShaderNodeFloatParameter::class.java.name, true, VisualShaderNodeFloatParameter::class.java.classLoader)
  VisualShaderNodeFloatParameter.MethodBindings
  Class.forName(VisualShaderNodeFrame::class.java.name, true, VisualShaderNodeFrame::class.java.classLoader)
  VisualShaderNodeFrame.MethodBindings
  Class.forName(VisualShaderNodeFresnel::class.java.name, true, VisualShaderNodeFresnel::class.java.classLoader)
  VisualShaderNodeFresnel.MethodBindings
  Class.forName(VisualShaderNodeGlobalExpression::class.java.name, true, VisualShaderNodeGlobalExpression::class.java.classLoader)
  VisualShaderNodeGlobalExpression.MethodBindings
  Class.forName(VisualShaderNodeGroupBase::class.java.name, true, VisualShaderNodeGroupBase::class.java.classLoader)
  VisualShaderNodeGroupBase.MethodBindings
  Class.forName(VisualShaderNodeIf::class.java.name, true, VisualShaderNodeIf::class.java.classLoader)
  VisualShaderNodeIf.MethodBindings
  Class.forName(VisualShaderNodeInput::class.java.name, true, VisualShaderNodeInput::class.java.classLoader)
  VisualShaderNodeInput.MethodBindings
  Class.forName(VisualShaderNodeIntConstant::class.java.name, true, VisualShaderNodeIntConstant::class.java.classLoader)
  VisualShaderNodeIntConstant.MethodBindings
  Class.forName(VisualShaderNodeIntFunc::class.java.name, true, VisualShaderNodeIntFunc::class.java.classLoader)
  VisualShaderNodeIntFunc.MethodBindings
  Class.forName(VisualShaderNodeIntOp::class.java.name, true, VisualShaderNodeIntOp::class.java.classLoader)
  VisualShaderNodeIntOp.MethodBindings
  Class.forName(VisualShaderNodeIntParameter::class.java.name, true, VisualShaderNodeIntParameter::class.java.classLoader)
  VisualShaderNodeIntParameter.MethodBindings
  Class.forName(VisualShaderNodeIs::class.java.name, true, VisualShaderNodeIs::class.java.classLoader)
  VisualShaderNodeIs.MethodBindings
  Class.forName(VisualShaderNodeLinearSceneDepth::class.java.name, true, VisualShaderNodeLinearSceneDepth::class.java.classLoader)
  VisualShaderNodeLinearSceneDepth.MethodBindings
  Class.forName(VisualShaderNodeMix::class.java.name, true, VisualShaderNodeMix::class.java.classLoader)
  VisualShaderNodeMix.MethodBindings
  Class.forName(VisualShaderNodeMultiplyAdd::class.java.name, true, VisualShaderNodeMultiplyAdd::class.java.classLoader)
  VisualShaderNodeMultiplyAdd.MethodBindings
  Class.forName(VisualShaderNodeOuterProduct::class.java.name, true, VisualShaderNodeOuterProduct::class.java.classLoader)
  VisualShaderNodeOuterProduct.MethodBindings
  Class.forName(VisualShaderNodeOutput::class.java.name, true, VisualShaderNodeOutput::class.java.classLoader)
  VisualShaderNodeOutput.MethodBindings
  Class.forName(VisualShaderNodeParameter::class.java.name, true, VisualShaderNodeParameter::class.java.classLoader)
  VisualShaderNodeParameter.MethodBindings
  Class.forName(VisualShaderNodeParameterRef::class.java.name, true, VisualShaderNodeParameterRef::class.java.classLoader)
  VisualShaderNodeParameterRef.MethodBindings
  Class.forName(VisualShaderNodeParticleAccelerator::class.java.name, true, VisualShaderNodeParticleAccelerator::class.java.classLoader)
  VisualShaderNodeParticleAccelerator.MethodBindings
  Class.forName(VisualShaderNodeParticleBoxEmitter::class.java.name, true, VisualShaderNodeParticleBoxEmitter::class.java.classLoader)
  VisualShaderNodeParticleBoxEmitter.MethodBindings
  Class.forName(VisualShaderNodeParticleConeVelocity::class.java.name, true, VisualShaderNodeParticleConeVelocity::class.java.classLoader)
  VisualShaderNodeParticleConeVelocity.MethodBindings
  Class.forName(VisualShaderNodeParticleEmit::class.java.name, true, VisualShaderNodeParticleEmit::class.java.classLoader)
  VisualShaderNodeParticleEmit.MethodBindings
  Class.forName(VisualShaderNodeParticleEmitter::class.java.name, true, VisualShaderNodeParticleEmitter::class.java.classLoader)
  VisualShaderNodeParticleEmitter.MethodBindings
  Class.forName(VisualShaderNodeParticleMeshEmitter::class.java.name, true, VisualShaderNodeParticleMeshEmitter::class.java.classLoader)
  VisualShaderNodeParticleMeshEmitter.MethodBindings
  Class.forName(VisualShaderNodeParticleMultiplyByAxisAngle::class.java.name, true, VisualShaderNodeParticleMultiplyByAxisAngle::class.java.classLoader)
  VisualShaderNodeParticleMultiplyByAxisAngle.MethodBindings
  Class.forName(VisualShaderNodeParticleOutput::class.java.name, true, VisualShaderNodeParticleOutput::class.java.classLoader)
  VisualShaderNodeParticleOutput.MethodBindings
  Class.forName(VisualShaderNodeParticleRandomness::class.java.name, true, VisualShaderNodeParticleRandomness::class.java.classLoader)
  VisualShaderNodeParticleRandomness.MethodBindings
  Class.forName(VisualShaderNodeParticleRingEmitter::class.java.name, true, VisualShaderNodeParticleRingEmitter::class.java.classLoader)
  VisualShaderNodeParticleRingEmitter.MethodBindings
  Class.forName(VisualShaderNodeParticleSphereEmitter::class.java.name, true, VisualShaderNodeParticleSphereEmitter::class.java.classLoader)
  VisualShaderNodeParticleSphereEmitter.MethodBindings
  Class.forName(VisualShaderNodeProximityFade::class.java.name, true, VisualShaderNodeProximityFade::class.java.classLoader)
  VisualShaderNodeProximityFade.MethodBindings
  Class.forName(VisualShaderNodeRandomRange::class.java.name, true, VisualShaderNodeRandomRange::class.java.classLoader)
  VisualShaderNodeRandomRange.MethodBindings
  Class.forName(VisualShaderNodeRemap::class.java.name, true, VisualShaderNodeRemap::class.java.classLoader)
  VisualShaderNodeRemap.MethodBindings
  Class.forName(VisualShaderNodeReroute::class.java.name, true, VisualShaderNodeReroute::class.java.classLoader)
  VisualShaderNodeReroute.MethodBindings
  Class.forName(VisualShaderNodeResizableBase::class.java.name, true, VisualShaderNodeResizableBase::class.java.classLoader)
  VisualShaderNodeResizableBase.MethodBindings
  Class.forName(VisualShaderNodeRotationByAxis::class.java.name, true, VisualShaderNodeRotationByAxis::class.java.classLoader)
  VisualShaderNodeRotationByAxis.MethodBindings
  Class.forName(VisualShaderNodeSDFRaymarch::class.java.name, true, VisualShaderNodeSDFRaymarch::class.java.classLoader)
  VisualShaderNodeSDFRaymarch.MethodBindings
  Class.forName(VisualShaderNodeSDFToScreenUV::class.java.name, true, VisualShaderNodeSDFToScreenUV::class.java.classLoader)
  VisualShaderNodeSDFToScreenUV.MethodBindings
  Class.forName(VisualShaderNodeSample3D::class.java.name, true, VisualShaderNodeSample3D::class.java.classLoader)
  VisualShaderNodeSample3D.MethodBindings
  Class.forName(VisualShaderNodeScreenNormalWorldSpace::class.java.name, true, VisualShaderNodeScreenNormalWorldSpace::class.java.classLoader)
  VisualShaderNodeScreenNormalWorldSpace.MethodBindings
  Class.forName(VisualShaderNodeScreenUVToSDF::class.java.name, true, VisualShaderNodeScreenUVToSDF::class.java.classLoader)
  VisualShaderNodeScreenUVToSDF.MethodBindings
  Class.forName(VisualShaderNodeSmoothStep::class.java.name, true, VisualShaderNodeSmoothStep::class.java.classLoader)
  VisualShaderNodeSmoothStep.MethodBindings
  Class.forName(VisualShaderNodeStep::class.java.name, true, VisualShaderNodeStep::class.java.classLoader)
  VisualShaderNodeStep.MethodBindings
  Class.forName(VisualShaderNodeSwitch::class.java.name, true, VisualShaderNodeSwitch::class.java.classLoader)
  VisualShaderNodeSwitch.MethodBindings
  Class.forName(VisualShaderNodeTexture::class.java.name, true, VisualShaderNodeTexture::class.java.classLoader)
  VisualShaderNodeTexture.MethodBindings
  Class.forName(VisualShaderNodeTexture2DArray::class.java.name, true, VisualShaderNodeTexture2DArray::class.java.classLoader)
  VisualShaderNodeTexture2DArray.MethodBindings
  Class.forName(VisualShaderNodeTexture2DArrayParameter::class.java.name, true, VisualShaderNodeTexture2DArrayParameter::class.java.classLoader)
  VisualShaderNodeTexture2DArrayParameter.MethodBindings
  Class.forName(VisualShaderNodeTexture2DParameter::class.java.name, true, VisualShaderNodeTexture2DParameter::class.java.classLoader)
  VisualShaderNodeTexture2DParameter.MethodBindings
  Class.forName(VisualShaderNodeTexture3D::class.java.name, true, VisualShaderNodeTexture3D::class.java.classLoader)
  VisualShaderNodeTexture3D.MethodBindings
  Class.forName(VisualShaderNodeTexture3DParameter::class.java.name, true, VisualShaderNodeTexture3DParameter::class.java.classLoader)
  VisualShaderNodeTexture3DParameter.MethodBindings
  Class.forName(VisualShaderNodeTextureParameter::class.java.name, true, VisualShaderNodeTextureParameter::class.java.classLoader)
  VisualShaderNodeTextureParameter.MethodBindings
  Class.forName(VisualShaderNodeTextureParameterTriplanar::class.java.name, true, VisualShaderNodeTextureParameterTriplanar::class.java.classLoader)
  VisualShaderNodeTextureParameterTriplanar.MethodBindings
  Class.forName(VisualShaderNodeTextureSDF::class.java.name, true, VisualShaderNodeTextureSDF::class.java.classLoader)
  VisualShaderNodeTextureSDF.MethodBindings
  Class.forName(VisualShaderNodeTextureSDFNormal::class.java.name, true, VisualShaderNodeTextureSDFNormal::class.java.classLoader)
  VisualShaderNodeTextureSDFNormal.MethodBindings
  Class.forName(VisualShaderNodeTransformCompose::class.java.name, true, VisualShaderNodeTransformCompose::class.java.classLoader)
  VisualShaderNodeTransformCompose.MethodBindings
  Class.forName(VisualShaderNodeTransformConstant::class.java.name, true, VisualShaderNodeTransformConstant::class.java.classLoader)
  VisualShaderNodeTransformConstant.MethodBindings
  Class.forName(VisualShaderNodeTransformDecompose::class.java.name, true, VisualShaderNodeTransformDecompose::class.java.classLoader)
  VisualShaderNodeTransformDecompose.MethodBindings
  Class.forName(VisualShaderNodeTransformFunc::class.java.name, true, VisualShaderNodeTransformFunc::class.java.classLoader)
  VisualShaderNodeTransformFunc.MethodBindings
  Class.forName(VisualShaderNodeTransformOp::class.java.name, true, VisualShaderNodeTransformOp::class.java.classLoader)
  VisualShaderNodeTransformOp.MethodBindings
  Class.forName(VisualShaderNodeTransformParameter::class.java.name, true, VisualShaderNodeTransformParameter::class.java.classLoader)
  VisualShaderNodeTransformParameter.MethodBindings
  Class.forName(VisualShaderNodeTransformVecMult::class.java.name, true, VisualShaderNodeTransformVecMult::class.java.classLoader)
  VisualShaderNodeTransformVecMult.MethodBindings
  Class.forName(VisualShaderNodeUIntConstant::class.java.name, true, VisualShaderNodeUIntConstant::class.java.classLoader)
  VisualShaderNodeUIntConstant.MethodBindings
  Class.forName(VisualShaderNodeUIntFunc::class.java.name, true, VisualShaderNodeUIntFunc::class.java.classLoader)
  VisualShaderNodeUIntFunc.MethodBindings
  Class.forName(VisualShaderNodeUIntOp::class.java.name, true, VisualShaderNodeUIntOp::class.java.classLoader)
  VisualShaderNodeUIntOp.MethodBindings
  Class.forName(VisualShaderNodeUIntParameter::class.java.name, true, VisualShaderNodeUIntParameter::class.java.classLoader)
  VisualShaderNodeUIntParameter.MethodBindings
  Class.forName(VisualShaderNodeUVFunc::class.java.name, true, VisualShaderNodeUVFunc::class.java.classLoader)
  VisualShaderNodeUVFunc.MethodBindings
  Class.forName(VisualShaderNodeUVPolarCoord::class.java.name, true, VisualShaderNodeUVPolarCoord::class.java.classLoader)
  VisualShaderNodeUVPolarCoord.MethodBindings
  Class.forName(VisualShaderNodeVarying::class.java.name, true, VisualShaderNodeVarying::class.java.classLoader)
  VisualShaderNodeVarying.MethodBindings
  Class.forName(VisualShaderNodeVaryingGetter::class.java.name, true, VisualShaderNodeVaryingGetter::class.java.classLoader)
  VisualShaderNodeVaryingGetter.MethodBindings
  Class.forName(VisualShaderNodeVaryingSetter::class.java.name, true, VisualShaderNodeVaryingSetter::class.java.classLoader)
  VisualShaderNodeVaryingSetter.MethodBindings
  Class.forName(VisualShaderNodeVec2Constant::class.java.name, true, VisualShaderNodeVec2Constant::class.java.classLoader)
  VisualShaderNodeVec2Constant.MethodBindings
  Class.forName(VisualShaderNodeVec2Parameter::class.java.name, true, VisualShaderNodeVec2Parameter::class.java.classLoader)
  VisualShaderNodeVec2Parameter.MethodBindings
  Class.forName(VisualShaderNodeVec3Constant::class.java.name, true, VisualShaderNodeVec3Constant::class.java.classLoader)
  VisualShaderNodeVec3Constant.MethodBindings
  Class.forName(VisualShaderNodeVec3Parameter::class.java.name, true, VisualShaderNodeVec3Parameter::class.java.classLoader)
  VisualShaderNodeVec3Parameter.MethodBindings
  Class.forName(VisualShaderNodeVec4Constant::class.java.name, true, VisualShaderNodeVec4Constant::class.java.classLoader)
  VisualShaderNodeVec4Constant.MethodBindings
  Class.forName(VisualShaderNodeVec4Parameter::class.java.name, true, VisualShaderNodeVec4Parameter::class.java.classLoader)
  VisualShaderNodeVec4Parameter.MethodBindings
  Class.forName(VisualShaderNodeVectorBase::class.java.name, true, VisualShaderNodeVectorBase::class.java.classLoader)
  VisualShaderNodeVectorBase.MethodBindings
  Class.forName(VisualShaderNodeVectorCompose::class.java.name, true, VisualShaderNodeVectorCompose::class.java.classLoader)
  VisualShaderNodeVectorCompose.MethodBindings
  Class.forName(VisualShaderNodeVectorDecompose::class.java.name, true, VisualShaderNodeVectorDecompose::class.java.classLoader)
  VisualShaderNodeVectorDecompose.MethodBindings
  Class.forName(VisualShaderNodeVectorDistance::class.java.name, true, VisualShaderNodeVectorDistance::class.java.classLoader)
  VisualShaderNodeVectorDistance.MethodBindings
  Class.forName(VisualShaderNodeVectorFunc::class.java.name, true, VisualShaderNodeVectorFunc::class.java.classLoader)
  VisualShaderNodeVectorFunc.MethodBindings
  Class.forName(VisualShaderNodeVectorLen::class.java.name, true, VisualShaderNodeVectorLen::class.java.classLoader)
  VisualShaderNodeVectorLen.MethodBindings
  Class.forName(VisualShaderNodeVectorOp::class.java.name, true, VisualShaderNodeVectorOp::class.java.classLoader)
  VisualShaderNodeVectorOp.MethodBindings
  Class.forName(VisualShaderNodeVectorRefract::class.java.name, true, VisualShaderNodeVectorRefract::class.java.classLoader)
  VisualShaderNodeVectorRefract.MethodBindings
  Class.forName(VisualShaderNodeWorldPositionFromDepth::class.java.name, true, VisualShaderNodeWorldPositionFromDepth::class.java.classLoader)
  VisualShaderNodeWorldPositionFromDepth.MethodBindings
  Class.forName(VoxelGI::class.java.name, true, VoxelGI::class.java.classLoader)
  VoxelGI.MethodBindings
  Class.forName(VoxelGIData::class.java.name, true, VoxelGIData::class.java.classLoader)
  VoxelGIData.MethodBindings
  Class.forName(WeakRef::class.java.name, true, WeakRef::class.java.classLoader)
  WeakRef.MethodBindings
  Class.forName(WebRTCDataChannel::class.java.name, true, WebRTCDataChannel::class.java.classLoader)
  WebRTCDataChannel.MethodBindings
  Class.forName(WebRTCDataChannelExtension::class.java.name, true, WebRTCDataChannelExtension::class.java.classLoader)
  WebRTCDataChannelExtension.MethodBindings
  Class.forName(WebRTCMultiplayerPeer::class.java.name, true, WebRTCMultiplayerPeer::class.java.classLoader)
  WebRTCMultiplayerPeer.MethodBindings
  Class.forName(WebRTCPeerConnection::class.java.name, true, WebRTCPeerConnection::class.java.classLoader)
  WebRTCPeerConnection.MethodBindings
  Class.forName(WebRTCPeerConnectionExtension::class.java.name, true, WebRTCPeerConnectionExtension::class.java.classLoader)
  WebRTCPeerConnectionExtension.MethodBindings
  Class.forName(WebSocketMultiplayerPeer::class.java.name, true, WebSocketMultiplayerPeer::class.java.classLoader)
  WebSocketMultiplayerPeer.MethodBindings
  Class.forName(WebSocketPeer::class.java.name, true, WebSocketPeer::class.java.classLoader)
  WebSocketPeer.MethodBindings
  Class.forName(WebXRInterface::class.java.name, true, WebXRInterface::class.java.classLoader)
  WebXRInterface.MethodBindings
  Class.forName(Window::class.java.name, true, Window::class.java.classLoader)
  Window.MethodBindings
  Class.forName(WorkerThreadPool::class.java.name, true, WorkerThreadPool::class.java.classLoader)
  WorkerThreadPool.MethodBindings
  Class.forName(World2D::class.java.name, true, World2D::class.java.classLoader)
  World2D.MethodBindings
  Class.forName(World3D::class.java.name, true, World3D::class.java.classLoader)
  World3D.MethodBindings
  Class.forName(WorldBoundaryShape2D::class.java.name, true, WorldBoundaryShape2D::class.java.classLoader)
  WorldBoundaryShape2D.MethodBindings
  Class.forName(WorldBoundaryShape3D::class.java.name, true, WorldBoundaryShape3D::class.java.classLoader)
  WorldBoundaryShape3D.MethodBindings
  Class.forName(WorldEnvironment::class.java.name, true, WorldEnvironment::class.java.classLoader)
  WorldEnvironment.MethodBindings
  Class.forName(X509Certificate::class.java.name, true, X509Certificate::class.java.classLoader)
  X509Certificate.MethodBindings
  Class.forName(XMLParser::class.java.name, true, XMLParser::class.java.classLoader)
  XMLParser.MethodBindings
  Class.forName(XRAnchor3D::class.java.name, true, XRAnchor3D::class.java.classLoader)
  XRAnchor3D.MethodBindings
  Class.forName(XRBodyModifier3D::class.java.name, true, XRBodyModifier3D::class.java.classLoader)
  XRBodyModifier3D.MethodBindings
  Class.forName(XRBodyTracker::class.java.name, true, XRBodyTracker::class.java.classLoader)
  XRBodyTracker.MethodBindings
  Class.forName(XRCamera3D::class.java.name, true, XRCamera3D::class.java.classLoader)
  XRCamera3D.MethodBindings
  Class.forName(XRController3D::class.java.name, true, XRController3D::class.java.classLoader)
  XRController3D.MethodBindings
  Class.forName(XRControllerTracker::class.java.name, true, XRControllerTracker::class.java.classLoader)
  XRControllerTracker.MethodBindings
  Class.forName(XRFaceModifier3D::class.java.name, true, XRFaceModifier3D::class.java.classLoader)
  XRFaceModifier3D.MethodBindings
  Class.forName(XRFaceTracker::class.java.name, true, XRFaceTracker::class.java.classLoader)
  XRFaceTracker.MethodBindings
  Class.forName(XRHandModifier3D::class.java.name, true, XRHandModifier3D::class.java.classLoader)
  XRHandModifier3D.MethodBindings
  Class.forName(XRHandTracker::class.java.name, true, XRHandTracker::class.java.classLoader)
  XRHandTracker.MethodBindings
  Class.forName(XRInterface::class.java.name, true, XRInterface::class.java.classLoader)
  XRInterface.MethodBindings
  Class.forName(XRInterfaceExtension::class.java.name, true, XRInterfaceExtension::class.java.classLoader)
  XRInterfaceExtension.MethodBindings
  Class.forName(XRNode3D::class.java.name, true, XRNode3D::class.java.classLoader)
  XRNode3D.MethodBindings
  Class.forName(XROrigin3D::class.java.name, true, XROrigin3D::class.java.classLoader)
  XROrigin3D.MethodBindings
  Class.forName(XRPose::class.java.name, true, XRPose::class.java.classLoader)
  XRPose.MethodBindings
  Class.forName(XRPositionalTracker::class.java.name, true, XRPositionalTracker::class.java.classLoader)
  XRPositionalTracker.MethodBindings
  Class.forName(XRServer::class.java.name, true, XRServer::class.java.classLoader)
  XRServer.MethodBindings
  Class.forName(XRTracker::class.java.name, true, XRTracker::class.java.classLoader)
  XRTracker.MethodBindings
  Class.forName(XRVRS::class.java.name, true, XRVRS::class.java.classLoader)
  XRVRS.MethodBindings
  Class.forName(ZIPPacker::class.java.name, true, ZIPPacker::class.java.classLoader)
  ZIPPacker.MethodBindings
  Class.forName(ZIPReader::class.java.name, true, ZIPReader::class.java.classLoader)
  ZIPReader.MethodBindings
}

public fun registerEngineTypes(): Unit {
  TypeManager.registerEngineType("AESContext", AESContext::class, ::AESContext)
  TypeManager.registerEngineType("AStar2D", AStar2D::class, ::AStar2D)
  TypeManager.registerEngineType("AStar3D", AStar3D::class, ::AStar3D)
  TypeManager.registerEngineType("AStarGrid2D", AStarGrid2D::class, ::AStarGrid2D)
  TypeManager.registerEngineType("AcceptDialog", AcceptDialog::class, ::AcceptDialog)
  TypeManager.registerSingleton("AccessibilityServer") { AccessibilityServer }
  TypeManager.registerEngineType("AccessibilityServer", AccessibilityServer::class) { AccessibilityServer }
  TypeManager.registerEngineType("AimModifier3D", AimModifier3D::class, ::AimModifier3D)
  TypeManager.registerEngineType("AnimatableBody2D", AnimatableBody2D::class, ::AnimatableBody2D)
  TypeManager.registerEngineType("AnimatableBody3D", AnimatableBody3D::class, ::AnimatableBody3D)
  TypeManager.registerEngineType("AnimatedSprite2D", AnimatedSprite2D::class, ::AnimatedSprite2D)
  TypeManager.registerEngineType("AnimatedSprite3D", AnimatedSprite3D::class, ::AnimatedSprite3D)
  TypeManager.registerEngineType("AnimatedTexture", AnimatedTexture::class, ::AnimatedTexture)
  TypeManager.registerEngineType("Animation", Animation::class, ::Animation)
  TypeManager.registerEngineType("AnimationLibrary", AnimationLibrary::class, ::AnimationLibrary)
  TypeManager.registerEngineType("AnimationMixer", AnimationMixer::class, ::AnimationMixer)
  TypeManager.registerEngineType("AnimationNode", AnimationNode::class, ::AnimationNode)
  TypeManager.registerEngineType("AnimationNodeAdd2", AnimationNodeAdd2::class, ::AnimationNodeAdd2)
  TypeManager.registerEngineType("AnimationNodeAdd3", AnimationNodeAdd3::class, ::AnimationNodeAdd3)
  TypeManager.registerEngineType("AnimationNodeAnimation", AnimationNodeAnimation::class, ::AnimationNodeAnimation)
  TypeManager.registerEngineType("AnimationNodeBlend2", AnimationNodeBlend2::class, ::AnimationNodeBlend2)
  TypeManager.registerEngineType("AnimationNodeBlend3", AnimationNodeBlend3::class, ::AnimationNodeBlend3)
  TypeManager.registerEngineType("AnimationNodeBlendSpace1D", AnimationNodeBlendSpace1D::class, ::AnimationNodeBlendSpace1D)
  TypeManager.registerEngineType("AnimationNodeBlendSpace2D", AnimationNodeBlendSpace2D::class, ::AnimationNodeBlendSpace2D)
  TypeManager.registerEngineType("AnimationNodeBlendTree", AnimationNodeBlendTree::class, ::AnimationNodeBlendTree)
  TypeManager.registerEngineType("AnimationNodeExtension", AnimationNodeExtension::class, ::AnimationNodeExtensionDummy)
  TypeManager.registerEngineType("AnimationNodeOneShot", AnimationNodeOneShot::class, ::AnimationNodeOneShot)
  TypeManager.registerEngineType("AnimationNodeOutput", AnimationNodeOutput::class, ::AnimationNodeOutput)
  TypeManager.registerEngineType("AnimationNodeStateMachine", AnimationNodeStateMachine::class, ::AnimationNodeStateMachine)
  TypeManager.registerEngineType("AnimationNodeStateMachinePlayback", AnimationNodeStateMachinePlayback::class, ::AnimationNodeStateMachinePlayback)
  TypeManager.registerEngineType("AnimationNodeStateMachineTransition", AnimationNodeStateMachineTransition::class, ::AnimationNodeStateMachineTransition)
  TypeManager.registerEngineType("AnimationNodeSub2", AnimationNodeSub2::class, ::AnimationNodeSub2)
  TypeManager.registerEngineType("AnimationNodeSync", AnimationNodeSync::class, ::AnimationNodeSync)
  TypeManager.registerEngineType("AnimationNodeTimeScale", AnimationNodeTimeScale::class, ::AnimationNodeTimeScale)
  TypeManager.registerEngineType("AnimationNodeTimeSeek", AnimationNodeTimeSeek::class, ::AnimationNodeTimeSeek)
  TypeManager.registerEngineType("AnimationNodeTransition", AnimationNodeTransition::class, ::AnimationNodeTransition)
  TypeManager.registerEngineType("AnimationPlayer", AnimationPlayer::class, ::AnimationPlayer)
  TypeManager.registerEngineType("AnimationRootNode", AnimationRootNode::class, ::AnimationRootNode)
  TypeManager.registerEngineType("AnimationTree", AnimationTree::class, ::AnimationTree)
  TypeManager.registerEngineType("Area2D", Area2D::class, ::Area2D)
  TypeManager.registerEngineType("Area3D", Area3D::class, ::Area3D)
  TypeManager.registerEngineType("AreaLight3D", AreaLight3D::class, ::AreaLight3D)
  TypeManager.registerEngineType("ArrayMesh", ArrayMesh::class, ::ArrayMesh)
  TypeManager.registerEngineType("ArrayOccluder3D", ArrayOccluder3D::class, ::ArrayOccluder3D)
  TypeManager.registerEngineType("AspectRatioContainer", AspectRatioContainer::class, ::AspectRatioContainer)
  TypeManager.registerEngineType("AtlasTexture", AtlasTexture::class, ::AtlasTexture)
  TypeManager.registerEngineType("AudioBusLayout", AudioBusLayout::class, ::AudioBusLayout)
  TypeManager.registerEngineType("AudioEffect", AudioEffect::class, ::AudioEffectDummy)
  TypeManager.registerEngineType("AudioEffectAmplify", AudioEffectAmplify::class, ::AudioEffectAmplify)
  TypeManager.registerEngineType("AudioEffectBandLimitFilter", AudioEffectBandLimitFilter::class, ::AudioEffectBandLimitFilter)
  TypeManager.registerEngineType("AudioEffectBandPassFilter", AudioEffectBandPassFilter::class, ::AudioEffectBandPassFilter)
  TypeManager.registerEngineType("AudioEffectCapture", AudioEffectCapture::class, ::AudioEffectCapture)
  TypeManager.registerEngineType("AudioEffectChorus", AudioEffectChorus::class, ::AudioEffectChorus)
  TypeManager.registerEngineType("AudioEffectCompressor", AudioEffectCompressor::class, ::AudioEffectCompressor)
  TypeManager.registerEngineType("AudioEffectDelay", AudioEffectDelay::class, ::AudioEffectDelay)
  TypeManager.registerEngineType("AudioEffectDistortion", AudioEffectDistortion::class, ::AudioEffectDistortion)
  TypeManager.registerEngineType("AudioEffectEQ", AudioEffectEQ::class, ::AudioEffectEQ)
  TypeManager.registerEngineType("AudioEffectEQ10", AudioEffectEQ10::class, ::AudioEffectEQ10)
  TypeManager.registerEngineType("AudioEffectEQ21", AudioEffectEQ21::class, ::AudioEffectEQ21)
  TypeManager.registerEngineType("AudioEffectEQ6", AudioEffectEQ6::class, ::AudioEffectEQ6)
  TypeManager.registerEngineType("AudioEffectFilter", AudioEffectFilter::class, ::AudioEffectFilter)
  TypeManager.registerEngineType("AudioEffectHardLimiter", AudioEffectHardLimiter::class, ::AudioEffectHardLimiter)
  TypeManager.registerEngineType("AudioEffectHighPassFilter", AudioEffectHighPassFilter::class, ::AudioEffectHighPassFilter)
  TypeManager.registerEngineType("AudioEffectHighShelfFilter", AudioEffectHighShelfFilter::class, ::AudioEffectHighShelfFilter)
  TypeManager.registerEngineType("AudioEffectInstance", AudioEffectInstance::class, ::AudioEffectInstanceDummy)
  TypeManager.registerEngineType("AudioEffectLimiter", AudioEffectLimiter::class, ::AudioEffectLimiter)
  TypeManager.registerEngineType("AudioEffectLowPassFilter", AudioEffectLowPassFilter::class, ::AudioEffectLowPassFilter)
  TypeManager.registerEngineType("AudioEffectLowShelfFilter", AudioEffectLowShelfFilter::class, ::AudioEffectLowShelfFilter)
  TypeManager.registerEngineType("AudioEffectNotchFilter", AudioEffectNotchFilter::class, ::AudioEffectNotchFilter)
  TypeManager.registerEngineType("AudioEffectPanner", AudioEffectPanner::class, ::AudioEffectPanner)
  TypeManager.registerEngineType("AudioEffectPhaser", AudioEffectPhaser::class, ::AudioEffectPhaser)
  TypeManager.registerEngineType("AudioEffectPitchShift", AudioEffectPitchShift::class, ::AudioEffectPitchShift)
  TypeManager.registerEngineType("AudioEffectRecord", AudioEffectRecord::class, ::AudioEffectRecord)
  TypeManager.registerEngineType("AudioEffectReverb", AudioEffectReverb::class, ::AudioEffectReverb)
  TypeManager.registerEngineType("AudioEffectSpectrumAnalyzer", AudioEffectSpectrumAnalyzer::class, ::AudioEffectSpectrumAnalyzer)
  TypeManager.registerEngineType("AudioEffectSpectrumAnalyzerInstance", AudioEffectSpectrumAnalyzerInstance::class, ::AudioEffectSpectrumAnalyzerInstance)
  TypeManager.registerEngineType("AudioEffectStereoEnhance", AudioEffectStereoEnhance::class, ::AudioEffectStereoEnhance)
  TypeManager.registerEngineType("AudioListener2D", AudioListener2D::class, ::AudioListener2D)
  TypeManager.registerEngineType("AudioListener3D", AudioListener3D::class, ::AudioListener3D)
  TypeManager.registerEngineType("AudioSample", AudioSample::class, ::AudioSample)
  TypeManager.registerEngineType("AudioSamplePlayback", AudioSamplePlayback::class, ::AudioSamplePlayback)
  TypeManager.registerSingleton("AudioServer") { AudioServer }
  TypeManager.registerEngineType("AudioServer", AudioServer::class) { AudioServer }
  TypeManager.registerEngineType("AudioStream", AudioStream::class, ::AudioStreamDummy)
  TypeManager.registerEngineType("AudioStreamGenerator", AudioStreamGenerator::class, ::AudioStreamGenerator)
  TypeManager.registerEngineType("AudioStreamGeneratorPlayback", AudioStreamGeneratorPlayback::class, ::AudioStreamGeneratorPlayback)
  TypeManager.registerEngineType("AudioStreamInteractive", AudioStreamInteractive::class, ::AudioStreamInteractive)
  TypeManager.registerEngineType("AudioStreamMP3", AudioStreamMP3::class, ::AudioStreamMP3)
  TypeManager.registerEngineType("AudioStreamMicrophone", AudioStreamMicrophone::class, ::AudioStreamMicrophone)
  TypeManager.registerEngineType("AudioStreamOggVorbis", AudioStreamOggVorbis::class, ::AudioStreamOggVorbis)
  TypeManager.registerEngineType("AudioStreamPlayback", AudioStreamPlayback::class, ::AudioStreamPlaybackDummy)
  TypeManager.registerEngineType("AudioStreamPlaybackInteractive", AudioStreamPlaybackInteractive::class, ::AudioStreamPlaybackInteractive)
  TypeManager.registerEngineType("AudioStreamPlaybackOggVorbis", AudioStreamPlaybackOggVorbis::class, ::AudioStreamPlaybackOggVorbis)
  TypeManager.registerEngineType("AudioStreamPlaybackPlaylist", AudioStreamPlaybackPlaylist::class, ::AudioStreamPlaybackPlaylist)
  TypeManager.registerEngineType("AudioStreamPlaybackPolyphonic", AudioStreamPlaybackPolyphonic::class, ::AudioStreamPlaybackPolyphonic)
  TypeManager.registerEngineType("AudioStreamPlaybackResampled", AudioStreamPlaybackResampled::class, ::AudioStreamPlaybackResampledDummy)
  TypeManager.registerEngineType("AudioStreamPlaybackSynchronized", AudioStreamPlaybackSynchronized::class, ::AudioStreamPlaybackSynchronized)
  TypeManager.registerEngineType("AudioStreamPlayer", AudioStreamPlayer::class, ::AudioStreamPlayer)
  TypeManager.registerEngineType("AudioStreamPlayer2D", AudioStreamPlayer2D::class, ::AudioStreamPlayer2D)
  TypeManager.registerEngineType("AudioStreamPlayer3D", AudioStreamPlayer3D::class, ::AudioStreamPlayer3D)
  TypeManager.registerEngineType("AudioStreamPlaylist", AudioStreamPlaylist::class, ::AudioStreamPlaylist)
  TypeManager.registerEngineType("AudioStreamPolyphonic", AudioStreamPolyphonic::class, ::AudioStreamPolyphonic)
  TypeManager.registerEngineType("AudioStreamRandomizer", AudioStreamRandomizer::class, ::AudioStreamRandomizer)
  TypeManager.registerEngineType("AudioStreamSynchronized", AudioStreamSynchronized::class, ::AudioStreamSynchronized)
  TypeManager.registerEngineType("AudioStreamWAV", AudioStreamWAV::class, ::AudioStreamWAV)
  TypeManager.registerEngineType("AwaitTweener", AwaitTweener::class, ::AwaitTweener)
  TypeManager.registerEngineType("BackBufferCopy", BackBufferCopy::class, ::BackBufferCopy)
  TypeManager.registerEngineType("BaseButton", BaseButton::class, ::BaseButton)
  TypeManager.registerEngineType("BaseMaterial3D", BaseMaterial3D::class, ::BaseMaterial3D)
  TypeManager.registerEngineType("BitMap", BitMap::class, ::BitMap)
  TypeManager.registerEngineType("BlitMaterial", BlitMaterial::class, ::BlitMaterial)
  TypeManager.registerEngineType("Bone2D", Bone2D::class, ::Bone2D)
  TypeManager.registerEngineType("BoneAttachment3D", BoneAttachment3D::class, ::BoneAttachment3D)
  TypeManager.registerEngineType("BoneConstraint3D", BoneConstraint3D::class, ::BoneConstraint3D)
  TypeManager.registerEngineType("BoneMap", BoneMap::class, ::BoneMap)
  TypeManager.registerEngineType("BoneTwistDisperser3D", BoneTwistDisperser3D::class, ::BoneTwistDisperser3D)
  TypeManager.registerEngineType("BoxContainer", BoxContainer::class, ::BoxContainer)
  TypeManager.registerEngineType("BoxMesh", BoxMesh::class, ::BoxMesh)
  TypeManager.registerEngineType("BoxOccluder3D", BoxOccluder3D::class, ::BoxOccluder3D)
  TypeManager.registerEngineType("BoxShape3D", BoxShape3D::class, ::BoxShape3D)
  TypeManager.registerEngineType("Button", Button::class, ::Button)
  TypeManager.registerEngineType("ButtonGroup", ButtonGroup::class, ::ButtonGroup)
  TypeManager.registerEngineType("CCDIK3D", CCDIK3D::class, ::CCDIK3D)
  TypeManager.registerEngineType("CPUParticles2D", CPUParticles2D::class, ::CPUParticles2D)
  TypeManager.registerEngineType("CPUParticles3D", CPUParticles3D::class, ::CPUParticles3D)
  TypeManager.registerEngineType("CSGBox3D", CSGBox3D::class, ::CSGBox3D)
  TypeManager.registerEngineType("CSGCombiner3D", CSGCombiner3D::class, ::CSGCombiner3D)
  TypeManager.registerEngineType("CSGCylinder3D", CSGCylinder3D::class, ::CSGCylinder3D)
  TypeManager.registerEngineType("CSGMesh3D", CSGMesh3D::class, ::CSGMesh3D)
  TypeManager.registerEngineType("CSGPolygon3D", CSGPolygon3D::class, ::CSGPolygon3D)
  TypeManager.registerEngineType("CSGPrimitive3D", CSGPrimitive3D::class, ::CSGPrimitive3D)
  TypeManager.registerEngineType("CSGShape3D", CSGShape3D::class, ::CSGShape3D)
  TypeManager.registerEngineType("CSGSphere3D", CSGSphere3D::class, ::CSGSphere3D)
  TypeManager.registerEngineType("CSGTorus3D", CSGTorus3D::class, ::CSGTorus3D)
  TypeManager.registerEngineType("CallbackTweener", CallbackTweener::class, ::CallbackTweener)
  TypeManager.registerEngineType("Camera2D", Camera2D::class, ::Camera2D)
  TypeManager.registerEngineType("Camera3D", Camera3D::class, ::Camera3D)
  TypeManager.registerEngineType("CameraAttributes", CameraAttributes::class, ::CameraAttributes)
  TypeManager.registerEngineType("CameraAttributesPhysical", CameraAttributesPhysical::class, ::CameraAttributesPhysical)
  TypeManager.registerEngineType("CameraAttributesPractical", CameraAttributesPractical::class, ::CameraAttributesPractical)
  TypeManager.registerEngineType("CameraFeed", CameraFeed::class, ::CameraFeed)
  TypeManager.registerSingleton("CameraServer") { CameraServer }
  TypeManager.registerEngineType("CameraServer", CameraServer::class) { CameraServer }
  TypeManager.registerEngineType("CameraTexture", CameraTexture::class, ::CameraTexture)
  TypeManager.registerEngineType("CanvasGroup", CanvasGroup::class, ::CanvasGroup)
  TypeManager.registerEngineType("CanvasItem", CanvasItem::class, ::CanvasItem)
  TypeManager.registerEngineType("CanvasItemMaterial", CanvasItemMaterial::class, ::CanvasItemMaterial)
  TypeManager.registerEngineType("CanvasLayer", CanvasLayer::class, ::CanvasLayer)
  TypeManager.registerEngineType("CanvasModulate", CanvasModulate::class, ::CanvasModulate)
  TypeManager.registerEngineType("CanvasTexture", CanvasTexture::class, ::CanvasTexture)
  TypeManager.registerEngineType("CapsuleMesh", CapsuleMesh::class, ::CapsuleMesh)
  TypeManager.registerEngineType("CapsuleShape2D", CapsuleShape2D::class, ::CapsuleShape2D)
  TypeManager.registerEngineType("CapsuleShape3D", CapsuleShape3D::class, ::CapsuleShape3D)
  TypeManager.registerEngineType("CenterContainer", CenterContainer::class, ::CenterContainer)
  TypeManager.registerEngineType("ChainIK3D", ChainIK3D::class, ::ChainIK3D)
  TypeManager.registerEngineType("CharFXTransform", CharFXTransform::class, ::CharFXTransform)
  TypeManager.registerEngineType("CharacterBody2D", CharacterBody2D::class, ::CharacterBody2D)
  TypeManager.registerEngineType("CharacterBody3D", CharacterBody3D::class, ::CharacterBody3D)
  TypeManager.registerEngineType("CheckBox", CheckBox::class, ::CheckBox)
  TypeManager.registerEngineType("CheckButton", CheckButton::class, ::CheckButton)
  TypeManager.registerEngineType("CircleShape2D", CircleShape2D::class, ::CircleShape2D)
  TypeManager.registerSingleton("ClassDB") { ClassDB }
  TypeManager.registerEngineType("ClassDB", ClassDB::class) { ClassDB }
  TypeManager.registerEngineType("CodeEdit", CodeEdit::class, ::CodeEdit)
  TypeManager.registerEngineType("CodeHighlighter", CodeHighlighter::class, ::CodeHighlighter)
  TypeManager.registerEngineType("CollisionObject2D", CollisionObject2D::class, ::CollisionObject2D)
  TypeManager.registerEngineType("CollisionObject3D", CollisionObject3D::class, ::CollisionObject3D)
  TypeManager.registerEngineType("CollisionPolygon2D", CollisionPolygon2D::class, ::CollisionPolygon2D)
  TypeManager.registerEngineType("CollisionPolygon3D", CollisionPolygon3D::class, ::CollisionPolygon3D)
  TypeManager.registerEngineType("CollisionShape2D", CollisionShape2D::class, ::CollisionShape2D)
  TypeManager.registerEngineType("CollisionShape3D", CollisionShape3D::class, ::CollisionShape3D)
  TypeManager.registerEngineType("ColorPalette", ColorPalette::class, ::ColorPalette)
  TypeManager.registerEngineType("ColorPicker", ColorPicker::class, ::ColorPicker)
  TypeManager.registerEngineType("ColorPickerButton", ColorPickerButton::class, ::ColorPickerButton)
  TypeManager.registerEngineType("ColorRect", ColorRect::class, ::ColorRect)
  TypeManager.registerEngineType("Compositor", Compositor::class, ::Compositor)
  TypeManager.registerEngineType("CompositorEffect", CompositorEffect::class, ::CompositorEffect)
  TypeManager.registerEngineType("CompressedCubemap", CompressedCubemap::class, ::CompressedCubemap)
  TypeManager.registerEngineType("CompressedCubemapArray", CompressedCubemapArray::class, ::CompressedCubemapArray)
  TypeManager.registerEngineType("CompressedTexture2D", CompressedTexture2D::class, ::CompressedTexture2D)
  TypeManager.registerEngineType("CompressedTexture2DArray", CompressedTexture2DArray::class, ::CompressedTexture2DArray)
  TypeManager.registerEngineType("CompressedTexture3D", CompressedTexture3D::class, ::CompressedTexture3D)
  TypeManager.registerEngineType("CompressedTextureLayered", CompressedTextureLayered::class, ::CompressedTextureLayered)
  TypeManager.registerEngineType("ConcavePolygonShape2D", ConcavePolygonShape2D::class, ::ConcavePolygonShape2D)
  TypeManager.registerEngineType("ConcavePolygonShape3D", ConcavePolygonShape3D::class, ::ConcavePolygonShape3D)
  TypeManager.registerEngineType("ConeTwistJoint3D", ConeTwistJoint3D::class, ::ConeTwistJoint3D)
  TypeManager.registerEngineType("ConfigFile", ConfigFile::class, ::ConfigFile)
  TypeManager.registerEngineType("ConfirmationDialog", ConfirmationDialog::class, ::ConfirmationDialog)
  TypeManager.registerEngineType("Container", Container::class, ::Container)
  TypeManager.registerEngineType("Control", Control::class, ::Control)
  TypeManager.registerEngineType("ConvertTransformModifier3D", ConvertTransformModifier3D::class, ::ConvertTransformModifier3D)
  TypeManager.registerEngineType("ConvexPolygonShape2D", ConvexPolygonShape2D::class, ::ConvexPolygonShape2D)
  TypeManager.registerEngineType("ConvexPolygonShape3D", ConvexPolygonShape3D::class, ::ConvexPolygonShape3D)
  TypeManager.registerEngineType("CopyTransformModifier3D", CopyTransformModifier3D::class, ::CopyTransformModifier3D)
  TypeManager.registerEngineType("Crypto", Crypto::class, ::Crypto)
  TypeManager.registerEngineType("CryptoKey", CryptoKey::class, ::CryptoKey)
  TypeManager.registerEngineType("Cubemap", Cubemap::class, ::Cubemap)
  TypeManager.registerEngineType("CubemapArray", CubemapArray::class, ::CubemapArray)
  TypeManager.registerEngineType("Curve", Curve::class, ::Curve)
  TypeManager.registerEngineType("Curve2D", Curve2D::class, ::Curve2D)
  TypeManager.registerEngineType("Curve3D", Curve3D::class, ::Curve3D)
  TypeManager.registerEngineType("CurveTexture", CurveTexture::class, ::CurveTexture)
  TypeManager.registerEngineType("CurveXYZTexture", CurveXYZTexture::class, ::CurveXYZTexture)
  TypeManager.registerEngineType("CylinderMesh", CylinderMesh::class, ::CylinderMesh)
  TypeManager.registerEngineType("CylinderShape3D", CylinderShape3D::class, ::CylinderShape3D)
  TypeManager.registerEngineType("DPITexture", DPITexture::class, ::DPITexture)
  TypeManager.registerEngineType("DTLSServer", DTLSServer::class, ::DTLSServer)
  TypeManager.registerEngineType("DampedSpringJoint2D", DampedSpringJoint2D::class, ::DampedSpringJoint2D)
  TypeManager.registerEngineType("Decal", Decal::class, ::Decal)
  TypeManager.registerEngineType("DirAccess", DirAccess::class, ::DirAccess)
  TypeManager.registerEngineType("DirectionalLight2D", DirectionalLight2D::class, ::DirectionalLight2D)
  TypeManager.registerEngineType("DirectionalLight3D", DirectionalLight3D::class, ::DirectionalLight3D)
  TypeManager.registerSingleton("DisplayServer") { DisplayServer }
  TypeManager.registerEngineType("DisplayServer", DisplayServer::class) { DisplayServer }
  TypeManager.registerEngineType("DrawableTexture2D", DrawableTexture2D::class, ::DrawableTexture2D)
  TypeManager.registerEngineType("ENetConnection", ENetConnection::class, ::ENetConnection)
  TypeManager.registerEngineType("ENetMultiplayerPeer", ENetMultiplayerPeer::class, ::ENetMultiplayerPeer)
  TypeManager.registerEngineType("ENetPacketPeer", ENetPacketPeer::class, ::ENetPacketPeer)
  TypeManager.registerEngineType("EncodedObjectAsID", EncodedObjectAsID::class, ::EncodedObjectAsID)
  TypeManager.registerSingleton("Engine") { Engine }
  TypeManager.registerEngineType("Engine", Engine::class) { Engine }
  TypeManager.registerSingleton("EngineDebugger") { EngineDebugger }
  TypeManager.registerEngineType("EngineDebugger", EngineDebugger::class) { EngineDebugger }
  TypeManager.registerEngineType("EngineProfiler", EngineProfiler::class, ::EngineProfiler)
  TypeManager.registerEngineType("Environment", Environment::class, ::Environment)
  TypeManager.registerEngineType("Expression", Expression::class, ::Expression)
  TypeManager.registerEngineType("ExternalTexture", ExternalTexture::class, ::ExternalTexture)
  TypeManager.registerEngineType("FABRIK3D", FABRIK3D::class, ::FABRIK3D)
  TypeManager.registerEngineType("FBXDocument", FBXDocument::class, ::FBXDocument)
  TypeManager.registerEngineType("FBXState", FBXState::class, ::FBXState)
  TypeManager.registerEngineType("FastNoiseLite", FastNoiseLite::class, ::FastNoiseLite)
  TypeManager.registerEngineType("FileAccess", FileAccess::class, ::FileAccess)
  TypeManager.registerEngineType("FileDialog", FileDialog::class, ::FileDialog)
  TypeManager.registerEngineType("FlowContainer", FlowContainer::class, ::FlowContainer)
  TypeManager.registerEngineType("FogMaterial", FogMaterial::class, ::FogMaterial)
  TypeManager.registerEngineType("FogVolume", FogVolume::class, ::FogVolume)
  TypeManager.registerEngineType("FoldableContainer", FoldableContainer::class, ::FoldableContainer)
  TypeManager.registerEngineType("FoldableGroup", FoldableGroup::class, ::FoldableGroup)
  TypeManager.registerEngineType("Font", Font::class, ::Font)
  TypeManager.registerEngineType("FontFile", FontFile::class, ::FontFile)
  TypeManager.registerEngineType("FontVariation", FontVariation::class, ::FontVariation)
  TypeManager.registerEngineType("FramebufferCacheRD", FramebufferCacheRD::class, ::FramebufferCacheRD)
  TypeManager.registerEngineType("GDExtension", GDExtension::class, ::GDExtension)
  TypeManager.registerSingleton("GDExtensionManager") { GDExtensionManager }
  TypeManager.registerEngineType("GDExtensionManager", GDExtensionManager::class) { GDExtensionManager }
  TypeManager.registerEngineType("GDScript", GDScript::class, ::GDScript)
  TypeManager.registerEngineType("GLTFAccessor", GLTFAccessor::class, ::GLTFAccessor)
  TypeManager.registerEngineType("GLTFAnimation", GLTFAnimation::class, ::GLTFAnimation)
  TypeManager.registerEngineType("GLTFBufferView", GLTFBufferView::class, ::GLTFBufferView)
  TypeManager.registerEngineType("GLTFCamera", GLTFCamera::class, ::GLTFCamera)
  TypeManager.registerEngineType("GLTFDocument", GLTFDocument::class, ::GLTFDocument)
  TypeManager.registerEngineType("GLTFDocumentExtension", GLTFDocumentExtension::class, ::GLTFDocumentExtension)
  TypeManager.registerEngineType("GLTFDocumentExtensionConvertImporterMesh", GLTFDocumentExtensionConvertImporterMesh::class, ::GLTFDocumentExtensionConvertImporterMesh)
  TypeManager.registerEngineType("GLTFLight", GLTFLight::class, ::GLTFLight)
  TypeManager.registerEngineType("GLTFMesh", GLTFMesh::class, ::GLTFMesh)
  TypeManager.registerEngineType("GLTFNode", GLTFNode::class, ::GLTFNode)
  TypeManager.registerEngineType("GLTFObjectModelProperty", GLTFObjectModelProperty::class, ::GLTFObjectModelProperty)
  TypeManager.registerEngineType("GLTFPhysicsBody", GLTFPhysicsBody::class, ::GLTFPhysicsBody)
  TypeManager.registerEngineType("GLTFPhysicsShape", GLTFPhysicsShape::class, ::GLTFPhysicsShape)
  TypeManager.registerEngineType("GLTFSkeleton", GLTFSkeleton::class, ::GLTFSkeleton)
  TypeManager.registerEngineType("GLTFSkin", GLTFSkin::class, ::GLTFSkin)
  TypeManager.registerEngineType("GLTFSpecGloss", GLTFSpecGloss::class, ::GLTFSpecGloss)
  TypeManager.registerEngineType("GLTFState", GLTFState::class, ::GLTFState)
  TypeManager.registerEngineType("GLTFTexture", GLTFTexture::class, ::GLTFTexture)
  TypeManager.registerEngineType("GLTFTextureSampler", GLTFTextureSampler::class, ::GLTFTextureSampler)
  TypeManager.registerEngineType("GPUParticles2D", GPUParticles2D::class, ::GPUParticles2D)
  TypeManager.registerEngineType("GPUParticles3D", GPUParticles3D::class, ::GPUParticles3D)
  TypeManager.registerEngineType("GPUParticlesAttractor3D", GPUParticlesAttractor3D::class, ::GPUParticlesAttractor3D)
  TypeManager.registerEngineType("GPUParticlesAttractorBox3D", GPUParticlesAttractorBox3D::class, ::GPUParticlesAttractorBox3D)
  TypeManager.registerEngineType("GPUParticlesAttractorSphere3D", GPUParticlesAttractorSphere3D::class, ::GPUParticlesAttractorSphere3D)
  TypeManager.registerEngineType("GPUParticlesAttractorVectorField3D", GPUParticlesAttractorVectorField3D::class, ::GPUParticlesAttractorVectorField3D)
  TypeManager.registerEngineType("GPUParticlesCollision3D", GPUParticlesCollision3D::class, ::GPUParticlesCollision3D)
  TypeManager.registerEngineType("GPUParticlesCollisionBox3D", GPUParticlesCollisionBox3D::class, ::GPUParticlesCollisionBox3D)
  TypeManager.registerEngineType("GPUParticlesCollisionHeightField3D", GPUParticlesCollisionHeightField3D::class, ::GPUParticlesCollisionHeightField3D)
  TypeManager.registerEngineType("GPUParticlesCollisionSDF3D", GPUParticlesCollisionSDF3D::class, ::GPUParticlesCollisionSDF3D)
  TypeManager.registerEngineType("GPUParticlesCollisionSphere3D", GPUParticlesCollisionSphere3D::class, ::GPUParticlesCollisionSphere3D)
  TypeManager.registerEngineType("GdjScript", GdjScript::class, ::GdjScript)
  TypeManager.registerEngineType("Generic6DOFJoint3D", Generic6DOFJoint3D::class, ::Generic6DOFJoint3D)
  TypeManager.registerSingleton("Geometry2D") { Geometry2D }
  TypeManager.registerEngineType("Geometry2D", Geometry2D::class) { Geometry2D }
  TypeManager.registerSingleton("Geometry3D") { Geometry3D }
  TypeManager.registerEngineType("Geometry3D", Geometry3D::class) { Geometry3D }
  TypeManager.registerEngineType("GeometryInstance3D", GeometryInstance3D::class, ::GeometryInstance3D)
  TypeManager.registerEngineType("GodotInstance", GodotInstance::class, ::GodotInstance)
  TypeManager.registerEngineType("Gradient", Gradient::class, ::Gradient)
  TypeManager.registerEngineType("GradientTexture1D", GradientTexture1D::class, ::GradientTexture1D)
  TypeManager.registerEngineType("GradientTexture2D", GradientTexture2D::class, ::GradientTexture2D)
  TypeManager.registerEngineType("GraphEdit", GraphEdit::class, ::GraphEdit)
  TypeManager.registerEngineType("GraphElement", GraphElement::class, ::GraphElement)
  TypeManager.registerEngineType("GraphFrame", GraphFrame::class, ::GraphFrame)
  TypeManager.registerEngineType("GraphNode", GraphNode::class, ::GraphNode)
  TypeManager.registerEngineType("GridContainer", GridContainer::class, ::GridContainer)
  TypeManager.registerEngineType("GridMap", GridMap::class, ::GridMap)
  TypeManager.registerEngineType("GrooveJoint2D", GrooveJoint2D::class, ::GrooveJoint2D)
  TypeManager.registerEngineType("HBoxContainer", HBoxContainer::class, ::HBoxContainer)
  TypeManager.registerEngineType("HFlowContainer", HFlowContainer::class, ::HFlowContainer)
  TypeManager.registerEngineType("HMACContext", HMACContext::class, ::HMACContext)
  TypeManager.registerEngineType("HScrollBar", HScrollBar::class, ::HScrollBar)
  TypeManager.registerEngineType("HSeparator", HSeparator::class, ::HSeparator)
  TypeManager.registerEngineType("HSlider", HSlider::class, ::HSlider)
  TypeManager.registerEngineType("HSplitContainer", HSplitContainer::class, ::HSplitContainer)
  TypeManager.registerEngineType("HTTPClient", HTTPClient::class, ::HTTPClient)
  TypeManager.registerEngineType("HTTPRequest", HTTPRequest::class, ::HTTPRequest)
  TypeManager.registerEngineType("HashingContext", HashingContext::class, ::HashingContext)
  TypeManager.registerEngineType("HeightMapShape3D", HeightMapShape3D::class, ::HeightMapShape3D)
  TypeManager.registerEngineType("HingeJoint3D", HingeJoint3D::class, ::HingeJoint3D)
  TypeManager.registerEngineType("IKModifier3D", IKModifier3D::class, ::IKModifier3D)
  TypeManager.registerSingleton("IP") { IP }
  TypeManager.registerEngineType("IP", IP::class) { IP }
  TypeManager.registerEngineType("Image", Image::class, ::Image)
  TypeManager.registerEngineType("ImageFormatLoader", ImageFormatLoader::class, ::ImageFormatLoader)
  TypeManager.registerEngineType("ImageFormatLoaderExtension", ImageFormatLoaderExtension::class, ::ImageFormatLoaderExtension)
  TypeManager.registerEngineType("ImageTexture", ImageTexture::class, ::ImageTexture)
  TypeManager.registerEngineType("ImageTexture3D", ImageTexture3D::class, ::ImageTexture3D)
  TypeManager.registerEngineType("ImageTextureLayered", ImageTextureLayered::class, ::ImageTextureLayered)
  TypeManager.registerEngineType("ImmediateMesh", ImmediateMesh::class, ::ImmediateMesh)
  TypeManager.registerEngineType("ImporterMesh", ImporterMesh::class, ::ImporterMesh)
  TypeManager.registerEngineType("ImporterMeshInstance3D", ImporterMeshInstance3D::class, ::ImporterMeshInstance3D)
  TypeManager.registerSingleton("Input") { Input }
  TypeManager.registerEngineType("Input", Input::class) { Input }
  TypeManager.registerEngineType("InputEvent", InputEvent::class, ::InputEvent)
  TypeManager.registerEngineType("InputEventAction", InputEventAction::class, ::InputEventAction)
  TypeManager.registerEngineType("InputEventFromWindow", InputEventFromWindow::class, ::InputEventFromWindow)
  TypeManager.registerEngineType("InputEventGesture", InputEventGesture::class, ::InputEventGesture)
  TypeManager.registerEngineType("InputEventJoypadButton", InputEventJoypadButton::class, ::InputEventJoypadButton)
  TypeManager.registerEngineType("InputEventJoypadMotion", InputEventJoypadMotion::class, ::InputEventJoypadMotion)
  TypeManager.registerEngineType("InputEventKey", InputEventKey::class, ::InputEventKey)
  TypeManager.registerEngineType("InputEventMIDI", InputEventMIDI::class, ::InputEventMIDI)
  TypeManager.registerEngineType("InputEventMagnifyGesture", InputEventMagnifyGesture::class, ::InputEventMagnifyGesture)
  TypeManager.registerEngineType("InputEventMouse", InputEventMouse::class, ::InputEventMouse)
  TypeManager.registerEngineType("InputEventMouseButton", InputEventMouseButton::class, ::InputEventMouseButton)
  TypeManager.registerEngineType("InputEventMouseMotion", InputEventMouseMotion::class, ::InputEventMouseMotion)
  TypeManager.registerEngineType("InputEventPanGesture", InputEventPanGesture::class, ::InputEventPanGesture)
  TypeManager.registerEngineType("InputEventScreenDrag", InputEventScreenDrag::class, ::InputEventScreenDrag)
  TypeManager.registerEngineType("InputEventScreenTouch", InputEventScreenTouch::class, ::InputEventScreenTouch)
  TypeManager.registerEngineType("InputEventShortcut", InputEventShortcut::class, ::InputEventShortcut)
  TypeManager.registerEngineType("InputEventWithModifiers", InputEventWithModifiers::class, ::InputEventWithModifiers)
  TypeManager.registerSingleton("InputMap") { InputMap }
  TypeManager.registerEngineType("InputMap", InputMap::class) { InputMap }
  TypeManager.registerEngineType("InstancePlaceholder", InstancePlaceholder::class, ::InstancePlaceholder)
  TypeManager.registerEngineType("IntervalTweener", IntervalTweener::class, ::IntervalTweener)
  TypeManager.registerEngineType("ItemList", ItemList::class, ::ItemList)
  TypeManager.registerEngineType("IterateIK3D", IterateIK3D::class, ::IterateIK3D)
  TypeManager.registerEngineType("JNISingleton", JNISingleton::class, ::JNISingleton)
  TypeManager.registerEngineType("JSON", JSON::class, ::JSON)
  TypeManager.registerEngineType("JSONRPC", JSONRPC::class, ::JSONRPC)
  TypeManager.registerEngineType("JacobianIK3D", JacobianIK3D::class, ::JacobianIK3D)
  TypeManager.registerEngineType("JavaClass", JavaClass::class, ::JavaClass)
  TypeManager.registerSingleton("JavaClassWrapper") { JavaClassWrapper }
  TypeManager.registerEngineType("JavaClassWrapper", JavaClassWrapper::class) { JavaClassWrapper }
  TypeManager.registerEngineType("JavaObject", JavaObject::class, ::JavaObject)
  TypeManager.registerEngineType("JavaScript", JavaScript::class, ::JavaScript)
  TypeManager.registerSingleton("JavaScriptBridge") { JavaScriptBridge }
  TypeManager.registerEngineType("JavaScriptBridge", JavaScriptBridge::class) { JavaScriptBridge }
  TypeManager.registerEngineType("JavaScriptObject", JavaScriptObject::class, ::JavaScriptObject)
  TypeManager.registerEngineType("Joint2D", Joint2D::class, ::Joint2D)
  TypeManager.registerEngineType("Joint3D", Joint3D::class, ::Joint3D)
  TypeManager.registerEngineType("JointLimitation3D", JointLimitation3D::class, ::JointLimitation3D)
  TypeManager.registerEngineType("JointLimitationCone3D", JointLimitationCone3D::class, ::JointLimitationCone3D)
  TypeManager.registerEngineType("JvmScript", JvmScript::class, ::JvmScript)
  TypeManager.registerEngineType("KinematicCollision2D", KinematicCollision2D::class, ::KinematicCollision2D)
  TypeManager.registerEngineType("KinematicCollision3D", KinematicCollision3D::class, ::KinematicCollision3D)
  TypeManager.registerEngineType("KotlinScript", KotlinScript::class, ::KotlinScript)
  TypeManager.registerEngineType("Label", Label::class, ::Label)
  TypeManager.registerEngineType("Label3D", Label3D::class, ::Label3D)
  TypeManager.registerEngineType("LabelSettings", LabelSettings::class, ::LabelSettings)
  TypeManager.registerEngineType("Light2D", Light2D::class, ::Light2D)
  TypeManager.registerEngineType("Light3D", Light3D::class, ::Light3D)
  TypeManager.registerEngineType("LightOccluder2D", LightOccluder2D::class, ::LightOccluder2D)
  TypeManager.registerEngineType("LightmapGI", LightmapGI::class, ::LightmapGI)
  TypeManager.registerEngineType("LightmapGIData", LightmapGIData::class, ::LightmapGIData)
  TypeManager.registerEngineType("LightmapProbe", LightmapProbe::class, ::LightmapProbe)
  TypeManager.registerEngineType("Lightmapper", Lightmapper::class, ::Lightmapper)
  TypeManager.registerEngineType("LightmapperRD", LightmapperRD::class, ::LightmapperRD)
  TypeManager.registerEngineType("LimitAngularVelocityModifier3D", LimitAngularVelocityModifier3D::class, ::LimitAngularVelocityModifier3D)
  TypeManager.registerEngineType("Line2D", Line2D::class, ::Line2D)
  TypeManager.registerEngineType("LineEdit", LineEdit::class, ::LineEdit)
  TypeManager.registerEngineType("LinkButton", LinkButton::class, ::LinkButton)
  TypeManager.registerEngineType("Logger", Logger::class, ::Logger)
  TypeManager.registerEngineType("LookAtModifier3D", LookAtModifier3D::class, ::LookAtModifier3D)
  TypeManager.registerEngineType("MainLoop", MainLoop::class, ::MainLoop)
  TypeManager.registerEngineType("MarginContainer", MarginContainer::class, ::MarginContainer)
  TypeManager.registerEngineType("Marker2D", Marker2D::class, ::Marker2D)
  TypeManager.registerEngineType("Marker3D", Marker3D::class, ::Marker3D)
  TypeManager.registerSingleton("Marshalls") { Marshalls }
  TypeManager.registerEngineType("Marshalls", Marshalls::class) { Marshalls }
  TypeManager.registerEngineType("Material", Material::class, ::MaterialDummy)
  TypeManager.registerEngineType("MenuBar", MenuBar::class, ::MenuBar)
  TypeManager.registerEngineType("MenuButton", MenuButton::class, ::MenuButton)
  TypeManager.registerEngineType("Mesh", Mesh::class, ::MeshDummy)
  TypeManager.registerEngineType("MeshConvexDecompositionSettings", MeshConvexDecompositionSettings::class, ::MeshConvexDecompositionSettings)
  TypeManager.registerEngineType("MeshDataTool", MeshDataTool::class, ::MeshDataTool)
  TypeManager.registerEngineType("MeshInstance2D", MeshInstance2D::class, ::MeshInstance2D)
  TypeManager.registerEngineType("MeshInstance3D", MeshInstance3D::class, ::MeshInstance3D)
  TypeManager.registerEngineType("MeshLibrary", MeshLibrary::class, ::MeshLibrary)
  TypeManager.registerEngineType("MeshTexture", MeshTexture::class, ::MeshTexture)
  TypeManager.registerEngineType("MethodTweener", MethodTweener::class, ::MethodTweener)
  TypeManager.registerEngineType("MissingNode", MissingNode::class, ::MissingNode)
  TypeManager.registerEngineType("MissingResource", MissingResource::class, ::MissingResource)
  TypeManager.registerEngineType("MobileVRInterface", MobileVRInterface::class, ::MobileVRInterface)
  TypeManager.registerEngineType("ModifierBoneTarget3D", ModifierBoneTarget3D::class, ::ModifierBoneTarget3D)
  TypeManager.registerEngineType("MovieWriter", MovieWriter::class, ::MovieWriterDummy)
  TypeManager.registerEngineType("MultiMesh", MultiMesh::class, ::MultiMesh)
  TypeManager.registerEngineType("MultiMeshInstance2D", MultiMeshInstance2D::class, ::MultiMeshInstance2D)
  TypeManager.registerEngineType("MultiMeshInstance3D", MultiMeshInstance3D::class, ::MultiMeshInstance3D)
  TypeManager.registerEngineType("MultiplayerAPI", MultiplayerAPI::class, ::MultiplayerAPI)
  TypeManager.registerEngineType("MultiplayerAPIExtension", MultiplayerAPIExtension::class, ::MultiplayerAPIExtension)
  TypeManager.registerEngineType("MultiplayerPeer", MultiplayerPeer::class, ::MultiplayerPeer)
  TypeManager.registerEngineType("MultiplayerPeerExtension", MultiplayerPeerExtension::class, ::MultiplayerPeerExtensionDummy)
  TypeManager.registerEngineType("MultiplayerSpawner", MultiplayerSpawner::class, ::MultiplayerSpawner)
  TypeManager.registerEngineType("MultiplayerSynchronizer", MultiplayerSynchronizer::class, ::MultiplayerSynchronizer)
  TypeManager.registerEngineType("Mutex", Mutex::class, ::Mutex)
  TypeManager.registerSingleton("NativeMenu") { NativeMenu }
  TypeManager.registerEngineType("NativeMenu", NativeMenu::class) { NativeMenu }
  TypeManager.registerEngineType("NavigationAgent2D", NavigationAgent2D::class, ::NavigationAgent2D)
  TypeManager.registerEngineType("NavigationAgent3D", NavigationAgent3D::class, ::NavigationAgent3D)
  TypeManager.registerEngineType("NavigationLink2D", NavigationLink2D::class, ::NavigationLink2D)
  TypeManager.registerEngineType("NavigationLink3D", NavigationLink3D::class, ::NavigationLink3D)
  TypeManager.registerEngineType("NavigationMesh", NavigationMesh::class, ::NavigationMesh)
  TypeManager.registerSingleton("NavigationMeshGenerator") { NavigationMeshGenerator }
  TypeManager.registerEngineType("NavigationMeshGenerator", NavigationMeshGenerator::class) { NavigationMeshGenerator }
  TypeManager.registerEngineType("NavigationMeshSourceGeometryData2D", NavigationMeshSourceGeometryData2D::class, ::NavigationMeshSourceGeometryData2D)
  TypeManager.registerEngineType("NavigationMeshSourceGeometryData3D", NavigationMeshSourceGeometryData3D::class, ::NavigationMeshSourceGeometryData3D)
  TypeManager.registerEngineType("NavigationObstacle2D", NavigationObstacle2D::class, ::NavigationObstacle2D)
  TypeManager.registerEngineType("NavigationObstacle3D", NavigationObstacle3D::class, ::NavigationObstacle3D)
  TypeManager.registerEngineType("NavigationPathQueryParameters2D", NavigationPathQueryParameters2D::class, ::NavigationPathQueryParameters2D)
  TypeManager.registerEngineType("NavigationPathQueryParameters3D", NavigationPathQueryParameters3D::class, ::NavigationPathQueryParameters3D)
  TypeManager.registerEngineType("NavigationPathQueryResult2D", NavigationPathQueryResult2D::class, ::NavigationPathQueryResult2D)
  TypeManager.registerEngineType("NavigationPathQueryResult3D", NavigationPathQueryResult3D::class, ::NavigationPathQueryResult3D)
  TypeManager.registerEngineType("NavigationPolygon", NavigationPolygon::class, ::NavigationPolygon)
  TypeManager.registerEngineType("NavigationRegion2D", NavigationRegion2D::class, ::NavigationRegion2D)
  TypeManager.registerEngineType("NavigationRegion3D", NavigationRegion3D::class, ::NavigationRegion3D)
  TypeManager.registerSingleton("NavigationServer2D") { NavigationServer2D }
  TypeManager.registerEngineType("NavigationServer2D", NavigationServer2D::class) { NavigationServer2D }
  TypeManager.registerSingleton("NavigationServer2DManager") { NavigationServer2DManager }
  TypeManager.registerEngineType("NavigationServer2DManager", NavigationServer2DManager::class) { NavigationServer2DManager }
  TypeManager.registerSingleton("NavigationServer3D") { NavigationServer3D }
  TypeManager.registerEngineType("NavigationServer3D", NavigationServer3D::class) { NavigationServer3D }
  TypeManager.registerSingleton("NavigationServer3DManager") { NavigationServer3DManager }
  TypeManager.registerEngineType("NavigationServer3DManager", NavigationServer3DManager::class) { NavigationServer3DManager }
  TypeManager.registerEngineType("NinePatchRect", NinePatchRect::class, ::NinePatchRect)
  TypeManager.registerEngineType("Node", Node::class, ::Node)
  TypeManager.registerEngineType("Node2D", Node2D::class, ::Node2D)
  TypeManager.registerEngineType("Node3D", Node3D::class, ::Node3D)
  TypeManager.registerEngineType("Node3DGizmo", Node3DGizmo::class, ::Node3DGizmo)
  TypeManager.registerEngineType("Noise", Noise::class, ::Noise)
  TypeManager.registerEngineType("NoiseTexture2D", NoiseTexture2D::class, ::NoiseTexture2D)
  TypeManager.registerEngineType("NoiseTexture3D", NoiseTexture3D::class, ::NoiseTexture3D)
  TypeManager.registerEngineType("ORMMaterial3D", ORMMaterial3D::class, ::ORMMaterial3D)
  TypeManager.registerSingleton("OS") { OS }
  TypeManager.registerEngineType("OS", OS::class) { OS }
  TypeManager.registerEngineType("Object", Object::class, ::Object)
  TypeManager.registerEngineType("Occluder3D", Occluder3D::class, ::Occluder3D)
  TypeManager.registerEngineType("OccluderInstance3D", OccluderInstance3D::class, ::OccluderInstance3D)
  TypeManager.registerEngineType("OccluderPolygon2D", OccluderPolygon2D::class, ::OccluderPolygon2D)
  TypeManager.registerEngineType("OfflineMultiplayerPeer", OfflineMultiplayerPeer::class, ::OfflineMultiplayerPeer)
  TypeManager.registerEngineType("OggPacketSequence", OggPacketSequence::class, ::OggPacketSequence)
  TypeManager.registerEngineType("OggPacketSequencePlayback", OggPacketSequencePlayback::class, ::OggPacketSequencePlayback)
  TypeManager.registerEngineType("OmniLight3D", OmniLight3D::class, ::OmniLight3D)
  TypeManager.registerEngineType("OpenXRAPIExtension", OpenXRAPIExtension::class, ::OpenXRAPIExtension)
  TypeManager.registerEngineType("OpenXRAction", OpenXRAction::class, ::OpenXRAction)
  TypeManager.registerEngineType("OpenXRActionBindingModifier", OpenXRActionBindingModifier::class, ::OpenXRActionBindingModifier)
  TypeManager.registerEngineType("OpenXRActionMap", OpenXRActionMap::class, ::OpenXRActionMap)
  TypeManager.registerEngineType("OpenXRActionSet", OpenXRActionSet::class, ::OpenXRActionSet)
  TypeManager.registerEngineType("OpenXRAnalogThresholdModifier", OpenXRAnalogThresholdModifier::class, ::OpenXRAnalogThresholdModifier)
  TypeManager.registerEngineType("OpenXRAnchorTracker", OpenXRAnchorTracker::class, ::OpenXRAnchorTracker)
  TypeManager.registerEngineType("OpenXRAndroidThreadSettingsExtension", OpenXRAndroidThreadSettingsExtension::class, ::OpenXRAndroidThreadSettingsExtension)
  TypeManager.registerEngineType("OpenXRBindingModifier", OpenXRBindingModifier::class, ::OpenXRBindingModifierDummy)
  TypeManager.registerEngineType("OpenXRCompositionLayer", OpenXRCompositionLayer::class, ::OpenXRCompositionLayer)
  TypeManager.registerEngineType("OpenXRCompositionLayerCylinder", OpenXRCompositionLayerCylinder::class, ::OpenXRCompositionLayerCylinder)
  TypeManager.registerEngineType("OpenXRCompositionLayerEquirect", OpenXRCompositionLayerEquirect::class, ::OpenXRCompositionLayerEquirect)
  TypeManager.registerEngineType("OpenXRCompositionLayerQuad", OpenXRCompositionLayerQuad::class, ::OpenXRCompositionLayerQuad)
  TypeManager.registerEngineType("OpenXRDpadBindingModifier", OpenXRDpadBindingModifier::class, ::OpenXRDpadBindingModifier)
  TypeManager.registerEngineType("OpenXRExtensionWrapper", OpenXRExtensionWrapper::class, ::OpenXRExtensionWrapper)
  TypeManager.registerEngineType("OpenXRExtensionWrapperExtension", OpenXRExtensionWrapperExtension::class, ::OpenXRExtensionWrapperExtension)
  TypeManager.registerEngineType("OpenXRFrameSynthesisExtension", OpenXRFrameSynthesisExtension::class, ::OpenXRFrameSynthesisExtension)
  TypeManager.registerEngineType("OpenXRFutureExtension", OpenXRFutureExtension::class, ::OpenXRFutureExtension)
  TypeManager.registerEngineType("OpenXRFutureResult", OpenXRFutureResult::class, ::OpenXRFutureResult)
  TypeManager.registerEngineType("OpenXRHand", OpenXRHand::class, ::OpenXRHand)
  TypeManager.registerEngineType("OpenXRHapticBase", OpenXRHapticBase::class, ::OpenXRHapticBase)
  TypeManager.registerEngineType("OpenXRHapticVibration", OpenXRHapticVibration::class, ::OpenXRHapticVibration)
  TypeManager.registerEngineType("OpenXRIPBinding", OpenXRIPBinding::class, ::OpenXRIPBinding)
  TypeManager.registerEngineType("OpenXRIPBindingModifier", OpenXRIPBindingModifier::class, ::OpenXRIPBindingModifier)
  TypeManager.registerEngineType("OpenXRInteractionProfile", OpenXRInteractionProfile::class, ::OpenXRInteractionProfile)
  TypeManager.registerEngineType("OpenXRInteractionProfileMetadata", OpenXRInteractionProfileMetadata::class, ::OpenXRInteractionProfileMetadata)
  TypeManager.registerEngineType("OpenXRInterface", OpenXRInterface::class, ::OpenXRInterface)
  TypeManager.registerEngineType("OpenXRMarkerTracker", OpenXRMarkerTracker::class, ::OpenXRMarkerTracker)
  TypeManager.registerEngineType("OpenXRPlaneTracker", OpenXRPlaneTracker::class, ::OpenXRPlaneTracker)
  TypeManager.registerEngineType("OpenXRRenderModel", OpenXRRenderModel::class, ::OpenXRRenderModel)
  TypeManager.registerEngineType("OpenXRRenderModelExtension", OpenXRRenderModelExtension::class, ::OpenXRRenderModelExtension)
  TypeManager.registerEngineType("OpenXRRenderModelManager", OpenXRRenderModelManager::class, ::OpenXRRenderModelManager)
  TypeManager.registerEngineType("OpenXRSpatialAnchorCapability", OpenXRSpatialAnchorCapability::class, ::OpenXRSpatialAnchorCapability)
  TypeManager.registerEngineType("OpenXRSpatialCapabilityConfigurationAnchor", OpenXRSpatialCapabilityConfigurationAnchor::class, ::OpenXRSpatialCapabilityConfigurationAnchor)
  TypeManager.registerEngineType("OpenXRSpatialCapabilityConfigurationAprilTag", OpenXRSpatialCapabilityConfigurationAprilTag::class, ::OpenXRSpatialCapabilityConfigurationAprilTag)
  TypeManager.registerEngineType("OpenXRSpatialCapabilityConfigurationAruco", OpenXRSpatialCapabilityConfigurationAruco::class, ::OpenXRSpatialCapabilityConfigurationAruco)
  TypeManager.registerEngineType("OpenXRSpatialCapabilityConfigurationBaseHeader", OpenXRSpatialCapabilityConfigurationBaseHeader::class, ::OpenXRSpatialCapabilityConfigurationBaseHeader)
  TypeManager.registerEngineType("OpenXRSpatialCapabilityConfigurationMicroQrCode", OpenXRSpatialCapabilityConfigurationMicroQrCode::class, ::OpenXRSpatialCapabilityConfigurationMicroQrCode)
  TypeManager.registerEngineType("OpenXRSpatialCapabilityConfigurationPlaneTracking", OpenXRSpatialCapabilityConfigurationPlaneTracking::class, ::OpenXRSpatialCapabilityConfigurationPlaneTracking)
  TypeManager.registerEngineType("OpenXRSpatialCapabilityConfigurationQrCode", OpenXRSpatialCapabilityConfigurationQrCode::class, ::OpenXRSpatialCapabilityConfigurationQrCode)
  TypeManager.registerEngineType("OpenXRSpatialComponentAnchorList", OpenXRSpatialComponentAnchorList::class, ::OpenXRSpatialComponentAnchorList)
  TypeManager.registerEngineType("OpenXRSpatialComponentBounded2DList", OpenXRSpatialComponentBounded2DList::class, ::OpenXRSpatialComponentBounded2DList)
  TypeManager.registerEngineType("OpenXRSpatialComponentBounded3DList", OpenXRSpatialComponentBounded3DList::class, ::OpenXRSpatialComponentBounded3DList)
  TypeManager.registerEngineType("OpenXRSpatialComponentData", OpenXRSpatialComponentData::class, ::OpenXRSpatialComponentData)
  TypeManager.registerEngineType("OpenXRSpatialComponentMarkerList", OpenXRSpatialComponentMarkerList::class, ::OpenXRSpatialComponentMarkerList)
  TypeManager.registerEngineType("OpenXRSpatialComponentMesh2DList", OpenXRSpatialComponentMesh2DList::class, ::OpenXRSpatialComponentMesh2DList)
  TypeManager.registerEngineType("OpenXRSpatialComponentMesh3DList", OpenXRSpatialComponentMesh3DList::class, ::OpenXRSpatialComponentMesh3DList)
  TypeManager.registerEngineType("OpenXRSpatialComponentParentList", OpenXRSpatialComponentParentList::class, ::OpenXRSpatialComponentParentList)
  TypeManager.registerEngineType("OpenXRSpatialComponentPersistenceList", OpenXRSpatialComponentPersistenceList::class, ::OpenXRSpatialComponentPersistenceList)
  TypeManager.registerEngineType("OpenXRSpatialComponentPlaneAlignmentList", OpenXRSpatialComponentPlaneAlignmentList::class, ::OpenXRSpatialComponentPlaneAlignmentList)
  TypeManager.registerEngineType("OpenXRSpatialComponentPlaneSemanticLabelList", OpenXRSpatialComponentPlaneSemanticLabelList::class, ::OpenXRSpatialComponentPlaneSemanticLabelList)
  TypeManager.registerEngineType("OpenXRSpatialComponentPolygon2DList", OpenXRSpatialComponentPolygon2DList::class, ::OpenXRSpatialComponentPolygon2DList)
  TypeManager.registerEngineType("OpenXRSpatialContextPersistenceConfig", OpenXRSpatialContextPersistenceConfig::class, ::OpenXRSpatialContextPersistenceConfig)
  TypeManager.registerEngineType("OpenXRSpatialEntityExtension", OpenXRSpatialEntityExtension::class, ::OpenXRSpatialEntityExtension)
  TypeManager.registerEngineType("OpenXRSpatialEntityTracker", OpenXRSpatialEntityTracker::class, ::OpenXRSpatialEntityTracker)
  TypeManager.registerEngineType("OpenXRSpatialMarkerTrackingCapability", OpenXRSpatialMarkerTrackingCapability::class, ::OpenXRSpatialMarkerTrackingCapability)
  TypeManager.registerEngineType("OpenXRSpatialPlaneTrackingCapability", OpenXRSpatialPlaneTrackingCapability::class, ::OpenXRSpatialPlaneTrackingCapability)
  TypeManager.registerEngineType("OpenXRSpatialQueryResultData", OpenXRSpatialQueryResultData::class, ::OpenXRSpatialQueryResultData)
  TypeManager.registerEngineType("OpenXRStructureBase", OpenXRStructureBase::class, ::OpenXRStructureBase)
  TypeManager.registerEngineType("OpenXRVisibilityMask", OpenXRVisibilityMask::class, ::OpenXRVisibilityMask)
  TypeManager.registerEngineType("OptimizedTranslation", OptimizedTranslation::class, ::OptimizedTranslation)
  TypeManager.registerEngineType("OptionButton", OptionButton::class, ::OptionButton)
  TypeManager.registerEngineType("PCKPacker", PCKPacker::class, ::PCKPacker)
  TypeManager.registerEngineType("PackedDataContainer", PackedDataContainer::class, ::PackedDataContainer)
  TypeManager.registerEngineType("PackedDataContainerRef", PackedDataContainerRef::class, ::PackedDataContainerRef)
  TypeManager.registerEngineType("PackedScene", PackedScene::class, ::PackedScene)
  TypeManager.registerEngineType("PacketPeer", PacketPeer::class, ::PacketPeer)
  TypeManager.registerEngineType("PacketPeerDTLS", PacketPeerDTLS::class, ::PacketPeerDTLS)
  TypeManager.registerEngineType("PacketPeerExtension", PacketPeerExtension::class, ::PacketPeerExtensionDummy)
  TypeManager.registerEngineType("PacketPeerStream", PacketPeerStream::class, ::PacketPeerStream)
  TypeManager.registerEngineType("PacketPeerUDP", PacketPeerUDP::class, ::PacketPeerUDP)
  TypeManager.registerEngineType("Panel", Panel::class, ::Panel)
  TypeManager.registerEngineType("PanelContainer", PanelContainer::class, ::PanelContainer)
  TypeManager.registerEngineType("PanoramaSkyMaterial", PanoramaSkyMaterial::class, ::PanoramaSkyMaterial)
  TypeManager.registerEngineType("Parallax2D", Parallax2D::class, ::Parallax2D)
  TypeManager.registerEngineType("ParallaxBackground", ParallaxBackground::class, ::ParallaxBackground)
  TypeManager.registerEngineType("ParallaxLayer", ParallaxLayer::class, ::ParallaxLayer)
  TypeManager.registerEngineType("ParticleProcessMaterial", ParticleProcessMaterial::class, ::ParticleProcessMaterial)
  TypeManager.registerEngineType("Path2D", Path2D::class, ::Path2D)
  TypeManager.registerEngineType("Path3D", Path3D::class, ::Path3D)
  TypeManager.registerEngineType("PathFollow2D", PathFollow2D::class, ::PathFollow2D)
  TypeManager.registerEngineType("PathFollow3D", PathFollow3D::class, ::PathFollow3D)
  TypeManager.registerSingleton("Performance") { Performance }
  TypeManager.registerEngineType("Performance", Performance::class) { Performance }
  TypeManager.registerEngineType("PhysicalBone2D", PhysicalBone2D::class, ::PhysicalBone2D)
  TypeManager.registerEngineType("PhysicalBone3D", PhysicalBone3D::class, ::PhysicalBone3D)
  TypeManager.registerEngineType("PhysicalBoneSimulator3D", PhysicalBoneSimulator3D::class, ::PhysicalBoneSimulator3D)
  TypeManager.registerEngineType("PhysicalSkyMaterial", PhysicalSkyMaterial::class, ::PhysicalSkyMaterial)
  TypeManager.registerEngineType("PhysicsBody2D", PhysicsBody2D::class, ::PhysicsBody2D)
  TypeManager.registerEngineType("PhysicsBody3D", PhysicsBody3D::class, ::PhysicsBody3D)
  TypeManager.registerEngineType("PhysicsDirectBodyState2D", PhysicsDirectBodyState2D::class, ::PhysicsDirectBodyState2D)
  TypeManager.registerEngineType("PhysicsDirectBodyState2DExtension", PhysicsDirectBodyState2DExtension::class, ::PhysicsDirectBodyState2DExtensionDummy)
  TypeManager.registerEngineType("PhysicsDirectBodyState3D", PhysicsDirectBodyState3D::class, ::PhysicsDirectBodyState3D)
  TypeManager.registerEngineType("PhysicsDirectBodyState3DExtension", PhysicsDirectBodyState3DExtension::class, ::PhysicsDirectBodyState3DExtensionDummy)
  TypeManager.registerEngineType("PhysicsDirectSpaceState2D", PhysicsDirectSpaceState2D::class, ::PhysicsDirectSpaceState2D)
  TypeManager.registerEngineType("PhysicsDirectSpaceState2DExtension", PhysicsDirectSpaceState2DExtension::class, ::PhysicsDirectSpaceState2DExtensionDummy)
  TypeManager.registerEngineType("PhysicsDirectSpaceState3D", PhysicsDirectSpaceState3D::class, ::PhysicsDirectSpaceState3D)
  TypeManager.registerEngineType("PhysicsDirectSpaceState3DExtension", PhysicsDirectSpaceState3DExtension::class, ::PhysicsDirectSpaceState3DExtensionDummy)
  TypeManager.registerEngineType("PhysicsMaterial", PhysicsMaterial::class, ::PhysicsMaterial)
  TypeManager.registerEngineType("PhysicsPointQueryParameters2D", PhysicsPointQueryParameters2D::class, ::PhysicsPointQueryParameters2D)
  TypeManager.registerEngineType("PhysicsPointQueryParameters3D", PhysicsPointQueryParameters3D::class, ::PhysicsPointQueryParameters3D)
  TypeManager.registerEngineType("PhysicsRayQueryParameters2D", PhysicsRayQueryParameters2D::class, ::PhysicsRayQueryParameters2D)
  TypeManager.registerEngineType("PhysicsRayQueryParameters3D", PhysicsRayQueryParameters3D::class, ::PhysicsRayQueryParameters3D)
  TypeManager.registerSingleton("PhysicsServer2D") { PhysicsServer2D }
  TypeManager.registerEngineType("PhysicsServer2D", PhysicsServer2D::class) { PhysicsServer2D }
  TypeManager.registerSingleton("PhysicsServer2DManager") { PhysicsServer2DManager }
  TypeManager.registerEngineType("PhysicsServer2DManager", PhysicsServer2DManager::class) { PhysicsServer2DManager }
  TypeManager.registerSingleton("PhysicsServer3D") { PhysicsServer3D }
  TypeManager.registerEngineType("PhysicsServer3D", PhysicsServer3D::class) { PhysicsServer3D }
  TypeManager.registerSingleton("PhysicsServer3DManager") { PhysicsServer3DManager }
  TypeManager.registerEngineType("PhysicsServer3DManager", PhysicsServer3DManager::class) { PhysicsServer3DManager }
  TypeManager.registerEngineType("PhysicsServer3DRenderingServerHandler", PhysicsServer3DRenderingServerHandler::class, ::PhysicsServer3DRenderingServerHandlerDummy)
  TypeManager.registerEngineType("PhysicsShapeQueryParameters2D", PhysicsShapeQueryParameters2D::class, ::PhysicsShapeQueryParameters2D)
  TypeManager.registerEngineType("PhysicsShapeQueryParameters3D", PhysicsShapeQueryParameters3D::class, ::PhysicsShapeQueryParameters3D)
  TypeManager.registerEngineType("PhysicsTestMotionParameters2D", PhysicsTestMotionParameters2D::class, ::PhysicsTestMotionParameters2D)
  TypeManager.registerEngineType("PhysicsTestMotionParameters3D", PhysicsTestMotionParameters3D::class, ::PhysicsTestMotionParameters3D)
  TypeManager.registerEngineType("PhysicsTestMotionResult2D", PhysicsTestMotionResult2D::class, ::PhysicsTestMotionResult2D)
  TypeManager.registerEngineType("PhysicsTestMotionResult3D", PhysicsTestMotionResult3D::class, ::PhysicsTestMotionResult3D)
  TypeManager.registerEngineType("PinJoint2D", PinJoint2D::class, ::PinJoint2D)
  TypeManager.registerEngineType("PinJoint3D", PinJoint3D::class, ::PinJoint3D)
  TypeManager.registerEngineType("PlaceholderCubemap", PlaceholderCubemap::class, ::PlaceholderCubemap)
  TypeManager.registerEngineType("PlaceholderCubemapArray", PlaceholderCubemapArray::class, ::PlaceholderCubemapArray)
  TypeManager.registerEngineType("PlaceholderMaterial", PlaceholderMaterial::class, ::PlaceholderMaterial)
  TypeManager.registerEngineType("PlaceholderMesh", PlaceholderMesh::class, ::PlaceholderMesh)
  TypeManager.registerEngineType("PlaceholderTexture2D", PlaceholderTexture2D::class, ::PlaceholderTexture2D)
  TypeManager.registerEngineType("PlaceholderTexture2DArray", PlaceholderTexture2DArray::class, ::PlaceholderTexture2DArray)
  TypeManager.registerEngineType("PlaceholderTexture3D", PlaceholderTexture3D::class, ::PlaceholderTexture3D)
  TypeManager.registerEngineType("PlaceholderTextureLayered", PlaceholderTextureLayered::class, ::PlaceholderTextureLayered)
  TypeManager.registerEngineType("PlaneMesh", PlaneMesh::class, ::PlaneMesh)
  TypeManager.registerEngineType("PointLight2D", PointLight2D::class, ::PointLight2D)
  TypeManager.registerEngineType("PointMesh", PointMesh::class, ::PointMesh)
  TypeManager.registerEngineType("Polygon2D", Polygon2D::class, ::Polygon2D)
  TypeManager.registerEngineType("PolygonOccluder3D", PolygonOccluder3D::class, ::PolygonOccluder3D)
  TypeManager.registerEngineType("PolygonPathFinder", PolygonPathFinder::class, ::PolygonPathFinder)
  TypeManager.registerEngineType("Popup", Popup::class, ::Popup)
  TypeManager.registerEngineType("PopupMenu", PopupMenu::class, ::PopupMenu)
  TypeManager.registerEngineType("PopupPanel", PopupPanel::class, ::PopupPanel)
  TypeManager.registerEngineType("PortableCompressedTexture2D", PortableCompressedTexture2D::class, ::PortableCompressedTexture2D)
  TypeManager.registerEngineType("PrimitiveMesh", PrimitiveMesh::class, ::PrimitiveMesh)
  TypeManager.registerEngineType("PrismMesh", PrismMesh::class, ::PrismMesh)
  TypeManager.registerEngineType("ProceduralSkyMaterial", ProceduralSkyMaterial::class, ::ProceduralSkyMaterial)
  TypeManager.registerEngineType("ProgressBar", ProgressBar::class, ::ProgressBar)
  TypeManager.registerSingleton("ProjectSettings") { ProjectSettings }
  TypeManager.registerEngineType("ProjectSettings", ProjectSettings::class) { ProjectSettings }
  TypeManager.registerEngineType("PropertyTweener", PropertyTweener::class, ::PropertyTweener)
  TypeManager.registerEngineType("QuadMesh", QuadMesh::class, ::QuadMesh)
  TypeManager.registerEngineType("QuadOccluder3D", QuadOccluder3D::class, ::QuadOccluder3D)
  TypeManager.registerEngineType("RDAccelerationStructureGeometry", RDAccelerationStructureGeometry::class, ::RDAccelerationStructureGeometry)
  TypeManager.registerEngineType("RDAccelerationStructureInstance", RDAccelerationStructureInstance::class, ::RDAccelerationStructureInstance)
  TypeManager.registerEngineType("RDAttachmentFormat", RDAttachmentFormat::class, ::RDAttachmentFormat)
  TypeManager.registerEngineType("RDFramebufferPass", RDFramebufferPass::class, ::RDFramebufferPass)
  TypeManager.registerEngineType("RDHitGroup", RDHitGroup::class, ::RDHitGroup)
  TypeManager.registerEngineType("RDPipelineColorBlendState", RDPipelineColorBlendState::class, ::RDPipelineColorBlendState)
  TypeManager.registerEngineType("RDPipelineColorBlendStateAttachment", RDPipelineColorBlendStateAttachment::class, ::RDPipelineColorBlendStateAttachment)
  TypeManager.registerEngineType("RDPipelineDepthStencilState", RDPipelineDepthStencilState::class, ::RDPipelineDepthStencilState)
  TypeManager.registerEngineType("RDPipelineMultisampleState", RDPipelineMultisampleState::class, ::RDPipelineMultisampleState)
  TypeManager.registerEngineType("RDPipelineRasterizationState", RDPipelineRasterizationState::class, ::RDPipelineRasterizationState)
  TypeManager.registerEngineType("RDPipelineShader", RDPipelineShader::class, ::RDPipelineShader)
  TypeManager.registerEngineType("RDPipelineSpecializationConstant", RDPipelineSpecializationConstant::class, ::RDPipelineSpecializationConstant)
  TypeManager.registerEngineType("RDSamplerState", RDSamplerState::class, ::RDSamplerState)
  TypeManager.registerEngineType("RDShaderFile", RDShaderFile::class, ::RDShaderFile)
  TypeManager.registerEngineType("RDShaderSPIRV", RDShaderSPIRV::class, ::RDShaderSPIRV)
  TypeManager.registerEngineType("RDShaderSource", RDShaderSource::class, ::RDShaderSource)
  TypeManager.registerEngineType("RDTextureFormat", RDTextureFormat::class, ::RDTextureFormat)
  TypeManager.registerEngineType("RDTextureView", RDTextureView::class, ::RDTextureView)
  TypeManager.registerEngineType("RDUniform", RDUniform::class, ::RDUniform)
  TypeManager.registerEngineType("RDVertexAttribute", RDVertexAttribute::class, ::RDVertexAttribute)
  TypeManager.registerEngineType("RandomNumberGenerator", RandomNumberGenerator::class, ::RandomNumberGenerator)
  TypeManager.registerEngineType("Range", Range::class, ::Range)
  TypeManager.registerEngineType("RayCast2D", RayCast2D::class, ::RayCast2D)
  TypeManager.registerEngineType("RayCast3D", RayCast3D::class, ::RayCast3D)
  TypeManager.registerEngineType("RectangleShape2D", RectangleShape2D::class, ::RectangleShape2D)
  TypeManager.registerEngineType("RefCounted", RefCounted::class, ::RefCounted)
  TypeManager.registerEngineType("ReferenceRect", ReferenceRect::class, ::ReferenceRect)
  TypeManager.registerEngineType("ReflectionProbe", ReflectionProbe::class, ::ReflectionProbe)
  TypeManager.registerEngineType("RegEx", RegEx::class, ::RegEx)
  TypeManager.registerEngineType("RegExMatch", RegExMatch::class, ::RegExMatch)
  TypeManager.registerEngineType("RemoteTransform2D", RemoteTransform2D::class, ::RemoteTransform2D)
  TypeManager.registerEngineType("RemoteTransform3D", RemoteTransform3D::class, ::RemoteTransform3D)
  TypeManager.registerEngineType("RenderData", RenderData::class, ::RenderData)
  TypeManager.registerEngineType("RenderDataExtension", RenderDataExtension::class, ::RenderDataExtension)
  TypeManager.registerEngineType("RenderDataRD", RenderDataRD::class, ::RenderDataRD)
  TypeManager.registerEngineType("RenderSceneBuffers", RenderSceneBuffers::class, ::RenderSceneBuffers)
  TypeManager.registerEngineType("RenderSceneBuffersConfiguration", RenderSceneBuffersConfiguration::class, ::RenderSceneBuffersConfiguration)
  TypeManager.registerEngineType("RenderSceneBuffersExtension", RenderSceneBuffersExtension::class, ::RenderSceneBuffersExtension)
  TypeManager.registerEngineType("RenderSceneBuffersRD", RenderSceneBuffersRD::class, ::RenderSceneBuffersRD)
  TypeManager.registerEngineType("RenderSceneData", RenderSceneData::class, ::RenderSceneData)
  TypeManager.registerEngineType("RenderSceneDataExtension", RenderSceneDataExtension::class, ::RenderSceneDataExtension)
  TypeManager.registerEngineType("RenderSceneDataRD", RenderSceneDataRD::class, ::RenderSceneDataRD)
  TypeManager.registerEngineType("RenderingDevice", RenderingDevice::class, ::RenderingDevice)
  TypeManager.registerSingleton("RenderingServer") { RenderingServer }
  TypeManager.registerEngineType("RenderingServer", RenderingServer::class) { RenderingServer }
  TypeManager.registerEngineType("Resource", Resource::class, ::Resource)
  TypeManager.registerEngineType("ResourceFormatLoader", ResourceFormatLoader::class, ::ResourceFormatLoaderDummy)
  TypeManager.registerEngineType("ResourceFormatSaver", ResourceFormatSaver::class, ::ResourceFormatSaver)
  TypeManager.registerEngineType("ResourceImporter", ResourceImporter::class, ::ResourceImporter)
  TypeManager.registerSingleton("ResourceLoader") { ResourceLoader }
  TypeManager.registerEngineType("ResourceLoader", ResourceLoader::class) { ResourceLoader }
  TypeManager.registerEngineType("ResourcePreloader", ResourcePreloader::class, ::ResourcePreloader)
  TypeManager.registerSingleton("ResourceSaver") { ResourceSaver }
  TypeManager.registerEngineType("ResourceSaver", ResourceSaver::class) { ResourceSaver }
  TypeManager.registerSingleton("ResourceUID") { ResourceUID }
  TypeManager.registerEngineType("ResourceUID", ResourceUID::class) { ResourceUID }
  TypeManager.registerEngineType("RetargetModifier3D", RetargetModifier3D::class, ::RetargetModifier3D)
  TypeManager.registerEngineType("RibbonTrailMesh", RibbonTrailMesh::class, ::RibbonTrailMesh)
  TypeManager.registerEngineType("RichTextEffect", RichTextEffect::class, ::RichTextEffect)
  TypeManager.registerEngineType("RichTextLabel", RichTextLabel::class, ::RichTextLabel)
  TypeManager.registerEngineType("RigidBody2D", RigidBody2D::class, ::RigidBody2D)
  TypeManager.registerEngineType("RigidBody3D", RigidBody3D::class, ::RigidBody3D)
  TypeManager.registerEngineType("RootMotionView", RootMotionView::class, ::RootMotionView)
  TypeManager.registerEngineType("ScalaScript", ScalaScript::class, ::ScalaScript)
  TypeManager.registerEngineType("SceneMultiplayer", SceneMultiplayer::class, ::SceneMultiplayer)
  TypeManager.registerEngineType("SceneReplicationConfig", SceneReplicationConfig::class, ::SceneReplicationConfig)
  TypeManager.registerEngineType("SceneState", SceneState::class, ::SceneState)
  TypeManager.registerEngineType("SceneTree", SceneTree::class, ::SceneTree)
  TypeManager.registerEngineType("SceneTreeTimer", SceneTreeTimer::class, ::SceneTreeTimer)
  TypeManager.registerEngineType("Script", Script::class, ::Script)
  TypeManager.registerEngineType("ScriptBacktrace", ScriptBacktrace::class, ::ScriptBacktrace)
  TypeManager.registerEngineType("ScriptExtension", ScriptExtension::class, ::ScriptExtensionDummy)
  TypeManager.registerEngineType("ScriptLanguage", ScriptLanguage::class, ::ScriptLanguage)
  TypeManager.registerEngineType("ScriptLanguageExtension", ScriptLanguageExtension::class, ::ScriptLanguageExtensionDummy)
  TypeManager.registerEngineType("ScrollBar", ScrollBar::class, ::ScrollBar)
  TypeManager.registerEngineType("ScrollContainer", ScrollContainer::class, ::ScrollContainer)
  TypeManager.registerEngineType("SegmentShape2D", SegmentShape2D::class, ::SegmentShape2D)
  TypeManager.registerEngineType("Semaphore", Semaphore::class, ::Semaphore)
  TypeManager.registerEngineType("SeparationRayShape2D", SeparationRayShape2D::class, ::SeparationRayShape2D)
  TypeManager.registerEngineType("SeparationRayShape3D", SeparationRayShape3D::class, ::SeparationRayShape3D)
  TypeManager.registerEngineType("Separator", Separator::class, ::Separator)
  TypeManager.registerEngineType("Shader", Shader::class, ::Shader)
  TypeManager.registerEngineType("ShaderGlobalsOverride", ShaderGlobalsOverride::class, ::ShaderGlobalsOverride)
  TypeManager.registerEngineType("ShaderInclude", ShaderInclude::class, ::ShaderInclude)
  TypeManager.registerEngineType("ShaderIncludeDB", ShaderIncludeDB::class, ::ShaderIncludeDB)
  TypeManager.registerEngineType("ShaderMaterial", ShaderMaterial::class, ::ShaderMaterial)
  TypeManager.registerEngineType("Shape2D", Shape2D::class, ::Shape2D)
  TypeManager.registerEngineType("Shape3D", Shape3D::class, ::Shape3D)
  TypeManager.registerEngineType("ShapeCast2D", ShapeCast2D::class, ::ShapeCast2D)
  TypeManager.registerEngineType("ShapeCast3D", ShapeCast3D::class, ::ShapeCast3D)
  TypeManager.registerEngineType("Shortcut", Shortcut::class, ::Shortcut)
  TypeManager.registerEngineType("Skeleton2D", Skeleton2D::class, ::Skeleton2D)
  TypeManager.registerEngineType("Skeleton3D", Skeleton3D::class, ::Skeleton3D)
  TypeManager.registerEngineType("SkeletonIK3D", SkeletonIK3D::class, ::SkeletonIK3D)
  TypeManager.registerEngineType("SkeletonModification2D", SkeletonModification2D::class, ::SkeletonModification2D)
  TypeManager.registerEngineType("SkeletonModification2DCCDIK", SkeletonModification2DCCDIK::class, ::SkeletonModification2DCCDIK)
  TypeManager.registerEngineType("SkeletonModification2DFABRIK", SkeletonModification2DFABRIK::class, ::SkeletonModification2DFABRIK)
  TypeManager.registerEngineType("SkeletonModification2DJiggle", SkeletonModification2DJiggle::class, ::SkeletonModification2DJiggle)
  TypeManager.registerEngineType("SkeletonModification2DLookAt", SkeletonModification2DLookAt::class, ::SkeletonModification2DLookAt)
  TypeManager.registerEngineType("SkeletonModification2DPhysicalBones", SkeletonModification2DPhysicalBones::class, ::SkeletonModification2DPhysicalBones)
  TypeManager.registerEngineType("SkeletonModification2DStackHolder", SkeletonModification2DStackHolder::class, ::SkeletonModification2DStackHolder)
  TypeManager.registerEngineType("SkeletonModification2DTwoBoneIK", SkeletonModification2DTwoBoneIK::class, ::SkeletonModification2DTwoBoneIK)
  TypeManager.registerEngineType("SkeletonModificationStack2D", SkeletonModificationStack2D::class, ::SkeletonModificationStack2D)
  TypeManager.registerEngineType("SkeletonModifier3D", SkeletonModifier3D::class, ::SkeletonModifier3D)
  TypeManager.registerEngineType("SkeletonProfile", SkeletonProfile::class, ::SkeletonProfile)
  TypeManager.registerEngineType("SkeletonProfileHumanoid", SkeletonProfileHumanoid::class, ::SkeletonProfileHumanoid)
  TypeManager.registerEngineType("Skin", Skin::class, ::Skin)
  TypeManager.registerEngineType("SkinReference", SkinReference::class, ::SkinReference)
  TypeManager.registerEngineType("Sky", Sky::class, ::Sky)
  TypeManager.registerEngineType("Slider", Slider::class, ::Slider)
  TypeManager.registerEngineType("SliderJoint3D", SliderJoint3D::class, ::SliderJoint3D)
  TypeManager.registerEngineType("SocketServer", SocketServer::class, ::SocketServer)
  TypeManager.registerEngineType("SoftBody3D", SoftBody3D::class, ::SoftBody3D)
  TypeManager.registerEngineType("SphereMesh", SphereMesh::class, ::SphereMesh)
  TypeManager.registerEngineType("SphereOccluder3D", SphereOccluder3D::class, ::SphereOccluder3D)
  TypeManager.registerEngineType("SphereShape3D", SphereShape3D::class, ::SphereShape3D)
  TypeManager.registerEngineType("SpinBox", SpinBox::class, ::SpinBox)
  TypeManager.registerEngineType("SplineIK3D", SplineIK3D::class, ::SplineIK3D)
  TypeManager.registerEngineType("SplitContainer", SplitContainer::class, ::SplitContainer)
  TypeManager.registerEngineType("SpotLight3D", SpotLight3D::class, ::SpotLight3D)
  TypeManager.registerEngineType("SpringArm3D", SpringArm3D::class, ::SpringArm3D)
  TypeManager.registerEngineType("SpringBoneCollision3D", SpringBoneCollision3D::class, ::SpringBoneCollision3D)
  TypeManager.registerEngineType("SpringBoneCollisionCapsule3D", SpringBoneCollisionCapsule3D::class, ::SpringBoneCollisionCapsule3D)
  TypeManager.registerEngineType("SpringBoneCollisionPlane3D", SpringBoneCollisionPlane3D::class, ::SpringBoneCollisionPlane3D)
  TypeManager.registerEngineType("SpringBoneCollisionSphere3D", SpringBoneCollisionSphere3D::class, ::SpringBoneCollisionSphere3D)
  TypeManager.registerEngineType("SpringBoneSimulator3D", SpringBoneSimulator3D::class, ::SpringBoneSimulator3D)
  TypeManager.registerEngineType("Sprite2D", Sprite2D::class, ::Sprite2D)
  TypeManager.registerEngineType("Sprite3D", Sprite3D::class, ::Sprite3D)
  TypeManager.registerEngineType("SpriteBase3D", SpriteBase3D::class, ::SpriteBase3D)
  TypeManager.registerEngineType("SpriteFrames", SpriteFrames::class, ::SpriteFrames)
  TypeManager.registerEngineType("StandardMaterial3D", StandardMaterial3D::class, ::StandardMaterial3D)
  TypeManager.registerEngineType("StaticBody2D", StaticBody2D::class, ::StaticBody2D)
  TypeManager.registerEngineType("StaticBody3D", StaticBody3D::class, ::StaticBody3D)
  TypeManager.registerEngineType("StatusIndicator", StatusIndicator::class, ::StatusIndicator)
  TypeManager.registerEngineType("StreamPeer", StreamPeer::class, ::StreamPeer)
  TypeManager.registerEngineType("StreamPeerBuffer", StreamPeerBuffer::class, ::StreamPeerBuffer)
  TypeManager.registerEngineType("StreamPeerExtension", StreamPeerExtension::class, ::StreamPeerExtensionDummy)
  TypeManager.registerEngineType("StreamPeerGZIP", StreamPeerGZIP::class, ::StreamPeerGZIP)
  TypeManager.registerEngineType("StreamPeerSocket", StreamPeerSocket::class, ::StreamPeerSocket)
  TypeManager.registerEngineType("StreamPeerTCP", StreamPeerTCP::class, ::StreamPeerTCP)
  TypeManager.registerEngineType("StreamPeerTLS", StreamPeerTLS::class, ::StreamPeerTLS)
  TypeManager.registerEngineType("StreamPeerUDS", StreamPeerUDS::class, ::StreamPeerUDS)
  TypeManager.registerEngineType("StyleBox", StyleBox::class, ::StyleBoxDummy)
  TypeManager.registerEngineType("StyleBoxEmpty", StyleBoxEmpty::class, ::StyleBoxEmpty)
  TypeManager.registerEngineType("StyleBoxFlat", StyleBoxFlat::class, ::StyleBoxFlat)
  TypeManager.registerEngineType("StyleBoxLine", StyleBoxLine::class, ::StyleBoxLine)
  TypeManager.registerEngineType("StyleBoxTexture", StyleBoxTexture::class, ::StyleBoxTexture)
  TypeManager.registerEngineType("SubViewport", SubViewport::class, ::SubViewport)
  TypeManager.registerEngineType("SubViewportContainer", SubViewportContainer::class, ::SubViewportContainer)
  TypeManager.registerEngineType("SubtweenTweener", SubtweenTweener::class, ::SubtweenTweener)
  TypeManager.registerEngineType("SurfaceTool", SurfaceTool::class, ::SurfaceTool)
  TypeManager.registerEngineType("SyntaxHighlighter", SyntaxHighlighter::class, ::SyntaxHighlighter)
  TypeManager.registerEngineType("SystemFont", SystemFont::class, ::SystemFont)
  TypeManager.registerEngineType("TCPServer", TCPServer::class, ::TCPServer)
  TypeManager.registerEngineType("TLSOptions", TLSOptions::class, ::TLSOptions)
  TypeManager.registerEngineType("TabBar", TabBar::class, ::TabBar)
  TypeManager.registerEngineType("TabContainer", TabContainer::class, ::TabContainer)
  TypeManager.registerEngineType("TextEdit", TextEdit::class, ::TextEdit)
  TypeManager.registerEngineType("TextLine", TextLine::class, ::TextLine)
  TypeManager.registerEngineType("TextMesh", TextMesh::class, ::TextMesh)
  TypeManager.registerEngineType("TextParagraph", TextParagraph::class, ::TextParagraph)
  TypeManager.registerEngineType("TextServer", TextServer::class, ::TextServer)
  TypeManager.registerEngineType("TextServerAdvanced", TextServerAdvanced::class, ::TextServerAdvanced)
  TypeManager.registerEngineType("TextServerDummy", TextServerDummy::class, ::TextServerDummy)
  TypeManager.registerEngineType("TextServerExtension", TextServerExtension::class, ::TextServerExtensionDummy)
  TypeManager.registerSingleton("TextServerManager") { TextServerManager }
  TypeManager.registerEngineType("TextServerManager", TextServerManager::class) { TextServerManager }
  TypeManager.registerEngineType("Texture", Texture::class, ::Texture)
  TypeManager.registerEngineType("Texture2D", Texture2D::class, ::Texture2DDummy)
  TypeManager.registerEngineType("Texture2DArray", Texture2DArray::class, ::Texture2DArray)
  TypeManager.registerEngineType("Texture2DArrayRD", Texture2DArrayRD::class, ::Texture2DArrayRD)
  TypeManager.registerEngineType("Texture2DRD", Texture2DRD::class, ::Texture2DRD)
  TypeManager.registerEngineType("Texture3D", Texture3D::class, ::Texture3DDummy)
  TypeManager.registerEngineType("Texture3DRD", Texture3DRD::class, ::Texture3DRD)
  TypeManager.registerEngineType("TextureButton", TextureButton::class, ::TextureButton)
  TypeManager.registerEngineType("TextureCubemapArrayRD", TextureCubemapArrayRD::class, ::TextureCubemapArrayRD)
  TypeManager.registerEngineType("TextureCubemapRD", TextureCubemapRD::class, ::TextureCubemapRD)
  TypeManager.registerEngineType("TextureLayered", TextureLayered::class, ::TextureLayeredDummy)
  TypeManager.registerEngineType("TextureLayeredRD", TextureLayeredRD::class, ::TextureLayeredRD)
  TypeManager.registerEngineType("TextureProgressBar", TextureProgressBar::class, ::TextureProgressBar)
  TypeManager.registerEngineType("TextureRect", TextureRect::class, ::TextureRect)
  TypeManager.registerEngineType("Theme", Theme::class, ::Theme)
  TypeManager.registerSingleton("ThemeDB") { ThemeDB }
  TypeManager.registerEngineType("ThemeDB", ThemeDB::class) { ThemeDB }
  TypeManager.registerEngineType("Thread", Thread::class, ::Thread)
  TypeManager.registerEngineType("TileData", TileData::class, ::TileData)
  TypeManager.registerEngineType("TileMap", TileMap::class, ::TileMap)
  TypeManager.registerEngineType("TileMapLayer", TileMapLayer::class, ::TileMapLayer)
  TypeManager.registerEngineType("TileMapPattern", TileMapPattern::class, ::TileMapPattern)
  TypeManager.registerEngineType("TileSet", TileSet::class, ::TileSet)
  TypeManager.registerEngineType("TileSetAtlasSource", TileSetAtlasSource::class, ::TileSetAtlasSource)
  TypeManager.registerEngineType("TileSetScenesCollectionSource", TileSetScenesCollectionSource::class, ::TileSetScenesCollectionSource)
  TypeManager.registerEngineType("TileSetSource", TileSetSource::class, ::TileSetSource)
  TypeManager.registerSingleton("Time") { Time }
  TypeManager.registerEngineType("Time", Time::class) { Time }
  TypeManager.registerEngineType("Timer", Timer::class, ::Timer)
  TypeManager.registerEngineType("TorusMesh", TorusMesh::class, ::TorusMesh)
  TypeManager.registerEngineType("TouchScreenButton", TouchScreenButton::class, ::TouchScreenButton)
  TypeManager.registerEngineType("Translation", Translation::class, ::Translation)
  TypeManager.registerEngineType("TranslationDomain", TranslationDomain::class, ::TranslationDomain)
  TypeManager.registerSingleton("TranslationServer") { TranslationServer }
  TypeManager.registerEngineType("TranslationServer", TranslationServer::class) { TranslationServer }
  TypeManager.registerEngineType("Tree", Tree::class, ::Tree)
  TypeManager.registerEngineType("TreeItem", TreeItem::class, ::TreeItem)
  TypeManager.registerEngineType("TriangleMesh", TriangleMesh::class, ::TriangleMesh)
  TypeManager.registerEngineType("TubeTrailMesh", TubeTrailMesh::class, ::TubeTrailMesh)
  TypeManager.registerEngineType("Tween", Tween::class, ::Tween)
  TypeManager.registerEngineType("Tweener", Tweener::class, ::Tweener)
  TypeManager.registerEngineType("TwoBoneIK3D", TwoBoneIK3D::class, ::TwoBoneIK3D)
  TypeManager.registerEngineType("UDPServer", UDPServer::class, ::UDPServer)
  TypeManager.registerEngineType("UDSServer", UDSServer::class, ::UDSServer)
  TypeManager.registerEngineType("UPNP", UPNP::class, ::UPNP)
  TypeManager.registerEngineType("UPNPDevice", UPNPDevice::class, ::UPNPDevice)
  TypeManager.registerEngineType("UndoRedo", UndoRedo::class, ::UndoRedo)
  TypeManager.registerEngineType("UniformSetCacheRD", UniformSetCacheRD::class, ::UniformSetCacheRD)
  TypeManager.registerEngineType("VBoxContainer", VBoxContainer::class, ::VBoxContainer)
  TypeManager.registerEngineType("VFlowContainer", VFlowContainer::class, ::VFlowContainer)
  TypeManager.registerEngineType("VScrollBar", VScrollBar::class, ::VScrollBar)
  TypeManager.registerEngineType("VSeparator", VSeparator::class, ::VSeparator)
  TypeManager.registerEngineType("VSlider", VSlider::class, ::VSlider)
  TypeManager.registerEngineType("VSplitContainer", VSplitContainer::class, ::VSplitContainer)
  TypeManager.registerEngineType("VehicleBody3D", VehicleBody3D::class, ::VehicleBody3D)
  TypeManager.registerEngineType("VehicleWheel3D", VehicleWheel3D::class, ::VehicleWheel3D)
  TypeManager.registerEngineType("VideoStream", VideoStream::class, ::VideoStreamDummy)
  TypeManager.registerEngineType("VideoStreamPlayback", VideoStreamPlayback::class, ::VideoStreamPlaybackDummy)
  TypeManager.registerEngineType("VideoStreamPlayer", VideoStreamPlayer::class, ::VideoStreamPlayer)
  TypeManager.registerEngineType("VideoStreamTheora", VideoStreamTheora::class, ::VideoStreamTheora)
  TypeManager.registerEngineType("Viewport", Viewport::class, ::Viewport)
  TypeManager.registerEngineType("ViewportTexture", ViewportTexture::class, ::ViewportTexture)
  TypeManager.registerEngineType("VirtualJoystick", VirtualJoystick::class, ::VirtualJoystick)
  TypeManager.registerEngineType("VisibleOnScreenEnabler2D", VisibleOnScreenEnabler2D::class, ::VisibleOnScreenEnabler2D)
  TypeManager.registerEngineType("VisibleOnScreenEnabler3D", VisibleOnScreenEnabler3D::class, ::VisibleOnScreenEnabler3D)
  TypeManager.registerEngineType("VisibleOnScreenNotifier2D", VisibleOnScreenNotifier2D::class, ::VisibleOnScreenNotifier2D)
  TypeManager.registerEngineType("VisibleOnScreenNotifier3D", VisibleOnScreenNotifier3D::class, ::VisibleOnScreenNotifier3D)
  TypeManager.registerEngineType("VisualInstance3D", VisualInstance3D::class, ::VisualInstance3D)
  TypeManager.registerEngineType("VisualShader", VisualShader::class, ::VisualShader)
  TypeManager.registerEngineType("VisualShaderNode", VisualShaderNode::class, ::VisualShaderNode)
  TypeManager.registerEngineType("VisualShaderNodeBillboard", VisualShaderNodeBillboard::class, ::VisualShaderNodeBillboard)
  TypeManager.registerEngineType("VisualShaderNodeBooleanConstant", VisualShaderNodeBooleanConstant::class, ::VisualShaderNodeBooleanConstant)
  TypeManager.registerEngineType("VisualShaderNodeBooleanParameter", VisualShaderNodeBooleanParameter::class, ::VisualShaderNodeBooleanParameter)
  TypeManager.registerEngineType("VisualShaderNodeClamp", VisualShaderNodeClamp::class, ::VisualShaderNodeClamp)
  TypeManager.registerEngineType("VisualShaderNodeColorConstant", VisualShaderNodeColorConstant::class, ::VisualShaderNodeColorConstant)
  TypeManager.registerEngineType("VisualShaderNodeColorFunc", VisualShaderNodeColorFunc::class, ::VisualShaderNodeColorFunc)
  TypeManager.registerEngineType("VisualShaderNodeColorOp", VisualShaderNodeColorOp::class, ::VisualShaderNodeColorOp)
  TypeManager.registerEngineType("VisualShaderNodeColorParameter", VisualShaderNodeColorParameter::class, ::VisualShaderNodeColorParameter)
  TypeManager.registerEngineType("VisualShaderNodeComment", VisualShaderNodeComment::class, ::VisualShaderNodeComment)
  TypeManager.registerEngineType("VisualShaderNodeCompare", VisualShaderNodeCompare::class, ::VisualShaderNodeCompare)
  TypeManager.registerEngineType("VisualShaderNodeConstant", VisualShaderNodeConstant::class, ::VisualShaderNodeConstant)
  TypeManager.registerEngineType("VisualShaderNodeCubemap", VisualShaderNodeCubemap::class, ::VisualShaderNodeCubemap)
  TypeManager.registerEngineType("VisualShaderNodeCubemapParameter", VisualShaderNodeCubemapParameter::class, ::VisualShaderNodeCubemapParameter)
  TypeManager.registerEngineType("VisualShaderNodeCurveTexture", VisualShaderNodeCurveTexture::class, ::VisualShaderNodeCurveTexture)
  TypeManager.registerEngineType("VisualShaderNodeCurveXYZTexture", VisualShaderNodeCurveXYZTexture::class, ::VisualShaderNodeCurveXYZTexture)
  TypeManager.registerEngineType("VisualShaderNodeCustom", VisualShaderNodeCustom::class, ::VisualShaderNodeCustom)
  TypeManager.registerEngineType("VisualShaderNodeDerivativeFunc", VisualShaderNodeDerivativeFunc::class, ::VisualShaderNodeDerivativeFunc)
  TypeManager.registerEngineType("VisualShaderNodeDeterminant", VisualShaderNodeDeterminant::class, ::VisualShaderNodeDeterminant)
  TypeManager.registerEngineType("VisualShaderNodeDistanceFade", VisualShaderNodeDistanceFade::class, ::VisualShaderNodeDistanceFade)
  TypeManager.registerEngineType("VisualShaderNodeDotProduct", VisualShaderNodeDotProduct::class, ::VisualShaderNodeDotProduct)
  TypeManager.registerEngineType("VisualShaderNodeExpression", VisualShaderNodeExpression::class, ::VisualShaderNodeExpression)
  TypeManager.registerEngineType("VisualShaderNodeFaceForward", VisualShaderNodeFaceForward::class, ::VisualShaderNodeFaceForward)
  TypeManager.registerEngineType("VisualShaderNodeFloatConstant", VisualShaderNodeFloatConstant::class, ::VisualShaderNodeFloatConstant)
  TypeManager.registerEngineType("VisualShaderNodeFloatFunc", VisualShaderNodeFloatFunc::class, ::VisualShaderNodeFloatFunc)
  TypeManager.registerEngineType("VisualShaderNodeFloatOp", VisualShaderNodeFloatOp::class, ::VisualShaderNodeFloatOp)
  TypeManager.registerEngineType("VisualShaderNodeFloatParameter", VisualShaderNodeFloatParameter::class, ::VisualShaderNodeFloatParameter)
  TypeManager.registerEngineType("VisualShaderNodeFrame", VisualShaderNodeFrame::class, ::VisualShaderNodeFrame)
  TypeManager.registerEngineType("VisualShaderNodeFresnel", VisualShaderNodeFresnel::class, ::VisualShaderNodeFresnel)
  TypeManager.registerEngineType("VisualShaderNodeGlobalExpression", VisualShaderNodeGlobalExpression::class, ::VisualShaderNodeGlobalExpression)
  TypeManager.registerEngineType("VisualShaderNodeGroupBase", VisualShaderNodeGroupBase::class, ::VisualShaderNodeGroupBase)
  TypeManager.registerEngineType("VisualShaderNodeIf", VisualShaderNodeIf::class, ::VisualShaderNodeIf)
  TypeManager.registerEngineType("VisualShaderNodeInput", VisualShaderNodeInput::class, ::VisualShaderNodeInput)
  TypeManager.registerEngineType("VisualShaderNodeIntConstant", VisualShaderNodeIntConstant::class, ::VisualShaderNodeIntConstant)
  TypeManager.registerEngineType("VisualShaderNodeIntFunc", VisualShaderNodeIntFunc::class, ::VisualShaderNodeIntFunc)
  TypeManager.registerEngineType("VisualShaderNodeIntOp", VisualShaderNodeIntOp::class, ::VisualShaderNodeIntOp)
  TypeManager.registerEngineType("VisualShaderNodeIntParameter", VisualShaderNodeIntParameter::class, ::VisualShaderNodeIntParameter)
  TypeManager.registerEngineType("VisualShaderNodeIs", VisualShaderNodeIs::class, ::VisualShaderNodeIs)
  TypeManager.registerEngineType("VisualShaderNodeLinearSceneDepth", VisualShaderNodeLinearSceneDepth::class, ::VisualShaderNodeLinearSceneDepth)
  TypeManager.registerEngineType("VisualShaderNodeMix", VisualShaderNodeMix::class, ::VisualShaderNodeMix)
  TypeManager.registerEngineType("VisualShaderNodeMultiplyAdd", VisualShaderNodeMultiplyAdd::class, ::VisualShaderNodeMultiplyAdd)
  TypeManager.registerEngineType("VisualShaderNodeOuterProduct", VisualShaderNodeOuterProduct::class, ::VisualShaderNodeOuterProduct)
  TypeManager.registerEngineType("VisualShaderNodeOutput", VisualShaderNodeOutput::class, ::VisualShaderNodeOutput)
  TypeManager.registerEngineType("VisualShaderNodeParameter", VisualShaderNodeParameter::class, ::VisualShaderNodeParameter)
  TypeManager.registerEngineType("VisualShaderNodeParameterRef", VisualShaderNodeParameterRef::class, ::VisualShaderNodeParameterRef)
  TypeManager.registerEngineType("VisualShaderNodeParticleAccelerator", VisualShaderNodeParticleAccelerator::class, ::VisualShaderNodeParticleAccelerator)
  TypeManager.registerEngineType("VisualShaderNodeParticleBoxEmitter", VisualShaderNodeParticleBoxEmitter::class, ::VisualShaderNodeParticleBoxEmitter)
  TypeManager.registerEngineType("VisualShaderNodeParticleConeVelocity", VisualShaderNodeParticleConeVelocity::class, ::VisualShaderNodeParticleConeVelocity)
  TypeManager.registerEngineType("VisualShaderNodeParticleEmit", VisualShaderNodeParticleEmit::class, ::VisualShaderNodeParticleEmit)
  TypeManager.registerEngineType("VisualShaderNodeParticleEmitter", VisualShaderNodeParticleEmitter::class, ::VisualShaderNodeParticleEmitter)
  TypeManager.registerEngineType("VisualShaderNodeParticleMeshEmitter", VisualShaderNodeParticleMeshEmitter::class, ::VisualShaderNodeParticleMeshEmitter)
  TypeManager.registerEngineType("VisualShaderNodeParticleMultiplyByAxisAngle", VisualShaderNodeParticleMultiplyByAxisAngle::class, ::VisualShaderNodeParticleMultiplyByAxisAngle)
  TypeManager.registerEngineType("VisualShaderNodeParticleOutput", VisualShaderNodeParticleOutput::class, ::VisualShaderNodeParticleOutput)
  TypeManager.registerEngineType("VisualShaderNodeParticleRandomness", VisualShaderNodeParticleRandomness::class, ::VisualShaderNodeParticleRandomness)
  TypeManager.registerEngineType("VisualShaderNodeParticleRingEmitter", VisualShaderNodeParticleRingEmitter::class, ::VisualShaderNodeParticleRingEmitter)
  TypeManager.registerEngineType("VisualShaderNodeParticleSphereEmitter", VisualShaderNodeParticleSphereEmitter::class, ::VisualShaderNodeParticleSphereEmitter)
  TypeManager.registerEngineType("VisualShaderNodeProximityFade", VisualShaderNodeProximityFade::class, ::VisualShaderNodeProximityFade)
  TypeManager.registerEngineType("VisualShaderNodeRandomRange", VisualShaderNodeRandomRange::class, ::VisualShaderNodeRandomRange)
  TypeManager.registerEngineType("VisualShaderNodeRemap", VisualShaderNodeRemap::class, ::VisualShaderNodeRemap)
  TypeManager.registerEngineType("VisualShaderNodeReroute", VisualShaderNodeReroute::class, ::VisualShaderNodeReroute)
  TypeManager.registerEngineType("VisualShaderNodeResizableBase", VisualShaderNodeResizableBase::class, ::VisualShaderNodeResizableBase)
  TypeManager.registerEngineType("VisualShaderNodeRotationByAxis", VisualShaderNodeRotationByAxis::class, ::VisualShaderNodeRotationByAxis)
  TypeManager.registerEngineType("VisualShaderNodeSDFRaymarch", VisualShaderNodeSDFRaymarch::class, ::VisualShaderNodeSDFRaymarch)
  TypeManager.registerEngineType("VisualShaderNodeSDFToScreenUV", VisualShaderNodeSDFToScreenUV::class, ::VisualShaderNodeSDFToScreenUV)
  TypeManager.registerEngineType("VisualShaderNodeSample3D", VisualShaderNodeSample3D::class, ::VisualShaderNodeSample3D)
  TypeManager.registerEngineType("VisualShaderNodeScreenNormalWorldSpace", VisualShaderNodeScreenNormalWorldSpace::class, ::VisualShaderNodeScreenNormalWorldSpace)
  TypeManager.registerEngineType("VisualShaderNodeScreenUVToSDF", VisualShaderNodeScreenUVToSDF::class, ::VisualShaderNodeScreenUVToSDF)
  TypeManager.registerEngineType("VisualShaderNodeSmoothStep", VisualShaderNodeSmoothStep::class, ::VisualShaderNodeSmoothStep)
  TypeManager.registerEngineType("VisualShaderNodeStep", VisualShaderNodeStep::class, ::VisualShaderNodeStep)
  TypeManager.registerEngineType("VisualShaderNodeSwitch", VisualShaderNodeSwitch::class, ::VisualShaderNodeSwitch)
  TypeManager.registerEngineType("VisualShaderNodeTexture", VisualShaderNodeTexture::class, ::VisualShaderNodeTexture)
  TypeManager.registerEngineType("VisualShaderNodeTexture2DArray", VisualShaderNodeTexture2DArray::class, ::VisualShaderNodeTexture2DArray)
  TypeManager.registerEngineType("VisualShaderNodeTexture2DArrayParameter", VisualShaderNodeTexture2DArrayParameter::class, ::VisualShaderNodeTexture2DArrayParameter)
  TypeManager.registerEngineType("VisualShaderNodeTexture2DParameter", VisualShaderNodeTexture2DParameter::class, ::VisualShaderNodeTexture2DParameter)
  TypeManager.registerEngineType("VisualShaderNodeTexture3D", VisualShaderNodeTexture3D::class, ::VisualShaderNodeTexture3D)
  TypeManager.registerEngineType("VisualShaderNodeTexture3DParameter", VisualShaderNodeTexture3DParameter::class, ::VisualShaderNodeTexture3DParameter)
  TypeManager.registerEngineType("VisualShaderNodeTextureParameter", VisualShaderNodeTextureParameter::class, ::VisualShaderNodeTextureParameter)
  TypeManager.registerEngineType("VisualShaderNodeTextureParameterTriplanar", VisualShaderNodeTextureParameterTriplanar::class, ::VisualShaderNodeTextureParameterTriplanar)
  TypeManager.registerEngineType("VisualShaderNodeTextureSDF", VisualShaderNodeTextureSDF::class, ::VisualShaderNodeTextureSDF)
  TypeManager.registerEngineType("VisualShaderNodeTextureSDFNormal", VisualShaderNodeTextureSDFNormal::class, ::VisualShaderNodeTextureSDFNormal)
  TypeManager.registerEngineType("VisualShaderNodeTransformCompose", VisualShaderNodeTransformCompose::class, ::VisualShaderNodeTransformCompose)
  TypeManager.registerEngineType("VisualShaderNodeTransformConstant", VisualShaderNodeTransformConstant::class, ::VisualShaderNodeTransformConstant)
  TypeManager.registerEngineType("VisualShaderNodeTransformDecompose", VisualShaderNodeTransformDecompose::class, ::VisualShaderNodeTransformDecompose)
  TypeManager.registerEngineType("VisualShaderNodeTransformFunc", VisualShaderNodeTransformFunc::class, ::VisualShaderNodeTransformFunc)
  TypeManager.registerEngineType("VisualShaderNodeTransformOp", VisualShaderNodeTransformOp::class, ::VisualShaderNodeTransformOp)
  TypeManager.registerEngineType("VisualShaderNodeTransformParameter", VisualShaderNodeTransformParameter::class, ::VisualShaderNodeTransformParameter)
  TypeManager.registerEngineType("VisualShaderNodeTransformVecMult", VisualShaderNodeTransformVecMult::class, ::VisualShaderNodeTransformVecMult)
  TypeManager.registerEngineType("VisualShaderNodeUIntConstant", VisualShaderNodeUIntConstant::class, ::VisualShaderNodeUIntConstant)
  TypeManager.registerEngineType("VisualShaderNodeUIntFunc", VisualShaderNodeUIntFunc::class, ::VisualShaderNodeUIntFunc)
  TypeManager.registerEngineType("VisualShaderNodeUIntOp", VisualShaderNodeUIntOp::class, ::VisualShaderNodeUIntOp)
  TypeManager.registerEngineType("VisualShaderNodeUIntParameter", VisualShaderNodeUIntParameter::class, ::VisualShaderNodeUIntParameter)
  TypeManager.registerEngineType("VisualShaderNodeUVFunc", VisualShaderNodeUVFunc::class, ::VisualShaderNodeUVFunc)
  TypeManager.registerEngineType("VisualShaderNodeUVPolarCoord", VisualShaderNodeUVPolarCoord::class, ::VisualShaderNodeUVPolarCoord)
  TypeManager.registerEngineType("VisualShaderNodeVarying", VisualShaderNodeVarying::class, ::VisualShaderNodeVarying)
  TypeManager.registerEngineType("VisualShaderNodeVaryingGetter", VisualShaderNodeVaryingGetter::class, ::VisualShaderNodeVaryingGetter)
  TypeManager.registerEngineType("VisualShaderNodeVaryingSetter", VisualShaderNodeVaryingSetter::class, ::VisualShaderNodeVaryingSetter)
  TypeManager.registerEngineType("VisualShaderNodeVec2Constant", VisualShaderNodeVec2Constant::class, ::VisualShaderNodeVec2Constant)
  TypeManager.registerEngineType("VisualShaderNodeVec2Parameter", VisualShaderNodeVec2Parameter::class, ::VisualShaderNodeVec2Parameter)
  TypeManager.registerEngineType("VisualShaderNodeVec3Constant", VisualShaderNodeVec3Constant::class, ::VisualShaderNodeVec3Constant)
  TypeManager.registerEngineType("VisualShaderNodeVec3Parameter", VisualShaderNodeVec3Parameter::class, ::VisualShaderNodeVec3Parameter)
  TypeManager.registerEngineType("VisualShaderNodeVec4Constant", VisualShaderNodeVec4Constant::class, ::VisualShaderNodeVec4Constant)
  TypeManager.registerEngineType("VisualShaderNodeVec4Parameter", VisualShaderNodeVec4Parameter::class, ::VisualShaderNodeVec4Parameter)
  TypeManager.registerEngineType("VisualShaderNodeVectorBase", VisualShaderNodeVectorBase::class, ::VisualShaderNodeVectorBase)
  TypeManager.registerEngineType("VisualShaderNodeVectorCompose", VisualShaderNodeVectorCompose::class, ::VisualShaderNodeVectorCompose)
  TypeManager.registerEngineType("VisualShaderNodeVectorDecompose", VisualShaderNodeVectorDecompose::class, ::VisualShaderNodeVectorDecompose)
  TypeManager.registerEngineType("VisualShaderNodeVectorDistance", VisualShaderNodeVectorDistance::class, ::VisualShaderNodeVectorDistance)
  TypeManager.registerEngineType("VisualShaderNodeVectorFunc", VisualShaderNodeVectorFunc::class, ::VisualShaderNodeVectorFunc)
  TypeManager.registerEngineType("VisualShaderNodeVectorLen", VisualShaderNodeVectorLen::class, ::VisualShaderNodeVectorLen)
  TypeManager.registerEngineType("VisualShaderNodeVectorOp", VisualShaderNodeVectorOp::class, ::VisualShaderNodeVectorOp)
  TypeManager.registerEngineType("VisualShaderNodeVectorRefract", VisualShaderNodeVectorRefract::class, ::VisualShaderNodeVectorRefract)
  TypeManager.registerEngineType("VisualShaderNodeWorldPositionFromDepth", VisualShaderNodeWorldPositionFromDepth::class, ::VisualShaderNodeWorldPositionFromDepth)
  TypeManager.registerEngineType("VoxelGI", VoxelGI::class, ::VoxelGI)
  TypeManager.registerEngineType("VoxelGIData", VoxelGIData::class, ::VoxelGIData)
  TypeManager.registerEngineType("WeakRef", WeakRef::class, ::WeakRef)
  TypeManager.registerEngineType("WebRTCDataChannel", WebRTCDataChannel::class, ::WebRTCDataChannel)
  TypeManager.registerEngineType("WebRTCDataChannelExtension", WebRTCDataChannelExtension::class, ::WebRTCDataChannelExtensionDummy)
  TypeManager.registerEngineType("WebRTCMultiplayerPeer", WebRTCMultiplayerPeer::class, ::WebRTCMultiplayerPeer)
  TypeManager.registerEngineType("WebRTCPeerConnection", WebRTCPeerConnection::class, ::WebRTCPeerConnection)
  TypeManager.registerEngineType("WebRTCPeerConnectionExtension", WebRTCPeerConnectionExtension::class, ::WebRTCPeerConnectionExtensionDummy)
  TypeManager.registerEngineType("WebSocketMultiplayerPeer", WebSocketMultiplayerPeer::class, ::WebSocketMultiplayerPeer)
  TypeManager.registerEngineType("WebSocketPeer", WebSocketPeer::class, ::WebSocketPeer)
  TypeManager.registerEngineType("WebXRInterface", WebXRInterface::class, ::WebXRInterface)
  TypeManager.registerEngineType("Window", Window::class, ::Window)
  TypeManager.registerSingleton("WorkerThreadPool") { WorkerThreadPool }
  TypeManager.registerEngineType("WorkerThreadPool", WorkerThreadPool::class) { WorkerThreadPool }
  TypeManager.registerEngineType("World2D", World2D::class, ::World2D)
  TypeManager.registerEngineType("World3D", World3D::class, ::World3D)
  TypeManager.registerEngineType("WorldBoundaryShape2D", WorldBoundaryShape2D::class, ::WorldBoundaryShape2D)
  TypeManager.registerEngineType("WorldBoundaryShape3D", WorldBoundaryShape3D::class, ::WorldBoundaryShape3D)
  TypeManager.registerEngineType("WorldEnvironment", WorldEnvironment::class, ::WorldEnvironment)
  TypeManager.registerEngineType("X509Certificate", X509Certificate::class, ::X509Certificate)
  TypeManager.registerEngineType("XMLParser", XMLParser::class, ::XMLParser)
  TypeManager.registerEngineType("XRAnchor3D", XRAnchor3D::class, ::XRAnchor3D)
  TypeManager.registerEngineType("XRBodyModifier3D", XRBodyModifier3D::class, ::XRBodyModifier3D)
  TypeManager.registerEngineType("XRBodyTracker", XRBodyTracker::class, ::XRBodyTracker)
  TypeManager.registerEngineType("XRCamera3D", XRCamera3D::class, ::XRCamera3D)
  TypeManager.registerEngineType("XRController3D", XRController3D::class, ::XRController3D)
  TypeManager.registerEngineType("XRControllerTracker", XRControllerTracker::class, ::XRControllerTracker)
  TypeManager.registerEngineType("XRFaceModifier3D", XRFaceModifier3D::class, ::XRFaceModifier3D)
  TypeManager.registerEngineType("XRFaceTracker", XRFaceTracker::class, ::XRFaceTracker)
  TypeManager.registerEngineType("XRHandModifier3D", XRHandModifier3D::class, ::XRHandModifier3D)
  TypeManager.registerEngineType("XRHandTracker", XRHandTracker::class, ::XRHandTracker)
  TypeManager.registerEngineType("XRInterface", XRInterface::class, ::XRInterface)
  TypeManager.registerEngineType("XRInterfaceExtension", XRInterfaceExtension::class, ::XRInterfaceExtension)
  TypeManager.registerEngineType("XRNode3D", XRNode3D::class, ::XRNode3D)
  TypeManager.registerEngineType("XROrigin3D", XROrigin3D::class, ::XROrigin3D)
  TypeManager.registerEngineType("XRPose", XRPose::class, ::XRPose)
  TypeManager.registerEngineType("XRPositionalTracker", XRPositionalTracker::class, ::XRPositionalTracker)
  TypeManager.registerSingleton("XRServer") { XRServer }
  TypeManager.registerEngineType("XRServer", XRServer::class) { XRServer }
  TypeManager.registerEngineType("XRTracker", XRTracker::class, ::XRTracker)
  TypeManager.registerEngineType("XRVRS", XRVRS::class, ::XRVRS)
  TypeManager.registerEngineType("ZIPPacker", ZIPPacker::class, ::ZIPPacker)
  TypeManager.registerEngineType("ZIPReader", ZIPReader::class, ::ZIPReader)
}
