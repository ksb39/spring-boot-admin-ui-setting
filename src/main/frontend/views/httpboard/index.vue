<!--
  - Copyright 2014-2018 the original author or authors.
  -
  - Licensed under the Apache License, Version 2.0 (the "License");
  - you may not use this file except in compliance with the License.
  - You may obtain a copy of the License at
  -
  -     http://www.apache.org/licenses/LICENSE-2.0
  -
  - Unless required by applicable law or agreed to in writing, software
  - distributed under the License is distributed on an "AS IS" BASIS,
  - WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  - See the License for the specific language governing permissions and
  - limitations under the License.
  -->

<template>
  <div class="section">
    <div class="container">
      <h1 class="title">
        httpboard
      </h1>
      <div class="content">
        <p>
          testtest
        </p>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    data: () => ({
      // eslint-disable-next-line no-undef
      version: ""
    }),
    computed: {
      test() {
        return `test`;
      }
    },
    install({viewRegistry}) {
      viewRegistry.addView({
        path: '/httpboard',
        name: 'httpboard',
        label: 'Httpboard',
        order: 200,
        component: this
      });
    }
  };
</script>

<style lang="scss">
</style>
