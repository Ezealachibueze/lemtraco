package logic;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@RequestScoped
public class Country {

	
	static  String regoin="";
	
	String 
	a0="Select  Country",
	 a1="Afghanistan",
	a2="Albania",
	a3="Algeria",
	a4="Andorra",
	a5="Angola",
	a6="Antigua and Barbuda",
	a8="Argentina",
	a9="Armenia",
	a10="Australia",
	a11="Austria",
	a12="Austrian Empire",
	a13="Azerbaijan",
	a14="Baden",
	a15="Bahamas",
	a16="Bahrain",
	a17="Bangladesh",
	a18="Barbados",
	a19="Bavaria",
	a20="Belarus",
	a21="Belgium",
	a22="Belize",
	a23="Benin (Dahomey)",
	a24="Bolivia",
	a25="Bosnia and Herzegovina",
	a26="Botswana",
	a27="Brazil",
	a28="Brunei",
	a29="Brunswick and Lüneburg",
	a30="Bulgaria",
	a31="Burkina Faso",
	a32="Burma",
	a33="Burundi",
	a34="Cabo Verde",
	a35="Cambodia",
	a36="Cameroon",
	a37="Canada",
	a38="Cayman Islands",
	a39="Central African Republic",
	a40="Central American Federation",
	a41="Chad",
	a42="Chile",
	a43="China",
	a44="Colombia",
	a45="Comoros",
	a46="Congo Free State",
	a47="Costa Rica",
	a48="Cote d’Ivoire (Ivory Coast)",
	a49="Croatia",
	a50="Cuba",
	a51="Cyprus",
	a52="Czechia",
	a53="Czechoslovakia",
	a54="Democratic Republic of the Congo",
	a55="Denmark",
	a56="Djibouti",
	a57="Dominica",
	a58="Dominican Republic",
	a59="Duchy of Parma",
	a60="East Germany (German Democratic Republic)",
	a61="Ecuador",
	a62="Egypt",
	a63="El Salvador",
	a64="Equatorial Guinea",
	a65="Eritrea",
	a66="Estonia",
	a67="Eswatini",
	a68="Ethiopia",
	a69="Fiji",
	a70="Finland",
	a71="France",
	a72="Gabon",
	a73="Gambia",
	a74="Georgia",
	a75="Germany",
	a76="Ghana",
	a77="Grand Duchy of Tuscany",
	a78="Greece",
	a79="Grenada",
	a80="Guatemala",
	a81="Guinea",
	a82="Guinea-Bissau",
	a83="Guyana",
	a84="Haiti",
	a85="Hanover",
	a86="Hanseatic Republics",
	a87="Hawaii",
	a88="Hesse",
	a89="Holy See",
	a90="Honduras",
	a91="Hungary",
	a92="Iceland",
	a93="India",
	a94="Indonesia",
	a95="Iran",
	a96="Iraq",
	a97="Ireland",
	a98="Israel",
	a99="Italy",
	a100="Jamaica",
	a101="Japan",
	a102="Jordan",
	a103="Kazakhstan",
	a104="Kenya",
	a105="Kingdom of Serbia/Yugoslavia",
	a106="Kiribati",
	a107="Korea",
	a108="Kosovo",
	a109="Kuwait",
	a110="Kyrgyzstan",
	a111="Laos",
	a112="Latvia",
	a113="Lebanon",
	a114="Lesotho",
	a115="Lew Chew (Loochoo)",
	a116="Liberia",
	a117="Libya",
	a118="Liechtenstein",
	a119="Lithuania",
	a120="Luxembourg",
	a121="Madagascar",
	a122="Malawi",
	a123="Malaysia",
	a124="Maldives",
	a125="Mali",
	a126="Malta",
	a127="Marshall Islands",
	a128="Mauritania",
	a129="Mauritius",
    a130="Mecklenburg-Schwerin",
	a131="Mecklenburg-Strelitz",
	a132="Mexico",
	a133="Micronesia",
	a134="Moldova",
	a135="Monaco",
	a136="Mongolia",
	a137="Montenegro",
	a138="Morocco",
	a139="Mozambique",
	a140="Namibia",
	a141="Nassau",
	a142="Nauru",
	a143="Nepal",
	a144="Netherlands",
	a145="New Zealand",
	a146="Nicaragua",
	a147="Niger",
	a148="Nigeria",
	a149="North German Confederation",
	a150="North German Union",
	a170="North Macedonia",
	a171="Norway",
	a172="Oldenburg",
	a173="Oman",
	a174="Orange Free State",
	a175="Pakistan",
	a176="Palau",
	a177="Panama",
	a178="Papal States",
	a179="Papua New Guinea",
	a180="Paraguay",
	a181="Peru",
	a182="Philippines",
	a183="Piedmont-Sardinia",
	a184="Poland",
	a185="Portugal",
	a186="Qatar",
	a187="Republic of Genoa",
	a188="Republic of Korea (South Korea)",
	a189="Republic of the Congo",
	a190="Romania",
	a191="Russia",
	a192="Rwanda",
	a193="Saint Kitts and Nevis",
	a194="Saint Lucia",
	a195="Saint Vincent and the Grenadines",
	a196="Samoa",
	a197="San Marino",
	a198="Sao Tome and Principe",
	a199="Saudi Arabia",
	a200="Schaumburg-Lippe",
	a201="Senegal",
	a202="Serbia",
	a203="Seychelles",
	a204="Sierra Leone",
	a205="Singapore",
	a206="Slovakia",
	a207="Slovenia",
	a208="Solomon Islands",
	a209="Somalia",
	a210="South Africa",
	a211="South Sudan",
	a212="Spain",
	a213="Sri Lanka",
	a214="Sudan",
	a215="Suriname",
	a216="Sweden",
	a217="Switzerland",
	a218="Syria",
	a219="Tajikistan",
	a220="Tanzania",
	a221="Texas",
	a222="Thailand",
	a223="Timor-Leste",
	a224="Togo",
	a225="Tonga",
	a226="Trinidad and Tobago",
	a227="Tunisia",
	a228="Turkey",
	a229="Turkmenistan",
	a230="Tuvalu",
	a231="Two Sicilies",
	a232="Uganda",
	a233="Ukraine",
	a234="United Arab Emirates",
	a235="United Kingdom",
	a236="Uruguay",
	a237="Uzbekistan",
	a238="Vanuatu",
	a239="Venezuela",
	a240="Vietnam",
	a241="Württemberg",
	a242="Yemen",
	a243="Zambia",
	a244="Zimbabwe";

	
    
	
	public String getRegoin() {
		return regoin;
	}
	

