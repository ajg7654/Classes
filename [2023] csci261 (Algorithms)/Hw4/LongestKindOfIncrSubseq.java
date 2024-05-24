import java.util.Scanner;

class LongestKindOfIncrSubseq {
	public static void log(Object a, boolean nl){
		String log = "" + a;
		if(nl)
			System.out.println(log);
		else 
			System.out.print(log);
	}

	public static void log_pair(Object a, Object b, boolean nl){
		String log = "(" + a + ", " + b + ")";
		if(nl)
			System.out.println(log);
		else 
			System.out.print(log);
	}

	public static void update_length(int[][] lengths, int i, int[] a){
		for(int j = 1; j < i; j++){
			
			int max_j_length = 1;

			for(int k = 0; k < j; k++){
				if((a[k] + a[j])/2 < a[i] && lengths[j][k] > max_j_length){
					max_j_length = lengths[j][k];
				}
			}

			lengths[i][j] = 1 + max_j_length;
		}
	}

	public static int longest_kind_of_subsequence(int n, int[] a){
		int[][] lengths = new int[n][n];

		for(int j = 2; j < n; j++){
			for(int k = 0; k < j; k++){
				lengths[j][k] = 3;
			}
		}

		for(int i = 2; i < n; i++){
			update_length(lengths, i, a);
		}

		int max_length = 0;

		for(int i = 2; i < n; i++){
			for(int j = 0; j < i; j++){
				int length = lengths[i][j];

				if(length > max_length)
					max_length = length;
			}
		}

		return max_length;//lengths[n-1][n-2];
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		/*
		int n = input.nextInt();
		int[] numbers = new int[n];

		for(int i = 0; i < n; i++){
			numbers[i] = input.nextInt();
		}

		*/

		int n = 1000;
		int[] numbers = {5364,13427,29779,20876,15241,12300,21698,21199,31560,9326,25082,23627,31405,17656,19825,14057,1800,29066,24597,3633,19153,25483,830,9581,15931,11313,21985,26635,1547,26620,8710,22852,13483,19332,18044,9979,8570,28021,26827,25576,19047,29144,874,11509,29630,31380,9266,15848,31297,308,28435,14659,2939,32234,14598,10088,14417,32724,20290,28929,5594,6783,16051,22687,24689,19626,12200,14241,21768,17484,10700,600,13503,9176,21591,22377,9909,11455,1669,7794,27677,29494,15432,31216,6805,32571,17209,4192,20660,32466,13269,28836,6370,28053,2790,5545,28269,21867,30527,19783,6361,3224,12204,1640,20855,5366,25897,19053,26425,129,9554,26061,21700,32537,16667,1023,31943,31108,3009,17051,139,23987,1537,32700,25804,70,18823,26536,30920,14162,18601,1459,13205,4705,13909,23648,31671,21434,10824,18634,3314,3811,21889,13634,28765,4197,23286,24378,15032,29391,8325,13410,1279,1277,11309,2832,21311,26010,24958,14821,23977,30692,13134,21166,28645,5551,7598,1160,21161,8877,31773,26952,29577,25836,4091,16921,16145,18080,19264,26471,24849,25891,13165,28668,24376,4410,28867,21353,16868,9370,23987,2984,16185,20651,10903,31231,7281,19083,27039,4903,14706,30806,5902,5806,31398,933,29094,21914,1287,30036,14176,19535,121,16009,6753,5043,21597,21233,554,28047,4707,14413,27919,28729,927,12078,1514,5488,3040,22780,16912,12423,22333,32573,7044,4038,1520,24596,15211,19725,19048,9224,10432,4538,11673,24839,20297,20941,28055,20139,29386,16970,10851,4028,25208,3807,21764,13557,176,4807,5338,23819,29417,6382,5936,5611,3560,26454,32016,25411,21043,6585,23387,3653,3271,3952,281,8872,28685,28819,30733,15599,14603,3682,29580,3565,13527,8931,8592,14217,14930,13261,4617,26303,27666,7333,10355,20199,22176,1063,19373,27194,16100,16615,18441,9106,13533,28984,6048,19825,16022,19021,1256,2629,12117,25246,23432,2538,32533,31629,7018,16497,13878,3658,25106,31264,16756,8180,32303,28857,16918,8449,24944,17920,11879,23519,25753,1911,22122,14043,4566,8044,8394,19779,26959,22325,5136,9159,21500,20155,24,31781,14523,3381,23494,3078,26528,3894,10997,6946,20364,30186,176,19627,12801,15260,29093,6121,18740,4476,2774,13346,5220,19104,8338,31676,15979,30792,2468,2725,21139,7014,6858,7155,13226,3934,30313,27336,2393,4618,1150,6777,6065,3329,9944,27119,13575,1049,32133,13901,20994,19754,20362,4306,18418,29973,27607,27650,24931,30213,5753,9216,20723,8949,22034,26175,2656,27763,13702,15449,12773,25251,19960,15935,5575,6278,11509,12179,26155,19580,27374,3154,7978,31240,1516,18614,22823,14548,21631,18523,29536,3317,9463,20640,19652,3183,23767,31312,32517,32252,11399,26242,20461,21769,11081,15037,19701,12034,28526,10336,17684,13775,30410,833,5333,2975,29541,11157,30892,9188,20595,20240,22922,11678,903,17741,18351,29405,32259,2927,6080,20865,21203,8969,22041,12613,25691,22587,1124,6908,11949,13086,21866,21786,512,6242,23338,10613,16734,23862,23336,14413,31132,21096,15624,31882,25743,2766,18267,25926,11389,24804,7865,10379,978,32694,15120,13150,25876,29441,18235,23292,3865,661,7895,13155,4472,23805,24146,12052,32061,21858,14660,27672,3553,14509,2819,21057,24185,32236,21874,26290,32557,22007,8729,30881,32492,24147,31099,2908,15710,31574,25763,8586,6426,7564,11521,19892,19994,30298,20084,11268,6251,24545,20392,10572,28457,31781,29858,15177,27563,20335,32665,28202,12539,23024,29704,27468,26505,29862,4097,23880,8480,30084,28612,21807,14616,24269,3984,5396,1230,7617,8121,25547,26705,7291,24315,19953,9054,11034,28430,30764,27279,1055,22394,26292,8399,28694,10925,24083,17681,19577,331,16681,26690,31185,16325,4210,16251,29982,23085,28300,9852,8313,2633,19955,9814,32504,11238,11280,21607,26578,13166,32114,7563,29891,29373,12123,20881,12210,8241,25214,748,17298,21504,17159,3755,13446,28623,8668,24748,25416,9344,13090,18444,24523,2635,5636,28641,20255,32528,2479,20524,26774,16107,29601,11017,20005,27402,6948,27177,17420,29371,15893,28802,3001,4809,25322,13381,26090,24329,3060,13585,19,2608,12256,8806,20735,24551,7044,18012,10425,9506,8409,2197,30637,21165,14147,7536,4363,24071,28953,13695,27756,1140,27233,16700,10936,19534,5339,7415,25159,12444,1346,14611,30278,10982,9678,4722,32093,3911,29181,3886,31630,28355,8083,5002,29537,29659,22751,25384,4670,27999,27713,8828,31770,31620,5353,3200,31318,4918,16609,12457,4579,19375,30798,19738,17579,10825,18931,6425,556,24720,24822,5055,2918,12444,10215,10995,19960,27550,7422,20121,31366,16056,15268,17414,23133,16914,7989,19895,10330,32298,17157,31555,28936,23403,929,13711,15880,12290,17751,23361,4278,24557,25592,375,28681,17236,20444,11448,3515,18205,31783,5675,18090,31675,587,20742,639,1606,7886,25674,13965,10193,27470,11438,4092,20216,31170,6872,2342,26552,13570,8659,28225,23940,10890,27070,5439,916,8570,6849,19698,22401,8930,21574,18292,21007,22333,9317,966,14921,23867,5023,31415,11988,32196,6352,4871,22909,24889,2399,8397,276,10749,22968,29718,28029,6196,16892,15055,20996,6858,6902,14821,12785,29111,1874,8618,29532,17794,15625,379,5187,22532,800,7840,13786,12911,14226,12915,29218,29839,29067,21444,12221,10575,5078,3965,26625,17534,25497,29826,4939,11731,30528,5851,12182,32047,4535,19989,5452,19491,15836,13029,3675,16562,15924,8207,25484,13656,9436,14982,21521,8779,10179,17621,11100,11264,1303,16829,26936,31473,3069,10784,12306,16542,7557,14878,28055,3537,14813,6525,29061,24103,28101,25422,26298,31948,13378,20685,25234,9862,8343,2954,32367,3317,25713,27334,12185,7961,1634,8224,20809,15124,23696,6001,5376,11569,8111,3572,19741,8230,10796,9386,17839,25238,14251,29180,8072,9690,14516,22179,24979,6657,3753,6597,13415,2837,17404,4192,31771,25504,5278,21484,17500,14447,23227,19516,12990,16790,13220,4262,29520,25781,28941,25699,21363,13433,10872,21048,32492,2405,753,11094,4919,6098,30460,28032 };
		log(longest_kind_of_subsequence(n, numbers), true);

	}
}