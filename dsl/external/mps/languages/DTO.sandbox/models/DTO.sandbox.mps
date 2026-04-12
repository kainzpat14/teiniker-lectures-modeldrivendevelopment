<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:0500737b-eb73-4500-9e5d-b39dfeb69305(DTO.sandbox)">
  <persistence version="9" />
  <languages>
    <use id="56553386-c201-4af6-a808-ebf8b0fd1c31" name="DTO" version="0" />
  </languages>
  <imports />
  <registry>
    <language id="56553386-c201-4af6-a808-ebf8b0fd1c31" name="DTO">
      <concept id="3690640395141702593" name="DTO.structure.SimpeFieldType" flags="ng" index="215MCz">
        <property id="3690640395141702594" name="type" index="215MCw" />
      </concept>
      <concept id="3690640395141702567" name="DTO.structure.DTO" flags="ng" index="215MD5">
        <child id="3690640395141738952" name="fields" index="215FwE" />
      </concept>
      <concept id="3690640395141702571" name="DTO.structure.DTOS" flags="ng" index="215MD9">
        <child id="3690640395141702573" name="dtos" index="215MDf" />
      </concept>
      <concept id="3690640395141702575" name="DTO.structure.Field" flags="ng" index="215MDd">
        <child id="3690640395141702581" name="type" index="215MDn" />
      </concept>
      <concept id="3690640395141702583" name="DTO.structure.DTOReference" flags="ng" index="215MDl">
        <reference id="3690640395141702584" name="dto" index="215MDq" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ngI" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="215MD9" id="3cRMuaM8n74">
    <node concept="215MD5" id="3cRMuaM8n75" role="215MDf">
      <property role="TrG5h" value="Person" />
      <node concept="215MDd" id="3cRMuaM8nv5" role="215FwE">
        <property role="TrG5h" value="firstName" />
        <node concept="215MCz" id="3cRMuaM8nv7" role="215MDn">
          <property role="215MCw" value="3cRMuaM8eeW/String" />
        </node>
      </node>
      <node concept="215MDd" id="3cRMuaM8nvb" role="215FwE">
        <property role="TrG5h" value="lastName" />
        <node concept="215MCz" id="3cRMuaM8nvf" role="215MDn">
          <property role="215MCw" value="3cRMuaM8eeW/String" />
        </node>
      </node>
    </node>
    <node concept="215MD5" id="3cRMuaM8n76" role="215MDf">
      <property role="TrG5h" value="Student" />
      <node concept="215MDd" id="3cRMuaM8nv9" role="215FwE">
        <property role="TrG5h" value="person" />
        <node concept="215MDl" id="3cRMuaM8nvj" role="215MDn">
          <ref role="215MDq" node="3cRMuaM8n75" resolve="Person" />
        </node>
      </node>
      <node concept="215MDd" id="3cRMuaM8nvh" role="215FwE">
        <property role="TrG5h" value="matNr" />
        <node concept="215MCz" id="3cRMuaM8nvn" role="215MDn">
          <property role="215MCw" value="3cRMuaM8eeX/Int" />
        </node>
      </node>
    </node>
  </node>
</model>