	public void setRegoin(String regoin) {
		this.regoin = regoin;
	}
	
	
	  public String select() {
			
	    	if(getRegoin().contains(a0) |getRegoin().trim().length()<=0)
	    		setRegoin("");
	    	 if(getRegoin().contains(a1))setRegoin(a1);
	    	else
	    		if(getRegoin().contains(a2)) setRegoin(a2);
		   	else 
		   		if(getRegoin().contains(a3)) setRegoin(a3);
	    	else
	    		if(getRegoin().contains(a4))	setRegoin(a4);
		    else
		    	if(getRegoin().contains(a5)) setRegoin(a5);
			else
				if(getRegoin().contains(a6)) 	setRegoin(a6);
			else
				if(getRegoin().contains(a8)) 	setRegoin(a8);
			else
				if(getRegoin().contains(a9)) setRegoin(a9);
			else
				if(getRegoin().contains(a10)) setRegoin(a10);
			else
				if(getRegoin().contains(a11))	setRegoin(a11);
			else
				if(getRegoin().contains(a12)) setRegoin(a12);
			else
				if(getRegoin().contains(a13)) setRegoin(a13);
			else
				if(getRegoin().contains(a14)) setRegoin(a14);
			else
				if(getRegoin().contains(a15))	setRegoin(a15);
			else
				if(getRegoin().contains(a16))	setRegoin(a16);
			else
				if(getRegoin().contains(a17))	setRegoin(a17);
			else
				if(getRegoin().contains(a18))	setRegoin(a18);
			else
				if(getRegoin().contains(a19))	setRegoin(a19);
			else
				if(getRegoin().contains(a20))	setRegoin(a20);
			else
				if(getRegoin().contains(a21))	setRegoin(a21);
			else
				if(getRegoin().contains(a22))	setRegoin(a22);
			else
				if(getRegoin().contains(a23))	setRegoin(a24);
			else
				if(getRegoin().contains(a25))	setRegoin(a25);
			else
				if(getRegoin().contains(a26))	setRegoin(a26);
			else
				if(getRegoin().contains(a27))	setRegoin(a27);
			else
				if(getRegoin().contains(a28))	setRegoin(a28);
			else
				if(getRegoin().contains(a29))	setRegoin(a29);
			else
				if(getRegoin().contains(a30))	setRegoin(a30);
			else
				if(getRegoin().contains(a31))	setRegoin(a31);
			else
				if(getRegoin().contains(a32))	setRegoin(a32);
			else
				if(getRegoin().contains(a33))	setRegoin(a33);
			else
				if(getRegoin().contains(a34))	setRegoin(a34);
			else
				if(getRegoin().contains(a35))	setRegoin(a35);
			else
				if(getRegoin().contains(a36))	setRegoin(a36);
			else
				if(getRegoin().contains(a37))	setRegoin(a37);
			else
				if(getRegoin().contains(a38))	setRegoin(a38);
			else
				if(getRegoin().contains(a39))	setRegoin(a39);
			else
				if(getRegoin().contains(a40))	setRegoin(a40);
			else
				if(getRegoin().contains(a41))	setRegoin(a41);
			else
				if(getRegoin().contains(a42))	setRegoin(a42);
			else
				if(getRegoin().contains(a43))	setRegoin(a34);
			else 
				if(getRegoin().contains(a44))	setRegoin(a44);
			else
				if(getRegoin().contains(a45))	setRegoin(a45);
			else
				if(getRegoin().contains(a46))	setRegoin(a46);
			else
				if(getRegoin().contains(a47))	setRegoin(a47);
			else
				if(getRegoin().contains(a48))	setRegoin(a48);
			else
				if(getRegoin().contains(a49))	setRegoin(a49);
			else
				if(getRegoin().contains(a50))	setRegoin(a50);
			else
				if(getRegoin().contains(a51))	setRegoin(a51);
			else
				if(getRegoin().contains(a52))	setRegoin(a52);
			else
				if(getRegoin().contains(a53))	setRegoin(a53);
			else
				if(getRegoin().contains(a54))	setRegoin(a54);
			else
				if(getRegoin().contains(a55))	setRegoin(a55);
			else 
				if(getRegoin().contains(a56))	setRegoin(a56);
			else
				if(getRegoin().contains(a57))	setRegoin(a57);
			else
				if(getRegoin().contains(a58))	setRegoin(a58);
			else
				if(getRegoin().contains(a59))	setRegoin(a59);
			else
				if(getRegoin().contains(a60))	setRegoin(a60);
			else
				if(getRegoin().contains(a61))	setRegoin(a61);
			else
				if(getRegoin().contains(a62))	setRegoin(a62);
			else
				if(getRegoin().contains(a63))	setRegoin(a63);
			else
				if(getRegoin().contains(a64))	setRegoin(a64);
			else
				if(getRegoin().contains(a65))	setRegoin(a65);
			else
				if(getRegoin().contains(a66))	setRegoin(a66);
			else
				if(getRegoin().contains(a67))	setRegoin(a67);
			else
				if(getRegoin().contains(a68))	setRegoin(a68);
			else
				if(getRegoin().contains(a69))	setRegoin(a69);
			else
				if(getRegoin().contains(a70))	setRegoin(a70);
			else
				if(getRegoin().contains(a71))	setRegoin(a71);
			else
				if(getRegoin().contains(a72))	setRegoin(a72);
			else
				if(getRegoin().contains(a73))	setRegoin(a73);
			else
				if(getRegoin().contains(a74))	setRegoin(a74);
			else
				if(getRegoin().contains(a75))	setRegoin(a75);
			else
				if(getRegoin().contains(a76))	setRegoin(a76);
			else
				if(getRegoin().contains(a77))	setRegoin(a77);
			else
				if(getRegoin().contains(a78))	setRegoin(a78);
			else
				if(getRegoin().contains(a79))	setRegoin(a79);
			else
				if(getRegoin().contains(a80))	setRegoin(a80);
			else
				if(getRegoin().contains(a81))	setRegoin(a81);
			else
				if(getRegoin().contains(a82))	setRegoin(a82);
			else
				if(getRegoin().contains(a83))	setRegoin(a83);
			else
				if(getRegoin().contains(a84))	setRegoin(a84);
			else
				if(getRegoin().contains(a85))	setRegoin(a85);
			else
				if(getRegoin().contains(a86))	setRegoin(a86);
			else
				if(getRegoin().contains(a87))	setRegoin(a87);
			else
				if(getRegoin().contains(a88))	setRegoin(a88);
			else
				if(getRegoin().contains(a89))	setRegoin(a89);
			else
				if(getRegoin().contains(a90))	setRegoin(a90);
			else
				if(getRegoin().contains(a91))	setRegoin(a91);
			else
				if(getRegoin().contains(a92))	setRegoin(a92);
			else
				if(getRegoin().contains(a93))	setRegoin(a93);
			else
				if(getRegoin().contains(a94))	setRegoin(a94);
			else
				if(getRegoin().contains(a95))	setRegoin(a95);
			else
				if(getRegoin().contains(a96))	setRegoin(a96);
			else
				if(getRegoin().contains(a97))	setRegoin(a97);
			else
				if(getRegoin().contains(a98))	setRegoin(a98);
			else
				if(getRegoin().contains(a99))	setRegoin(a99);
			else
				if(getRegoin().contains(a100))	setRegoin(a100);
			else
				if(getRegoin().contains(a101))	setRegoin(a101);
			else
				if(getRegoin().contains(a102))	setRegoin(a102);
			else
				if(getRegoin().contains(a103))	setRegoin(a103);
			else
				if(getRegoin().contains(a104))	setRegoin(a104);
			else
				if(getRegoin().contains(a105))	setRegoin(a105);
			else
				if(getRegoin().contains(a106))	setRegoin(a106);
			else
				if(getRegoin().contains(a107))	setRegoin(a107);
			else
				if(getRegoin().contains(a108))	setRegoin(a108);
			else
				if(getRegoin().contains(a109))	setRegoin(a109);
			else
				if(getRegoin().contains(a110))	setRegoin(a110);
			else
				if(getRegoin().contains(a111))	setRegoin(a111);
			else
				if(getRegoin().contains(a112))	setRegoin(a112);
			else
				if(getRegoin().contains(a113))	setRegoin(a113);
			else
				if(getRegoin().contains(a114))	setRegoin(a114);
			else
				if(getRegoin().contains(a115))	setRegoin(a115);
			else
				if(getRegoin().contains(a116))	setRegoin(a116);
			else
				if(getRegoin().contains(a117))	setRegoin(a117);
			else
				if(getRegoin().contains(a118))	setRegoin(a118);
			else
				if(getRegoin().contains(a119))	setRegoin(a119);
			else
				if(getRegoin().contains(a120))	setRegoin(a120);
			else
				if(getRegoin().contains(a121))	setRegoin(a121);
			else 
				if(getRegoin().contains(a122))	setRegoin(a122);
			else
				if(getRegoin().contains(a123))	setRegoin(a123);
			else 
				if(getRegoin().contains(a124))	setRegoin(a124);
			else 
				if(getRegoin().contains(a125))	setRegoin(a125);
			else 
				if(getRegoin().contains(a126))	setRegoin(a126);
			else 
				if(getRegoin().contains(a127))	setRegoin(a127);
			else 
				if(getRegoin().contains(a128))	setRegoin(a128);
			else
				if(getRegoin().contains(a129))	setRegoin(a129);
			else
				if(getRegoin().contains(a130))	setRegoin(a130);
			else
				if(getRegoin().contains(a131))	setRegoin(a131);
			else
				if(getRegoin().contains(a132))	setRegoin(a132);
			else 
				if(getRegoin().contains(a133))	setRegoin(a133);
			else 
				if(getRegoin().contains(a134))	setRegoin(a134);
			else 
				if(getRegoin().contains(a135))	setRegoin(a135);
			else
				if(getRegoin().contains(a136))	setRegoin(a136);
			else 
				if(getRegoin().contains(a137))	setRegoin(a137);
			else
				if(getRegoin().contains(a138))	setRegoin(a138);
			else 
				if(getRegoin().contains(a139))	setRegoin(a139);
			else
				if(getRegoin().contains(a140))	setRegoin(a140);
			else 
				if(getRegoin().contains(a141))	setRegoin(a141);
			else
				if(getRegoin().contains(a142))	setRegoin(a142);
			else
				if(getRegoin().contains(a143))	setRegoin(a143);
			else
				if(getRegoin().contains(a144))	setRegoin(a144);
			else
				if(getRegoin().contains(a145))	setRegoin(a145);
			else
				if(getRegoin().contains(a146))	setRegoin(a146);
			else
				if(getRegoin().contains(a147))	setRegoin(a147);
			else
				if(getRegoin().contains(a148))	setRegoin(a148);
			else
				if(getRegoin().contains(a149))	setRegoin(a149);
			else
				if(getRegoin().contains(a150))	setRegoin(a150);
			else 
				if(getRegoin().contains(a170))	setRegoin(a170);
			else 
				if(getRegoin().contains(a171))	setRegoin(a171);
			else
				if(getRegoin().contains(a172))	setRegoin(a172);
			else
				if(getRegoin().contains(a173))	setRegoin(a173);
			else
				if(getRegoin().contains(a174))	setRegoin(a174);
			else
				if(getRegoin().contains(a175))	setRegoin(a175);
			else
				if(getRegoin().contains(a176))	setRegoin(a176);
			else 
				if(getRegoin().contains(a177))	setRegoin(a177);
			else 
				if(getRegoin().contains(a179))	setRegoin(a179);
			else
				if(getRegoin().contains(a180))	setRegoin(a180);
			else
				if(getRegoin().contains(a181))	setRegoin(a181);
			else
				if(getRegoin().contains(a182))	setRegoin(a182);
			else
				if(getRegoin().contains(a183))	setRegoin(a183);
			else
				if(getRegoin().contains(a184))	setRegoin(a84);
			else
				if(getRegoin().contains(a185))	setRegoin(a185);
			else
				if(getRegoin().contains(a186))	setRegoin(a186);
			else
				if(getRegoin().contains(a187))	setRegoin(a187);
			else
				if(getRegoin().contains(a188))	setRegoin(a188);
			else
				if(getRegoin().contains(a189))	setRegoin(a189);
			else
				if(getRegoin().contains(a190))	setRegoin(a190);
			else
				if(getRegoin().contains(a191))	setRegoin(a191);
			else
				if(getRegoin().contains(a192))	setRegoin(a192);
			else 
				if(getRegoin().contains(a193))	setRegoin(a193);
			else
				if(getRegoin().contains(a194))	setRegoin(a194);
			else
				if(getRegoin().contains(a195))	setRegoin(a195);
			else
				if(getRegoin().contains(a196))	setRegoin(a196);
			else
				if(getRegoin().contains(a197))	setRegoin(a197);
			else
				if(getRegoin().contains(a198))	setRegoin(a198);
			else 
				if(getRegoin().contains(a199))	setRegoin(a199);
			else
				if(getRegoin().contains(a200))	setRegoin(a200);
			else
				if(getRegoin().contains(a201))	setRegoin(a201);
			else
				if(getRegoin().contains(a202))	setRegoin(a202);
			else
				if(getRegoin().contains(a203))	setRegoin(a203);
			else
				if(getRegoin().contains(a204))	setRegoin(a204);
			else
				if(getRegoin().contains(a205))	setRegoin(a205);
			else
				if(getRegoin().contains(a206))	setRegoin(a206);
			else
				if(getRegoin().contains(a207))	setRegoin(a207);
			else 
				if(getRegoin().contains(a208))	setRegoin(a208);
			else
				if(getRegoin().contains(a210))	setRegoin(a210);
			else 
				if(getRegoin().contains(a211))	setRegoin(a211);
			else 
				if(getRegoin().contains(a221))	setRegoin(a221);
			else
				if(getRegoin().contains(a222))	setRegoin(a222);
			else
				if(getRegoin().contains(a223))	setRegoin(a223);
			else
				if(getRegoin().contains(a224))	setRegoin(a224);
			else
				if(getRegoin().contains(a225))	setRegoin(a225);
			else
				if(getRegoin().contains(a226))	setRegoin(a226);
			else
				if(getRegoin().contains(a227))	setRegoin(a227);
			else
				if(getRegoin().contains(a228))	setRegoin(a228);
			else
				if(getRegoin().contains(a229))	setRegoin(a229);
			else
				if(getRegoin().contains(a230))	setRegoin(a230);
			else
				if(getRegoin().contains(a231))	setRegoin(a231);
			else
				if(getRegoin().contains(a232))	setRegoin(a232);
			else
				if(getRegoin().contains(a233))	setRegoin(a233);
			else
				if(getRegoin().contains(a234))	setRegoin(a234);
			else
				if(getRegoin().contains(a235))	setRegoin(a235);
			else 
				if(getRegoin().contains(a236))	setRegoin(a236);
			else
				if(getRegoin().contains(a237))	setRegoin(a237);
			else
				if(getRegoin().contains(a238))	setRegoin(a238);
			else
				if(getRegoin().contains(a239))	setRegoin(a239);
			else
				if(getRegoin().contains(a240))	setRegoin(a240);
			else
				if(getRegoin().contains(a241))	setRegoin(a241);
			else
				if(getRegoin().contains(a242))	setRegoin(a242);
			else
				if(getRegoin().contains(a243))	setRegoin(a243);
			else
				if(getRegoin().contains(a244))	setRegoin(a244);
	    	
			  return getRegoin(); 
			  }
	  
	  
	  
	  
	  
	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	public String getA3() {
		return a3;
	}

