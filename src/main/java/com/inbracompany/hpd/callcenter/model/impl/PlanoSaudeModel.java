package com.inbracompany.hpd.callcenter.model.impl;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.hpd.callcenter.model.IMongo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("planosaude")
@Document(collection = "planosaude")
public enum PlanoSaudeModel implements IMongo, Serializable {

	@XStreamAlias("amil")
	AMIL("AMIL"), @XStreamAlias("aspara")
	ASPARA("ASPARA"), @XStreamAlias("assefaz")
	ASSEFAZ("ASSEFAZ"), @XStreamAlias("bacen")
	BACEN("BACEN"), @XStreamAlias("capesaude")
	CAPESAUDE("CAPESAUDE"), @XStreamAlias("capesesp")
	CAPESESP("CAPESESP"), @XStreamAlias("casemprapa")
	CASEMPRAPA("CASEMPRAPA"), @XStreamAlias("casf")
	CASF("CASF"), @XStreamAlias("cassi")
	CASSI("CASSI"), @XStreamAlias("comando_aeronautica")
	COMANDO_AERONAUTICA("COMANDO_AERONAUTICA"), @XStreamAlias("funsa")
	FUNSA("FUNSA"), @XStreamAlias("comando_marinha")
	COMANDO_MARINHA("COMANDO_MARINHA"), @XStreamAlias("e_vida")
	E_VIDA("E_VIDA"), @XStreamAlias("embratel")
	EMBRATEL("EMBRATEL"), @XStreamAlias("garantia_saude")
	GARANTIA_SAUDE("GARANTIA_SAUDE"), @XStreamAlias("hospital_belem")
	HOSPITAL_BELEM("HOSPITAL_BELEM"), @XStreamAlias("geap")
	GEAP("GEAP"), @XStreamAlias("iasep")
	IASEP("IASEP"), @XStreamAlias("ipamb")
	IPAMB("IPAMB"), @XStreamAlias("justica_federal")
	JUSTIÇA_FEDERAL("JUSTICA_FEDERAL"), @XStreamAlias("pro_social")
	PRO_SOCIAL("PRO_SOCIAL"), @XStreamAlias("petrobras_petroleo")
	PETROBRAS_PETROLEO("PETROBRAS_PETROLEO"), @XStreamAlias("petrobras_distribuidora")
	PETROBRAS_DISTRIBUIDORA("PETROBRAS_DISTRIBUIDORA"), @XStreamAlias("porto_dias_saude")
	PORTO_DIAS_SAUDE("PORTO_DIAS_SAUDE"), @XStreamAlias("postal_saude")
	POSTAL_SAUDE("POSTAL_SAUDE"), @XStreamAlias("saude_caixa")
	SAUDE_CAIXA("SAUDE_CAIXA"), @XStreamAlias("sudam")
	SUDAM("SUDAM"), @XStreamAlias("sepaco")
	SEPACO("SEPACO"), @XStreamAlias("trt")
	TRT("TRT"), @XStreamAlias("unafisco")
	UNAFISCO("UNAFISCO"), @XStreamAlias("unimed")
	UNIMED("UNIMED"), @XStreamAlias("vale")
	VALE("VALE"), @XStreamAlias("particular")
	PARTICULAR("PARTICULAR");

	private final String value;

	PlanoSaudeModel(String value) {
		this.value = value;
	}

	public static PlanoSaudeModel fromValue(String value) {
		if (value != null) {
			for (PlanoSaudeModel intent : values()) {
				if (intent.value.equals(value)) {
					return intent;
				}
			}
		}

		throw new RuntimeException("Error to define Intent Enum");
	}

}
