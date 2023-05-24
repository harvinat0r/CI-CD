<template>
    <section class="section pb-0 section-components">
        <div class="container mb-5">
            <!-- Inputs -->
            <h3 class="h4 text-success font-weight-bold mb-4">Inputs</h3>
            <fieldset class="row col-lg-4 col-sm-6">
                <base-input placeholder="운동 이름 검색. ex) 벤치프레스"
                                addon-left-icon="ni ni-zoom-split-in">
                </base-input>
                <base-button type="primary" @click="search">Button</base-button>
            </fieldset>
        </div>
        
    </section>
</template>
<script>
export default {};
</script>
<style>
</style>