	public void setA3(String a3) {
		this.a3 = a3;
	}

	public String getA4() {
		return a4;
	}

	public void setA4(String a4) {
		this.a4 = a4;
	}

	public String getA5() {
		return a5;
	}

	public void setA5(String a5) {
		this.a5 = a5;
	}

	public String getA6() {
		return a6;
	}

	public void setA6(String a6) {
		this.a6 = a6;
	}

	public String getA8() {
		return a8;
	}

	public void setA8(String a8) {
		this.a8 = a8;
	}

	public String getA9() {
		return a9;
	}

	public void setA9(String a9) {
		this.a9 = a9;
	}

	public String getA10() {
		return a10;
	}

	public void setA10(String a10) {
		this.a10 = a10;
	}

	public String getA11() {
		return a11;
	}

	public void setA11(String a11) {
		this.a11 = a11;
	}

	public String getA12() {
		return a12;
	}

	public void setA12(String a12) {
		this.a12 = a12;
	}

	public String getA13() {
		return a13;
	}

	public void setA13(String a13) {
		this.a13 = a13;
	}

	public String getA14() {
		return a14;
	}

	public void setA14(String a14) {
		this.a14 = a14;
	}

	public String getA15() {
		return a15;
	}

	public void setA15(String a15) {
		this.a15 = a15;
	}

