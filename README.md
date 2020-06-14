# react-component-creator

![Downloads](https://img.shields.io/jetbrains/plugin/d/13965-react-component-creator?style=for-the-badge)
![Version](https://img.shields.io/jetbrains/plugin/v/13965-react-component-creator?style=for-the-badge)
![Rating](https://img.shields.io/jetbrains/plugin/r/rating/13965-react-component-creator?style=for-the-badge)


- An Brainstorm Plugin to create a new react functional component with all additional files like
SCSS, Spec, Storybook.
- Add Redux reducer module with actions, mutations, state and types.
- Add custom templates to match your coding style and your needs.


![Settings](https://github.com/faebeee/react-component-creator-plugin/blob/master/doc/settings.png?raw=true "")
![Create component](https://github.com/faebeee/react-component-creator-plugin/blob/master/doc/create_component.gif?raw=true "")
![Create Reducer](https://github.com/faebeee/react-component-creator-plugin/blob/master/doc/create_reducer.gif?raw=true "")

# Install
Search for `React Component Creator` in the plugins settings. Or download the plugin from the [release site](https://github.com/faebeee/react-component-creator-plugin/releases)

# Custom Templates
If you are not happy with the predefined templates, you can choose your
own templates. The templates will be processed with mustache as templating.
All variables can also be used for the filenames.

Following variables are available


**Component**

| variable | Description |
|---|---|
| {{componentName}} | the inputted component name. Without any alterations |
| {{componentCamelcaseName}} | Camelcased input `my-component` becomes `MyComponent` |

**Reducer**

| variable | Description |
|---|---|
| {{actionFunctionName}} | Name of the function inside the `actions.ts` file |
| {{moduleName}} | Name of the folder |
| {{mutationType}} | String which will be used as type of the dispatch/mutation |
| {{moduleNamePascalCase}} | Pascalcased moduleName |
| {{stateName}} | Name for the state. `my-component` becomes `MyComponentState` |
| {{actionTypeName}} | Takes the input of `actionFunctionName` and capitalizes the first letter and appends `Action`. From `setData` becomes `SetDataAction` |
| {{actionTypesEnumName}} | Name used for the action types enum. actionTypesEnumName is the namespace where all `mutationType` actions are kept |


# Development
Follow the [Setup Instructions](./doc/DEVELOPMENT.md)

# Icons
Icons provided by https://www.iconfinder.com/justicon via https://www.iconfinder.com
