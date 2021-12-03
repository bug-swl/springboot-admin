<template>
  <div id="container">
    <Sidebar class="side-bar"/>
    <div class="main">
      <Header/>
      <el-tabs
        v-model="editableTabsValue"
        type="border-card"
        closable
        @tab-remove="removeTab"
      >
        <el-tab-pane
          v-for="item in editableTabs"
          :key="item.name"
          :label="item.title"
          :name="item.name"
        >
          {{ item.content }}
        </el-tab-pane>
      </el-tabs>
      <router-view/>
    </div>
  </div>
</template>

<script>
import Header from '@/components/Header'
import Sidebar from '@/components/Sidebar'

import { ref } from 'vue'

export default {
  name: 'Layout',
  components: {
    Header,
    Sidebar,
  },
  data () {
    return {
      isCollapse: false,
      editableTabsValue: '2',
      editableTabs: [
        {
          title: 'Tab 1',
          name: '1',
          content: import('@/views/Home')
        },
        {
          title: 'Tab 2',
          name: '2',
          content: 'Tab 2 content',
        },
      ],
      tabIndex: 2,
    }
  },
  methods:{
    addTab(targetName) {
      const newTabName = `${++this.tabIndex}`
      this.editableTabs.push({
        title: 'New Tab',
        name: newTabName,
        content: 'New Tab content',
      })
      this.editableTabsValue = newTabName
    },
    removeTab(targetName) {
      const tabs = this.editableTabs
      let activeName = this.editableTabsValue
      if (activeName === targetName) {
        tabs.forEach((tab, index) => {
          if (tab.name === targetName) {
            const nextTab = tabs[index + 1] || tabs[index - 1]
            if (nextTab) {
              activeName = nextTab.name
            }
          }
        })
      }

      this.editableTabsValue = activeName
      this.editableTabs = tabs.filter((tab) => tab.name !== targetName)
    },
  },
  provide () {
    return {
      isCollapse: ref(this.isCollapse)
    }
  }
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

.el-main {
  padding: 10px;
}
</style>