	public String getA16() {
		return a16;
	}

	public void setA16(String a16) {
		this.a16 = a16;
	}

	public String getA17() {
		return a17;
	}

	public void setA17(String a17) {
		this.a17 = a17;
	}

	public String getA18() {
		return a18;
	}

	public void setA18(String a18) {
		this.a18 = a18;
	}

	public String getA19() {
		return a19;
	}

	public void setA19(String a19) {
		this.a19 = a19;
	}

	public String getA20() {
		return a20;
	}

	public void setA20(String a20) {
		this.a20 = a20;
	}

	public String getA21() {
		return a21;
	}

	public void setA21(String a21) {
		this.a21 = a21;
	}

	public String getA22() {
		return a22;
	}

	public void setA22(String a22) {
		this.a22 = a22;
	}

	public String getA23() {
		return a23;
	}

	public void setA23(String a23) {
		this.a23 = a23;
	}

	public String getA24() {
		return a24;
	}

	public void setA24(String a24) {
		this.a24 = a24;
	}

	public String getA25() {
		return a25;
	}

	public void setA25(String a25) {
		this.a25 = a25;
	}

	public String getA26() {
		return a26;
	}

	public void setA26(String a26) {
		this.a26 = a26;
	}

	public String getA27() {
		return a27;
	}

