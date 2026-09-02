def can_build(env, platform):
    return True

def configure(env):
    env.add_module_version_string("jvm-1.0.0-dev3")
