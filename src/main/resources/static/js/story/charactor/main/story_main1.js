/**
 * ストーリー：メイン制御
 * 更新日：2025/4/20
 */

const userId = /*[[${userId}]]*/ 1;
//const storyMain = /*[[${storyMain}]]*/ 1;

// クリックカウント用
let count = 0;
let texts = [];

// 名前、あだ名、StoryId、MainStoryIntの取得
Promise.all([
  fetch(`http://localhost:2102/TwilightOfDuet/api/users/heroine`).then(res => res.text()),
  fetch(`http://localhost:2102/TwilightOfDuet/api/users/heroine-nickname`).then(res => res.text())
//  fetch(`http://localhost:2102/TwilightOfDuet/api/story/story-id`).then(res => res.text()),
//  fetch(`http://localhost:2102/TwilightOfDuet/api/story/story-main`).then(res => res.text())

])

.then(([heroineName, heroineNickname]) => {
  // 値がなければデフォルトを使う
  if (!heroineName) heroineName = "鳴海千晴";
  if (!heroineNickname) heroineNickname = "ちい";

    // ヒロイン名を差し込んだテキスト配列を作る
    texts = [
		"メインストーリー　1話",
		`？？？：${heroineNickname}`,
	    "呼ばれて顔を見上げると、見慣れた顔が視界に入った。",
	    `${heroineName}：みいくん`,
	    "”みいくん”と呼んだ彼は、『園山巧美』。私の幼馴染で同級生。",
		`巧美：緊張してる？${heroineNickname}、楽しみにしてたもんね`,
		"何を隠そう、今日は待ちに待った選択科目『音楽』の授業初日。",
		"初めて入る音楽科棟の講堂は、普通科よりステージが大きく客席が狭い造りになっている。",
		"講堂内の生徒の数は、その収容人数よりはるかに少なかった。",
		"巧美：思ったより少ないね、人数。",
		`${heroineName}：みいくんも思った？私も思った。人気、ないのかなぁ？`,
		"ため息を吐く間もなく、投稿独特のチャイムがキリーンコローン、と鳴った。授業開始の合図だ。",
		"先生：はーい音楽科目選択のみなさん、本日最終授業にご参列お疲れ様です。",
		"大きな声で講堂のステージに立ったのは、見たことのない男の先生だった。",
		"普通科では見たことがないから、きっと音楽科の先生だろう。",
		"これから始まるだろう授業に胸がわくわくすると同時に、さらに緊張して肩に力が入ってしまう。",
		"先生：僕は音楽科指揮専攻担当教員の”下加茂八鳥（しもがもやとり）”といいます。",
		"八鳥：さて、君たちは選択科目として珍しい音楽を選んだわけですが、前年度までは奏花高等学校の選択科目に音楽はありませんでした。",
		"私たちが通う学校『奏花（そうか）高等学校』は普通科・特進科・音楽科の3学科がある高校だ。",
		"それぞれの学科は”学科等”でわかれていて、授業においての接点が一切ない。",
		"――――――この選択科目を除いて。",
		"八鳥：奏花高等学校学長が、他の学科の生徒同士の不愛を授業でも取り入れたいという意向から、選択科目に音楽を追加することにしたんですよね",
		"八鳥：このクラスは選択科目『音楽』の第一期生ということですねえ",
		"生徒一同：・・・・・・・・。",
		"――――――ばんっ！",
		"八鳥：では、時間も惜しいので簡単に説明しますね",
		"八鳥：選択科目は9月から3月までの学期跨ぎの授業です。"
    ];

    // 初回表示（任意）
    document.getElementById('textMain1').textContent = texts[0];

    // イベント設定（この中でやってもいい）
    document.getElementById('clickArea_main1').addEventListener('click', changeText);
  })
  .catch(error => {
    console.error("名前の取得失敗:", error);
	
    // 失敗したときも同じようにデフォルトで動かす
    texts = [
		"？？？：ちい",
	    "呼ばれて顔を見上げると、見慣れた顔が視界に入った。",
	    "鳴海千晴：みいくん",
	    "”みいくん”と呼んだ彼は、『園山巧美』。私の幼馴染で同級生。",
		"巧美：緊張してる？ちい、楽しみにしてたもんね",
		"何を隠そう、今日は待ちに待った選択科目『音楽』の授業初日。",
		"初めて入る音楽科棟の講堂は、普通科よりステージが大きく客席が狭い造りになっている。",
		"講堂内の生徒の数は、その収容人数よりはるかに少なかった。",
		"巧美：思ったより少ないね、人数。",
		"鳴海千晴：みいくんも思った？私も思った。人気、ないのかなぁ？",
		"ため息を吐く間もなく、投稿独特のチャイムがキリーンコローン、と鳴った。授業開始の合図だ。",
		"先生：はーい音楽科目選択のみなさん、本日最終授業にご参列お疲れ様です。",
		"大きな声で講堂のステージに立ったのは、見たことのない男の先生だった。",
		"普通科では見たことがないから、きっと音楽科の先生だろう。",
		"これから始まるだろう授業に胸がわくわくすると同時に、さらに緊張して肩に力が入ってしまう。",
		"先生：僕は音楽科指揮専攻担当教員の”下加茂八鳥（しもがもやとり）”といいます。",
		"八鳥：さて、君たちは選択科目として珍しい音楽を選んだわけですが、前年度までは奏花高等学校の選択科目に音楽はありませんでした。",
		"私たちが通う学校『奏花（そうか）高等学校』は普通科・特進科・音楽科の3学科がある高校だ。",
		"それぞれの学科は”学科等”でわかれていて、授業においての接点が一切ない。",
		"――――――この選択科目を除いて。",
		"八鳥：奏花高等学校学長が、他の学科の生徒同士の不愛を授業でも取り入れたいという意向から、選択科目に音楽を追加することにしたんですよね",
		"八鳥：このクラスは選択科目『音楽』の第一期生ということですねえ",
		"生徒一同：・・・・・・・・。",
		"――――――ばんっ！",
		"八鳥：では、時間も惜しいので簡単に説明しますね",
		"八鳥：選択科目は9月から3月までの学期跨ぎの授業です。"
    ];
	
    document.getElementById('textMain1').textContent = texts[0];
    document.getElementById('clickArea_main1').addEventListener('click', changeText);
	
  });

  // メインストーリーカラムに数値の値を返す
  fetch('http://localhost:2102/TwilightOfDuet/api/story/main/complete', {
  	
  	method: 'POST',
  	headers: {
  		'Content-Type':'application/json'
  	},
  	body: JSON.stringify({"mainStory": 1})

  	
  })
  .then(response => response.json())
  .then(data => console.log("サーバ応答:", data));


// テキスト切り替え処理
function changeText() {
  const textElement = document.getElementById('textMain1');
  const clickAreaElement = document.getElementById('clickArea_main1');

  count++;
  if (count < texts.length) {
    textElement.textContent = texts[count];
	
  } else {
    clickAreaElement.style.pointerEvents = 'none'; // 全部終わったら無効化
	
  }
}