	public void setA27(String a27) {
		this.a27 = a27;
	}

	public String getA28() {
		return a28;
	}

	public void setA28(String a28) {
		this.a28 = a28;
	}

	public String getA29() {
		return a29;
	}

	public void setA29(String a29) {
		this.a29 = a29;
	}

	public String getA30() {
		return a30;
	}

	public void setA30(String a30) {
		this.a30 = a30;
	}

	public String getA31() {
		return a31;
	}

	public void setA31(String a31) {
		this.a31 = a31;
	}

	public String getA32() {
		return a32;
	}

	public void setA32(String a32) {
		this.a32 = a32;
	}

	public String getA33() {
		return a33;
	}

	public void setA33(String a33) {
		this.a33 = a33;
	}

	public String getA34() {
		return a34;
	}

	public void setA34(String a34) {
		this.a34 = a34;
	}

	public String getA35() {
		return a35;
	}

	public void setA35(String a35) {
		this.a35 = a35;
	}

	public String getA36() {
		return a36;
	}

	public void setA36(String a36) {
		this.a36 = a36;
	}

	public String getA37() {
		return a37;
	}

	public void setA37(String a37) {
		this.a37 = a37;
	}

	public String getA38() {
		return a38;
	}

	public void setA38(String a38) {
		this.a38 = a38;
	}

	public String getA39() {
		return a39;
	}

	public void setA39(String a39) {
		this.a39 = a39;
	}

	public String getA40() {
		return a40;
	}

	public void setA40(String a40) {
		this.a40 = a40;
	}

	public String getA41() {
		return a41;
	}

	public void setA41(String a41) {
		this.a41 = a41;
	}

	public String getA42() {
		return a42;
	}

	public void setA42(String a42) {
		this.a42 = a42;
	}

	public String getA43() {
		return a43;
	}

	public void setA43(String a43) {
		this.a43 = a43;
	}

	public String getA44() {
		return a44;
	}

	public void setA44(String a44) {
		this.a44 = a44;
	}

	public String getA45() {
		return a45;
	}

	public void setA45(String a45) {
		this.a45 = a45;
	}

	public String getA46() {
		return a46;
	}

	public void setA46(String a46) {
		this.a46 = a46;
	}

	public String getA47() {
		return a47;
	}

	public void setA47(String a47) {
		this.a47 = a47;
	}

	public String getA48() {
		return a48;
	}

	public void setA48(String a48) {
		this.a48 = a48;
	}

	public String getA49() {
		return a49;
	}

	public void setA49(String a49) {
		this.a49 = a49;
	}

	public String getA50() {
		return a50;
	}

	public void setA50(String a50) {
		this.a50 = a50;
	}

	public String getA51() {
		return a51;
	}

	public void setA51(String a51) {
		this.a51 = a51;
	}

	public String getA52() {
		return a52;
	}

	public void setA52(String a52) {
		this.a52 = a52;
	}

	public String getA53() {
		return a53;
	}

	public void setA53(String a53) {
		this.a53 = a53;
	}

	public String getA54() {
		return a54;
	}

	public void setA54(String a54) {
		this.a54 = a54;
	}

	public String getA55() {
		return a55;
	}

	public void setA55(String a55) {
		this.a55 = a55;
	}

	public String getA56() {
		return a56;
	}

	public void setA56(String a56) {
		this.a56 = a56;
	}

	public String getA57() {
		return a57;
	}

	public void setA57(String a57) {
		this.a57 = a57;
	}

	public String getA58() {
		return a58;
	}

	public void setA58(String a58) {
		this.a58 = a58;
	}

	public String getA59() {
		return a59;
	}

	public void setA59(String a59) {
		this.a59 = a59;
	}

	public String getA60() {
		return a60;
	}

	public void setA60(String a60) {
		this.a60 = a60;
	}

	public String getA61() {
		return a61;
	}

	public void setA61(String a61) {
		this.a61 = a61;
	}

	public String getA62() {
		return a62;
	}

	public void setA62(String a62) {
		this.a62 = a62;
	}

	public String getA63() {
		return a63;
	}

	public void setA63(String a63) {
		this.a63 = a63;
	}

	public String getA64() {
		return a64;
	}

	public void setA64(String a64) {
		this.a64 = a64;
	}

	public String getA65() {
		return a65;
	}

	public void setA65(String a65) {
		this.a65 = a65;
	}

	public String getA66() {
		return a66;
	}

	public void setA66(String a66) {
		this.a66 = a66;
	}

	public String getA67() {
		return a67;
	}

	public void setA67(String a67) {
		this.a67 = a67;
	}

	public String getA68() {
		return a68;
	}

	public void setA68(String a68) {
		this.a68 = a68;
	}

