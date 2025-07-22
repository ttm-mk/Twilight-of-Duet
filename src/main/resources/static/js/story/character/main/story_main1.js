/**
 * ストーリー：メイン制御
 * 更新日：2025/7/5
 */

const userId = /*[[${userId}]]*/ 1;

// クリックカウント用
let count = 0;
let texts = [];
let imagesLeft = [];
let imagesRight = [];
let background = [];

// 名前、あだ名、StoryId、MainStoryIntの取得
Promise.all([
  fetch(`http://localhost:2102/TwilightOfDuet/api/users/heroine`).then(res => res.text()),
  fetch(`http://localhost:2102/TwilightOfDuet/api/users/heroine-nickname`).then(res => res.text())

])

.then(([heroineName, heroineNickname]) => {
  // 値がなければデフォルトを使う
  if (!heroineName) heroineName = "鳴海千晴";
  if (!heroineNickname) heroineNickname = "ちい";

    // ヒロイン名を差し込んだテキスト配列を作る
    texts = [
		"メインストーリー　1話",
		`？？？：${heroineNickname}`,
		"園山巧美（そのやまたくみ）",
		"奏花高等学校普通科2年。鳴海千晴の幼なじみのチェロ奏者。",
		`${heroineName}：みいくん`,
		`巧美：緊張してる？${heroineNickname}、楽しみにしてたもんね`,
		"今日は待ちに待った本校音楽科恒例のチャリティーコンサートの説明会の日。",
		"今年度から音楽科外の参加が可能となり、私はいち早く応募したのだ。",
		"巧美：思ったより少ないね、人数。",
		`${heroineName}：みいくんも思った？私も思った。人気ないのかなぁ、チャリティーコンサート`,
		"キリーンコローンカラーンコローン",
		"先生：はーいチャリティーコンサートにご参加のみなさん、最終授業後のご参列お疲れ様です",
		"先生：僕は音楽科指揮専攻担当教員の”下加茂八鳥（しもがもやとり）”と言います",
		"八鳥：さて、君たちは毎年恒例のチャリティーコンサートに参加するわけですが、前年度までは奏花高等学校の音楽科のみ参加可能の行事でした",
		"私たちが通う学校『奏花高等学校』は普通科、特進科、音楽科の3学科がある高校だ。",
		"それぞれの学科は”学科棟”でわかれており、授業においての接点が一切なかった。",
		"八鳥：奏花高等学校学長が、他の学科の生徒同士の触れ合いを取り入れたいという意向から、チャリティーコンサート参加者に学科の制限をなくすことにしたんですよね",
		"八鳥：このメンバーは新設☆チャリティーコンサートの第1期生ってことですね",
		"生徒一同：・・・・・・・・。",
		"八鳥：では、時間も惜しいので簡単に説明しますね。毎年参加してる生徒さんも一旦お口チャック",
		"八鳥：このチャリティーコンサートは4月から3月まで放課後の時間を使って準備をします",
		"八鳥：3月の第1金曜日の最終授業後に、ここ音楽科棟講堂でコンサートを開きます。チームは金管、木管、弦楽それぞれで組んでもらいますからね",
		"八鳥：ただのチャリティーコンサートとあなどるなかれ、毎年音楽科のOBやOG、来賓の方々も参列して聴いていただいてます。演奏が学校の評価になりますので、最後までしっかり練習してくださいね",
		"どうやらこのチャリティーコンサート、想像よりも格式高いコンサートのようだ。普通科の私が参加してもよいのだろうか・・・すこし心配になってきた。",
		"八鳥：それでは今から言う箇所に集まってくださいね。えーっと、金管はステージ・・・・",
		`${heroineName}：緊張するね`,
		"巧美：そうか？誰が一緒でもすることは変わらないだろ",
		`${heroineName}：みいくんはそうだろうけど、私は心配だよ。ついていけるかなぁ`,
		`巧美：${heroineNickname}は音にでるもんな、全部`,
		`${heroineName}：もー！他人事だと思って！みいくんは心配じゃないの？`,
		"巧美：全然余裕",
		"八鳥：・・・・弦楽はメイン出入口前に集まってください。はいっ、移動～！",
		"八鳥が手を叩くと、散り散りに座っていた生徒たちが立ち上がり、指定された場所に移動し始めた。",
		`巧美：${heroineNickname}、行こうか`,

		"？？？：君たちも弦楽かい？",
		"？？？：もしかして普通科の方ですか？",
		"巧美：弦楽は4人だけ、でしょうか",
		"？？？：そのようだね。なら、まずは自己紹介かな",
		"？？？：僕は『須王御幸（すおうみゆき）』、音楽科3年生。ヴィオラ専攻だよ。毎年このチャリティーコンサートに参加してるから、何でも聞いてね",
		"須王御幸（すおうみゆき）",
		"奏花高等学校音楽科3年。2専攻：ヴィオラ",
		"？？？：『小早川颯真（こばやかわそうま）』、音楽科1年でヴァイオリン専攻です。・・・・足手まといにならないようにお願いします",
		"小早川颯真",
		"奏花高等学校1年。専攻：ヴァイオリン",
		"巧美：園山巧美、普通科2年でチェロしてます",
		`${heroineName}：${heroineName}です、みいくんと同じ普通科2年です。ヴァイオリン弾いてます。よろしくお願いします・・・！`,
		"御幸：ふたりともよろしくね。さて、八鳥先生からの説明もあったけど、チャリティーコンサートまでの流れを軽く僕から説明しておきたいんだけど",
		"御幸：みんな、部活動には入ってない？",
		"こくり",
		"御幸：オーケー。なら問題ないね",
		"御幸：チャリティーコンサートの準備と練習は放課後の時間を使ってするから、ほとんど部活動みたいなものなんだ",
		"御幸：チーム分け、曲決め、練習、リハーサルをして本番になるんだ。基本的に先生たちは関与しない、生徒たちで全て作り上げていくんだ",
		"颯真：先生は何をするんです？引率だけですか？",
		"御幸：引率もだけれど、生徒たちやチャリティーコンサート自体の全般の管理はしてもらえるよ",
		"御幸：だから、僕たちは音楽にだけ集中できるんだ",
		"御幸：これからすぐに曲決めをして、そのあと練習に移るよ。時間は限られているからね",
		"巧美：あの、チーム決めっていうのが最初でしたが、俺たち4人だけの場合はどうするんですか。カルテットでも組むんですか？",
		"御幸：そうだねえ、ヴァイオリン2、ヴィオラ1、チェロ1ならそうした方が無難だと思うけど、みんなどうかな",
		"颯真：俺もいいと思います",
		"巧美：右に同じで",
		"私もこくりと頷いた。",
		"御幸：オーケー。じゃあカルテットでいこう。",
		"颯真：そうなると曲決めですか。御幸先輩は、いつもはどうされてたんですか",
		"御幸：うーん、大体組むメンバーが決まったら持ち帰りで考えて翌日から意見まとめてたかな",
		"巧美：あ、俺、先輩たちの音しらないんで、1回音を聴いておきたいです。曲決めの参考になると思うので",
		"御幸：あ、そうだね。じゃあみんな1曲弾いてみようか。まずは僕からいくね",
		"マラン・マレ：5つの古いフランス舞曲集",
		"概要すこし書く",
		`${heroineName}：（伸びやかな優しい音。ヴィオラの音域が須王先輩に合ってる）`,
		"颯真：次、俺弾きます",
		"アントニオ・ヴィヴァルディ：『調和の霊感』作品3の第6番ヴァイオリン協奏曲イ短調",
		"概要すこし書く",
		`${heroineName}：（力強くてかっこいいヴァイオリンの音だ。芯がしっかりしていてすごく上手い）`,
		"御幸：さすが颯真くん、新入生代表だっただけはあるね",
		"颯真：しってたんすか。あざっす・・・・",
		"御幸：普通科のふたりも、弾いてくれるかな",
		"巧美：わかりました。じゃあ俺から",
		"J.S.バッハ：無伴奏チェロ組曲",
		"概要すこし書く",
		`${heroineName}：（みいくんの音色は落ち着くなあ。流れるように音符が耳に届く）`,
		"御幸：びっくりした。すごく上手いんだね",
		`巧美：ありがとうございます。ほら、${heroineNickname}も`,
		`${heroineName}：あ、うん。じゃあ、私も弾きます`,
		"弓を構えるが、緊張のせいで音が震える。",
		"御幸：・・・驚いた。普通科に弾ける子たちがいるなんて。どうして音楽科に来なかったのか不思議なくらいだ",
		"巧美：みんな弾いたと思うんですけど、どうですか。すぐ決められそうです？",
		"御幸：いや、一旦今日は持ち帰りたいかな。颯真くんもそれでいいかな",
		"颯真：問題ないです",
		"御幸：じゃあ各自持ち帰って、今週末の放課後に集まって決めようか。",
		"御幸：集合場所はおって連絡するから、みんなのPINE教えてくれる？",
		"颯真：わかりました",
		"巧美：はい",
		"私もみんなと同様にスマホを出して先輩のQRコードを読み取った。",
		"御幸：みんなありがと。これでグループに設定して・・・。",
		"御幸：・・・はい。グループ作っておいたから、各自連絡あったらここにちょうだい",
		"キリーンコローンカラーンコロ―ン・・・・",
		"御幸：5時のチャイムか。ちょうどいい、今日はこれで解散にしようか",
		"颯真：すみません、俺用事あるんで先に帰ります。お疲れ様っす",
		"御幸：おつかれ～。君たちももう帰って大丈夫だから。それじゃあまたね",
		"巧美：お疲れさまでした",
		`${heroineName}：お疲れ様です`,
		"巧美：なんか自由な二人だったな",
		`${heroineName}：そうだね。でもわくわくするかも`,
		"巧美：そうだな、思ったよりはなんとかなりそうな気はするかな",
		"巧美：それじゃあ俺らも帰るか",
		`${heroineName}：うん・・・・あれ？`,
		"",
		"巧美：どうした？",
		`${heroineName}：（いま、たとくんがいたような・・・気のせいかな）`,
		`${heroineName}：ううん。なんでもないよ。帰ろっか`,
		"？？？：やったー！あたしこれ大好きなんだ～。うれしー！",
		"巧美：わ、ギャルがいる・・・・",
		`${heroineName}：みいくんギャルに反応しすぎだよ、苦手臭でてるよ？`,
		"巧美：仕方ないだろ、中学の時に絡まれてからほんっとうにだめなんだって知ってるだろ？",
		`${heroineName}：あの人たちだってみいくんとお話したかっただけだと思うけど`,
		"巧美：ばっか！あの人種がそれだけで終わると思うか？俺には無理・・・・",
		`${heroineName}：（トラウマになってるなあ・・・・、仕方ないけどね）`,
		`巧美：${heroineNickname}、早くでよ。鳥肌たってくる・・・・`,
		`${heroineName}：うん、帰ろ～。次の集まり楽しみ～！`,
		"次集まるのは金曜日。",
		"みんなの音を反芻しながら、私は家路を急いだ。",
		"メインストーリー　1話　了"

    ];
	
	imagesLeft = [
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_s.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/smile/takumi_smile_m.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/smile/takumi_smile_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/smile/takumi_smile_m.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",

		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/smile/miyuki_smile_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/smile/miyuki_smile_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/smile/miyuki_smile_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_s.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/smile/miyuki_smile_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_s.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_s.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_s.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_s.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_s.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_m.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/smile/miyuki_smile_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/smile/miyuki_smile_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/smile/miyuki_smile_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/smile/miyuki_smile_n.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/smile/miyuki_smile_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/smile/miyuki_smile_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/smile/miyuki_smile_m.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_s.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_s.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_s.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_s.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_s.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png"
		
	];
	
	imagesRight = [
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",

		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_s.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_s.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_s.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_s.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_s.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/smile/miyuki_smile_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_n.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_m.png",
		"/TwilightOfDuet/assets/images/character/SuoMiyuki/normal/miyuki_normal_n.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_s.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakumi/normal/takumi_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_s.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_s.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_n.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/character/KobayakawaSoma/normal/soma_normal_s.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/character/SonoyamaTakuto/normal/takuto_normal_n.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/character/AiraMiru/normal/miru_normal_n.png",
		"/TwilightOfDuet/assets/images/character/AiraMiru/normal/miru_normal_n.png",
		"/TwilightOfDuet/assets/images/character/AiraMiru/normal/miru_normal_n.png",
		"/TwilightOfDuet/assets/images/character/AiraMiru/normal/miru_normal_n.png",
		"/TwilightOfDuet/assets/images/character/AiraMiru/normal/miru_normal_n.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png",
		"/TwilightOfDuet/assets/images/common/none.png"

	];
	
	background = [
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",

		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png",
		"/TwilightOfDuet/assets/images/background/facility.png"

	    ];
	
	// 初回表示（任意）
	document.getElementById('textMain1').textContent = texts[0];
	document.getElementById('imagesLeft').src = imagesLeft[0];
	document.getElementById('imagesRight').src = imagesRight[0];
	document.getElementById('background').src = background[0];
	
	
    // イベント設定（この中でやってもいい）
    document.getElementById('clickArea_main1').addEventListener('click', changeObject);

  })
  .catch(error => {
    console.error("名前の取得失敗:", error);
	
    // 失敗したときも同じようにデフォルトで動かす
    texts = [
		"メインストーリー　1話",
		"？？？：ちい",
		"園山巧美（そのやまたくみ）",
		"奏花高等学校普通科2年。鳴海千晴の幼なじみのチェロ奏者。",
		"鳴海千晴：みいくん",
		"巧美：緊張してる？ちい、楽しみにしてたもんね",
		"今日は待ちに待った本校音楽科恒例のチャリティーコンサートの説明会の日。",
		"今年度から音楽科外の参加が可能となり、私はいち早く応募したのだ。",
		"巧美：思ったより少ないね、人数。",
		"鳴海千晴：みいくんも思った？私も思った。人気ないのかなぁ、チャリティーコンサート",
		"キリーンコローンカラーンコローン",
		"先生：はーいチャリティーコンサートにご参加のみなさん、最終授業後のご参列お疲れ様です",
		"先生：僕は音楽科指揮専攻担当教員の”下加茂八鳥（しもがもやとり）”と言います",
		"八鳥：さて、君たちは毎年恒例のチャリティーコンサートに参加するわけですが、前年度までは奏花高等学校の音楽科のみ参加可能の行事でした",
		"私たちが通う学校『奏花高等学校』は普通科、特進科、音楽科の3学科がある高校だ。",
		"それぞれの学科は”学科棟”でわかれており、授業においての接点が一切なかった。",
		"八鳥：奏花高等学校学長が、他の学科の生徒同士の触れ合いを取り入れたいという意向から、チャリティーコンサート参加者に学科の制限をなくすことにしたんですよね",
		"八鳥：このメンバーは新設☆チャリティーコンサートの第1期生ってことですね",
		"生徒一同：・・・・・・・・。",
		"八鳥：では、時間も惜しいので簡単に説明しますね。毎年参加してる生徒さんも一旦お口チャック",
		"八鳥：このチャリティーコンサートは4月から3月まで放課後の時間を使って準備をします",
		"八鳥：3月の第1金曜日の最終授業後に、ここ音楽科棟講堂でコンサートを開きます。チームは金管、木管、弦楽それぞれで組んでもらいますからね",
		"八鳥：ただのチャリティーコンサートとあなどるなかれ、毎年音楽科のOBやOG、来賓の方々も参列して聴いていただいてます。演奏が学校の評価になりますので、最後までしっかり練習してくださいね",
		"どうやらこのチャリティーコンサート、想像よりも格式高いコンサートのようだ。普通科の私が参加してもよいのだろうか・・・すこし心配になってきた。",
		"八鳥：それでは今から言う箇所に集まってくださいね。えーっと、金管はステージ・・・・",
		"鳴海千晴：緊張するね",
		"巧美：そうか？誰が一緒でもすることは変わらないだろ",
		"鳴海千晴：みいくんはそうだろうけど、私は心配だよ。ついていけるかなぁ",
		"巧美：ちいは音にでるもんな、全部",
		"鳴海千晴：もー！他人事だと思って！みいくんは心配じゃないの？",
		"巧美：全然余裕",
		"八鳥：・・・・弦楽はメイン出入口前に集まってください。はいっ、移動～！",
		"八鳥が手を叩くと、散り散りに座っていた生徒たちが立ち上がり、指定された場所に移動し始めた。",
		"巧美：ちい、行こうか",

		"？？？：君たちも弦楽かい？",
		"？？？：もしかして普通科の方ですか？",
		"巧美：弦楽は4人だけ、でしょうか",
		"？？？：そのようだね。なら、まずは自己紹介かな",
		"？？？：僕は『須王御幸（すおうみゆき）』、音楽科3年生。ヴィオラ専攻だよ。毎年このチャリティーコンサートに参加してるから、何でも聞いてね",
		"須王御幸（すおうみゆき）",
		"奏花高等学校音楽科3年。2専攻：ヴィオラ",
		"？？？：『小早川颯真（こばやかわそうま）』、音楽科1年でヴァイオリン専攻です。・・・・足手まといにならないようにお願いします",
		"小早川颯真",
		"奏花高等学校1年。専攻：ヴァイオリン",
		"巧美：園山巧美、普通科2年でチェロしてます",
		"鳴海千晴：鳴海千晴です、みいくんと同じ普通科2年です。ヴァイオリン弾いてます。よろしくお願いします・・・！",
		"御幸：ふたりともよろしくね。さて、八鳥先生からの説明もあったけど、チャリティーコンサートまでの流れを軽く僕から説明しておきたいんだけど",
		"御幸：みんな、部活動には入ってない？",
		"こくり",
		"御幸：オーケー。なら問題ないね",
		"御幸：チャリティーコンサートの準備と練習は放課後の時間を使ってするから、ほとんど部活動みたいなものなんだ",
		"御幸：チーム分け、曲決め、練習、リハーサルをして本番になるんだ。基本的に先生たちは関与しない、生徒たちで全て作り上げていくんだ",
		"颯真：先生は何をするんです？引率だけですか？",
		"御幸：引率もだけれど、生徒たちやチャリティーコンサート自体の全般の管理はしてもらえるよ",
		"御幸：だから、僕たちは音楽にだけ集中できるんだ",
		"御幸：これからすぐに曲決めをして、そのあと練習に移るよ。時間は限られているからね",
		"巧美：あの、チーム決めっていうのが最初でしたが、俺たち4人だけの場合はどうするんですか。カルテットでも組むんですか？",
		"御幸：そうだねえ、ヴァイオリン2、ヴィオラ1、チェロ1ならそうした方が無難だと思うけど、みんなどうかな",
		"颯真：俺もいいと思います",
		"巧美：右に同じで",
		"私もこくりと頷いた。",
		"御幸：オーケー。じゃあカルテットでいこう。",
		"颯真：そうなると曲決めですか。御幸先輩は、いつもはどうされてたんですか",
		"御幸：うーん、大体組むメンバーが決まったら持ち帰りで考えて翌日から意見まとめてたかな",
		"巧美：あ、俺、先輩たちの音しらないんで、1回音を聴いておきたいです。曲決めの参考になると思うので",
		"御幸：あ、そうだね。じゃあみんな1曲弾いてみようか。まずは僕からいくね",
		"マラン・マレ：5つの古いフランス舞曲集",
		"概要すこし書く",
		"鳴海千晴：（伸びやかな優しい音。ヴィオラの音域が須王先輩に合ってる）",
		"颯真：次、俺弾きます",
		"アントニオ・ヴィヴァルディ：『調和の霊感』作品3の第6番ヴァイオリン協奏曲イ短調",
		"概要すこし書く",
		"鳴海千晴：（力強くてかっこいいヴァイオリンの音だ。芯がしっかりしていてすごく上手い）",
		"御幸：さすが颯真くん、新入生代表だっただけはあるね",
		"颯真：しってたんすか。あざっす・・・・",
		"御幸：普通科のふたりも、弾いてくれるかな",
		"巧美：わかりました。じゃあ俺から",
		"J.S.バッハ：無伴奏チェロ組曲",
		"概要すこし書く",
		"鳴海千晴：（みいくんの音色は落ち着くなあ。流れるように音符が耳に届く）",
		"御幸：びっくりした。すごく上手いんだね",
		"巧美：ありがとうございます。ほら、ちいも",
		"鳴海千晴：あ、うん。じゃあ、私も弾きます",
		"弓を構えるが、緊張のせいで音が震える。",
		"御幸：・・・驚いた。普通科に弾ける子たちがいるなんて。どうして音楽科に来なかったのか不思議なくらいだ",
		"巧美：みんな弾いたと思うんですけど、どうですか。すぐ決められそうです？",
		"御幸：いや、一旦今日は持ち帰りたいかな。颯真くんもそれでいいかな",
		"颯真：問題ないです",
		"御幸：じゃあ各自持ち帰って、今週末の放課後に集まって決めようか。",
		"御幸：集合場所はおって連絡するから、みんなのPINE教えてくれる？",
		"颯真：わかりました",
		"巧美：はい",
		"私もみんなと同様にスマホを出して先輩のQRコードを読み取った。",
		"御幸：みんなありがと。これでグループに設定して・・・。",
		"御幸：・・・はい。グループ作っておいたから、各自連絡あったらここにちょうだい",
		"キリーンコローンカラーンコロ―ン・・・・",
		"御幸：5時のチャイムか。ちょうどいい、今日はこれで解散にしようか",
		"颯真：すみません、俺用事あるんで先に帰ります。お疲れ様っす",
		"御幸：おつかれ～。君たちももう帰って大丈夫だから。それじゃあまたね",
		"巧美：お疲れさまでした",
		"鳴海千晴：お疲れ様です",
		"巧美：なんか自由な二人だったな",
		"鳴海千晴：そうだね。でもわくわくするかも",
		"巧美：そうだな、思ったよりはなんとかなりそうな気はするかな",
		"巧美：それじゃあ俺らも帰るか",
		"鳴海千晴：うん・・・・あれ？",
		"",
		"巧美：どうした？",
		"鳴海千晴：（いま、たとくんがいたような・・・気のせいかな）",
		"鳴海千晴：ううん。なんでもないよ。帰ろっか",
		"？？？：やったー！あたしこれ大好きなんだ～。うれしー！",
		"巧美：わ、ギャルがいる・・・・",
		"鳴海千晴：みいくんギャルに反応しすぎだよ、苦手臭でてるよ？",
		"巧美：仕方ないだろ、中学の時に絡まれてからほんっとうにだめなんだって知ってるだろ？",
		"鳴海千晴：あの人たちだってみいくんとお話したかっただけだと思うけど",
		"巧美：ばっか！あの人種がそれだけで終わると思うか？俺には無理・・・・",
		"鳴海千晴：（トラウマになってるなあ・・・・、仕方ないけどね）",
		"巧美：ちい、早くでよ。鳥肌たってくる・・・・",
		"鳴海千晴：うん、帰ろ～。次の集まり楽しみ～！",
		"次集まるのは金曜日。",
		"みんなの音を反芻しながら、私は家路を急いだ。",
		"メインストーリー　1話　了"
    ];
	
	// 初回表示（任意）
	document.getElementById('textMain1').textContent = texts[0];
	// 画像読み取り用（初回）
	// 画像はどうやら読み込みが非同期らしく、即時読み込みが文章のようにされないので手動（明記）で読み込みさせてあげたほうがよいようだ
	//　documentは要素、Windowは全体のことで、画像は全体の動きで考えたほうがよいみたい
	document.getElementById('imagesLeft').src = imagesLeft[0];
	document.getElementById('imagesLeft').src = imagesRight[0];
	document.getElementById('background').src = background[0];


	// イベント設定（この中でやってもいい）
	document.getElementById('clickArea_main1').addEventListener('click', changeObject);

	
  });



