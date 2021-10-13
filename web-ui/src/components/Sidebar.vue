<template>
  <!--      <el-radio-group v-model="isCollapse" style="margin-bottom: 20px">-->
  <!--        <el-radio-button :label="false">expand</el-radio-button>-->
  <!--        <el-radio-button :label="true">collapse</el-radio-button>-->
  <!--      </el-radio-group>-->
  <div>
    <div class="side-logo">
      <i v-show="!isCollapse" class="el-icon-menu" style="width: 24px;text-align: center;margin-right: 5px"></i>
      <i v-show="isCollapse" class="el-icon-menu" style="width: 23px;text-align: center;"></i>
      <span v-show="!isCollapse">Derik</span>
    </div>

    <el-menu
      default-active="2"
      class="el-menu-vertical"
      :collapse="isCollapse"
      @open="handleOpen"
      @close="handleClose"
    >
      <el-sub-menu index="1">
        <template #title>
          <i class="el-icon-location"></i>
          <span>Navigator One</span>
        </template>
          <el-menu-item index="1-1">item one</el-menu-item>
          <el-menu-item index="1-2">item two</el-menu-item>
          <el-menu-item index="1-3">item three</el-menu-item>

        <el-sub-menu index="1-4">
          <template #title><span>item four</span></template>
          <el-menu-item index="1-4-1">item one</el-menu-item>
        </el-sub-menu>
      </el-sub-menu>
      <el-menu-item index="2">
        <i class="el-icon-menu"></i>
        <template #title>Navigator Two</template>
      </el-menu-item>
      <el-menu-item index="3" disabled>
        <i class="el-icon-document"></i>
        <template #title>Navigator Three</template>
      </el-menu-item>
      <el-menu-item index="4">
        <i class="el-icon-setting"></i>
        <template #title>Navigator Four</template>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
import {inject, ref} from "vue"

export default {
  name: "Sidebar",
  setup() {
    const isCollapse = inject("isCollapse")
    const title = ref("Derik后台管理系统")
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