	public String getA69() {
		return a69;
	}

	public void setA69(String a69) {
		this.a69 = a69;
	}

	public String getA70() {
		return a70;
	}

	public void setA70(String a70) {
		this.a70 = a70;
	}

	public String getA71() {
		return a71;
	}

	public void setA71(String a71) {
		this.a71 = a71;
	}

	public String getA72() {
		return a72;
	}

	public void setA72(String a72) {
		this.a72 = a72;
	}

	public String getA73() {
		return a73;
	}

	public void setA73(String a73) {
		this.a73 = a73;
	}

	public String getA74() {
		return a74;
	}

	public void setA74(String a74) {
		this.a74 = a74;
	}

	public String getA75() {
		return a75;
	}

	public void setA75(String a75) {
		this.a75 = a75;
	}

	public String getA76() {
		return a76;
	}

	public void setA76(String a76) {
		this.a76 = a76;
	}

	public String getA77() {
		return a77;
	}

	public void setA77(String a77) {
		this.a77 = a77;
	}

	public String getA78() {
		return a78;
	}

	public void setA78(String a78) {
		this.a78 = a78;
	}

	public String getA79() {
		return a79;
	}

	public void setA79(String a79) {
		this.a79 = a79;
	}

	public String getA80() {
		return a80;
	}

	public void setA80(String a80) {
		this.a80 = a80;
	}

	public String getA81() {
		return a81;
	}

	public void setA81(String a81) {
		this.a81 = a81;
	}

	public String getA82() {
		return a82;
	}

	public void setA82(String a82) {
		this.a82 = a82;
	}

	public String getA83() {
		return a83;
	}

	public void setA83(String a83) {
		this.a83 = a83;
	}

	public String getA84() {
		return a84;
	}

	public void setA84(String a84) {
		this.a84 = a84;
	}

	public String getA85() {
		return a85;
	}

	public void setA85(String a85) {
		this.a85 = a85;
	}

	public String getA86() {
		return a86;
	}

	public void setA86(String a86) {
		this.a86 = a86;
	}

	public String getA87() {
		return a87;
	}

	public void setA87(String a87) {
		this.a87 = a87;
	}

	public String getA88() {
		return a88;
	}

	public void setA88(String a88) {
		this.a88 = a88;
	}

	public String getA89() {
		return a89;
	}

	public void setA89(String a89) {
		this.a89 = a89;
	}

	public String getA90() {
		return a90;
	}

	public void setA90(String a90) {
		this.a90 = a90;
	}

	public String getA91() {
		return a91;
	}

	public void setA91(String a91) {
		this.a91 = a91;
	}

	public String getA92() {
		return a92;
	}

	public void setA92(String a92) {
		this.a92 = a92;
	}

	public String getA93() {
		return a93;
	}

	public void setA93(String a93) {
		this.a93 = a93;
	}

	public String getA94() {
		return a94;
	}

	public void setA94(String a94) {
		this.a94 = a94;
	}

	public String getA95() {
		return a95;
	}

	public void setA95(String a95) {
		this.a95 = a95;
	}

	public String getA96() {
		return a96;
	}

	public void setA96(String a96) {
		this.a96 = a96;
	}

	public String getA97() {
		return a97;
	}

	public void setA97(String a97) {
		this.a97 = a97;
	}

	public String getA98() {
		return a98;
	}

	public void setA98(String a98) {
		this.a98 = a98;
	}

	public String getA99() {
		return a99;
	}

	public void setA99(String a99) {
		this.a99 = a99;
	}

	public String getA100() {
		return a100;
	}

	public void setA100(String a100) {
		this.a100 = a100;
	}

	public String getA101() {
		return a101;
	}

	public void setA101(String a101) {
		this.a101 = a101;
	}

	public String getA102() {
		return a102;
	}

	public void setA102(String a102) {
		this.a102 = a102;
	}

	public String getA103() {
		return a103;
	}

	public void setA103(String a103) {
		this.a103 = a103;
	}

	public String getA104() {
		return a104;
	}

	public void setA104(String a104) {
		this.a104 = a104;
	}

	public String getA105() {
		return a105;
	}

	public void setA105(String a105) {
		this.a105 = a105;
	}

	public String getA106() {
		return a106;
	}

	public void setA106(String a106) {
		this.a106 = a106;
	}

	public String getA107() {
		return a107;
	}

	public void setA107(String a107) {
		this.a107 = a107;
	}

	public String getA108() {
		return a108;
	}

	public void setA108(String a108) {
		this.a108 = a108;
	}

	public String getA109() {
		return a109;
	}

	public void setA109(String a109) {
		this.a109 = a109;
	}

	public String getA110() {
		return a110;
	}

	public void setA110(String a110) {
		this.a110 = a110;
	}

	public String getA111() {
		return a111;
	}

	public void setA111(String a111) {
		this.a111 = a111;
	}

	public String getA112() {
		return a112;
	}

	public void setA112(String a112) {
		this.a112 = a112;
	}

	public String getA113() {
		return a113;
	}

	public void setA113(String a113) {
		this.a113 = a113;
	}

	public String getA114() {
		return a114;
	}

	public void setA114(String a114) {
		this.a114 = a114;
	}

	public String getA115() {
		return a115;
	}

	public void setA115(String a115) {
		this.a115 = a115;
	}

	public String getA116() {
		return a116;
	}

	public void setA116(String a116) {
		this.a116 = a116;
	}

	public String getA117() {
		return a117;
	}

	public void setA117(String a117) {
		this.a117 = a117;
	}

	public String getA118() {
		return a118;
	}

	public void setA118(String a118) {
		this.a118 = a118;
	}

	public String getA119() {
		return a119;
	}

	public void setA119(String a119) {
		this.a119 = a119;
	}

	public String getA120() {
		return a120;
	}

	public void setA120(String a120) {
		this.a120 = a120;
	}

	public String getA121() {
		return a121;
	}

