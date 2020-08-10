<template>
  <div id="app">
    <!-- <div class="bg"></div>
    <div class="bg bg2"></div>
    <div class="bg bg3"></div> -->
    <html>
      <body>
        <button class="back start-btn" @click="backTop()">
        スタートに戻る
        </button>
      <div id="nav" />
      <router-view />
      </body>
    </html>
  </div>
</template>

<script>
export default {
  methods: {
    backTop () {
      this.$store.commit('initCount')
      this.$store.commit('initCorrectCount')
      this.$router.push('/')
    }
  }
}
</script>

<style>
#app {
  color: #2c3e50;
  height: 100%;
  width: 100%;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.bg {
  animation:slide 3s ease-in-out infinite alternate;
  background-image: linear-gradient(-60deg, #6c3 50%, #09f 50%);
  bottom:0;
  left:-50%;
  opacity:.5;
  position:fixed;
  right:-50%;
  top:0;
  z-index:-1;
}

.bg2 {
  animation-direction:alternate-reverse;
  animation-duration:4s;
}

.bg3 {
  animation-duration:5s;
}

#nav {
  color: #2c3e50;
  font-weight: bold;
  display: flex;
}

@keyframes slide {
  0% {
    transform:translateX(-25%);
  }
  100% {
    transform:translateX(25%);
  }
}

.start-btn {
  background:#FFC107;
  color:#fff;
  border:none;
  position:relative;
  height:60px;
  font-size:1.6em;
  padding:0 2em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
  border-radius: 5vw;
}

.start-btn:hover {
  background:#fff;
  color:#FFC107;
}

.start-btn:before,.start-btn:after {
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #FFC107;
  transition:400ms ease all;
}

.start-btn:after {
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}

.start-btn:hover:before,.start-btn:hover:after {
  width:100%;
  transition:800ms ease all;
}

.back {
  padding: 1vw;
  font-size: 10px;
  border-radius: 5vw;
}

body {
  height: 100%;
  margin: 0px;
  background-image:
    url('https://github.com/Kageetai/mario-background-parallax/blob/master/img/mario.gif?raw=true'),
    url('https://github.com/Kageetai/mario-background-parallax/blob/master/img/ground.png?raw=true'),
    url('https://github.com/Kageetai/mario-background-parallax/blob/master/img/bushes.png?raw=true'),
    url('https://raw.githubusercontent.com/Kageetai/mario-background-parallax/master/img/back.png?raw=true');
  background-color: #F8E0B0;
  background-repeat:
    no-repeat,
    repeat-x,
    repeat-x,
    repeat-x;
  background-position:
    left 30% bottom 22px,
    left 0px bottom 0px,
    left 0px bottom 22px,
    left 0px bottom 0px;
  animation: back 15s infinite linear;
}

@keyframes back {
  0% {
    background-position:
      left 30% bottom 22px,
      left 0px bottom 0px,
      left 0px bottom 22px,
      left 0px bottom 0px;
  }

  50% {
    background-position:
      left 50% bottom 22px,
      left (-(68px * 12)) bottom 0px,
      left (-(508px * 1)) bottom 22px,
      left (-(512px / 2)) bottom 0px;
  }
  100% {
    background-position:
      left 30% bottom 22px,
      left (-(68px * 24)) bottom 0px,
      left (-(508px * 2)) bottom 22px,
      left (-512px) bottom 0px;
  }
}
</style>
