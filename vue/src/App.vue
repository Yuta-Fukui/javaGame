<template>
  <div id="app">
    <div id="nav">
    </div>
    <router-view />
  </div>
</template>

<style>
#app {
  color: #2c3e50;
  height: 400px;
  background: linear-gradient(-45deg, rgba(246, 255, 0, .8), rgba(255, 0, 161, .8));
  background-size: cover;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  margin: 10vw;
}

#nav a {
  color: #2c3e50;
  font-weight: bold;
}
</style>