	public void setA121(String a121) {
		this.a121 = a121;
	}

	public String getA122() {
		return a122;
	}

	public void setA122(String a122) {
		this.a122 = a122;
	}

	public String getA123() {
		return a123;
	}

	public void setA123(String a123) {
		this.a123 = a123;
	}

	public String getA124() {
		return a124;
	}

	public void setA124(String a124) {
		this.a124 = a124;
	}

	public String getA125() {
		return a125;
	}

	public void setA125(String a125) {
		this.a125 = a125;
	}

	public String getA126() {
		return a126;
	}

	public void setA126(String a126) {
		this.a126 = a126;
	}

	public String getA127() {
		return a127;
	}

	public void setA127(String a127) {
		this.a127 = a127;
	}

	public String getA128() {
		return a128;
	}

	public void setA128(String a128) {
		this.a128 = a128;
	}

	public String getA129() {
		return a129;
	}

	public void setA129(String a129) {
		this.a129 = a129;
	}

	public String getA130() {
		return a130;
	}

	public void setA130(String a130) {
		this.a130 = a130;
	}

	public String getA131() {
		return a131;
	}

	public void setA131(String a131) {
		this.a131 = a131;
	}

	public String getA132() {
		return a132;
	}

	public void setA132(String a132) {
		this.a132 = a132;
	}

	public String getA133() {
		return a133;
	}

	public void setA133(String a133) {
		this.a133 = a133;
	}

	public String getA134() {
		return a134;
	}

	public void setA134(String a134) {
		this.a134 = a134;
	}

	public String getA135() {
		return a135;
	}

	public void setA135(String a135) {
		this.a135 = a135;
	}

	public String getA136() {
		return a136;
	}

	public void setA136(String a136) {
		this.a136 = a136;
	}

	public String getA137() {
		return a137;
	}

	public void setA137(String a137) {
		this.a137 = a137;
	}

	public String getA138() {
		return a138;
	}

	public void setA138(String a138) {
		this.a138 = a138;
	}

	public String getA139() {
		return a139;
	}

	public void setA139(String a139) {
		this.a139 = a139;
	}

	public String getA140() {
		return a140;
	}

	public void setA140(String a140) {
		this.a140 = a140;
	}

	public String getA141() {
		return a141;
	}

	public void setA141(String a141) {
		this.a141 = a141;
	}

	public String getA142() {
		return a142;
	}

	public void setA142(String a142) {
		this.a142 = a142;
	}

	public String getA143() {
		return a143;
	}

	public void setA143(String a143) {
		this.a143 = a143;
	}

	public String getA144() {
		return a144;
	}

	public void setA144(String a144) {
		this.a144 = a144;
	}

	public String getA145() {
		return a145;
	}

	public void setA145(String a145) {
		this.a145 = a145;
	}

	public String getA146() {
		return a146;
	}

	public void setA146(String a146) {
		this.a146 = a146;
	}

	public String getA147() {
		return a147;
	}

	public void setA147(String a147) {
		this.a147 = a147;
	}

	public String getA148() {
		return a148;
	}

	public void setA148(String a148) {
		this.a148 = a148;
	}

	public String getA149() {
		return a149;
	}

	public void setA149(String a149) {
		this.a149 = a149;
	}

	public String getA150() {
		return a150;
	}

	public void setA150(String a150) {
		this.a150 = a150;
	}

	public String getA170() {
		return a170;
	}

	public void setA170(String a170) {
		this.a170 = a170;
	}

	public String getA171() {
		return a171;
	}

	public void setA171(String a171) {
		this.a171 = a171;
	}

	public String getA172() {
		return a172;
	}

	public void setA172(String a172) {
		this.a172 = a172;
	}

	public String getA173() {
		return a173;
	}

	public void setA173(String a173) {
		this.a173 = a173;
	}

	public String getA174() {
		return a174;
	}

	public void setA174(String a174) {
		this.a174 = a174;
	}

	public String getA175() {
		return a175;
	}

	public void setA175(String a175) {
		this.a175 = a175;
	}

	public String getA176() {
		return a176;
	}

	public void setA176(String a176) {
		this.a176 = a176;
	}

	public String getA177() {
		return a177;
	}

	public void setA177(String a177) {
		this.a177 = a177;
	}

	public String getA178() {
		return a178;
	}

	public void setA178(String a178) {
		this.a178 = a178;
	}

	public String getA179() {
		return a179;
	}

	public void setA179(String a179) {
		this.a179 = a179;
	}

	public String getA180() {
		return a180;
	}

	public void setA180(String a180) {
		this.a180 = a180;
	}

	public String getA181() {
		return a181;
	}

	public void setA181(String a181) {
		this.a181 = a181;
	}

	public String getA182() {
		return a182;
	}

	public void setA182(String a182) {
		this.a182 = a182;
	}

	public String getA183() {
		return a183;
	}

	public void setA183(String a183) {
		this.a183 = a183;
	}

	public String getA184() {
		return a184;
	}

	public void setA184(String a184) {
		this.a184 = a184;
	}

	public String getA185() {
		return a185;
	}

	public void setA185(String a185) {
		this.a185 = a185;
	}

	public String getA186() {
		return a186;
	}

	public void setA186(String a186) {
		this.a186 = a186;
	}

	public String getA187() {
		return a187;
	}

	public void setA187(String a187) {
		this.a187 = a187;
	}

	public String getA188() {
		return a188;
	}

	public void setA188(String a188) {
		this.a188 = a188;
	}

	public String getA189() {
		return a189;
	}

	public void setA189(String a189) {
		this.a189 = a189;
	}

	public String getA190() {
		return a190;
	}

	public void setA190(String a190) {
		this.a190 = a190;
	}

	public String getA191() {
		return a191;
	}

	public void setA191(String a191) {
		this.a191 = a191;
	}

	public String getA192() {
		return a192;
	}

	public void setA192(String a192) {
		this.a192 = a192;
	}

	public String getA193() {
		return a193;
	}

