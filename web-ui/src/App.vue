<template>
  <div>
    <router-view/>
  </div>
</template>
<script>

export default {
  name: 'App',
}

</script>
<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  //text-align: center;
  color: #2c3e50;
  font-size: 14px;
}

#nav {
  //padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}

#container {
  display: flex;
  flex-direction: row;
  height: 100vh;
  width: 100vw;

  .side-bar {
    //border-right: 1px solid #ccc;
    text-align: left;
  }

  .main {
    flex: 1;
    overflow: auto;
  }
}

</style>
