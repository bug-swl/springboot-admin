<template>
  <!--      <el-radio-group v-model="isCollapse" style="margin-bottom: 20px">-->
  <!--        <el-radio-button :label="false">expand</el-radio-button>-->
  <!--        <el-radio-button :label="true">collapse</el-radio-button>-->
  <!--      </el-radio-group>-->
  <div>


    <el-menu
      default-active="user"
      class="el-menu-vertical"
      :collapse="isCollapse"
      @open="handleOpen"
      @close="handleClose"
    >
      <el-menu-item index="1">
        <el-icon>
          <el-icon-home-filled/>
        </el-icon>
        <span>DERIK</span>
      </el-menu-item>
      <el-sub-menu index="2">
        <template #title>
          <el-icon>
            <el-icon-operation/>
          </el-icon>
          <span>系统管理</span>
        </template>
        <el-menu-item index="user">
          <el-icon>
            <el-icon-avatar/>
          </el-icon>
          <span>用户管理</span></el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="3">
        <template #title>
          <el-icon>
            <el-icon-location/>
          </el-icon>
          <span>系统工具</span>
        </template>
        <el-menu-item index="tool">工具1</el-menu-item>
      </el-sub-menu>
    </el-menu>
  </div>
</template>

<script>
import { inject, ref } from 'vue'

export default {
  name: 'Sidebar',
  setup () {
    const isCollapse = inject('isCollapse')
    const title = ref('Derik后台管理系统')
    const handleOpen = (key, keyPath) => {
      console.log(key, keyPath)
    }
    const handleClose = (key, keyPath) => {
      console.log(key, keyPath)
    }
    return {
      isCollapse,
      title,
      handleOpen,
      handleClose,
    }
  },
}


</script>

<style scoped lang="scss">
.side-logo {
  font-weight: bold;
  color: dodgerblue;
  line-height: 50px;
  text-align: left;
  padding: 0 20px;
  width: 100%;
  border-right: solid 1px #e6e6e6;

  &:hover {
    cursor: pointer;
  }
}

.el-menu-vertical {
  text-align: left;
  height: calc(100vh - 50px);

}

.el-menu-vertical:not(.el-menu--collapse) {
  width: 240px;
  min-height: 400px;
}

a {
  font-weight: bold;
  color: dodgerblue;
  line-height: 50px;

  &.router-link-exact-active {
    color: #42b983;
  }
}
</style>
