<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:48c3ddae-4e6e-4b6c-9e02-82f97b0bd552(DTO.editor)">
  <persistence version="9" />
  <languages>
    <use id="18bc6592-03a6-4e29-a83a-7ff23bde13ba" name="jetbrains.mps.lang.editor" version="15" />
    <use id="aee9cad2-acd4-4608-aef2-0004f6a1cdbd" name="jetbrains.mps.lang.actions" version="4" />
    <devkit ref="fbc25dd2-5da4-483a-8b19-70928e1b62d7(jetbrains.mps.devkit.general-purpose)" />
  </languages>
  <imports>
    <import index="fici" ref="r:2edbaf7b-4499-4f0a-8ea1-bc7a6dac74a9(DTO.structure)" implicit="true" />
    <import index="tpck" ref="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" implicit="true" />
  </imports>
  <registry>
    <language id="18bc6592-03a6-4e29-a83a-7ff23bde13ba" name="jetbrains.mps.lang.editor">
      <concept id="1071666914219" name="jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration" flags="ig" index="24kQdi">
        <child id="2597348684684069742" name="contextHints" index="CpUAK" />
      </concept>
      <concept id="6822301196700715228" name="jetbrains.mps.lang.editor.structure.ConceptEditorHintDeclarationReference" flags="ig" index="2aJ2om">
        <reference id="5944657839026714445" name="hint" index="2$4xQ3" />
      </concept>
      <concept id="1140524381322" name="jetbrains.mps.lang.editor.structure.CellModel_ListWithRole" flags="ng" index="2czfm3">
        <child id="1140524464360" name="cellLayout" index="2czzBx" />
      </concept>
      <concept id="1106270571710" name="jetbrains.mps.lang.editor.structure.CellLayout_Vertical" flags="nn" index="2iRkQZ" />
      <concept id="1237303669825" name="jetbrains.mps.lang.editor.structure.CellLayout_Indent" flags="nn" index="l2Vlx" />
      <concept id="1080736578640" name="jetbrains.mps.lang.editor.structure.BaseEditorComponent" flags="ig" index="2wURMF">
        <child id="1080736633877" name="cellModel" index="2wV5jI" />
      </concept>
      <concept id="5944657839000868711" name="jetbrains.mps.lang.editor.structure.ConceptEditorContextHints" flags="ig" index="2ABfQD">
        <child id="5944657839000877563" name="hints" index="2ABdcP" />
      </concept>
      <concept id="5944657839003601246" name="jetbrains.mps.lang.editor.structure.ConceptEditorHintDeclaration" flags="ig" index="2BsEeg">
        <property id="168363875802087287" name="showInUI" index="2gpH_U" />
      </concept>
      <concept id="1186414928363" name="jetbrains.mps.lang.editor.structure.SelectableStyleSheetItem" flags="ln" index="VPM3Z" />
      <concept id="1088013125922" name="jetbrains.mps.lang.editor.structure.CellModel_RefCell" flags="sg" stub="730538219795941030" index="1iCGBv">
        <child id="1088186146602" name="editorComponent" index="1sWHZn" />
      </concept>
      <concept id="1088185857835" name="jetbrains.mps.lang.editor.structure.InlineEditorComponent" flags="ig" index="1sVBvm" />
      <concept id="1139848536355" name="jetbrains.mps.lang.editor.structure.CellModel_WithRole" flags="ng" index="1$h60E">
        <property id="1140017977771" name="readOnly" index="1Intyy" />
        <reference id="1140103550593" name="relationDeclaration" index="1NtTu8" />
      </concept>
      <concept id="1073389446423" name="jetbrains.mps.lang.editor.structure.CellModel_Collection" flags="sn" stub="3013115976261988961" index="3EZMnI">
        <child id="1106270802874" name="cellLayout" index="2iSdaV" />
        <child id="1073389446424" name="childCellModel" index="3EZMnx" />
      </concept>
      <concept id="1073389577006" name="jetbrains.mps.lang.editor.structure.CellModel_Constant" flags="sn" stub="3610246225209162225" index="3F0ifn">
        <property id="1073389577007" name="text" index="3F0ifm" />
      </concept>
      <concept id="1073389658414" name="jetbrains.mps.lang.editor.structure.CellModel_Property" flags="sg" stub="730538219796134133" index="3F0A7n" />
      <concept id="1219418625346" name="jetbrains.mps.lang.editor.structure.IStyleContainer" flags="ngI" index="3F0Thp">
        <child id="1219418656006" name="styleItem" index="3F10Kt" />
      </concept>
      <concept id="1073389882823" name="jetbrains.mps.lang.editor.structure.CellModel_RefNode" flags="sg" stub="730538219795960754" index="3F1sOY" />
      <concept id="1073390211982" name="jetbrains.mps.lang.editor.structure.CellModel_RefNodeList" flags="sg" stub="2794558372793454595" index="3F2HdR" />
      <concept id="1166049232041" name="jetbrains.mps.lang.editor.structure.AbstractComponent" flags="ng" index="1XWOmA">
        <reference id="1166049300910" name="conceptDeclaration" index="1XX52x" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ngI" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="24kQdi" id="3cRMuaM8nvp">
    <ref role="1XX52x" to="fici:3cRMuaM8eeB" resolve="DTO" />
    <node concept="3EZMnI" id="3cRMuaM8nvD" role="2wV5jI">
      <node concept="3F0ifn" id="3cRMuaM8nvJ" role="3EZMnx">
        <property role="3F0ifm" value="dto" />
      </node>
      <node concept="3F0A7n" id="3cRMuaM8nvM" role="3EZMnx">
        <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
      </node>
      <node concept="3F2HdR" id="3cRMuaM8nvP" role="3EZMnx">
        <ref role="1NtTu8" to="fici:3cRMuaM8n78" resolve="fields" />
        <node concept="2iRkQZ" id="3cRMuaM8nvS" role="2czzBx" />
        <node concept="VPM3Z" id="3cRMuaM8nvT" role="3F10Kt" />
      </node>
      <node concept="l2Vlx" id="3cRMuaM8nvG" role="2iSdaV" />
    </node>
  </node>
  <node concept="24kQdi" id="3cRMuaM8nvw">
    <ref role="1XX52x" to="fici:3cRMuaM8eeF" resolve="DTOS" />
    <node concept="3F2HdR" id="3cRMuaM8nvy" role="2wV5jI">
      <ref role="1NtTu8" to="fici:3cRMuaM8eeH" resolve="dtos" />
      <node concept="2iRkQZ" id="3cRMuaM8nv$" role="2czzBx" />
    </node>
  </node>
  <node concept="24kQdi" id="3cRMuaM8_u2">
    <ref role="1XX52x" to="fici:3cRMuaM8eeJ" resolve="Field" />
    <node concept="3EZMnI" id="3cRMuaM8_u4" role="2wV5jI">
      <node concept="3F0A7n" id="3cRMuaM8_ua" role="3EZMnx">
        <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
      </node>
      <node concept="3F0ifn" id="3cRMuaM8_ud" role="3EZMnx">
        <property role="3F0ifm" value=":" />
      </node>
      <node concept="3F1sOY" id="3cRMuaM8_ug" role="3EZMnx">
        <ref role="1NtTu8" to="fici:3cRMuaM8eeP" resolve="type" />
      </node>
      <node concept="l2Vlx" id="3cRMuaM8_u7" role="2iSdaV" />
    </node>
  </node>
  <node concept="24kQdi" id="3cRMuaM8_uk">
    <ref role="1XX52x" to="fici:3cRMuaM8ef1" resolve="SimpeFieldType" />
    <node concept="3F0A7n" id="3cRMuaM8_um" role="2wV5jI">
      <ref role="1NtTu8" to="fici:3cRMuaM8ef2" resolve="type" />
    </node>
  </node>
  <node concept="24kQdi" id="3cRMuaM8_up">
    <ref role="1XX52x" to="fici:3cRMuaM8eeR" resolve="DTOReference" />
    <node concept="1iCGBv" id="3cRMuaM8_ur" role="2wV5jI">
      <ref role="1NtTu8" to="fici:3cRMuaM8eeS" resolve="dto" />
      <node concept="1sVBvm" id="3cRMuaM8_ut" role="1sWHZn">
        <node concept="3F0A7n" id="3cRMuaM8_ux" role="2wV5jI">
          <property role="1Intyy" value="true" />
          <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
        </node>
      </node>
    </node>
  </node>
  <node concept="24kQdi" id="3cRMuaM8FD1">
    <ref role="1XX52x" to="fici:3cRMuaM8eeB" resolve="DTO" />
    <node concept="3EZMnI" id="3cRMuaM8FDi" role="2wV5jI">
      <node concept="3F0ifn" id="3cRMuaM8FDm" role="3EZMnx">
        <property role="3F0ifm" value="dto" />
      </node>
      <node concept="3F0A7n" id="3cRMuaM8FDr" role="3EZMnx">
        <ref role="1NtTu8" to="tpck:h0TrG11" resolve="name" />
      </node>
      <node concept="3EZMnI" id="3cRMuaM8RlV" role="3EZMnx">
        <node concept="VPM3Z" id="3cRMuaM8RlX" role="3F10Kt" />
        <node concept="3F0ifn" id="3cRMuaM8Rm1" role="3EZMnx">
          <property role="3F0ifm" value="{" />
        </node>
        <node concept="3F2HdR" id="3cRMuaM8Rm4" role="3EZMnx">
          <ref role="1NtTu8" to="fici:3cRMuaM8n78" resolve="fields" />
          <node concept="2iRkQZ" id="3cRMuaM8Rm7" role="2czzBx" />
          <node concept="VPM3Z" id="3cRMuaM8Rm8" role="3F10Kt" />
        </node>
        <node concept="3F0ifn" id="3cRMuaM8Rmb" role="3EZMnx">
          <property role="3F0ifm" value="}" />
        </node>
        <node concept="2iRkQZ" id="3cRMuaM8Rm0" role="2iSdaV" />
      </node>
      <node concept="l2Vlx" id="3cRMuaM8FDl" role="2iSdaV" />
    </node>
    <node concept="2aJ2om" id="3cRMuaM8FD3" role="CpUAK">
      <ref role="2$4xQ3" node="3cRMuaM8FDd" resolve="JavaStyle" />
    </node>
  </node>
  <node concept="2ABfQD" id="3cRMuaM8FDc">
    <property role="TrG5h" value="JavaStyle" />
    <node concept="2BsEeg" id="3cRMuaM8FDd" role="2ABdcP">
      <property role="2gpH_U" value="true" />
      <property role="TrG5h" value="JavaStyle" />
    </node>
  </node>
</model>