// テキスト切り替え処理
function changeObject() {
  const textElement = document.getElementById('textMain1');
  const imagesLeftElement = document.getElementById('imagesLeft');
  const imagesRightElement = document.getElementById('imagesRight');
  const backgroundElement = document.getElementById('background');
  const clickAreaElement = document.getElementById('clickArea_main1');

  count++;
  if (count < texts.length) {
    textElement.textContent = texts[count];
	imagesLeftElement.src = imagesLeft[count];
	imagesRightElement.src = imagesRight[count];
	backgroundElement.src = background[count];
	
  } else {
    clickAreaElement.style.pointerEvents = 'none'; // 全部終わったら無効化
	
	// メインストーリーカラムに数値の値を返す
	fetch('http://localhost:2102/TwilightOfDuet/api/story/main/complete', {
	  	
		method: 'POST',
		headers: {
			'Content-Type':'application/json'
		},
		body: JSON.stringify({
			"mainStory": 1
		})

	 })
	.then(response => response.json())
	.then(data => console.log("サーバ応答:", data));
	
  }
}

//function loadImages(){
//	
//	const imagesLeftElement = document.getElementById('imagesLeft');
//	const imagesRightElement = document.getElementById('imagesRight');
//	
//	// 初期表示用（左用) TODO:読み込みブレについてはいったん保留！
//	for (let i = 0; i < 5; i++) {
//	  const img = new Image();
//	  
//	  img.onload = () => {
//		imagesLeftElement.src = img.src;
//	  }
//	  
//	  img.src = imagesLeft[i];
//	}
//
//	// 少し遅れて残りを読み始める（左用）
//	setTimeout(() => {
//	  for (let i = 5; i < imagesLeft.length; i++) {
//	    const img = new Image();		
//	    img.src = imagesLeft[i];
//	  }
//	}, 1000); // 1秒後とか
//
//
//	// 初期表示用（右用）
//	for (let i = 0; i < 5; i++) {
//	  const img = new Image();
//	  img.src = imagesRight[i];
//	}
//
//	// 少し遅れて残りを読み始める（右用）
//	setTimeout(() => {
//	  for (let i = 5; i < imagesRight.length; i++) {
//	    const img = new Image();
//	    img.src = imagesRight[i];
//	  }
//	}, 1000); // 1秒後とか
//	
//}


