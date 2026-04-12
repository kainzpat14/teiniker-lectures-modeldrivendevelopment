<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:2edbaf7b-4499-4f0a-8ea1-bc7a6dac74a9(DTO.structure)">
  <persistence version="9" />
  <languages>
    <devkit ref="78434eb8-b0e5-444b-850d-e7c4ad2da9ab(jetbrains.mps.devkit.aspect.structure)" />
  </languages>
  <imports>
    <import index="tpck" ref="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" implicit="true" />
  </imports>
  <registry>
    <language id="c72da2b9-7cce-4447-8389-f407dc1158b7" name="jetbrains.mps.lang.structure">
      <concept id="3348158742936976480" name="jetbrains.mps.lang.structure.structure.EnumerationMemberDeclaration" flags="ng" index="25R33">
        <property id="1421157252384165432" name="memberId" index="3tVfz5" />
      </concept>
      <concept id="3348158742936976479" name="jetbrains.mps.lang.structure.structure.EnumerationDeclaration" flags="ng" index="25R3W">
        <child id="3348158742936976577" name="members" index="25R1y" />
      </concept>
      <concept id="1082978164218" name="jetbrains.mps.lang.structure.structure.DataTypeDeclaration" flags="ng" index="AxPO6">
        <property id="7791109065626895363" name="datatypeId" index="3F6X1D" />
      </concept>
      <concept id="1169125787135" name="jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration" flags="ig" index="PkWjJ">
        <property id="6714410169261853888" name="conceptId" index="EcuMT" />
        <property id="4628067390765956802" name="abstract" index="R5$K7" />
        <property id="5092175715804935370" name="conceptAlias" index="34LRSv" />
        <child id="1071489727083" name="linkDeclaration" index="1TKVEi" />
        <child id="1071489727084" name="propertyDeclaration" index="1TKVEl" />
      </concept>
      <concept id="1169127622168" name="jetbrains.mps.lang.structure.structure.InterfaceConceptReference" flags="ig" index="PrWs8">
        <reference id="1169127628841" name="intfc" index="PrY4T" />
      </concept>
      <concept id="1071489090640" name="jetbrains.mps.lang.structure.structure.ConceptDeclaration" flags="ig" index="1TIwiD">
        <property id="1096454100552" name="rootable" index="19KtqR" />
        <reference id="1071489389519" name="extends" index="1TJDcQ" />
        <child id="1169129564478" name="implements" index="PzmwI" />
      </concept>
      <concept id="1071489288299" name="jetbrains.mps.lang.structure.structure.PropertyDeclaration" flags="ig" index="1TJgyi">
        <property id="241647608299431129" name="propertyId" index="IQ2nx" />
        <reference id="1082985295845" name="dataType" index="AX2Wp" />
      </concept>
      <concept id="1071489288298" name="jetbrains.mps.lang.structure.structure.LinkDeclaration" flags="ig" index="1TJgyj">
        <property id="1071599776563" name="role" index="20kJfa" />
        <property id="1071599893252" name="sourceCardinality" index="20lbJX" />
        <property id="1071599937831" name="metaClass" index="20lmBu" />
        <property id="241647608299431140" name="linkId" index="IQ2ns" />
        <reference id="1071599976176" name="target" index="20lvS9" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ngI" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="1TIwiD" id="3cRMuaM8eeB">
    <property role="EcuMT" value="3690640395141702567" />
    <property role="TrG5h" value="DTO" />
    <property role="34LRSv" value="dto" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="PrWs8" id="3cRMuaM8eeE" role="PzmwI">
      <ref role="PrY4T" to="tpck:h0TrEE$" resolve="INamedConcept" />
    </node>
    <node concept="1TJgyj" id="3cRMuaM8n78" role="1TKVEi">
      <property role="IQ2ns" value="3690640395141738952" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="fields" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="3cRMuaM8eeJ" resolve="Field" />
    </node>
  </node>
  <node concept="1TIwiD" id="3cRMuaM8eeF">
    <property role="EcuMT" value="3690640395141702571" />
    <property role="TrG5h" value="DTOS" />
    <property role="19KtqR" value="true" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyj" id="3cRMuaM8eeH" role="1TKVEi">
      <property role="IQ2ns" value="3690640395141702573" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="dtos" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="3cRMuaM8eeB" resolve="DTO" />
    </node>
  </node>
  <node concept="1TIwiD" id="3cRMuaM8eeJ">
    <property role="EcuMT" value="3690640395141702575" />
    <property role="TrG5h" value="Field" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="PrWs8" id="3cRMuaM8eeK" role="PzmwI">
      <ref role="PrY4T" to="tpck:h0TrEE$" resolve="INamedConcept" />
    </node>
    <node concept="1TJgyj" id="3cRMuaM8eeP" role="1TKVEi">
      <property role="IQ2ns" value="3690640395141702581" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="type" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3cRMuaM8eeM" resolve="FieldType" />
    </node>
  </node>
  <node concept="1TIwiD" id="3cRMuaM8eeM">
    <property role="EcuMT" value="3690640395141702578" />
    <property role="TrG5h" value="FieldType" />
    <property role="R5$K7" value="true" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
  </node>
  <node concept="1TIwiD" id="3cRMuaM8eeR">
    <property role="EcuMT" value="3690640395141702583" />
    <property role="TrG5h" value="DTOReference" />
    <ref role="1TJDcQ" node="3cRMuaM8eeM" resolve="FieldType" />
    <node concept="1TJgyj" id="3cRMuaM8eeS" role="1TKVEi">
      <property role="IQ2ns" value="3690640395141702584" />
      <property role="20kJfa" value="dto" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="3cRMuaM8eeB" resolve="DTO" />
    </node>
  </node>
  <node concept="25R3W" id="3cRMuaM8eeV">
    <property role="3F6X1D" value="3690640395141702587" />
    <property role="TrG5h" value="SimpleTypes" />
    <node concept="25R33" id="3cRMuaM8eeW" role="25R1y">
      <property role="3tVfz5" value="3690640395141702588" />
      <property role="TrG5h" value="String" />
    </node>
    <node concept="25R33" id="3cRMuaM8eeX" role="25R1y">
      <property role="3tVfz5" value="3690640395141702589" />
      <property role="TrG5h" value="Int" />
    </node>
    <node concept="25R33" id="3cRMuaM8eeY" role="25R1y">
      <property role="3tVfz5" value="3690640395141702590" />
      <property role="TrG5h" value="Boolean" />
    </node>
  </node>
  <node concept="1TIwiD" id="3cRMuaM8ef1">
    <property role="EcuMT" value="3690640395141702593" />
    <property role="TrG5h" value="SimpeFieldType" />
    <ref role="1TJDcQ" node="3cRMuaM8eeM" resolve="FieldType" />
    <node concept="1TJgyi" id="3cRMuaM8ef2" role="1TKVEl">
      <property role="IQ2nx" value="3690640395141702594" />
      <property role="TrG5h" value="type" />
      <ref role="AX2Wp" node="3cRMuaM8eeV" resolve="SimpleTypes" />
    </node>
  </node>
</model>

