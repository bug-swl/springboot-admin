<template>
  <div id="container">
    <Sidebar class="side-bar"/>
    <div class="main">
      <Header/>
      <router-view/>
    </div>
  </div>
</template>
<script>
import Header from "@/components/Header"
import Sidebar from "@/components/Sidebar"
import {ref} from "vue"

export default {
  name: "Layout",
  components: {
    Header,
    Sidebar
  },
  provide() {
    return {
      isCollapse: ref(false)
    }
  }

}

</script>
<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
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

  .side-bar {
    //border-right: 1px solid #ccc;
    text-align: left;
  }

  .main {
    flex: 1;

  }
}


</style>
