<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:2adad0e6-10f5-404d-aa72-81fa0d28e36d(DTO.generator.templates@generator)">
  <persistence version="9" />
  <languages>
    <use id="b401a680-8325-4110-8fd3-84331ff25bef" name="jetbrains.mps.lang.generator" version="4" />
    <use id="d7706f63-9be2-479c-a3da-ae92af1e64d5" name="jetbrains.mps.lang.generator.generationContext" version="2" />
    <devkit ref="a2eb3a43-fcc2-4200-80dc-c60110c4862d(jetbrains.mps.devkit.templates)" />
  </languages>
  <imports>
    <import index="fici" ref="r:2edbaf7b-4499-4f0a-8ea1-bc7a6dac74a9(DTO.structure)" implicit="true" />
    <import index="wyt6" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)" implicit="true" />
    <import index="tpck" ref="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" implicit="true" />
  </imports>
  <registry>
    <language id="f3061a53-9226-4cc5-a443-f952ceaf5816" name="jetbrains.mps.baseLanguage">
      <concept id="1202948039474" name="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" flags="nn" index="liA8E" />
      <concept id="1197027756228" name="jetbrains.mps.baseLanguage.structure.DotExpression" flags="nn" index="2OqwBi">
        <child id="1197027771414" name="operand" index="2Oq$k0" />
        <child id="1197027833540" name="operation" index="2OqNvi" />
      </concept>
      <concept id="1201370618622" name="jetbrains.mps.baseLanguage.structure.Property" flags="ig" index="2RhdJD">
        <property id="1201371481316" name="propertyName" index="2RkwnN" />
        <child id="1201371521209" name="type" index="2RkE6I" />
        <child id="1201372378714" name="propertyImplementation" index="2RnVtd" />
      </concept>
      <concept id="1201372606839" name="jetbrains.mps.baseLanguage.structure.DefaultPropertyImplementation" flags="ng" index="2RoN1w">
        <child id="1202065356069" name="defaultGetAccessor" index="3wFrgM" />
        <child id="1202078082794" name="defaultSetAccessor" index="3xrYvX" />
      </concept>
      <concept id="1137021947720" name="jetbrains.mps.baseLanguage.structure.ConceptFunction" flags="in" index="2VMwT0">
        <child id="1137022507850" name="body" index="2VODD2" />
      </concept>
      <concept id="1070475926800" name="jetbrains.mps.baseLanguage.structure.StringLiteral" flags="nn" index="Xl_RD">
        <property id="1070475926801" name="value" index="Xl_RC" />
      </concept>
      <concept id="1068390468198" name="jetbrains.mps.baseLanguage.structure.ClassConcept" flags="ig" index="312cEu" />
      <concept id="1068580123155" name="jetbrains.mps.baseLanguage.structure.ExpressionStatement" flags="nn" index="3clFbF">
        <child id="1068580123156" name="expression" index="3clFbG" />
      </concept>
      <concept id="1068580123159" name="jetbrains.mps.baseLanguage.structure.IfStatement" flags="nn" index="3clFbJ">
        <child id="1068580123160" name="condition" index="3clFbw" />
        <child id="1068580123161" name="ifTrue" index="3clFbx" />
      </concept>
      <concept id="1068580123136" name="jetbrains.mps.baseLanguage.structure.StatementList" flags="sn" stub="5293379017992965193" index="3clFbS">
        <child id="1068581517665" name="statement" index="3cqZAp" />
      </concept>
      <concept id="1068581242878" name="jetbrains.mps.baseLanguage.structure.ReturnStatement" flags="nn" index="3cpWs6">
        <child id="1068581517676" name="expression" index="3cqZAk" />
      </concept>
      <concept id="1204053956946" name="jetbrains.mps.baseLanguage.structure.IMethodCall" flags="ngI" index="1ndlxa">
        <reference id="1068499141037" name="baseMethodDeclaration" index="37wK5l" />
        <child id="1068499141038" name="actualArgument" index="37wK5m" />
      </concept>
      <concept id="1107461130800" name="jetbrains.mps.baseLanguage.structure.Classifier" flags="ng" index="3pOWGL">
        <child id="5375687026011219971" name="member" index="jymVt" unordered="true" />
      </concept>
      <concept id="1107535904670" name="jetbrains.mps.baseLanguage.structure.ClassifierType" flags="in" index="3uibUv">
        <reference id="1107535924139" name="classifier" index="3uigEE" />
      </concept>
      <concept id="1202065242027" name="jetbrains.mps.baseLanguage.structure.DefaultGetAccessor" flags="ng" index="3wEZqW" />
      <concept id="1202077725299" name="jetbrains.mps.baseLanguage.structure.DefaultSetAccessor" flags="ng" index="3xqBd$">
        <child id="1202077744034" name="visibility" index="3xqFEP" />
      </concept>
      <concept id="1178549954367" name="jetbrains.mps.baseLanguage.structure.IVisible" flags="ngI" index="1B3ioH">
        <child id="1178549979242" name="visibility" index="1B3o_S" />
      </concept>
      <concept id="1146644602865" name="jetbrains.mps.baseLanguage.structure.PublicVisibility" flags="nn" index="3Tm1VV" />
      <concept id="1146644623116" name="jetbrains.mps.baseLanguage.structure.PrivateVisibility" flags="nn" index="3Tm6S6" />
    </language>
    <language id="b401a680-8325-4110-8fd3-84331ff25bef" name="jetbrains.mps.lang.generator">
      <concept id="1114706874351" name="jetbrains.mps.lang.generator.structure.CopySrcNodeMacro" flags="ln" index="29HgVG">
        <child id="1168024447342" name="sourceNodeQuery" index="3NFExx" />
      </concept>
      <concept id="1095416546421" name="jetbrains.mps.lang.generator.structure.MappingConfiguration" flags="ig" index="bUwia">
        <child id="1167328349397" name="reductionMappingRule" index="3acgRq" />
        <child id="1167514678247" name="rootMappingRule" index="3lj3bC" />
      </concept>
      <concept id="1168559333462" name="jetbrains.mps.lang.generator.structure.TemplateDeclarationReference" flags="ln" index="j$656" />
      <concept id="1168619357332" name="jetbrains.mps.lang.generator.structure.RootTemplateAnnotation" flags="lg" index="n94m4">
        <reference id="1168619429071" name="applicableConcept" index="n9lRv" />
      </concept>
      <concept id="1095672379244" name="jetbrains.mps.lang.generator.structure.TemplateFragment" flags="ng" index="raruj" />
      <concept id="1722980698497626400" name="jetbrains.mps.lang.generator.structure.ITemplateCall" flags="ngI" index="v9R3L">
        <reference id="1722980698497626483" name="template" index="v9R2y" />
      </concept>
      <concept id="1167169188348" name="jetbrains.mps.lang.generator.structure.TemplateFunctionParameter_sourceNode" flags="nn" index="30H73N" />
      <concept id="1167169308231" name="jetbrains.mps.lang.generator.structure.BaseMappingRule" flags="ng" index="30H$t8">
        <reference id="1167169349424" name="applicableConcept" index="30HIoZ" />
      </concept>
      <concept id="1092059087312" name="jetbrains.mps.lang.generator.structure.TemplateDeclaration" flags="ig" index="13MO4I">
        <reference id="1168285871518" name="applicableConcept" index="3gUMe" />
        <child id="1092060348987" name="contentNode" index="13RCb5" />
      </concept>
      <concept id="1087833241328" name="jetbrains.mps.lang.generator.structure.PropertyMacro" flags="ln" index="17Uvod">
        <child id="1167756362303" name="propertyValueFunction" index="3zH0cK" />
      </concept>
      <concept id="1167327847730" name="jetbrains.mps.lang.generator.structure.Reduction_MappingRule" flags="lg" index="3aamgX">
        <child id="1169672767469" name="ruleConsequence" index="1lVwrX" />
      </concept>
      <concept id="1167514355419" name="jetbrains.mps.lang.generator.structure.Root_MappingRule" flags="lg" index="3lhOvk">
        <reference id="1167514355421" name="template" index="3lhOvi" />
      </concept>
      <concept id="1167756080639" name="jetbrains.mps.lang.generator.structure.PropertyMacro_GetPropertyValue" flags="in" index="3zFVjK" />
      <concept id="1167770111131" name="jetbrains.mps.lang.generator.structure.ReferenceMacro_GetReferent" flags="in" index="3$xsQk" />
      <concept id="1167951910403" name="jetbrains.mps.lang.generator.structure.SourceSubstituteMacro_SourceNodesQuery" flags="in" index="3JmXsc" />
      <concept id="1168024337012" name="jetbrains.mps.lang.generator.structure.SourceSubstituteMacro_SourceNodeQuery" flags="in" index="3NFfHV" />
      <concept id="1118786554307" name="jetbrains.mps.lang.generator.structure.LoopMacro" flags="ln" index="1WS0z7">
        <child id="1167952069335" name="sourceNodesQuery" index="3Jn$fo" />
      </concept>
      <concept id="1088761943574" name="jetbrains.mps.lang.generator.structure.ReferenceMacro" flags="ln" index="1ZhdrF">
        <child id="1167770376702" name="referentFunction" index="3$ytzL" />
      </concept>
    </language>
    <language id="7866978e-a0f0-4cc7-81bc-4d213d9375e1" name="jetbrains.mps.lang.smodel">
      <concept id="1966870290083281362" name="jetbrains.mps.lang.smodel.structure.EnumMember_NameOperation" flags="ng" index="24Tkf9" />
      <concept id="1138056022639" name="jetbrains.mps.lang.smodel.structure.SPropertyAccess" flags="nn" index="3TrcHB">
        <reference id="1138056395725" name="property" index="3TsBF5" />
      </concept>
      <concept id="1138056143562" name="jetbrains.mps.lang.smodel.structure.SLinkAccess" flags="nn" index="3TrEf2">
        <reference id="1138056516764" name="link" index="3Tt5mk" />
      </concept>
      <concept id="1138056282393" name="jetbrains.mps.lang.smodel.structure.SLinkListAccess" flags="nn" index="3Tsc0h">
        <reference id="1138056546658" name="link" index="3TtcxE" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1133920641626" name="jetbrains.mps.lang.core.structure.BaseConcept" flags="ng" index="2VYdi">
        <child id="5169995583184591170" name="smodelAttribute" index="lGtFl" />
      </concept>
      <concept id="3364660638048049750" name="jetbrains.mps.lang.core.structure.PropertyAttribute" flags="ng" index="A9Btg">
        <property id="1757699476691236117" name="name_DebugInfo" index="2qtEX9" />
        <property id="1341860900487648621" name="propertyId" index="P4ACc" />
      </concept>
      <concept id="3364660638048049745" name="jetbrains.mps.lang.core.structure.LinkAttribute" flags="ng" index="A9Btn">
        <property id="1757699476691236116" name="role_DebugInfo" index="2qtEX8" />
        <property id="1341860900488019036" name="linkId" index="P3scX" />
      </concept>
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ngI" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
    <language id="83888646-71ce-4f1c-9c53-c54016f6ad4f" name="jetbrains.mps.baseLanguage.collections">
      <concept id="6099516049394485324" name="jetbrains.mps.baseLanguage.collections.structure.CustomContainers" flags="ng" index="2llxRb" />
    </language>
  </registry>
  <node concept="bUwia" id="3cRMuaM8dXq">
    <property role="TrG5h" value="main" />
    <node concept="3aamgX" id="7wWVNZN4nGv" role="3acgRq">
      <ref role="30HIoZ" to="fici:3cRMuaM8eeJ" resolve="Field" />
      <node concept="j$656" id="7wWVNZN4nGB" role="1lVwrX">
        <ref role="v9R2y" node="7wWVNZN4nG_" resolve="reduce_Field" />
      </node>
    </node>
    <node concept="3aamgX" id="7wWVNZN4oH1" role="3acgRq">
      <ref role="30HIoZ" to="fici:3cRMuaM8ef1" resolve="SimpeFieldType" />
      <node concept="j$656" id="7wWVNZN4oH6" role="1lVwrX">
        <ref role="v9R2y" node="7wWVNZN4oH4" resolve="reduce_SimpeFieldType" />
      </node>
    </node>
    <node concept="3aamgX" id="7wWVNZN4oH8" role="3acgRq">
      <ref role="30HIoZ" to="fici:3cRMuaM8eeR" resolve="DTOReference" />
      <node concept="j$656" id="7wWVNZN4oHc" role="1lVwrX">
        <ref role="v9R2y" node="7wWVNZN4oHa" resolve="reduce_DTOReference" />
      </node>
    </node>
    <node concept="3lhOvk" id="7wWVNZN47TQ" role="3lj3bC">
      <ref role="30HIoZ" to="fici:3cRMuaM8eeB" resolve="DTO" />
      <ref role="3lhOvi" node="7wWVNZN47TT" resolve="DTO" />
    </node>
    <node concept="3lhOvk" id="7wWVNZN5GKs" role="3lj3bC">
      <ref role="30HIoZ" to="fici:3cRMuaM8eeF" resolve="DTOS" />
      <ref role="3lhOvi" node="7wWVNZN5GKu" resolve="map_DTOS" />
    </node>
  </node>
  <node concept="312cEu" id="7wWVNZN47TT">
    <property role="TrG5h" value="DTO" />
    <node concept="2RhdJD" id="7wWVNZN4n7W" role="jymVt">
      <property role="2RkwnN" value="someProperty" />
      <node concept="3Tm1VV" id="7wWVNZN4n7X" role="1B3o_S" />
      <node concept="2RoN1w" id="7wWVNZN4n7Y" role="2RnVtd">
        <node concept="3wEZqW" id="7wWVNZN4n7Z" role="3wFrgM" />
        <node concept="3xqBd$" id="7wWVNZN4n80" role="3xrYvX">
          <node concept="3Tm6S6" id="7wWVNZN4n81" role="3xqFEP" />
        </node>
      </node>
      <node concept="3uibUv" id="7wWVNZN4n8V" role="2RkE6I">
        <ref role="3uigEE" to="wyt6:~String" resolve="String" />
      </node>
      <node concept="1WS0z7" id="7wWVNZN4nij" role="lGtFl">
        <node concept="3JmXsc" id="7wWVNZN4nim" role="3Jn$fo">
          <node concept="3clFbS" id="7wWVNZN4nin" role="2VODD2">
            <node concept="3clFbF" id="7wWVNZN4nit" role="3cqZAp">
              <node concept="2OqwBi" id="7wWVNZN4nio" role="3clFbG">
                <node concept="3Tsc0h" id="7wWVNZN4nir" role="2OqNvi">
                  <ref role="3TtcxE" to="fici:3cRMuaM8n78" resolve="fields" />
                </node>
                <node concept="30H73N" id="7wWVNZN4nis" role="2Oq$k0" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node concept="29HgVG" id="7wWVNZN4nCj" role="lGtFl" />
    </node>
    <node concept="3Tm1VV" id="7wWVNZN47TU" role="1B3o_S" />
    <node concept="n94m4" id="7wWVNZN47TV" role="lGtFl">
      <ref role="n9lRv" to="fici:3cRMuaM8eeB" resolve="DTO" />
    </node>
    <node concept="17Uvod" id="7wWVNZN4btQ" role="lGtFl">
      <property role="2qtEX9" value="name" />
      <property role="P4ACc" value="ceab5195-25ea-4f22-9b92-103b95ca8c0c/1169194658468/1169194664001" />
      <node concept="3zFVjK" id="7wWVNZN4btR" role="3zH0cK">
        <node concept="3clFbS" id="7wWVNZN4btS" role="2VODD2">
          <node concept="3clFbF" id="7wWVNZN4dq7" role="3cqZAp">
            <node concept="2OqwBi" id="7wWVNZN4ecg" role="3clFbG">
              <node concept="30H73N" id="7wWVNZN4dq6" role="2Oq$k0" />
              <node concept="3TrcHB" id="7wWVNZN4g0k" role="2OqNvi">
                <ref role="3TsBF5" to="tpck:h0TrG11" resolve="name" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node concept="13MO4I" id="7wWVNZN4nG_">
    <property role="TrG5h" value="reduce_Field" />
    <ref role="3gUMe" to="fici:3cRMuaM8eeJ" resolve="Field" />
    <node concept="2RhdJD" id="7wWVNZN4nGK" role="13RCb5">
      <property role="2RkwnN" value="fieldName" />
      <node concept="3Tm1VV" id="7wWVNZN4nGL" role="1B3o_S" />
      <node concept="2RoN1w" id="7wWVNZN4nGM" role="2RnVtd">
        <node concept="3wEZqW" id="7wWVNZN4nGN" role="3wFrgM" />
        <node concept="3xqBd$" id="7wWVNZN4nGO" role="3xrYvX">
          <node concept="3Tm6S6" id="7wWVNZN4nGP" role="3xqFEP" />
        </node>
      </node>
      <node concept="raruj" id="7wWVNZN4nH1" role="lGtFl" />
      <node concept="17Uvod" id="7wWVNZN4nHa" role="lGtFl">
        <property role="2qtEX9" value="propertyName" />
        <property role="P4ACc" value="f3061a53-9226-4cc5-a443-f952ceaf5816/1201370618622/1201371481316" />
        <node concept="3zFVjK" id="7wWVNZN4nHb" role="3zH0cK">
          <node concept="3clFbS" id="7wWVNZN4nHc" role="2VODD2">
            <node concept="3clFbF" id="7wWVNZN4nNy" role="3cqZAp">
              <node concept="2OqwBi" id="7wWVNZN4o5D" role="3clFbG">
                <node concept="30H73N" id="7wWVNZN4nNx" role="2Oq$k0" />
                <node concept="3TrcHB" id="7wWVNZN4of3" role="2OqNvi">
                  <ref role="3TsBF5" to="tpck:h0TrG11" resolve="name" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node concept="3uibUv" id="7wWVNZN4oBY" role="2RkE6I">
        <ref role="3uigEE" to="wyt6:~String" resolve="String" />
        <node concept="29HgVG" id="7wWVNZN4oCI" role="lGtFl">
          <node concept="3NFfHV" id="7wWVNZN4oCJ" role="3NFExx">
            <node concept="3clFbS" id="7wWVNZN4oCK" role="2VODD2">
              <node concept="3clFbF" id="7wWVNZN4oCQ" role="3cqZAp">
                <node concept="2OqwBi" id="7wWVNZN4oCL" role="3clFbG">
                  <node concept="3TrEf2" id="7wWVNZN4oCO" role="2OqNvi">
                    <ref role="3Tt5mk" to="fici:3cRMuaM8eeP" resolve="type" />
                  </node>
                  <node concept="30H73N" id="7wWVNZN4oCP" role="2Oq$k0" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node concept="13MO4I" id="7wWVNZN4oH4">
    <property role="TrG5h" value="reduce_SimpeFieldType" />
    <ref role="3gUMe" to="fici:3cRMuaM8ef1" resolve="SimpeFieldType" />
    <node concept="2RhdJD" id="7wWVNZN59l8" role="13RCb5">
      <property role="2RkwnN" value="testProperty" />
      <node concept="3Tm1VV" id="7wWVNZN59l9" role="1B3o_S" />
      <node concept="2RoN1w" id="7wWVNZN59la" role="2RnVtd">
        <node concept="3wEZqW" id="7wWVNZN59lb" role="3wFrgM" />
        <node concept="3xqBd$" id="7wWVNZN59lc" role="3xrYvX">
          <node concept="3Tm6S6" id="7wWVNZN59ld" role="3xqFEP" />
        </node>
      </node>
      <node concept="3uibUv" id="7wWVNZN5ufj" role="2RkE6I">
        <ref role="3uigEE" to="wyt6:~String" resolve="String" />
        <node concept="raruj" id="7wWVNZN5ufm" role="lGtFl" />
        <node concept="1ZhdrF" id="7wWVNZN5ufs" role="lGtFl">
          <property role="2qtEX8" value="classifier" />
          <property role="P3scX" value="f3061a53-9226-4cc5-a443-f952ceaf5816/1107535904670/1107535924139" />
          <node concept="3$xsQk" id="7wWVNZN5uft" role="3$ytzL">
            <node concept="3clFbS" id="7wWVNZN5ufu" role="2VODD2">
              <node concept="3clFbJ" id="7wWVNZN5ugw" role="3cqZAp">
                <node concept="2OqwBi" id="7wWVNZN5vz1" role="3clFbw">
                  <node concept="2OqwBi" id="7wWVNZN5uND" role="2Oq$k0">
                    <node concept="2OqwBi" id="7wWVNZN5uto" role="2Oq$k0">
                      <node concept="30H73N" id="7wWVNZN5ui9" role="2Oq$k0" />
                      <node concept="3TrcHB" id="7wWVNZN5uCi" role="2OqNvi">
                        <ref role="3TsBF5" to="fici:3cRMuaM8ef2" resolve="type" />
                      </node>
                    </node>
                    <node concept="24Tkf9" id="7wWVNZN5v1C" role="2OqNvi" />
                  </node>
                  <node concept="liA8E" id="7wWVNZN5vWV" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~String.equals(java.lang.Object)" resolve="equals" />
                    <node concept="Xl_RD" id="7wWVNZN5vX1" role="37wK5m">
                      <property role="Xl_RC" value="Int" />
                    </node>
                  </node>
                </node>
                <node concept="3clFbS" id="7wWVNZN5ugy" role="3clFbx">
                  <node concept="3cpWs6" id="7wWVNZN5w7u" role="3cqZAp">
                    <node concept="Xl_RD" id="7wWVNZN5wfB" role="3cqZAk">
                      <property role="Xl_RC" value="Integer" />
                    </node>
                  </node>
                </node>
              </node>
              <node concept="3cpWs6" id="7wWVNZN5wy_" role="3cqZAp">
                <node concept="2OqwBi" id="7wWVNZN5yT_" role="3cqZAk">
                  <node concept="2OqwBi" id="7wWVNZN5y7U" role="2Oq$k0">
                    <node concept="30H73N" id="7wWVNZN5xhg" role="2Oq$k0" />
                    <node concept="3TrcHB" id="7wWVNZN5ynu" role="2OqNvi">
                      <ref role="3TsBF5" to="fici:3cRMuaM8ef2" resolve="type" />
                    </node>
                  </node>
                  <node concept="24Tkf9" id="7wWVNZN5zh6" role="2OqNvi" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node concept="13MO4I" id="7wWVNZN4oHa">
    <property role="TrG5h" value="reduce_DTOReference" />
    <ref role="3gUMe" to="fici:3cRMuaM8eeR" resolve="DTOReference" />
    <node concept="2RhdJD" id="7wWVNZN5FE3" role="13RCb5">
      <property role="2RkwnN" value="propertyName" />
      <node concept="3Tm1VV" id="7wWVNZN5FE4" role="1B3o_S" />
      <node concept="2RoN1w" id="7wWVNZN5FE5" role="2RnVtd">
        <node concept="3wEZqW" id="7wWVNZN5FE6" role="3wFrgM" />
        <node concept="3xqBd$" id="7wWVNZN5FE7" role="3xrYvX">
          <node concept="3Tm6S6" id="7wWVNZN5FE8" role="3xqFEP" />
        </node>
      </node>
      <node concept="3uibUv" id="7wWVNZN5FEc" role="2RkE6I">
        <ref role="3uigEE" to="wyt6:~String" resolve="String" />
        <node concept="raruj" id="7wWVNZN5FEk" role="lGtFl" />
        <node concept="1ZhdrF" id="7wWVNZN5FEq" role="lGtFl">
          <property role="2qtEX8" value="classifier" />
          <property role="P3scX" value="f3061a53-9226-4cc5-a443-f952ceaf5816/1107535904670/1107535924139" />
          <node concept="3$xsQk" id="7wWVNZN5FEr" role="3$ytzL">
            <node concept="3clFbS" id="7wWVNZN5FEs" role="2VODD2">
              <node concept="3clFbF" id="7wWVNZN5FFv" role="3cqZAp">
                <node concept="2OqwBi" id="7wWVNZN5Gud" role="3clFbG">
                  <node concept="2OqwBi" id="7wWVNZN5FWG" role="2Oq$k0">
                    <node concept="30H73N" id="7wWVNZN5FFu" role="2Oq$k0" />
                    <node concept="3TrEf2" id="7wWVNZN5G7v" role="2OqNvi">
                      <ref role="3Tt5mk" to="fici:3cRMuaM8eeS" resolve="dto" />
                    </node>
                  </node>
                  <node concept="3TrcHB" id="7wWVNZN5GFq" role="2OqNvi">
                    <ref role="3TsBF5" to="tpck:h0TrG11" resolve="name" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node concept="2llxRb" id="7wWVNZN5GKu">
    <property role="TrG5h" value="map_DTOS" />
    <node concept="n94m4" id="7wWVNZN5GKv" role="lGtFl">
      <ref role="n9lRv" to="fici:3cRMuaM8eeF" resolve="DTOS" />
    </node>
  </node>
</model>