	public void setA193(String a193) {
		this.a193 = a193;
	}

	public String getA194() {
		return a194;
	}

	public void setA194(String a194) {
		this.a194 = a194;
	}

	public String getA195() {
		return a195;
	}

	public void setA195(String a195) {
		this.a195 = a195;
	}

	public String getA196() {
		return a196;
	}

	public void setA196(String a196) {
		this.a196 = a196;
	}

	public String getA197() {
		return a197;
	}

	public void setA197(String a197) {
		this.a197 = a197;
	}

	public String getA198() {
		return a198;
	}

	public void setA198(String a198) {
		this.a198 = a198;
	}

	public String getA199() {
		return a199;
	}

	public void setA199(String a199) {
		this.a199 = a199;
	}

	public String getA200() {
		return a200;
	}

	public void setA200(String a200) {
		this.a200 = a200;
	}

	public String getA201() {
		return a201;
	}

	public void setA201(String a201) {
		this.a201 = a201;
	}

	public String getA202() {
		return a202;
	}

	public void setA202(String a202) {
		this.a202 = a202;
	}

	public String getA203() {
		return a203;
	}

	public void setA203(String a203) {
		this.a203 = a203;
	}

	public String getA204() {
		return a204;
	}

	public void setA204(String a204) {
		this.a204 = a204;
	}

	public String getA205() {
		return a205;
	}

	public void setA205(String a205) {
		this.a205 = a205;
	}

	public String getA206() {
		return a206;
	}

	public void setA206(String a206) {
		this.a206 = a206;
	}

	public String getA207() {
		return a207;
	}

	public void setA207(String a207) {
		this.a207 = a207;
	}

	public String getA208() {
		return a208;
	}

	public void setA208(String a208) {
		this.a208 = a208;
	}

	public String getA209() {
		return a209;
	}

	public void setA209(String a209) {
		this.a209 = a209;
	}

	public String getA210() {
		return a210;
	}

	public void setA210(String a210) {
		this.a210 = a210;
	}

	public String getA211() {
		return a211;
	}

	public void setA211(String a211) {
		this.a211 = a211;
	}

	public String getA222() {
		return a222;
	}

	public void setA222(String a222) {
		this.a222 = a222;
	}

	public String getA223() {
		return a223;
	}

	public void setA223(String a223) {
		this.a223 = a223;
	}

	public String getA224() {
		return a224;
	}

	public void setA224(String a224) {
		this.a224 = a224;
	}

	public String getA225() {
		return a225;
	}

	public void setA225(String a225) {
		this.a225 = a225;
	}

	public String getA226() {
		return a226;
	}

	public void setA226(String a226) {
		this.a226 = a226;
	}

	public String getA227() {
		return a227;
	}

	public void setA227(String a227) {
		this.a227 = a227;
	}

	public String getA228() {
		return a228;
	}

	public void setA228(String a228) {
		this.a228 = a228;
	}

	public String getA229() {
		return a229;
	}

	public void setA229(String a229) {
		this.a229 = a229;
	}

	public String getA230() {
		return a230;
	}

	public void setA230(String a230) {
		this.a230 = a230;
	}

	public String getA231() {
		return a231;
	}

	public void setA231(String a231) {
		this.a231 = a231;
	}

	public String getA232() {
		return a232;
	}

	public void setA232(String a232) {
		this.a232 = a232;
	}

	public String getA233() {
		return a233;
	}

	public void setA233(String a233) {
		this.a233 = a233;
	}

	public String getA234() {
		return a234;
	}

	public void setA234(String a234) {
		this.a234 = a234;
	}

	public String getA235() {
		return a235;
	}

	public void setA235(String a235) {
		this.a235 = a235;
	}

	public String getA236() {
		return a236;
	}

	public void setA236(String a236) {
		this.a236 = a236;
	}

	public String getA237() {
		return a237;
	}

	public void setA237(String a237) {
		this.a237 = a237;
	}

	public String getA238() {
		return a238;
	}

	public void setA238(String a238) {
		this.a238 = a238;
	}

	public String getA239() {
		return a239;
	}

	public void setA239(String a239) {
		this.a239 = a239;
	}

	public String getA240() {
		return a240;
	}

	public void setA240(String a240) {
		this.a240 = a240;
	}

	public String getA241() {
		return a241;
	}

	public void setA241(String a241) {
		this.a241 = a241;
	}

	public String getA243() {
		return a243;
	}

	public void setA243(String a243) {
		this.a243 = a243;
	}

	public String getA242() {
		return a242;
	}

	public void setA242(String a242) {
		this.a242 = a242;
	}

	public String getA244() {
		return a244;
	}

	public void setA244(String a244) {
		this.a244 = a244;
	}

	
    public String getA0() {
		return a0;
	}


	public void setA0(String a0) {
		this.a0 = a0;
	}


	public String getA212() {
		return a212;
	}


	public void setA212(String a212) {
		this.a212 = a212;
	}


	public String getA213() {
		return a213;
	}


	public void setA213(String a213) {
		this.a213 = a213;
	}


	public String getA214() {
		return a214;
	}


	public void setA214(String a214) {
		this.a214 = a214;
	}


	public String getA215() {
		return a215;
	}


	public void setA215(String a215) {
		this.a215 = a215;
	}


	public String getA216() {
		return a216;
	}


	public void setA216(String a216) {
		this.a216 = a216;
	}


	public String getA217() {
		return a217;
	}


	public void setA217(String a217) {
		this.a217 = a217;
	}


	public String getA218() {
		return a218;
	}


	public void setA218(String a218) {
		this.a218 = a218;
	}


	public String getA219() {
		return a219;
	}


	public void setA219(String a219) {
		this.a219 = a219;
	}


	public String getA220() {
		return a220;
	}


	public void setA220(String a220) {
		this.a220 = a220;
	}


	public String getA221() {
		return a221;
	}


	public void setA221(String a221) {
		this.a221 = a221;
	}





	
}
